package com.dormitory.web;

import com.dormitory.pojo.DoRecord;
import com.dormitory.pojo.Record;
import com.dormitory.service.impl.RecordServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordServiceImpl recordService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/recordInfo")
    public String recordInfo(Model model,
                            @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                             @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){

        //登陆的用户名
        String userName = (String) request.getSession().getAttribute("userName");
        //按姓名查询
        String role = (String) request.getSession().getAttribute("role");
        if(role.equals("2") ){
            List<DoRecord> byName = recordService.selectStudentByName(pageIndex, pageSize, userName);
            PageInfo recordPageInfo=new PageInfo(byName);
            model.addAttribute("recordPageInfo",recordPageInfo);
        }else {
            //查询所有记录
            List<DoRecord> allRecords = recordService.selectAllRecords(pageIndex,pageSize);
            PageInfo recordPageInfo=new PageInfo(allRecords);
            model.addAttribute("recordPageInfo",recordPageInfo);
        }
        return "record";
    }

    @GetMapping("/deleteRecord")
    public String deleteRecord(Model model,Integer recordid,
                               @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                               @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){
        int delete = recordService.deleteRecordByid(recordid);
        if (delete==1){
            List<DoRecord> allRecords = recordService.selectAllRecords(pageIndex,pageSize);
            PageInfo recordPageInfo=new PageInfo(allRecords);
            model.addAttribute("recordPageInfo",recordPageInfo);
            model.addAttribute("msg","删除成功！");
        }else{
            model.addAttribute("msg","删除失败！");
        }
        return "redirect:/record/recordInfo";
    }

    @PostMapping("/insertRecord")
    public String insertRecord(Record record) throws ParseException {
        String date = record.getDate1();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = dateFormat.parse(date);
        //Timestamp timestamp = new Timestamp(parse.getTime());
        record.setDate(parse);
        int insert = recordService.insertRecord(record);

        return "redirect:/record/recordInfo";
    }
    @GetMapping("/searchByNum")
    public String searchByNum(String studentnum,Model model,
                              @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                              @RequestParam(value = "pageSize",defaultValue = "4")Integer pageSize){
        List<DoRecord> doRecords = recordService.selectStudentByNum(pageIndex, pageSize, studentnum);
        System.out.println("==========="+doRecords.get(0).getStudentnumber());
        PageInfo recordPageInfo=new PageInfo(doRecords);
        model.addAttribute("recordPageInfo",recordPageInfo);
        return "record";
    }
}
