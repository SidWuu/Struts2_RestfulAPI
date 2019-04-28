package com.myself.api.struts.rest.portals.action;

import com.myself.api.struts.rest.portals.service.PortalService;
import com.myself.api.struts.rest.portals.vo.Portal;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PortalsController extends ActionSupport implements ModelDriven<Object> {

    private Long id;
    private Portal bean;
    private List<Portal> list;
    private PortalService portalService;

    /**
     * GET
     * /struts/rest/portals/1.do
     * @return
     */
    public HttpHeaders show() {
        try {
            if (null != id) {
                setBean(portalService.get(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultHttpHeaders("show");
    }

    /**
     * GET
     * /struts/rest/portals.do
     * @return
     */
    public HttpHeaders index() {
        try {
            setList(portalService.query());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultHttpHeaders("index").disableCaching();
    }

    /**
     * GET
     * /strust/rest/portals/1/edit.do
     * @return
     */
    public String edit() {
        try {
            if (null != id) {
                setBean(portalService.get(id));
                System.out.println("修改");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "edit";
    }

    /**
     * GET
     * /rest/portals/new.do
     * @return
     */
    public String editNew() {
        try {
            setBean(new Portal());
            System.out.println("新单");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "editNew";
    }

    /**
     * GET
     * /rest/portals/1/deleteConfirm.do
     * @return
     */
    public String deleteConfirm() {
        if (null != id) {
            setBean(portalService.get(id));
            System.out.println("删除确认");
        }
        return "deleteConfirm";
    }

    /**
     * DELETE
     * /rest/portals/1.do?_method="DELETE"
     * @return
     */
    public HttpHeaders destroy() {
        try {
            portalService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index();
    }

    /**
     * POST
     * /rest/portals.do
     * @return
     */
    public HttpHeaders create() {
        try {
            portalService.save(bean);
            HttpServletResponse response = ServletActionContext.getResponse();
            HttpServletRequest request = ServletActionContext.getRequest();
            String accept = request.getHeader("Accept");
            if (accept.contains("text/html")) { // 页面视图过来的
                response.sendRedirect("portals/");
            } else if (accept.contains("text/xml")) { // 发送xml过来的
                response.sendRedirect("portals/" + bean.getId() + ".xml");
            } else { // 其它的返回json视图
                response.sendRedirect("portals/" + bean.getId() + ".json");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * PUT
     * /rest/portals/1.do?_method="PUT"
     * @return
     */
    public HttpHeaders update() {
        try {
            portalService.update(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index();
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

    @Override
    public Object getModel() {
        return null != list ? list : bean;
    }
}
