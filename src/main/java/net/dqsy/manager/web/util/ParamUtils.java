package net.dqsy.manager.web.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * This class assists skin writers in getting parameters.
 *
 * @author yeyin
 */
public class ParamUtils {
    public static final Log log = LogFactory.getLog(ParamUtils.class);

    /**
     * Gets a parameter as a string.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the parameter you want to get
     * @return The value of the parameter or null if the parameter was not found
     * or if the parameter is a zero-length string.
     */
    public static String getParameter(HttpServletRequest request, String name) {
        return getParameter(request, name, false);
    }

    /**
     * Gets a parameter as a string.
     *
     * @param request        The HttpServletRequest object, known as "request" in a JSP
     *                       page.
     * @param name           The name of the parameter you want to get
     * @param emptyStringsOK Return the parameter values even if it is an empty string.
     * @return The value of the parameter or null if the parameter was not
     * found.
     */
    public static String getParameter(HttpServletRequest request, String name, boolean emptyStringsOK) {
        try {
            String temp = request.getParameter(name);
            if (temp != null) {
                if (temp.equals("") && !emptyStringsOK) {
                    return null;
                } else {
                    // TODO: 2017/3/18  过滤请求中的敏感词
                    // temp = JunkWordsUtil.filterSensitiveWord(temp);
                    return temp;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

    }

    public static String getParameter(HttpServletRequest request, String name, String defaultVal) {
        try {
            String temp = request.getParameter(name);
            if (temp == null || "".equals(temp)) {
                return defaultVal;
            } else {
                //过滤请求中的敏感词
                // temp = JunkWordsUtil.filterSensitiveWord(temp);
                return temp;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return defaultVal;
        }

    }

    /**
     * Gets a parameter as a boolean.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the parameter you want to get
     * @return True if the value of the parameter was "true", false otherwise.
     */
    public static boolean getBooleanParameter(HttpServletRequest request, String name) {
        return getBooleanParameter(request, name, false);
    }

    /**
     * Gets a parameter as a boolean.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the parameter you want to get
     * @return True if the value of the parameter was "true", false otherwise.
     */
    public static Boolean getBooleanParameter(HttpServletRequest request, String name, Boolean defaultVal) {
        String temp = request.getParameter(name);
        if ("true".equals(temp) || "on".equals(temp)) {
            return true;
        } else if ("false".equals(temp) || "off".equals(temp)) {
            return false;
        } else {
            return defaultVal;
        }
    }

    /**
     * Gets a parameter as an int.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the parameter you want to get
     * @return The int value of the parameter specified or the default value if
     * the parameter is not found.
     */
    public static int getIntParameter(HttpServletRequest request, String name, int defaultNum) {
        try {
            String temp = request.getParameter(name);
            if (temp != null && !temp.equals("")) {
                int num = defaultNum;
                try {
                    num = Integer.parseInt(temp);
                } catch (Exception ignored) {
                }
                return num;
            } else {
                return defaultNum;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return defaultNum;
        }
    }

    public static float getFloatParameter(HttpServletRequest request, String name, float defaultNum) {
        try {
            String temp = request.getParameter(name);
            if (temp != null && !temp.trim().equals("")) {
                float num = defaultNum;
                try {
                    num = Float.parseFloat(temp.trim());
                } catch (Exception ignored) {
                }
                return num;
            } else {
                return defaultNum;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return defaultNum;
        }
    }

    /**
     * Gets a list of int parameters.
     *
     * @param request    The HttpServletRequest object, known as "request" in a JSP
     *                   page.
     * @param name       The name of the parameter you want to get
     * @param defaultNum The default value of a parameter, if the parameter can't be
     *                   converted into an int.
     */
    public static int[] getIntParameters(HttpServletRequest request, String name, int defaultNum) {
        try {
            String[] paramValues = request.getParameterValues(name);
            if (paramValues == null) {
                return null;
            }
            if (paramValues.length < 1) {
                return new int[0];
            }
            int[] values = new int[paramValues.length];
            for (int i = 0; i < paramValues.length; i++) {
                try {
                    values[i] = Integer.parseInt(paramValues[i]);
                } catch (Exception e) {
                    values[i] = defaultNum;
                }
            }
            return values;
        } catch (Exception e) {
            log.error(e.getMessage());
            return new int[0];
        }
    }

    /**
     * Gets a parameter as a double.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the parameter you want to get
     * @return The double value of the parameter specified or the default value
     * if the parameter is not found.
     */
    public static double getDoubleParameter(HttpServletRequest request, String name, double defaultNum) {
        try {
            String temp = request.getParameter(name);
            if (temp != null && !temp.equals("")) {
                double num = defaultNum;
                try {
                    num = Double.parseDouble(temp);
                } catch (Exception ignored) {
                }
                return num;
            } else {
                return defaultNum;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return defaultNum;
        }
    }

    /**
     * Gets a parameter as a long.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the parameter you want to get
     * @return The long value of the parameter specified or the default value if
     * the parameter is not found.
     */
    public static long getLongParameter(HttpServletRequest request, String name, long defaultNum) {
        try {
            String temp = request.getParameter(name);
            if (temp != null && !temp.trim().equals("")) {
                long num = defaultNum;
                try {
                    num = Long.parseLong(temp.trim());
                } catch (Exception ignored) {
                }
                return num;
            } else {
                return defaultNum;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return defaultNum;
        }
    }

    public static Long getLongParameter(HttpServletRequest request, String name) {
        Long num = null;
        try {
            String temp = request.getParameter(name);
            if (StringUtils.isNoneBlank(temp)) {
                num = Long.parseLong(temp.trim());
            }
            return num;
        } catch (Exception ignore) {
            return num;
        }
    }

    /**
     * Gets a list of long parameters.
     *
     * @param request    The HttpServletRequest object, known as "request" in a JSP
     *                   page.
     * @param name       The name of the parameter you want to get
     * @param defaultNum The default value of a parameter, if the parameter can't be
     *                   converted into a long.
     */
    public static long[] getLongParameters(HttpServletRequest request, String name, long defaultNum) {
        String[] paramValues = request.getParameterValues(name);
        if (paramValues == null) {
            return null;
        }
        if (paramValues.length < 1) {
            return new long[0];
        }
        long[] values = new long[paramValues.length];
        for (int i = 0; i < paramValues.length; i++) {
            try {
                values[i] = Long.parseLong(paramValues[i]);
            } catch (Exception e) {
                values[i] = defaultNum;
            }
        }
        return values;
    }

    /**
     * Gets a parameter as a string.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the parameter you want to get
     * @return The value of the parameter or null if the parameter was not found
     * or if the parameter is a zero-length string.
     */
    public static String getAttribute(HttpServletRequest request, String name) {
        return getAttribute(request, name, false);
    }

    /**
     * Gets a parameter as a string.
     *
     * @param request        The HttpServletRequest object, known as "request" in a JSP
     *                       page.
     * @param name           The name of the parameter you want to get
     * @param emptyStringsOK Return the parameter values even if it is an empty string.
     * @return The value of the parameter or null if the parameter was not
     * found.
     */
    public static String getAttribute(HttpServletRequest request, String name, boolean emptyStringsOK) {
        String temp = (String) request.getAttribute(name);
        if (temp != null) {
            if (temp.equals("") && !emptyStringsOK) {
                return null;
            } else {
                return temp;
            }
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getAttribute(HttpServletRequest request, String name, Class<T> expectedClazz) {
        Object attributeVal = request.getAttribute(name);
        if (attributeVal == null) {
            return null;
        }
        if (expectedClazz.isAssignableFrom(attributeVal.getClass())) {
            return (T) attributeVal;
        }
        //throw new ClassCastException(attributeVal.getClass() + "cannot be cast into " + expectedClazz); //fail-fast
        return null;
    }

    /**
     * Gets an attribute as a boolean.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the attribute you want to get
     * @return True if the value of the attribute is "true", false otherwise.
     */
    public static boolean getBooleanAttribute(HttpServletRequest request, String name) {
        String temp = (String) request.getAttribute(name);
        if (temp != null && temp.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets an attribute as a int.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the attribute you want to get
     * @return The int value of the attribute or the default value if the
     * attribute is not found or is a zero length string.
     */
    public static int getIntAttribute(HttpServletRequest request, String name, int defaultNum) {
        String temp = (String) request.getAttribute(name);
        if (temp != null && !temp.equals("")) {
            int num = defaultNum;
            try {
                num = Integer.parseInt(temp);
            } catch (Exception ignored) {
            }
            return num;
        } else {
            return defaultNum;
        }
    }

    /**
     * Gets an attribute as a long.
     *
     * @param request The HttpServletRequest object, known as "request" in a JSP
     *                page.
     * @param name    The name of the attribute you want to get
     * @return The long value of the attribute or the default value if the
     * attribute is not found or is a zero length string.
     */
    public static long getLongAttribute(HttpServletRequest request, String name, long defaultNum) {
        String temp = (String) request.getAttribute(name);
        if (temp != null && !temp.equals("")) {
            long num = defaultNum;
            try {
                num = Long.parseLong(temp);
            } catch (Exception ignored) {
            }
            return num;
        } else {
            return defaultNum;
        }
    }

    /**
     * @param request
     * @param names
     * @return
     */
    public static String getOptinalParameter(HttpServletRequest request, String... names) {
        return getOptinalParameter(request, false, false, names);
    }

    public static String getOptinalParameter(HttpServletRequest request, boolean emptyStringsOK, boolean needFilter, String... names) {
        if (names == null || names.length == 0)
            return null;
        for (String name : names) {
            String paramVal = getParameter(request, name, emptyStringsOK);
            if (paramVal == null || paramVal.trim().equals("")) { //empty
                if (emptyStringsOK) return paramVal;
            } else {
                //过滤请求中的敏感词
                // if (needFilter) paramVal = JunkWordsUtil.filterSensitiveWord(paramVal);
                return paramVal;
            }
        }
        return null;
    }
}
