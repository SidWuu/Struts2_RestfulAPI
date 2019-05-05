package com.myself.api.common.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "portal")
public class Portal {
    private Long id;
    private String code;
    private String name;

    public Portal() {}

    public Portal(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
}
