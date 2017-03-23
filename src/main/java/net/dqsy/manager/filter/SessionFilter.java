package net.dqsy.manager.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by CAI on 2017/3/23.
 */
public class SessionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 不过滤的uri
        String[] notFilter = new String[] {"login","logon"};

        // 请求的uri
        String uri = request.getRequestURI();

        // uri中包含background时才进行过滤
        if (uri.indexOf("/") != -1) {
            // 是否过滤
            boolean doFilter = true;
            for (String s : notFilter) {
                if (uri.indexOf(s) != -1) {
                    // 如果uri中包含不过滤的uri，则不进行过滤
                    doFilter = false;
                    break;
                }
            }
            if (doFilter) {
                // 执行过滤
                // 从session中获取登录者实体
                Object obj = request.getSession().getAttribute("username");
                if (null == obj) {
                    // 如果session中不存在登录者实体，则弹出框提示重新登录
                   response.sendRedirect("redirect:/login");

                } else {
                    // 如果session中存在登录者，则继续
                    filterChain.doFilter(request, response);
                }
            } else {
                // 如果不执行过滤，则继续
                filterChain.doFilter(request, response);
            }
        } else {
            // 如果uri中不包含/，则继续
            filterChain.doFilter(request, response);
        }
    }
}

