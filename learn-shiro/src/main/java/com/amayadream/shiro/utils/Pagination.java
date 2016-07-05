package com.amayadream.shiro.utils;

import java.util.List;

/**
 * 分页组件
 * @author :  Amayadream
 * @date :  2016.07.03 15:24
 */
public class Pagination<T> {

    /** 一页数据默认20条 */
    private int pageSize = 20;
    /** 当前页码 */
    private int pageNo;
    /** 上一页 */
    private int upPage;
    /** 下一页 */
    private int nextPage;
    /** 总记录数 */
    private long totalCount;
    /** 总页数 */
    private int totalPage;
    /** 数据集合 */
    private List<T> datas;
    /** 分页url */
    private String pageUrl;


    public Pagination(int pageNo, int pageSize, long totalCount) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        this.setTotalCount(totalCount);
        this.init();
    }

    private void init(){
        this.setTotalPage();    //设置总页数
        this.setUpPage();       //设置上一页
        this.setNextPage();     //设置下一页
    }

    /**
     * 获取第一条记录位置
     * @return
     */
    public int getFirstResult(){
        return (this.getPageNo() - 1) * this.getPageSize();
    }

    /**
     * 获取最后记录位置
     * @return
     */
    public int getLastResult(){
        return this.getPageNo() * this.getPageSize();
    }

    /**
     * 计算总页数
     */
    public void setTotalPage(){
        this.totalPage = (int) ((this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1) : this.totalCount / this.pageSize);
    }

    /**
     * 设置上一页
     */
    public void setUpPage(){
        this.upPage = (this.pageNo > 1) ? this.pageNo - 1 : this.pageNo;
    }

    public void setNextPage(){
        this.nextPage = (this.pageNo == this.totalPage) ? this.pageNo : this.pageNo + 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getUpPage() {
        return upPage;
    }

    public void setUpPage(int upPage) {
        this.upPage = upPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
}
