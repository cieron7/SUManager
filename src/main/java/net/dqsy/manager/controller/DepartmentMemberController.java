package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Department;
import net.dqsy.manager.service.IDepartmentMemberService;
import net.dqsy.manager.service.IDepartmentService;
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
import java.util.List;

@Controller
@RequestMapping("departmentMember")
public class DepartmentMemberController {
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IDepartmentMemberService departmentMemberService;

    @RequestMapping("list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {

        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if (account == null) {
            ModelAndView mav = new ModelAndView("redirect:/index");
            return mav;
        }

        // 获取部门信息
        long departmentId = ParamUtils.getLongParameter(request, "departmentId", 0L);
        int start = ParamUtils.getIntParameter(request, "page", 1);
        int limit = ParamUtils.getIntParameter(request, "limit", 10);

        Department department = departmentService.findDepartmentById(departmentId);


        List<Account> accountList = departmentMemberService.findDepartMemberList(department.getId(), start, limit);

        int totalCount = departmentMemberService.getTotalCount(department.getId());
        String pagation = PageUtil.getPagation("/departmentMember/list", totalCount, start, limit);


        ModelAndView mav = new ModelAndView("departmentMember/list");
        mav.getModel().put("department", department);
        mav.getModel().put("accountList", accountList);
        mav.getModel().put("pageCode", pagation);
        return mav;

    }
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void delete(HttpServletRequest request, HttpServletResponse response){

        long accountId = ParamUtils.getLongParameter(request, "accountId", 0L);
        long departmentId = ParamUtils.getLongParameter(request, "departmentId", 0L);

        departmentMemberService.delete(departmentId, accountId);
        ResultUtil.success(response);
    }
}
