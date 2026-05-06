package com.pack1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayFilter implements Filter {

    public FilterConfig fcobj = null;

    @Override
    public void init(FilterConfig config) {
        this.fcobj = config;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
            throws IOException, ServletException {

        req.setAttribute("fcobj", fcobj.getFilterName());
        req.setAttribute("msg", fcobj.getInitParameter("msg"));

        req.getRequestDispatcher("Display.jsp").forward(req, res);
    }
}