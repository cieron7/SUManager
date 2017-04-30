package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Department;
import net.dqsy.manager.pojo.DepartmentApply;
import net.dqsy.manager.service.IDepartmentApplyService;
import net.dqsy.manager.service.IDepartmentService;
import net.dqsy.manager.service.junkword.SensitiveService;
import net.dqsy.manager.web.util.LocalizationUtil;
import net.dqsy.manager.web.util.ParamUtils;
import net.dqsy.manager.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("departmentApply")
public class DepartmentApplyController {
    @Autowired
    private SensitiveService sensitiveService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IDepartmentApplyService departmentApplyService;

    /**
     * 提交申请
     *
     * @param request
     * @param response
     */
    @RequestMapping("apply")
    public void apply(HttpServletRequest request, HttpServletResponse response) {

        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if (account == null) {
            ResultUtil.fail("请登录", response);
        }

        long departmentId = ParamUtils.getLongParameter(request, "departmentId", 0L);

        Department department = departmentService.findDepartmentById(departmentId);
        if (department == null) {
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }
        int type = ParamUtils.getIntParameter(request, "type", 0);

        String content = ParamUtils.getParameter(request, "content", "");
        content = sensitiveService.filter(content);

        DepartmentApply apply = new DepartmentApply();
        apply.setAccountId(account.getId());
        apply.setContent(content);
        apply.setCreateTime(new Date());
        apply.setDepartmentId(departmentId);
        apply.setType(type);
        apply.setStatus(DepartmentApply.NEW);
        departmentApplyService.add(apply);
        ResultUtil.success(response);
    }


}
