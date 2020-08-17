package org.caohh.albol.controller;

import org.caohh.albol.service.ResourceService;
import org.caohh.albol.vo.Resource;
import org.caohh.albol.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/search")
    public Result search(Resource resource){
        return resourceService.search(resource);
    }

    @PostMapping("/save")
    public Result save(@RequestBody  Resource resource){
        return resourceService.save(resource);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return resourceService.delete(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Resource resource){
        return resourceService.update(resource);
    }
}
