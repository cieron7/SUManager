package net.dqsy.manager.controller;


import net.dqsy.manager.web.dto.MenuDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("manage")
public class ManageRedirectController {
    @RequestMapping("")
    public String managePage(Model model){
        // 临时配置左侧菜单
        List<MenuDTO> list = new ArrayList<>();

        MenuDTO menu01 = new MenuDTO("机构管理", "");
        MenuDTO menu02 = new MenuDTO("部门管理", "");
        MenuDTO menu03 = new MenuDTO("机构信息管理", "");
        MenuDTO menu04 = new MenuDTO("机构信息管理", "");

        list.add(menu01);
        list.add(menu02);
        list.add(menu03);
        list.add(menu04);
        model.addAttribute("menu",list);


        return "main";
    }
}
