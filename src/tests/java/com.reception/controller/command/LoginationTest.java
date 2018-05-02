package com.reception.controller.command;


import com.reception.controller.exception.ControllerException;
import com.reception.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.when;

public class LoginationTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private User user;

    private LoginationPageCommand command;

    @Before
    public void setUp() throws IOException, ServletException {
        MockitoAnnotations.initMocks(this);
        command = new LoginationPageCommand();
        when(request.getSession()).thenReturn(session);

    }


    @Test
    public void when_user_is_admin_then_print_message() throws IOException, ControllerException, ServletException {
        //given
        when(session.getAttribute("role"))
                .thenReturn("admin");
        //when
        command.execute(request, response);
        //then
        System.out.println("SUCCESS! ADMIN");

    }


    @Test


    public void when_user_is_user_then_print_message() throws IOException, ControllerException, ServletException {

        //given
        when(session.getAttribute("role"))
                .thenReturn("user");
        //when
        command.execute(request, response);
        //then
        System.out.println("SUCCESS! USER");

    }


}