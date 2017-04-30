package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Department;
import net.dqsy.manager.pojo.Organization;
import net.dqsy.manager.service.IDepartmentService;
import net.dqsy.manager.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("departmentMember")
public class DepartmentMemberController {
    @Autowired
    private IOrganizationService organizationService;
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){

        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if (account == null) {
            ModelAndView mav = new ModelAndView("redirect:/index");
            return mav;
    }

        Organization organization = organizationService.findOrganizationByAccountId(account.getId());

        List<Department> departmentList = departmentService.findList(organization.getId(), 0, 0);

        ModelAndView mav = new ModelAndView("departmentMember/list");
        mav.getModel().put("departmentList", departmentList);
        return mav;

    }
}
