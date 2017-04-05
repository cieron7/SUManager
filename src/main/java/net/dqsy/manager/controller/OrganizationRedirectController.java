package net.dqsy.manager.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrganizationRedirectController extends MultiActionController {

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("main");
        mav.getModel().put("mainPage", "organization/list.jsp");
        return mav;
    }
}
