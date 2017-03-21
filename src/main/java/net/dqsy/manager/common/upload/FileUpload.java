package net.dqsy.manager.common.upload;

import net.dqsy.manager.web.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传
 */
@RequestMapping(value = "/file")
public class FileUpload {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String filePath = "c:/uploadfile";
        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID() + "-" + fileName;
        File targetFile = new File(filePath, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map result = new HashMap<String, Object>();
        result.put("url", fileName);
        ResultUtil.success(result, response);
    }
}
