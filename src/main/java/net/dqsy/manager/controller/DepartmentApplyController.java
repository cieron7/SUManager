package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Department;
import net.dqsy.manager.pojo.DepartmentApply;
import net.dqsy.manager.service.IDepartmentApplyService;
import net.dqsy.manager.service.IDepartmentService;
import net.dqsy.manager.service.junkword.SensitiveService;
import net.dqsy.manager.web.util.LocalizationUtil;
import net.dqsy.manager.web.util.PageUtil;
import net.dqsy.manager.web.util.ParamUtils;
import net.dqsy.manager.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("departmentApply")
public class DepartmentApplyController {
    @Autowired
    private SensitiveService sensitiveService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IDepartmentApplyService departmentApplyService;

    @RequestMapping("add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if (account == null) {
            ModelAndView mav = new ModelAndView("redirect:/index");
            return mav;
        }
        List<Department> departmentList = departmentService.findList(0, 1, 0);
        ModelAndView mav = new ModelAndView("departmentApply/apply");
        mav.getModel().put("departmentList", departmentList);
        return mav;
    }

    @RequestMapping("list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if (account == null) {
            ModelAndView mav = new ModelAndView("redirect:/index");
            return mav;
        }
        int start = ParamUtils.getIntParameter(request, "start", 1);
        int limit = ParamUtils.getIntParameter(request, "limit", 10);
        List<DepartmentApply> list = departmentApplyService.findApplyList(account.getId(), start, limit);
        if(list.size()> 0){
            for(DepartmentApply departmentApply :list){
                Department department = departmentService.findDepartmentById(departmentApply.getDepartmentId());
                departmentApply.setDepartmentName(department.getName());
                if (departmentApply.getType() == 4) {
                    departmentApply.setTypeName("部长");
                } else if (departmentApply.getType() == 5) {
                    departmentApply.setTypeName("副部长");
                } else if (departmentApply.getType() == 6) {
                    departmentApply.setTypeName("部员");
                }
            }
        }
        int totalCount = departmentApplyService.getTotalCount(account.getId());
        String pagation = PageUtil.getPagation("/departmentApply/list", totalCount, start, limit);

        ModelAndView mav = new ModelAndView("departmentApply/list");
        mav.getModel().put("pageCode", pagation);
        mav.getModel().put("applyList", list);
        return mav;
    }


    @RequestMapping("getDepartmentList")
    public void getDepartmentList(HttpServletRequest request, HttpServletResponse response){

        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if (account == null) {
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }
        List<Department> departmentList = departmentService.findList(0, 1, 0);
        ResultUtil.success(departmentList, response);
    }


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
    @RequestMapping("delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){

        Long applyId = ParamUtils.getLongParameter(request, "applyId");
        DepartmentApply apply = departmentApplyService.findById(applyId);
        if(apply == null){
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }
        departmentApplyService.deleteById(apply.getId());
        ResultUtil.success(response);
    }
    @RequestMapping("detail")
    public ModelAndView detail(HttpServletRequest request, HttpServletResponse response){
        Long applyId = ParamUtils.getLongParameter(request, "applyId");
        DepartmentApply apply = departmentApplyService.findById(applyId);
        ModelAndView mav = new ModelAndView("departmentApply/detail");
        Department department = departmentService.findDepartmentById(apply.getDepartmentId());
        apply.setDepartmentName(department.getName());
        if (apply.getType() == 4) {
            apply.setTypeName("部长");
        } else if (apply.getType() == 5) {
            apply.setTypeName("副部长");
        } else if (apply.getType() == 6) {
            apply.setTypeName("部员");
        }
        mav.getModel().put("apply", apply);
        return mav;
    }


}
