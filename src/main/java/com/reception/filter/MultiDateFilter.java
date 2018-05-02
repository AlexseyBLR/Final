package com.reception.filter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MultiDateFilter implements Filter {

    private DiskFileItemFactory factory = new DiskFileItemFactory();
    private ServletFileUpload upload = new ServletFileUpload(factory);


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            List<FileItem> fileItems = upload.parseRequest((HttpServletRequest) servletRequest);

            Iterator<FileItem> iterator = fileItems.iterator();

            while (iterator.hasNext()) {
                FileItem file = iterator.next();
                if (file.isFormField()) {
                    servletRequest.setAttribute(file.getFieldName(), file.getString("utf-8"));
                } else {
                    servletRequest.setAttribute(file.getFieldName(), file.get());
                }
            }

        } catch (FileUploadException e) {
            throw new ServletException(e);
        } finally {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        factory = null;
        upload = null;
    }
}
