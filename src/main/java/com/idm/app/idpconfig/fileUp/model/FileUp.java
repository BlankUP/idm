package com.idm.app.idpconfig.fileUp.model;

import java.io.Serializable;

/**
 * @author: pl
 * @desc:文件
 * @date: 2020/9/18
 */
public class FileUp implements Serializable {
    private String fileCode;
    private String fileName;
    private String status;

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FileUp{" +
                "fileCode='" + fileCode + '\'' +
                ", fileName='" + fileName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
