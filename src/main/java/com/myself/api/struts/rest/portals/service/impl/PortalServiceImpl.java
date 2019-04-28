package com.myself.api.struts.rest.portals.service.impl;

import com.myself.api.struts.rest.portals.service.PortalService;
import com.myself.api.struts.rest.portals.vo.Portal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortalServiceImpl implements PortalService {

    private static Map<Long, Portal> portals = new HashMap<>();
    static {
        portals.put(1L, new Portal(1L, "code1", "name1"));
        portals.put(2L, new Portal(2L, "code2", "name2"));
        portals.put(3L, new Portal(3L, "code3", "name3"));
        portals.put(4L, new Portal(4L, "code4", "name4"));
    }
    private static long nextId = 5;

    @Override
    public List<Portal> query() {
        return new ArrayList<Portal>(portals.values());
    }

    @Override
    public Portal get(Long id) {
        return portals.get(id);
    }

    @Override
    public void save(Portal bean) {
        if (null == bean) {
            System.out.println("数据为空");
            return;
        }
        if (null != portals.get(bean.getId())) {
            System.out.println("ID" + bean.getId() + "已存在");
            return;
        }
        portals.put(nextId++, bean);
    }

    @Override
    public void update(Portal bean) {
        if (null == bean) {
            System.out.println("数据为空");
            return;
        }
        if (null == portals.get(bean.getId())) {
            System.out.println("ID" + bean.getId() + "不存在");
            return;
        }
        portals.put(bean.getId(), bean);
    }

    @Override
    public void delete(Long id) {
        if (null == id) {
            System.out.println("ID为空");
            return;
        }
        portals.remove(id);
    }
}
