package net.dqsy.manager.web.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LocalizationUtil {
	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$
	private static final String MISSING_BUNDLE = "!Missing bundle {0}!"; //$NON-NLS-1$
	private static final String MISSING_KEY = "!{0}!"; //$NON-NLS-1$
	private static ClassLoader classLoader = LocalizationUtil.class.getClassLoader();

	private LocalizationUtil() {
	}

	public static String getClientString(String key, HttpServletRequest request) {
		try {
			if (request == null) {
				return getString(BUNDLE_NAME, key, null);
			}
			return getString(BUNDLE_NAME, key, getLocale(request));
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String getClientString(String key, Locale locale) {
		if (locale == null)
			locale = Locale.CHINA;
		return getString(BUNDLE_NAME, key, locale);
	}

	public static String getClientString(String key, Object[] params, Locale locale) {
		try {
			return MessageFormat.format(getString(BUNDLE_NAME, key, locale), params);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static Locale getLocale(HttpServletRequest request) {
		// Locale locale = request.getLocale();
		Locale locale = Locale.CHINA;
		String localeValue = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			String localeInCookie = "";
			for (int i = 0; i < cookies.length; i++) {
				// TODO: 2017/3/24 登陆设置cookie
				if (cookies[i].getName().equalsIgnoreCase("su_locale")) {
					localeInCookie = cookies[i].getValue();
					localeValue = localeInCookie;
					break;
				}
			}
		}
		// String localeInSession = (String)
		// request.getSession().getAttribute("locale");
		// System.out.println("localeInSession:"+localeInSession);
		// if (!StringUtil.isNull(localeInSession)) {
		// localeValue = localeInSession;
		// }
		if (!StringUtils.isBlank(localeValue)) {
			if (localeValue.equalsIgnoreCase("zh")) {
				locale = Locale.CHINA;
			} else {
				locale = Locale.US;
			}
		} else {
			/*
			 * Set default language be chinese. If you want to make it changed
			 * by browser, only open the blow; locale = request.getLocale();
			 */
			locale = Locale.CHINA;
		}

		if (!locale.equals(Locale.CHINA)) {
			locale = Locale.US;
		}
		return locale;
	}

	public static String getClientString(String key, Object[] params, HttpServletRequest request) {
		try {
			return MessageFormat.format(getString(BUNDLE_NAME, key, getLocale(request)), params);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	private static String getEnglishString(String bundleName, String key) {
		String message;
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle(bundleName, Locale.ENGLISH, classLoader);
			message = getMessage(key, resourceBundle);
		} catch (MissingResourceException missingBundle) {
			message = getMissingBundleMessage(bundleName);
		}
		return message;
	}

	private static String getString(String bundleName, String key, Locale locale) {
		if (key == null)
			throw new IllegalArgumentException("key must not be null"); //$NON-NLS-1$
		String message = null;
		ResourceBundle resourceBundle = null;
		if (locale == null) {
			// Default use chinese
			locale = Locale.CHINA;
		}
		try {
			if (locale != null) {
				resourceBundle = ResourceBundle.getBundle(bundleName, locale, classLoader);
				message = getMessage(key, resourceBundle);
			}
		} catch (MissingResourceException missingBundle) {
			message = getMissingBundleMessage(bundleName);
		}
		// Default use english string
		if (message == null) {
			message = getEnglishString(bundleName, key);
		}
		return message;
	}

	private static String getMessage(String key, ResourceBundle resourceBundle) {
		String message;
		try {
			message = resourceBundle.getString(key);
		} catch (MissingResourceException exception) {
			message = MessageFormat.format(MISSING_KEY, key);
		}
		return message;
	}

	private static String getMissingBundleMessage(String bundleName) {
		String message = MessageFormat.format(MISSING_BUNDLE, bundleName);
		return message;
	}

	public static String getMyUrl(HttpServletRequest request) {
		String myUrl = request.getRequestURL().toString();
		if(request.getQueryString() != null){
			myUrl +=  "?" + request.getQueryString();
		}
		return myUrl;
	}
	
	/**
	 * 设置cookie
	 * @author heyuxing
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期  以秒为单位 
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, Integer maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge != null)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	/**
	 * 将cookie封装到Map里面
	 * @author heyuxing
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
	
	/**
	 * 根据名字获取cookie
	 * @author heyuxing
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request,String name){
		if (name == null) {
			return null;
		}
	    Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;  
	}
}
