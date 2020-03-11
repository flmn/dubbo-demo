package tech.jitao.dubbodemo.bff.common.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class IntegerIdRequest {

    @NotNull
    @Positive
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
