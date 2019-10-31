package com.dormitory.web;

import com.dormitory.pojo.DormManager;
import com.dormitory.pojo.Student;
import com.dormitory.service.impl.DormManagerServiceImpl;
import com.dormitory.service.impl.StudentServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    DormManagerServiceImpl dormManagerService;


    @RequestMapping("/studentInfo")
    public String studentInfo(Model model,
                              @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                              @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){

        Integer loginId = (Integer) request.getSession().getAttribute("id");
        String role = (String) request.getSession().getAttribute("role");
//        System.out.println("===================="+role);
        if(role.equals("0")){//系统管理员
            List<Student> studentList=studentService.selectAllStudents(pageIndex,pageSize);
            PageInfo<Student> studentPageInfo=new PageInfo<>(studentList);
            model.addAttribute("studentPageInfo",studentPageInfo);
        }
         if(role.equals("1")){//宿舍管理员
            //获取登录管理员
            DormManager dormManager = dormManagerService.selectDormByid(loginId);
            //登录管理员的宿舍楼
            Integer dormbuildid = dormManager.getDormbuildid();
            //根据宿舍楼查询学生
            List<Student> studentList = studentService.selectStudentByOne(pageIndex,pageSize,dormbuildid);
//            System.out.println("-----------------------------"+studentList.get(0).getName());
            PageInfo<Student> studentPageInfo=new PageInfo<>(studentList);
            model.addAttribute("studentPageInfo",studentPageInfo);
        }
        return "student";
    }
    @GetMapping("/searchByBid")
    public String searchByBid(Model model,String dormname,String name,
                              @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                              @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){
        Integer loginId = (Integer) request.getSession().getAttribute("id");
        String role = (String) request.getSession().getAttribute("role");
        if(role.equals("0")){//系统管理员
            //按寝室、姓名搜索
            List<Student> selectStudents=studentService.seleteStuByDormBId(pageIndex,pageSize,dormname,name);
            if(selectStudents.size()>0 && selectStudents!=null){
                PageInfo<Student> studentPageInfo=new PageInfo<>(selectStudents);
                model.addAttribute("studentPageInfo",studentPageInfo);
            }
        }
        if(role.equals("1")){//宿舍管理员
            //获取登录管理员
            DormManager dormManager = dormManagerService.selectDormByid(loginId);
            //登录管理员的宿舍楼
            Integer dormbuildid = dormManager.getDormbuildid();
            //按寝室、姓名且宿舍楼id等于楼管宿舍楼id搜索
            List<Student> selectStudents=studentService.seleteStuByDormBIdMan(pageIndex,pageSize,dormbuildid,dormname,name);
            if(selectStudents.size()>0 && selectStudents!=null){
                PageInfo<Student> studentPageInfo=new PageInfo<>(selectStudents);
                model.addAttribute("studentPageInfo",studentPageInfo);
            }
        }

        return "student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(Model model,Integer studentid,
                                @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                                @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){
        int delete = studentService.deleteStudentById(studentid);
        Integer loginId = (Integer) request.getSession().getAttribute("id");
        String role = (String) request.getSession().getAttribute("role");
        if(delete==1){
            if(role.equals("0")){//系统管理员
                List<Student> studentList=studentService.selectAllStudents(pageIndex,pageSize);
                PageInfo<Student> studentPageInfo=new PageInfo<>(studentList);
                model.addAttribute("studentPageInfo",studentPageInfo);
                model.addAttribute("msg","删除成功！");
            }
            if(role.equals("1")){//宿舍管理员
                //获取登录管理员
                DormManager dormManager = dormManagerService.selectDormByid(loginId);
                //登录管理员的宿舍楼
                Integer dormbuildid = dormManager.getDormbuildid();
                List<Student> studentList = studentService.selectStudentByOne(pageIndex,pageSize,dormbuildid);
                PageInfo<Student> studentPageInfo=new PageInfo<>(studentList);
                model.addAttribute("studentPageInfo",studentPageInfo);
                model.addAttribute("msg","删除成功！");
            }

        }else{
            model.addAttribute("msg","删除失败！");
        }
        return "student";
    }

    @PostMapping("/insertStudent")
    public String insertStudent(Model model,String studentNum,String name,String password,
                                Integer dormBuildId,String dormId ,String sex,String tel){
        Student student=new Student();
        student.setStudentnum(studentNum);
        student.setName(name);
        student.setPassword(password);
        student.setDormbuildid(dormBuildId);
        student.setDormname(dormId);
        student.setSex(sex);
        student.setTel(tel);
        int insert=studentService.addStudentOne(student);
        if(insert==1){
            model.addAttribute("addmsg","添加成功！");
        }else{
            model.addAttribute("addmsg","添加失败！");
        }
        return "redirect:/student/studentInfo";
    }

}
