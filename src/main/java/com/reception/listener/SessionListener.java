package com.reception.listener;

import com.reception.controller.constant.Constant;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(Constant.WebProperty.USER_ATTRIBUTE_ROLE, Constant.WebProperty.GUEST_ROLE);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
