package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Activity;
import net.dqsy.manager.service.IActivityService;
import net.dqsy.manager.web.util.PageUtil;
import net.dqsy.manager.web.util.ParamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("activity")
public class ActivityController{

    @Autowired
    private IActivityService activityService;
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){

        int type = ParamUtils.getIntParameter(request, "type", 1);
        int start = ParamUtils.getIntParameter(request, "start", 1);
        int limit = ParamUtils.getIntParameter(request, "limit", 10);
        int totalCount = activityService.getTotalCount(Arrays.asList(type));
        List<Activity> list = activityService.findList(Arrays.asList(type), start, limit);

        String pagation = PageUtil.getPagation("/activityRedirectController.do?action=list", totalCount, start, limit);

        ModelAndView mav = new ModelAndView("activity/list");
        mav.getModel().put("activityList", list);
        mav.getModel().put("pageCode", pagation);
        return mav;

    }


}
