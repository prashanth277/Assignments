package com.university;

import java.util.ArrayList;
import java.util.List;

public class Student {
    int sid;
    String name;
    String pwd;
    List<Course> courseList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getPwd() {
        return pwd;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
