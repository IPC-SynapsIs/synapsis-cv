package org.synapsis.resource.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.synapsis.Repository.ICurriculumVitaeRepository;
import org.synapsis.entity.CurriculumVitae;
import org.synapsis.resource.ICurriculumVitaeResource;


import java.net.URI;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@RestController
@RequestMapping(value = "/cv")
public class CurriculumVitaeResource implements ICurriculumVitaeResource {

    @Autowired
    ICurriculumVitaeRepository curriculumVitaeDao;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity get(@PathVariable("id") String id) {
        CurriculumVitae curriculumVitae = curriculumVitaeDao.findOne(UUID.fromString(id));
        return (curriculumVitae==null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(curriculumVitae);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity getAll() {
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeDao.findAll();
        return ResponseEntity.ok(curriculumVitaeList);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity add(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return ResponseEntity.created(URI.create("/cv/"+curriculumVitae.getId())).build();
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity update(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity remove(String id) {
        curriculumVitaeDao.delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = {"/ping"},method = RequestMethod.GET)
    public ResponseEntity ping(){
        return ResponseEntity.ok("pong");

    }
}
