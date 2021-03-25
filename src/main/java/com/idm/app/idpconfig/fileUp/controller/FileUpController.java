package com.idm.app.idpconfig.fileUp.controller;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @author: pl
 * @desc:控制层
 * @date: 2020/9/18
 */
public class FileUpController {

    private Logger logger = Logger.getLogger(FileUpController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/up_file_show")
    public String fileUpInfo(Model model){
        return "upFile";
    }

    @RequestMapping(value = "/up_file_import",method = RequestMethod.POST)
    @ResponseBody
    public void importExcel(@RequestParam("file")MultipartFile filee, HttpServletRequest request){
        filee.getOriginalFilename();
        InputStream inputStream = null;
        try {
            inputStream = filee.getInputStream();
            FileUtils.copyInputStreamToFile(inputStream,new File("E:\\Test\1.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/up_fileArray_import",method = RequestMethod.POST)
    @ResponseBody
    public String importExcel(@RequestParam("file")MultipartFile[] filee, HttpServletRequest request){
        InputStream inputStream = null;
        File file1 = null;
        for(MultipartFile ps: filee){
            ps.getOriginalFilename();
            try {
                inputStream = ps.getInputStream();
                file1 = new File("E:\\Test\1.xls");
                FileUtils.copyInputStreamToFile(inputStream,file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String message = "表格数据上传成功！";

        return message;
    }
}
