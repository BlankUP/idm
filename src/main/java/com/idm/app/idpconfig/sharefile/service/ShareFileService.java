package com.idm.app.idpconfig.sharefile.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.sharefile.mapper.ShareFileMapper;
import com.idm.app.idpconfig.sharefile.model.ShareFile;

/**
 * 
 *<p>Title: ShareFileService</p>  
 * @Description: 文件路径service
 * @author 黄百超
 * @date 2019年3月4日
 * @version  1.0
 *
 */
@Service
public class ShareFileService {
	@Resource
	ShareFileMapper shareFileMapper;

	public List<ShareFile> queryShareFile(ShareFile shareFile) {
		return shareFileMapper.queryShareFile(shareFile);
	}
    public long addShareFile(ShareFile shareFile) throws Exception
    {
        return shareFileMapper.addShareFile(shareFile);
    }
    public long queryVersion() throws Exception
    {
        return shareFileMapper.queryVersion();
    }
}
