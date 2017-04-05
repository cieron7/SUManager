package net.dqsy.manager.web.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class WebUtil {

	public static long getUserId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String value = "";
        for (Cookie cookie :cookies){
            if("su".equals(cookie.getName())){
                value = cookie.getValue();
                break;
            }
        }
        //todo AES 解密
        return Long.valueOf(value);
    }
}
