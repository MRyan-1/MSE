package cn.wormholestack.mse.common.model.base;

/**
 * @description： 分页
 * @Author MRyan
 * @Date 2021/11/13 14:11
 * @Version 1.0
 */
public class BasePage extends BaseReq {

    /**
     * 当前页 1开始
     */
    private Integer currentPage;

    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 排序类型 desc  asc
     */
    private String sortType;

    /**
     * 排序字段
     */
    private String sortFiled;


    public Integer getCurrentPage() {
        return currentPage == null ? 0 : currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
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

    public String getSortFiled() {
        return sortFiled;
    }

    public void setSortFiled(String sortFiled) {
        this.sortFiled = sortFiled;
    }
}
