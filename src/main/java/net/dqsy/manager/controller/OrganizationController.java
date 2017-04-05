package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Organization;
import net.dqsy.manager.service.IOrganizationService;
import net.dqsy.manager.web.util.LocalizationUtil;
import net.dqsy.manager.web.util.ParamUtils;
import net.dqsy.manager.web.util.ResultUtil;
import net.dqsy.manager.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "org")
public class OrganizationController {
    @Autowired
    private IOrganizationService organizationService;

    // 只允许机构管理员操作
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public void info(HttpServletRequest request, HttpServletResponse response) {
        long accountId = WebUtil.getUserId(request);
        // TODO: 2017/4/5 从Redis获取用户信息
        Account account = null;

        if (account == null) {
            ResultUtil.fail(LocalizationUtil.getClientString("Permission.deny", request), response);
            return;
        }
        Organization organization = organizationService.findOrganizationByAccountId(account.getId());
        if (organization == null) {
            ResultUtil.fail(LocalizationUtil.getClientString("Permission.deny", request), response);
            return;
        }
        ResultUtil.success(organization, response);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void updateOrganization(HttpServletRequest request, HttpServletResponse response) {

        // TODO: 2017/4/5 判断权限
        long orgId = ParamUtils.getLongParameter(request, "orgId", 0L);
        String logo = ParamUtils.getParameter(request, "logo", "");
        String orgName = ParamUtils.getParameter(request, "orgName", "");

        Organization organization = organizationService.findById(orgId);
        organization.setLogo(logo);
        organization.setName(orgName);
        organizationService.updateOrganization(organization);
        ResultUtil.success(response);

    }


}
