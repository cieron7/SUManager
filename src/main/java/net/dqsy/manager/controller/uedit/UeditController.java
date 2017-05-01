package net.dqsy.manager.controller.uedit;


import com.alibaba.fastjson.JSON;
import net.dqsy.manager.web.util.ResultUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class UeditController extends MultiActionController {

    String filePath= "c:/uploadfile";
    String domain = "http://img.desy.net/";

    /**
     * @param request
     * @param response
     */
    public void config(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Resource fileRource = new ClassPathResource("config.json");
        InputStream is = fileRource.getInputStream();
        InputStreamReader reader = new InputStreamReader(is, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            out.println(line);
        }
    }

    public void uploadimage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String path =filePath + "/images";
        //List<Map<String, Object>> resultList = new ArrayList();
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        Map<String, Object> result = new HashMap<>();
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                String fileName = file.getOriginalFilename();
                fileName = UUID.randomUUID() + "-" + fileName;
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                if (file != null) {
                    //上传
                    file.transferTo(targetFile);
                    result.put("state","SUCCESS");
                    result.put("original", fileName);
                    result.put("size", file.getSize());
                    result.put("title", fileName);
                    String prefix=fileName.substring(fileName.lastIndexOf("."));
                    result.put("type", prefix);
                    result.put("url", domain + "images/" + fileName);
                    //resultList.add(result);
                }
            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
        String jsonString = JSON.toJSONString(result);
        byte[] bout = null;
        try {
            bout = jsonString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        ResultUtil.outputData(bout, response);

    }

    public void uploadvideo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path =filePath + "/video";
        //List<Map<String, Object>> resultList = new ArrayList();
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        Map<String, Object> result = new HashMap<>();
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                String fileName = file.getOriginalFilename();
                fileName = UUID.randomUUID() + "-" + fileName;
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                if (file != null) {
                    //上传
                    file.transferTo(targetFile);
                    result.put("state","SUCCESS");
                    result.put("original", fileName);
                    result.put("size", file.getSize());
                    result.put("title", fileName);
                    String prefix=fileName.substring(fileName.lastIndexOf("."));
                    result.put("type", prefix);
                    result.put("url", domain + "video/" + fileName);
                    //resultList.add(result);
                }
            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
        String jsonString = JSON.toJSONString(result);
        byte[] bout = null;
        try {
            bout = jsonString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        ResultUtil.outputData(bout, response);



    }


}
