package tech.jitao.dubbodemo.bff.common.request;

import com.google.common.base.Strings;
import tech.jitao.dubbodemo.api.dto.CommonListRequest;

import javax.validation.constraints.Size;

public class SearchingRequest extends FilteringRequest {

    @Size(max = 32)
    private String keyword;

    public CommonListRequest toCommonListRequest() {
        CommonListRequest request = new CommonListRequest();
        request.setCurrentPage(getCurrentPage());
        request.setPageSize(getPageSize());
        request.setFilters(toFilterConditions());
        request.setSort(Strings.nullToEmpty(getSort()));
        request.setKeyword(Strings.nullToEmpty(getKeyword()));

        return request;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
