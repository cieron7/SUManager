package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Organization;
import net.dqsy.manager.service.IOrganizationService;
import net.dqsy.manager.web.util.ParamUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrganizationRedirectController extends MultiActionController {

    private IOrganizationService organizationService;

    public void setOrganizationService(IOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
        Account currentAccount = (Account) request.getSession().getAttribute("currentAccount");
        Organization organization = organizationService.findOrganizationByAccountId(currentAccount.getId());
        ModelAndView mav = new ModelAndView("organization/list");
        mav.getModel().put("organization", organization);
        return mav;
    }

    public ModelAndView update(HttpServletRequest request, HttpServletResponse response){
        long orgId = ParamUtils.getLongParameter(request, "orgId", 0L);

        Organization organization = organizationService.findById(orgId);
        ModelAndView mav = new ModelAndView("organization/update");
        mav.getModel().put("organization", organization);
        return mav;

    }

    public String save(HttpServletRequest request, HttpServletResponse response){
        long orgId = ParamUtils.getLongParameter(request, "orgId", 0L);
        String orgName = ParamUtils.getParameter(request, "orgName", "未设定");
        String orgLogo = ParamUtils.getParameter(request, "orgLogo", "");

        Organization organization = organizationService.findById(orgId);
        organization.setName(orgName);
        organization.setLogo(orgLogo);

        organizationService.updateOrganization(organization);

        return "redirect:/organizationRedirectController.do?action=list";


    }
}
