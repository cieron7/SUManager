package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Activity;
import net.dqsy.manager.pojo.Department;
import net.dqsy.manager.pojo.DepartmentMember;
import net.dqsy.manager.pojo.Function;
import net.dqsy.manager.service.IAccountService;
import net.dqsy.manager.service.IActivityService;
import net.dqsy.manager.service.IDepartmentMemberService;
import net.dqsy.manager.service.IDepartmentService;
import net.dqsy.manager.service.IFunctionService;
import net.dqsy.manager.web.util.MD5Util;
import net.dqsy.manager.web.util.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("")
public class IndexRedirectController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IFunctionService functionService;
    @Autowired
    private IActivityService activityService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IDepartmentMemberService departmentMemberService;

    public static Logger logger = LoggerFactory.getLogger(IndexRedirectController.class);

    @RequestMapping("/login")
    public String logon(HttpServletRequest request, HttpServletResponse response, Model model) {

        //获取前台界面的username和password
        String username = ParamUtils.getParameter(request, "username", "");
        String password = ParamUtils.getParameter(request, "password", "");

        password = MD5Util.getMD5(password.getBytes());
        Account account = accountService.logon(username.trim(), password);
        if (account == null) {
            return "redirect:/index";
        }
        //将用户护具存入session
        request.getSession().setAttribute("currentAccount", account);
        // 权限列表
        List<Function> functions = functionService.findFunctionListByRole(account.getType());
        request.getSession().setAttribute("functions", functions);
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model){
        request.getSession().invalidate();
        return "redirect:/index";
    }

    @RequestMapping(value = {"index", ""})
    public String indexPage(HttpServletRequest request, HttpServletResponse response) {
        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if(account != null){
            DepartmentMember member = departmentMemberService.findMemberByAccountId(account.getId());
            if(member != null){
                Department department = departmentService.findDepartmentById(member.getDepartmentId());
                request.getSession().setAttribute("department", department.getName() + "-");
            }
        }
        List<Map<String, Object>> result = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");


        if(account == null){
            return "login";
        }else{
            List<Activity> list = activityService.findList(Arrays.asList(1), 1, 0);
            for(Activity activity : list){

                try {
                    long departmentId = activity.getDepartmentId();
                    Department department = departmentService.findDepartmentById(departmentId);
                    Map<String, Object> map = new HashMap();
                    if(department != null){
                        map.put("departmentName", department.getName());
                    }
                    map.put("id", activity.getId());
                    map.put("title", activity.getTitle());
                    map.put("userName", account.getUsername());
                    Date startTime = activity.getStartTime();
                    String date = sdf.format(startTime);
                    map.put("createTime", date);
                    String content = activity.getContent();
                    map.put("content", content);
                    result.add(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            request.setAttribute("activityList", result);
            return "index";
        }

    }

}
