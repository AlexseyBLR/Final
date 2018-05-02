package com.reception.filter;

import com.reception.controller.constant.Constant;
import com.reception.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminUrlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest)servletRequest).getSession();

        User customer = (User) session.getAttribute(Constant.WebProperty.USER_ATTRIBUTE_NAME);

        if(customer == null || !customer.getRole().equalsIgnoreCase(Constant.WebProperty.ADMIN_ROLE)){
            servletRequest.getRequestDispatcher(Constant.WebProperty.PAGE_ERROR).forward(servletRequest, servletResponse);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
