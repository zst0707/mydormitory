package com.dormitory.pojo;

import java.util.Date;

public class DoRecord {
    private Integer recordid;

    private String studentnumber;

    private String studentname;

    private String sex;

    private Integer dormbuildid;

    private String dormname;
    private Date date;
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        this.studentnumber = studentnumber;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
        this.dormname = dormname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    private String tel;
}
