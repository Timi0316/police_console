package com.team.cn.mapper;

import com.team.cn.entity.DynamicEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by pein on 2016/3/15.
 */
@Repository
public interface DynamicEntityMapper {

    public List<DynamicEntity> selectDynamicByPage(Map<String,Object> paramMap);

    public int selectSizeByPage(Map<String,Object> paramMap);

    public void insertDynamic(DynamicEntity dynamicEntity);

    public DynamicEntity selectDynamicById(String id);

    public void updateDynamic(DynamicEntity dynamicEntity);

    public void deleteDynamicById(String id);
}
