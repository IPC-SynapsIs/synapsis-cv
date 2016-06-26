package org.synapsis.resource.impl;

import io.swagger.annotations.*;
import io.swagger.models.Response;
import io.swagger.models.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.synapsis.repository.ICurriculumVitaeRepository;
import org.synapsis.entity.CurriculumVitae;
import org.synapsis.resource.ICurriculumVitaeResource;
import org.synapsis.servcie.ICurriculumVitaeService;


import java.io.*;
import java.net.URI;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@RestController
@RequestMapping(value = "/cv")
@Api( value = "Curriculum Vitae",description = "Point d'entrée pour gerer la ressource 'Curriculum Vitae'")
public class CurriculumVitaeResource implements ICurriculumVitaeResource {

    @Autowired
    ICurriculumVitaeService curriculumVitaeService;

    @Autowired
    Environment env;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Rechercher un 'Curriculum Vitae' par son id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "le 'Curriculum Vitae' est trouvé, on le retourne en reponse", response = CurriculumVitae.class),
            @ApiResponse(code = 404, message = "le 'Curriculum Vitae' est introuvable, on ne renvoie rien", response = void.class)})
    public ResponseEntity get(@ApiParam(value = "L'id de la ressource 'Curriculum Vitae'", required = true) @PathVariable("id") String id) {
        CurriculumVitae curriculumVitae = curriculumVitaeService.get(id);
        return (curriculumVitae==null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(curriculumVitae);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Retourner tous les 'Curriculum Vitae' existants")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Au moins un 'Curriculum Vitae' est trouvé, on retourne la liste des 'Curriculum Vitae'", response = Iterable.class)})
    public ResponseEntity getAll() {
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeService.gelAll();
        return ResponseEntity.ok(curriculumVitaeList);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Ajout d'un 'Curriculum Vitae'")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Création de 'Curriculum Vitae' OK", response = URI.class)})
    public ResponseEntity add(@RequestParam(value="file", required=true) MultipartFile file) {
        CurriculumVitae curriculumVitae = new CurriculumVitae();
        curriculumVitaeService.add(curriculumVitae);

        String filepath = Paths.get(env.getProperty("org.synapsis.path.fileuploads"), curriculumVitae.getId().toString()).toString();
        BufferedOutputStream stream =  null;
        try {
            stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(file.getBytes());
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.created(URI.create("/cv/"+curriculumVitae.getId())).build();
    }





    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Mettre a jour un 'Curriculum Vitae' existants")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Mise a jour de 'Curriculum Vitae' OK", response = void.class)})
    public ResponseEntity update(@ApiParam(value = "'Curriculum Vitae'", required = true) CurriculumVitae curriculumVitae) {
        curriculumVitaeService.update(curriculumVitae);
        return ResponseEntity.ok().build();
    }




    @RequestMapping(method = RequestMethod.DELETE,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Supprimer un 'Curriculum Vitae'")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Suppression de 'Curriculum Vitae' OK", response = void.class)})
    public ResponseEntity remove(String id) {
        curriculumVitaeService.remove(id);
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "Tester la reactivité du Micro-Service")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Micro-Service OK", response = String.class)})
    @RequestMapping(value = {"/ping"},method = RequestMethod.GET)
    public ResponseEntity ping(){
        return ResponseEntity.ok("pong");

    }
}
