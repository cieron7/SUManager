package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Activity;
import net.dqsy.manager.pojo.DepartmentMember;
import net.dqsy.manager.service.IActivityService;
import net.dqsy.manager.service.IDepartmentMemberService;
import net.dqsy.manager.service.junkword.SensitiveService;
import net.dqsy.manager.web.util.PageUtil;
import net.dqsy.manager.web.util.ParamUtils;
import net.dqsy.manager.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("activity")
public class ActivityController{

    @Autowired
    private IActivityService activityService;
    @Autowired
    private SensitiveService sensitiveService;
    @Autowired
    private IDepartmentMemberService departmentMemberService;
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

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("activity/activity_add");
        return mav;
    }

    @RequestMapping("addActivity")
    public void addActivity(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if (account == null) {
            ResultUtil.fail(response);
            return;
        }

        String title = ParamUtils.getParameter(request, "title");
        String subTitle = ParamUtils.getParameter(request, "subTitle");
        int limitNum = ParamUtils.getIntParameter(request, "limitNum", 0);
        String startTime = ParamUtils.getParameter(request, "startTime");
        String endTime = ParamUtils.getParameter(request, "endTime");
        String content = ParamUtils.getParameter(request, "content");

        // 初始化时设置 日期和时间模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(startTime);
        Date end = sdf.parse(endTime);

        DepartmentMember member = departmentMemberService.findMemberByAccountId(account.getId());
        if(member == null){
            ResultUtil.fail(response);
            return;
        }
        Activity activity = new Activity();
        activity.setTitle(title);
        activity.setSubTitle(subTitle);
        activity.setContent(content);
        activity.setLimitNum(limitNum);
        activity.setStartTime(start);
        activity.setEndTime(end);
        activity.setDepartmentMemberId(member.getDepartmentId());
        activity.setDepartmentId(member.getDepartmentId());
        activity.setType(Activity.ACTIVITY);
        activityService.add(activity);
        ResultUtil.success(response);

    }

    @RequestMapping("detail")
    public ModelAndView detail(HttpServletRequest request, HttpServletResponse response){

        Long activityId = ParamUtils.getLongParameter(request, "activityId");

        Activity activity = activityService.findById(activityId);

        ModelAndView mav = new ModelAndView("activity/detail");
        mav.getModel().put("activity",activity);
        return mav;
    }
    @RequestMapping("delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        Long activityId = ParamUtils.getLongParameter(request, "activityId");
        Activity activity = activityService.findById(activityId);
        if(activity == null){
            ResultUtil.fail(response);
            return;
        }
        activityService.deleteById(activity.getId());
        ResultUtil.success(response);
    }




}
