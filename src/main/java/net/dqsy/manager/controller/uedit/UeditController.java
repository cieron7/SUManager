package net.dqsy.manager.controller.uedit;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.dqsy.manager.web.util.ResultUtil;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class UeditController extends MultiActionController {

    /**
     * @param request
     * @param response
     */
    public void config(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        // 上传图片配置
        result.put("imageActionName", "uploadimage");
        result.put("imageFieldName", "upfile");
        result.put("imageMaxSize", "2048000");
        result.put("imageAllowFiles", "[\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"]");
        result.put("imageCompressEnable", "true");
        result.put("imageCompressBorder", "1600");
        result.put("imageUrlPrefix", "");
        result.put("imagePathFormat", "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}");

        // 上传视频配置
        result.put("videoActionName", "uploadvideo");
        result.put("videoFieldName", "upfile");
        result.put("videoPathFormat", "/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}");
        result.put("videoUrlPrefix", "");
        result.put("videoMaxSize", "102400000");
        result.put("videoAllowFiles", "[" +
                "\".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", " +
                "\".mpg\",\".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\"" +
                "]");

        //上传文件配置
        result.put("fileActionName", "uploadfile");
        result.put("fileFieldName", "upfile");
        result.put("filePathFormat", "/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}");
        result.put("fileUrlPrefix", "");
        result.put("fileMaxSize", "51200000");
        result.put("fileAllowFiles", "[" +
                "\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\".flv\", \".swf\"," +
                " \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\".ogg\", " +
                "\".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", " +
                "\".mid\",\".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\"," +
                " \".iso\",\".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml]");


        String jsonString = JSON.toJSONString(result);
        try {
            byte[] bout = jsonString.getBytes("UTF-8");
            ResultUtil.outputData(bout, response);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
    }


}
