package com.myself.api.spring.rest.portals.action;

import com.myself.api.common.vo.Portal;
import com.myself.api.common.vo.PortalList;
import com.myself.api.spring.rest.portals.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/sso/*")
public class PortalsController {

    @Autowired
    private PortalService portalService;
    private Long id;
    private Portal bean;
    private PortalList list;
    /**
     * GET
     * /rest/sso/portals/1
     * @return
     */
    @RequestMapping(value = "/portals/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ResponseBody
    public Portal show(@PathVariable("id") Long id) {
        try {
            if (null != id) {
                setBean(portalService.get(id));
                System.out.println("查看");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * GET
     * /rest/sso/portals
     * @return
     */
    @RequestMapping(value = "/portals", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ResponseBody
    public PortalList index() {
        try {
            setList(portalService.query());
            System.out.println("查询");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * DELETE
     * /rest/portals/1.do?_method="DELETE"
     * @return
     */
    public PortalList destroy() {
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
    public String create(HttpServletRequest request, HttpServletResponse response) {
        try {
            portalService.save(bean);
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
    public PortalList update() {
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

    public PortalList getList() {
        return list;
    }

    public void setList(PortalList list) {
        this.list = list;
    }
}
