package com.dormitory.pojo;

import java.util.Date;

public class Record {
    private Integer recordid;

    private String studentnumber;

    private String studentname;

    private Integer dormbuildid;

    private String dormname;

    private Date date;

    private String detail;
    private String date1;
    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate1() {
        return date1;
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber == null ? null : studentnumber.trim();
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public Integer getDormbuildid() {
        return dormbuildid;
    }

    public void setDormbuildid(Integer dormbuildid) {
        this.dormbuildid = dormbuildid;
    }

    public String getDormname() {
        return dormname;
    }

    public void setDormname(String dormname) {
        this.dormname = dormname == null ? null : dormname.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}