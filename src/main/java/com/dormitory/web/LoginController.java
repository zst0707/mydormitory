package com.dormitory.web;

import com.dormitory.pojo.Admin;
import com.dormitory.pojo.DormManager;
import com.dormitory.pojo.Student;
import com.dormitory.service.impl.AdminServiceImpl;
import com.dormitory.service.impl.DormManagerServiceImpl;
import com.dormitory.service.impl.StudentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private DormManagerServiceImpl dormManagerService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/gologin")
    public String gologin(){
        return "login";
    }
    //登录跳转
    @RequestMapping(value = "/gotologin",method = RequestMethod.POST)
    public String gotoLogin(@Param("userName") String userName,
                            @Param("password") String password,
                            @Param("role") String role){
        System.out.println("----------------------"+userName+"========"+password+"---"+role);
        if(role.equals("0")){//系统管理员角色
            List<Admin> adminList=adminService.adminLogin(userName,password);
            if(adminList.size()==0){
                request.setAttribute("msg","用户名或密码错误");
                return "login";
            }
            if(adminList.size()==1){
                request.getSession().setAttribute("userName",adminList.get(0).getUsername());
                request.getSession().setAttribute("password",adminList.get(0).getPassword());
                request.getSession().setAttribute("id",adminList.get(0).getAdminid());
                request.getSession().setAttribute("role",role);
                return "index";
            }
        }
        if(role.equals("1")){//宿舍管理员
            List<DormManager> dormManagerList=dormManagerService.dormManagerLogin(userName,password);
            if(dormManagerList.size()==0){
                request.setAttribute("msg","用户名或密码错误");
                return "login";
            }
            if(dormManagerList.size()==1){
                request.getSession().setAttribute("userName",dormManagerList.get(0).getUsername());
                request.getSession().setAttribute("password",dormManagerList.get(0).getPassword());
                request.getSession().setAttribute("id",dormManagerList.get(0).getDormmanid());
                request.getSession().setAttribute("role",role);
                return "index";
            }
        }
        if(role.equals("2")){//学生角色
            List<Student> studentList=studentService.studentLogin(userName,password);
            if(studentList.size()==0){
                request.setAttribute("msg","用户名或密码错误");
                return "login";
            }
            if(studentList.size()==1){
                request.getSession().setAttribute("userName",studentList.get(0).getName());
                request.getSession().setAttribute("password",studentList.get(0).getPassword());
                request.getSession().setAttribute("id",studentList.get(0).getStudentid());
                request.getSession().setAttribute("role",role);
                return "index";
            }
        }
       return "login";
    }
    //系统管理员登录
    @RequestMapping("/adminIndex")
    public String gotoAdminIndex(){
        return "admin/index";
    }

}
