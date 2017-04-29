package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Department;
import net.dqsy.manager.pojo.Organization;
import net.dqsy.manager.service.IDepartmentService;
import net.dqsy.manager.service.IOrganizationService;
import net.dqsy.manager.web.util.LocalizationUtil;
import net.dqsy.manager.web.util.PageUtil;
import net.dqsy.manager.web.util.ParamUtils;
import net.dqsy.manager.web.util.ResultUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class DepartmentRedirectController  extends MultiActionController {

    private IDepartmentService departmentService;
    private IOrganizationService organizationService;

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setOrganizationService(IOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){

        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if (account == null) {
            ModelAndView mav = new ModelAndView("redirect:/index");
            return mav;
        }

        Organization organization = organizationService.findOrganizationByAccountId(account.getId());

        int start = ParamUtils.getIntParameter(request, "page", 1);
        int limit = ParamUtils.getIntParameter(request, "limit", 10);
        List<Department> list = departmentService.findList(organization.getId(), start, limit);
        int totalCount = departmentService.getTotalCount(organization.getId());

        String pagation = PageUtil.getPagation("/departmentRedirectController.do?action=list", totalCount, start, limit);

        ModelAndView mav = new ModelAndView("department/list");
        mav.getModel().put("departmentList", list);
        mav.getModel().put("pageCode", pagation);
        return mav;
    }

    public void detail(HttpServletRequest request, HttpServletResponse response){
        Long departmentId = ParamUtils.getLongParameter(request, "department_id", 0L);
        if(departmentId == 0L){
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }

        Department department = departmentService.findDepartmentById(departmentId);
        ResultUtil.success(department, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response){
        Long departmentId = ParamUtils.getLongParameter(request, "department_id", 0L);
        if(departmentId == 0L){
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }
        departmentService.deleteById(departmentId);
        ResultUtil.success(response);

    }
}
