package com.idm.app.ruleengine.datasourceManage.common.mapper;

import com.idm.app.ruleengine.datasourceManage.common.model.VColComments;
import com.idm.app.ruleengine.datasourceManage.common.model.VColCommentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VColCommentsMapper {
    long countByExample(VColCommentsExample example);

    int deleteByExample(VColCommentsExample example);

    int insert(VColComments record);

    int insertSelective(VColComments record);

    List<VColComments> selectByExample(VColCommentsExample example);

    int updateByExampleSelective(@Param("record") VColComments record, @Param("example") VColCommentsExample example);

    int updateByExample(@Param("record") VColComments record, @Param("example") VColCommentsExample example);
}