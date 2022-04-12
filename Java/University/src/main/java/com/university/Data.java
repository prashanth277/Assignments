package com.university;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static final ArrayList<Student>  students = new ArrayList<Student>();

    public Data(){
        Student s1 = new Student();
        s1.setSid(1);
        s1.setName("raj");
        s1.setPwd("xyz");

        Student s2 = new Student();
        s2.setSid(2);
        s2.setName("ching");
        s2.setPwd("xyz");

        Student s3 = new Student();
        s3.setSid(3);
        s3.setName("tom");
        s3.setPwd("xyz");

        Course c1 = new Course();
        c1.setId(101);
        c1.setName("math");

        Course c2 = new Course();
        c2.setId(102);
        c2.setName("eng");

        Course c3 = new Course();
        c3.setId(103);
        c3.setName("science");

        Course c4 = new Course();
        c4.setId(104);
        c4.setName("biology");



        List<Course> courseList = new ArrayList<>();
        courseList.add(c1);
        courseList.add(c2);

        List<Course> courseList2 = new ArrayList<>();
        courseList2.add(c3);
        courseList2.add(c4);

        s1.setCourseList(courseList);
        s2.setCourseList(courseList2);
        s3.setCourseList(courseList);
        students.add(s1);
        students.add(s2);
        students.add(s3);

    }
    public String getStudentDetails(){
        return students.toString();
    }


    public String getStudentDetailsById(int id){
        for(int i = 0; i < students.size() ; i++){
            if(id == students.get(i).getSid()){
                return students.get(i).toString();
            }
        }

        return "";
    }
    public String deleteStudentById(int id){
        for(int i = 0; i <= students.size() ; i++){
            if(id == students.get(i).getSid()){
                students.remove(i);
            }
        }
        return getStudentDetails();
    }


}
