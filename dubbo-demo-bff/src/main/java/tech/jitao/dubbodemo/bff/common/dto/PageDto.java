package tech.jitao.dubbodemo.bff.common.dto;

import java.util.Collections;
import java.util.List;

public class PageDto<T> {
    private static final PageDto<?> EMPTY = new PageDto<>();

    private List<T> items = Collections.emptyList();
    private String next;
    private Long total;

    @SuppressWarnings("unchecked")
    public static final <T> PageDto<T> empty() {
        return (PageDto<T>) EMPTY;
    }

    public static <T> PageDto<T> of(List<T> items) {
        PageDto<T> dto = new PageDto<>();
        dto.setItems(items);

        return dto;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
