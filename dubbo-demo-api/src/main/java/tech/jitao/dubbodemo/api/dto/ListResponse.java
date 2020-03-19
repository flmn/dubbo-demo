package tech.jitao.dubbodemo.api.dto;

import java.io.Serializable;
import java.util.List;

public class ListResponse<T> implements Serializable {
    private static final long serialVersionUID = -819872122005641456L;

    private List<T> items;
    private Long total;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
