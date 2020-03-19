package tech.jitao.dubbodemo.api.dto;

import java.io.Serializable;

public class FilterCondition implements Serializable {
    private static final long serialVersionUID = 5796534432914857980L;

    private String field; // 字段
    private FilterOperator operator; // 操作符
    private String value1; // 值1
    private String value2; // 值2

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public FilterOperator getOperator() {
        return operator;
    }

    public void setOperator(FilterOperator operator) {
        this.operator = operator;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
