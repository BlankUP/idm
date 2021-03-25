package com.idm.app.idpconfig.countAnalysis.mapper;

import java.util.List;

import com.idm.app.idpconfig.countAnalysis.model.IdpRequestInfo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IdpRequestInfoMapper {

	int selectCountByAll(IdpRequestInfo idprequestinfo);

	List<IdpRequestInfo> queryIdpRequestInfo(IdpRequestInfo idprequestinfo);


    List<IdpRequestInfo> queryIdpRequestInfoExcel(IdpRequestInfo idprequestinfo);
}
