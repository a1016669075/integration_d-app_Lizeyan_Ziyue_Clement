package com.demo;



import com.demo.utils.TaleUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * BaseContorller
 */
public abstract class BaseController {

    public BaseController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }

    public BaseController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }

}
