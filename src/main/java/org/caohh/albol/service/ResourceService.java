package org.caohh.albol.service;

import org.caohh.albol.vo.Resource;
import org.caohh.albol.vo.Result;
import org.springframework.stereotype.Service;

@Service
public interface ResourceService {
    Result search(Resource resource);

    Result save(Resource resource);

    Result delete(Long id);

    Result update(Resource resource);

}
