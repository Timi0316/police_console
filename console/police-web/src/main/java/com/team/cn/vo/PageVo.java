package com.team.cn.vo;

/**
 * Created by pein on 2016/3/15.
 */
public class PageVo {

    /*每页记录数*/
    private int pageSize;

    /*当前页编号*/
    private int pageNum;

    private String beginDate;

    private String endDate;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
