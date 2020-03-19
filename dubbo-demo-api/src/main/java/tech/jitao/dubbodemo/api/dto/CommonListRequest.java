package tech.jitao.dubbodemo.api.dto;

import java.io.Serializable;
import java.util.List;

public class CommonListRequest implements Serializable {
    private static final long serialVersionUID = 317215705362195859L;

    private Integer currentPage; // 页码
    private Integer pageSize; // 每页记录数
    List<FilterCondition> filters; // 筛选条件
    private String sort; // 排序字段
    private String keyword; // 搜索字

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

    public List<FilterCondition> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterCondition> filters) {
        this.filters = filters;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
