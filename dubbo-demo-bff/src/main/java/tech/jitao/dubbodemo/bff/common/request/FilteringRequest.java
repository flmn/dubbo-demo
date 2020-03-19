package tech.jitao.dubbodemo.bff.common.request;

import com.google.common.base.Strings;
import tech.jitao.dubbodemo.api.dto.FilterCondition;
import tech.jitao.dubbodemo.api.dto.FilterOperator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringRequest extends PagingRequest {
    private List<Filter> filters = Collections.emptyList();

    public List<FilterCondition> toFilterConditions() {
        return filters.stream().map(f -> {
            FilterCondition fc = new FilterCondition();
            fc.setField(f.getF());
            fc.setOperator(FilterOperator.valueOf(f.getOp()));
            fc.setValue1(Strings.nullToEmpty(f.getV1()));
            fc.setValue2(Strings.nullToEmpty(f.getV2()));

            return fc;
        }).collect(Collectors.toList());
    }

    private static class Filter {
        private String f;
        private String op;
        private String v1;
        private String v2;

        public String getF() {
            return f;
        }

        public void setF(String f) {
            this.f = f;
        }

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }

        public String getV1() {
            return v1;
        }

        public void setV1(String v1) {
            this.v1 = v1;
        }

        public String getV2() {
            return v2;
        }

        public void setV2(String v2) {
            this.v2 = v2;
        }
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }
}
