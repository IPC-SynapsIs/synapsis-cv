package org.synapsis.resource.impl;

import io.swagger.annotations.*;
import io.swagger.models.Response;
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
@Api( value = "Curriculum Vitae",description = "Point d'entrée pour gerer la ressource 'Curriculum Vitae'")
public class CurriculumVitaeResource implements ICurriculumVitaeResource {

    @Autowired
    ICurriculumVitaeRepository curriculumVitaeDao;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Rechercher un 'Curriculum Vitae' par son id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "le 'Curriculum Vitae' est trouvé, on le retourne en reponse", response = CurriculumVitae.class),
            @ApiResponse(code = 404, message = "le 'Curriculum Vitae' est introuvable, on ne renvoie rien", response = void.class)})
    public ResponseEntity get(@ApiParam(value = "L'id de la ressource 'Curriculum Vitae'", required = true) @PathVariable("id") String id) {
        CurriculumVitae curriculumVitae = curriculumVitaeDao.findOne(UUID.fromString(id));
        return (curriculumVitae==null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(curriculumVitae);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Retourner tous les 'Curriculum Vitae' existants")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Au moins un 'Curriculum Vitae' est trouvé, on retourne la liste des 'Curriculum Vitae'", response = Iterable.class)})
    public ResponseEntity getAll() {
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeDao.findAll();
        return ResponseEntity.ok(curriculumVitaeList);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Ajout d'un 'Curriculum Vitae'")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Création de 'Curriculum Vitae' OK", response = URI.class)})
    public ResponseEntity add(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return ResponseEntity.created(URI.create("/cv/"+curriculumVitae.getId())).build();
    }




    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Mettre a jour un 'Curriculum Vitae' existants")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Mise a jour de 'Curriculum Vitae' OK", response = void.class)})
    public ResponseEntity update(@ApiParam(value = "'Curriculum Vitae'", required = true) CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return ResponseEntity.ok().build();
    }




    @RequestMapping(method = RequestMethod.DELETE,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Supprimer un 'Curriculum Vitae'")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Suppression de 'Curriculum Vitae' OK", response = void.class)})
    public ResponseEntity remove(String id) {
        curriculumVitaeDao.delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "Tester la reactivité du Micro-Service")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Micro-Service OK", response = String.class)})
    @RequestMapping(value = {"/ping"},method = RequestMethod.GET)
    public ResponseEntity ping(){
        return ResponseEntity.ok("pong");

    }
}
