package com.idm.app.idpconfig.bom.mapper;

import java.util.List;

import com.idm.app.idpconfig.bom.model.BomInfo;
import com.idm.app.idpconfig.bom.model.Field;
import com.idm.app.idpconfig.eventconfig.model.InterfaceInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ModelQParaField;
import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;


public interface BomInfoMapper {

	List<BomInfo> queryBomInfo(BomInfo bomInfo);
	List<ModelQParaField> queryModelQFieldList();
	List<Field> queryFieldList();
	List<ParaBaseInfo> getParaList();
	long addField(Field field);
	long addInterfaceInfo(InterfaceInfo interfaceInfo);
	long addBomInfo(BomInfo bomInfo) throws Exception;
	long updateBomInfo(BomInfo bomInfo) throws Exception;
	long updateAllBomInfoStatus() throws Exception;
	long updateBomInfoStatus(BomInfo bomInfo) throws Exception;
	long updateFieldStatus()throws Exception;
	long updateInterfaceInfoStatus()throws Exception;

	Integer selectCountByAll(BomInfo bomInfo) ;

}
