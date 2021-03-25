package com.idm.app.idpconfig.sharefile.mapper;

import java.util.List;

import com.idm.app.idpconfig.sharefile.model.ShareFile;

/**
 * 
 *<p>Title: ShareFileMapper</p>  
 * @Description: 文件路径Mapper
 * @author 黄百超
 * @date 2019年3月4日
 * @version  1.0
 *
 */
public interface ShareFileMapper {

	List<ShareFile> queryShareFile(ShareFile shareFile);
	long addShareFile(ShareFile shareFile) throws Exception;
	long queryVersion() throws Exception;

}
