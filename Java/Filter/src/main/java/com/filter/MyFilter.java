package com.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.LogRecord;
import javax.servlet.*;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public  static Logger logger= LoggerFactory.getLogger(MyFilter.class);
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.info("insude Authentication filter");
        PrintWriter out=servletResponse.getWriter();

        String password=servletRequest.getParameter("password");
        if(password.equals("admin")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            out.print("username or password error!");
            RequestDispatcher rd=servletRequest.getRequestDispatcher("index.html");
            rd.include(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }


}
