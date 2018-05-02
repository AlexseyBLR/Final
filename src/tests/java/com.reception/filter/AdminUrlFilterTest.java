package com.reception.filter;

import com.reception.controller.constant.Constant;
import com.reception.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class AdminUrlFilterTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @Mock
    private HttpSession session;

    @Mock
    private User customer;

    @Mock
    private RequestDispatcher dispatcher;

    private AdminUrlFilter filter;

    @Before
    public void setUp() throws IOException, ServletException {
        MockitoAnnotations.initMocks(this);
        filter = new AdminUrlFilter();
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(Constant.WebProperty.PAGE_ERROR)).thenReturn(dispatcher);
    }


    @Test
    public void when_user_sing_is_a_customer_then_should_redirect_to_errorPage() throws IOException, ServletException {

        //given
        when(session.getAttribute(Constant.WebProperty.USER_ATTRIBUTE_NAME))
                .thenReturn(customer);
        when(customer.getRole()).thenReturn(Constant.WebProperty.CUSTOMER_ROLE);
        //when
        filter.doFilter(request, response, filterChain);

        //then
        verify(dispatcher).forward(request, response);
        verify(filterChain).doFilter(request, response);
    }

    @Test
    public void when_user_is_a_guest_then_should_redirect_to_errorPage() throws IOException, ServletException {
        //given
        when(session.getAttribute(Constant.WebProperty.USER_ATTRIBUTE_NAME))
                .thenReturn(null);
        //when
        filter.doFilter(request, response, filterChain);

        //then
        verify(dispatcher).forward(request, response);
        verify(filterChain).doFilter(request, response);
    }

    @Test
    public void when_user_is_an_admin_then_should_do_nothing() throws IOException, ServletException {

        //given
        when(session.getAttribute(Constant.WebProperty.USER_ATTRIBUTE_NAME))
                .thenReturn(customer);
        when(customer.getRole()).thenReturn(Constant.WebProperty.ADMIN_ROLE);

        //when
        filter.doFilter(request, response, filterChain);

        //then
        verify(request).getSession();
        verify(session).getAttribute(Constant.WebProperty.USER_ATTRIBUTE_NAME);
        verify(customer).getRole();
        verify(filterChain).doFilter(request, response);
        verifyNoMoreInteractions(request, response, filterChain);


    }


}
