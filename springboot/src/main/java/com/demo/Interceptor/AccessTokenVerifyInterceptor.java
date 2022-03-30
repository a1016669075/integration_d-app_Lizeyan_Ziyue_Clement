package com.demo.Interceptor;

import com.demo.utils.StringUtil;
import com.demo.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class AccessTokenVerifyInterceptor implements HandlerInterceptor {




    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-----------intercepteur d'entrée------------");
        boolean flag = false;
        request.getSession().getId();
        System.out.println("-----------permettre l'accès------------"+ request.getSession().getId());
        String url = request.getRequestURL().toString();

            return true;

    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}