package com.idm.app.system.csvprocess.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件读取类
 *<P>Title:</P>
 *@Description:
 *@author panling
 *@date 2019年9月2日
 *@version
 */
public class FileUtils {

	 /**
     * 读文件
     * @param filePath /Users/baonier/Downloads/
     * @param fileName 2018.txt
     * @return
     */
	private static final Logger logger = LoggerFactory.getLogger(FTPUtils.class);
	
    public static List<String[]> readerFile(String filePath, String fileName){
        long currentTime = System.currentTimeMillis();
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符  防止跨平台出现路径问题
        if (!filePath.endsWith(File.separator)){
            filePath = filePath + File.separator;
        }
        // Text文件
        File file = new File(filePath+fileName);
        // 构造一个BufferedReader类来读取文件
        BufferedReader br = null;
        String s = null;
        String[] readers = null;
        List<String[]> readersList = new ArrayList<>();
        try {
            logger.info("开始读取文件路径："+filePath+"中的："+fileName);
            long readerTime = System.currentTimeMillis();
            br = new BufferedReader(new FileReader(file));
            // 使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                //拆分
                readers = s.split("\\|");
                //添加到集合中
                readersList.add(readers);
            }
            logger.info("读取文件路径："+filePath+"中的："+fileName+"一共耗时："+(System.currentTimeMillis()-readerTime));
        } catch (IOException e) {
            logger.error("读取文件路径："+filePath+"中的："+fileName+"发生异常，异常信息是：", e);
            return null;
        }finally {
            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                logger.error("关闭读取文件流发生异常，异常信息是：", e);
                return null;
                }
        }
        logger.info("call[FileUtils][readerFile]PARAMETER:[" + filePath+fileName ,System.currentTimeMillis()-currentTime+"]");
        return readersList;
    }
}
