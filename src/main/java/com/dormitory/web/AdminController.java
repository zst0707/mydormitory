package com.dormitory.web;

import com.dormitory.pojo.Admin;
import com.dormitory.pojo.DormManager;
import com.dormitory.pojo.Student;
import com.dormitory.service.impl.AdminServiceImpl;
import com.dormitory.service.impl.DormManagerServiceImpl;
import com.dormitory.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private DormManagerServiceImpl dormManagerService;
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/adminMain")
    public String adminMain(){
        return "index";
    }

    @RequestMapping("/adminInfo")
    public String adminInfo(){
        return "form-elements";
    }

    @GetMapping("/updateAdmin")
    @ResponseBody
    public String updateAdmin(String name, String userName, String password, String sex,
                              String tel,Integer dormbuildid,String dormname,String studentnumber){
        int update=0;
        String role = (String) request.getSession().getAttribute("role");
        Integer id = (Integer) request.getSession().getAttribute("id");
        if(role.equals("0")){//管理员
            Admin admin = adminService.selectAdminsById(id);
            admin.setName(name);
            admin.setUsername(userName);
            admin.setPassword(password);
            admin.setSex(sex);
            admin.setTel(tel);
            update=adminService.updateAdmin(admin);
        }else if(role.equals("1")){//宿舍管理员
            DormManager dormManager=dormManagerService.selectDormByid(id);
            dormManager.setName(name);
            dormManager.setUsername(userName);
            dormManager.setPassword(password);
            dormManager.setSex(sex);
            dormManager.setTel(tel);
            dormManager.setDormbuildid(dormbuildid);
            System.out.println("+++++++++++++++="+dormManager.getDormmanid());
            update=dormManagerService.updateDorms(dormManager);

        }else if(role.equals("2")){//学生
            Student student=studentService.selectStudentById(id);
            student.setName(name);
            student.setPassword(password);
            student.setStudentnum(studentnumber);
            student.setSex(sex);
            student.setTel(tel);
            student.setDormbuildid(dormbuildid);
            update=studentService.updateStudentById(student);

        }
        if(update==1){
            return "修改成功！";
        }else{
            return "修改失败！";
        }
    }
}
