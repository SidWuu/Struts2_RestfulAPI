package com.myself.api.rest.portals.service;

import com.myself.api.rest.portals.vo.Portal;

import java.util.List;

public interface PortalService {
    public List<Portal> query();

    public Portal get(Long id);

    public void save(Portal bean);

    public void update(Portal bean);

    public void delete(Long id);
}
