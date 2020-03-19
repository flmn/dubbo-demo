package tech.jitao.dubbodemo.bff.common.request;

import javax.validation.constraints.*;

public class PagingRequest {

    @NotNull
    @Positive
    private Integer currentPage = 1;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer pageSize = 15;

    @Size(max = 32)
    private String sort;

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
