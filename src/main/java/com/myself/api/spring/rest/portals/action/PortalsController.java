package com.myself.api.spring.rest.portals.action;

import com.myself.api.common.Constants;
import com.myself.api.common.vo.Portal;
import com.myself.api.common.vo.PortalList;
import com.myself.api.spring.rest.portals.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sso/*")
public class PortalsController {

    @Autowired
    private PortalService portalService;

    /**
     * GET
     * spring/rest/sso/portals
     * @return
     */
    @RequestMapping(value = "/portals", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ModelMap index() {
        ModelMap modelMap = new ModelMap();
        try {
            PortalList list = portalService.query();
            System.out.println("查询");
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_OK);
            modelMap.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_ERROR);
            modelMap.addAttribute(Constants.RETURN_MSG, e.getMessage());
        }
        return modelMap;
    }

    /**
     * GET
     * spring/rest/sso/portals/1
     * @return
     */
    @RequestMapping(value = "/portals/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ModelMap show(@PathVariable("id") Long id) {
        ModelMap modelMap = new ModelMap();
        try {
            if (null != id) {
                Portal portal = portalService.get(id);
                System.out.println("查看");
                modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_OK);
                modelMap.addAttribute("bean", portal);
            } else {
                modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_WARN);
                modelMap.addAttribute(Constants.RETURN_MSG, "ID为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_ERROR);
            modelMap.addAttribute(Constants.RETURN_MSG, e.getMessage());
        }
        return modelMap;
    }

    /**
     * POST
     * spring/rest/sso/portals
     * @return
     */
    @RequestMapping(value = "/portals", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ModelMap create(@RequestParam Portal bean) {
        ModelMap modelMap = new ModelMap();
        try {
            portalService.save(bean);
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_OK);
            modelMap.addAttribute(Constants.RETURN_MSG, "新增成功");
        }catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_ERROR);
            modelMap.addAttribute(Constants.RETURN_MSG, e.getMessage());
        }
        return modelMap;
    }

    /**
     * PUT
     * spring/rest/sso/portals
     * @return
     */
    @RequestMapping(value = "/portals", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ModelMap update(@RequestParam Portal bean) {
        ModelMap modelMap = new ModelMap();
        try {
            portalService.update(bean);
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_OK);
            modelMap.addAttribute(Constants.RETURN_MSG, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_ERROR);
            modelMap.addAttribute(Constants.RETURN_MSG, e.getMessage());
        }
        return modelMap;
    }

    /**
     * DELETE
     * spring/rest/portals/1
     * @return
     */
    @RequestMapping(value = "/portals/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ModelMap destroy(@PathVariable("id") Long id) {
        ModelMap modelMap = new ModelMap();
        try {
            portalService.delete(id);
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_OK);
            modelMap.addAttribute(Constants.RETURN_MSG, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute(Constants.RETURN_STATUS, Constants.RETURN_STATUS_ERROR);
            modelMap.addAttribute(Constants.RETURN_MSG, e.getMessage());
        }
        return modelMap;
    }
}
