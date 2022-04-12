package com.university;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class StudentDetails extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Data d = new Data();
        PrintWriter out = response.getWriter();
        out.println(d.getStudentDetails());
        out.println(d.getStudentDetailsById(2));
        out.close();
    }
}
