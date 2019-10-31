package com.dormitory.web;

import com.dormitory.pojo.DormManager;
import com.dormitory.service.impl.DormManagerServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dormManager")
public class DormManagerController {
    @Autowired
    private DormManagerServiceImpl dormManagerService;

    @RequestMapping("/dormManInfo")
    public String dormManInfo(Model model,
                              @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                              @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){
        //显示所有宿舍管理员
        List<DormManager> dormManagerList = dormManagerService.selectAllDormMans(pageIndex,pageSize);
        model.addAttribute("dormManagerList",dormManagerList);
        //根据宿舍楼dormbuildid查询管理员
        //List<DormManager> dormMansByDormId =DormManagerService.selectDormsByDormId();

        //分页,PageInfo类，这个类中拥有上一页，下一页，总页数等等属性
        PageInfo<DormManager> managerPageInfo=new PageInfo<>(dormManagerList);
        model.addAttribute("managerPageInfo",managerPageInfo);

        return "dormManagerInfo";
    }
    @GetMapping("look")
    public String look(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                       @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize,
                       Model model,Integer id){
        List<DormManager> dormManagerList = dormManagerService.selectDormsByDormId(pageIndex,pageSize,id);
        //System.out.println("==========================="+dormManagerList);
        if (dormManagerList.size()>0&&dormManagerList!=null) {
            PageInfo pageInfo = new PageInfo(dormManagerList);
            model.addAttribute("dormManagerList", dormManagerList);
            model.addAttribute("managerPageInfo", pageInfo);
        }
        return "dormManagerInfo";
    }
    @GetMapping("/deleteSelectedDorm")
    public String deleteSelectedDorm(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                                     @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize,
                                     Model model,Integer dormmanid,Integer id){
        int delete=dormManagerService.deleteDormsById(dormmanid);
        //System.out.println("===================="+delete);
        if(delete==1){
            model.addAttribute("msg","删除成功！");
            List<DormManager> dormManagerList = dormManagerService.selectDormsByDormId(pageIndex,pageSize,id);
            PageInfo pageInfo = new PageInfo(dormManagerList);
            model.addAttribute("dormManagerList", dormManagerList);
            model.addAttribute("managerPageInfo", pageInfo);
        }else {
            model.addAttribute("msg","删除失败！");
        }
        return "dormManagerInfo";
    }



}
