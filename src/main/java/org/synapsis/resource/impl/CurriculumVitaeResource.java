package org.synapsis.resource.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.synapsis.dao.ICurriculumVitaeDao;
import org.synapsis.entity.CurriculumVitae;
import org.synapsis.resource.ICurriculumVitaeResource;


import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@RestController
@RequestMapping(value = "/cv")
public class CurriculumVitaeResource implements ICurriculumVitaeResource {
    public ResponseEntity add(CurriculumVitae curriculumVitae) {
        return null;
    }

    public ResponseEntity update(CurriculumVitae curriculumVitae) {
        return null;
    }

    public ResponseEntity get(UUID id) {
        return null;
    }

    public ResponseEntity getAll() {
        return null;
    }

    public ResponseEntity remove(UUID id) {
        return null;
    }


    @RequestMapping(value = {"/ping",""},method = RequestMethod.GET)
    //@RequestMapping("/ping")
    public ResponseEntity ping(){
        return ResponseEntity.ok("pong");

    }
}
