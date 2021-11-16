package cn.wormholestack.mse.common.model.base;

/**
 * @description： BasePageVO
 * @Author MRyan
 * @Date 2021/11/13 17:10
 * @Version 1.0
 */
public class BasePageVO extends BaseVO {
    /**
     * 当前页 1开始
     */
    private Integer currentPage;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 排序类型 - desc  asc
     */
    private String sortType = "desc";

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}