package com.myself.api.common.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 要以bean返回xml格式的list, 否则浏览器报406, 暂不知道原因
 */
@XmlRootElement(name = "portals")
public class PortalList {

    private List<Portal> list;

    public PortalList() {}

    public PortalList(List<Portal> list) {
        this.list = list;
    }

    public List<Portal> getList() {
        return list;
    }

    @XmlElement
    public void setList(List<Portal> list) {
        this.list = list;
    }
}
