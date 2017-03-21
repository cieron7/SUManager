package net.dqsy.manager.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.dqsy.manager.pojo.ResultBean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author jingzhibao
 * @version 1.0.0 2017/3/21 11:45
 */
public class ResultUtil {

    private static SerializerFeature[] features = {
            SerializerFeature.WriteNullBooleanAsFalse,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteDateUseDateFormat,
            SerializerFeature.WriteNullNumberAsZero
    };

    /**
     * 安全隐私协议
     */
    public static void addP3P(HttpServletResponse response) {
        response.addHeader("p3p", "CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
    }

    /**
     * 调用成功，没有数据返回
     *
     * @param response
     */
    public static void success(HttpServletResponse response) {
        success(null, "请求成功！", response);
    }

    /**
     * 调用成功,返回数据
     *
     * @param response
     */
    public static <T> void success(T obj, HttpServletResponse response) {
        success(obj, "请求成功！", response);
    }


    /**
     * 调用成功
     *
     * @param obj      返回的数据
     * @param message  消息
     * @param response
     * @param <T>
     */
    public static <T> void success(T obj, String message, HttpServletResponse response) {
        addP3P(response);
        ResultBean<T> resultBean = new ResultBean(true, message, obj);
        String jsonString = JSON.toJSONString(resultBean, features);
        byte[] bout = null;
        try {
            bout = jsonString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        outputData(bout, response);
    }

    /**
     * 调用成功，没有数据返回
     *
     * @param response
     */
    public static void fail(HttpServletResponse response) {
        fail("请求失败！", response);
    }

    public static void fail(String message, HttpServletResponse response) {
        addP3P(response);
        ResultBean resultBean = new ResultBean(false, message);
        String jsonString = JSON.toJSONString(resultBean, features);
        byte[] bout = null;
        try {
            bout = jsonString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        outputData(bout, response);
    }

    private static void outputData(byte[] bout, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            OutputStream out = response.getOutputStream();
            out.write(bout);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
