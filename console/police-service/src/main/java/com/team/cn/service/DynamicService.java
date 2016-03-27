package com.team.cn.service;

import com.team.cn.domain.Dynamic;
import com.team.cn.entity.DynamicEntity;
import com.team.cn.mapper.DynamicEntityMapper;
import com.team.cn.utils.ConsoleUtils;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pein on 2016/3/15.
 */
@Service
public class DynamicService {

    @Autowired
    private DynamicEntityMapper dynamicEntityMapper;

    @Autowired
    private FileService fileService;

    /**
     * 查询总页数
     * @param beginDate
     * @param endDate
     * @param pageSize
     * @return
     */
    public int selectDynamicSize(String beginDate, String endDate, int pageSize) {
        int count = dynamicEntityMapper.selectSizeByPage(buildParam(beginDate, endDate));
        int size = count%pageSize==0?count/pageSize:count/pageSize+1;
        return size;
    }

    public List<Dynamic> selectDynamicByPage(String beginDate, String endDate, int pageNum, int pageSize) {
        int pageNo = (pageNum - 1) * pageSize;
        List<DynamicEntity> dynamicEntityList = dynamicEntityMapper.selectDynamicByPage(buildParam(beginDate, endDate, pageNo, pageSize));
        return generateDynamic(dynamicEntityList);
    }

    public Dynamic selectDynamicById(String id) {
        DynamicEntity dynamicEntity = dynamicEntityMapper.selectDynamicById(id);
        if (dynamicEntity == null) {
            return null;
        }
        return ConsoleUtils.copyProperties(dynamicEntity, Dynamic.class);
    }
    /**
     * 保存数据到数据库，同时上传图片
     */
    @Transactional
    public void addDynamic(Dynamic dynamic,MultipartFile imageFile) throws IOException {
        String pathAll = fileService.upload(imageFile);
        dynamic.setImageUrl(pathAll);
        dynamic.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        dynamicEntityMapper.insertDynamic(ConsoleUtils.copyProperties(dynamic,DynamicEntity.class));
    }

    /**
     * 保存数据到数据库，同时上传图片
     */
    @Transactional
    public void editDynamic(Dynamic dynamic,MultipartFile imageFile) throws IOException {
        String pathAll = fileService.upload(imageFile);
        dynamic.setImageUrl(pathAll);
        dynamic.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        dynamicEntityMapper.updateDynamic(ConsoleUtils.copyProperties(dynamic, DynamicEntity.class));
    }

    /**
     * 删除
     * 仅仅删除表中记录，不对文件做处理
     */
    public void deleteDynamicById(String id){
        dynamicEntityMapper.deleteDynamicById(id);
    }


    private List<Dynamic> generateDynamic(List<DynamicEntity> dynamicEntityList) {
        List<Dynamic> dynamicList = new ArrayList<Dynamic>();
        for (DynamicEntity dynamicEntity : dynamicEntityList) {
            Dynamic dynamic = new Dynamic();
            ConsoleUtils.copySameProperties(dynamic, dynamicEntity);
            dynamicList.add(dynamic);
        }
        return dynamicList;
    }


    private Map<String, Object> buildParam(String beginDate, String endDate) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if(!StringUtil.isEmpty(beginDate)){
            paramMap.put("beginDate", beginDate);
        }
        if(!StringUtil.isEmpty(endDate)){
            paramMap.put("endDate", endDate);
        }
        return paramMap;
    }

    private Map<String, Object> buildParam(String beginDate, String endDate, int pageNo, int pageSize) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if(!StringUtil.isEmpty(beginDate)){
            paramMap.put("beginDate", beginDate);
        }
        if(!StringUtil.isEmpty(endDate)){
            paramMap.put("endDate", endDate);
        }
        paramMap.put("pageNo", pageNo);
        paramMap.put("pageSize", pageSize);
        return paramMap;
    }

}
