package tech.jitao.dubbodemo.api.domain;

import java.io.Serializable;

public class Privilege implements Serializable {
    private static final long serialVersionUID = -4162441955122634513L;

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
