package com.deng.malltiny.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 1.其实，在service里面PageHelper.startPage（pagenum,pagesize)（相当于limit）已经发挥作用
 * 这四个api都只是封装着返回结果
 * 2.这个api封装了要返回的结果（pageNum,pageSize,pageTotal,total,list),而这些数据由restPage
 * 方法分析由service.listBrand返回的结果而得出，
 */
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer pageTotal;
    private Long total;
    private List<T> list;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static <T> CommonPage<T> restPage(List<T> list){
        CommonPage<T> commonPage = new CommonPage();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setList(pageInfo.getList());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotal(pageInfo.getTotal());
        return commonPage;

    }
}
