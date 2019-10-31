package com.dormitory.web;

import com.dormitory.pojo.DormBuild;
import com.dormitory.service.impl.DormBuildServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dormbuild")
public class DormBuildController {
    @Autowired
    private DormBuildServiceImpl dormBuildService;

    @RequestMapping("/dormbuildInfo")
    public String dormbuildInfo(Model model,
                                @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                                @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){
        List<DormBuild> dormBuilds = dormBuildService.selectAllDormBuilds(pageIndex,pageSize);
        PageInfo dormBuildPage =new PageInfo(dormBuilds);
        model.addAttribute("dormBuildPage",dormBuildPage);
        return "dormbuild";
    }

    @GetMapping("/deleteBuild")
    public String deleteBuild(Model model,Integer dormbuildid,
                              @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                              @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){
        int delete = dormBuildService.deleteDormBuild(dormbuildid);
        if(delete==1){
            List<DormBuild> dormBuilds = dormBuildService.selectAllDormBuilds(pageIndex,pageSize);
            PageInfo dormBuildPage =new PageInfo(dormBuilds);
            model.addAttribute("dormBuildPage",dormBuildPage);
            model.addAttribute("msg","删除成功！");
        }else {
            model.addAttribute("msg","删除失败！");
        }

        return "dormbuild";
    }

    @GetMapping("/selectBuild")
    public String selectBuild(Model model,Integer dormbuildid,
                               @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                               @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){
        List<DormBuild> dormBuilds = dormBuildService.selectBuildByid(pageIndex,pageSize,dormbuildid);
        PageInfo dormBuildPage =new PageInfo(dormBuilds);
        model.addAttribute("dormBuildPage",dormBuildPage);
        return "dormbuild";
    }
    @PostMapping("/insertBuild")
    public String insertBuild(Integer buildid,String name,String dormbuilddetail,Model model){
        DormBuild dormBuild=new DormBuild();
        dormBuild.setDormbuildid(buildid);
        dormBuild.setDormbuildname(name);
        dormBuild.setDormbuilddetail(dormbuilddetail);
        int add = dormBuildService.insertBuild(dormBuild);
        System.out.println("================="+add);
        if(add==1){
            model.addAttribute("addmsg","添加成功！");
        }else{
            model.addAttribute("addmsg","添加失败！");
        }
        return "redirect:/dormbuild/dormbuildInfo";
    }


}
