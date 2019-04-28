package com.myself.api.struts.rest.portals.action;

import com.myself.api.struts.rest.portals.service.PortalService;
import com.myself.api.struts.rest.portals.vo.Portal;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.List;

public class PortalsController {

    private Long id;
    private Portal bean;
    private List<Portal> list;
    private PortalService portalService;

    public HttpHeaders show() {
        try {
            if (null != id) {

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultHttpHeaders("show");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Portal getBean() {
        return bean;
    }

    public void setBean(Portal bean) {
        this.bean = bean;
    }

    public List<Portal> getList() {
        return list;
    }

    public void setList(List<Portal> list) {
        this.list = list;
    }

    public void setPortalService(PortalService portalService) {
        this.portalService = portalService;
    }
}
