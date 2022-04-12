package com.calculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    int  a = Integer.parseInt(request.getParameter("a"));
    int  b = Integer.parseInt(request.getParameter("b"));
    String operation = request.getParameter("op");
    PrintWriter out = response.getWriter();
    switch (operation){
        case "add":
            int sum = a+b;
            out.println("sum of " + a +"and "+ b+"is "+ sum);
            break;
        case "sub":
            int sub = a-b;
            out.println("sub of " + a +"and "+ b+"is "+ sub);
            break;
        case "mul":
            int mul = a*b;
            out.println("mul of " + a +"and "+ b+"is "+ mul);
            break;
        case "div":
            int div = a/b;
            out.println("div of " + a +"and "+ b+"is "+ div);
            break;
        default:
            out.println("give correct option");
    }
    }
}
