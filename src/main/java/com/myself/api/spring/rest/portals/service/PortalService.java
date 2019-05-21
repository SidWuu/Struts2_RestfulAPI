package com.myself.api.spring.rest.portals.service;

import com.myself.api.common.vo.Portal;
import com.myself.api.common.vo.PortalList;

public interface PortalService {
    public PortalList query();

    public Portal get(Long id);

    public void save(Portal bean);

    public void update(Portal bean);

    public void delete(Long id);
}
