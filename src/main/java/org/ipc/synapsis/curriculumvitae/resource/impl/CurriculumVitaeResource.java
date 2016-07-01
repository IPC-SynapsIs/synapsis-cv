package org.ipc.synapsis.curriculumvitae.resource.impl;

import io.swagger.annotations.*;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.resource.ICurriculumVitaeResource;
import org.ipc.synapsis.curriculumvitae.servcie.ICurriculumVitaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.net.URI;
import java.nio.file.Paths;

/**
 * Created by mbasri on 19/06/2016.
 */
@RestController
@RequestMapping(value = "/api/cv")
@Api( value = "Curriculum Vitae", description = "'Curriculum Vitae' resource base endpoint")
public class CurriculumVitaeResource implements ICurriculumVitaeResource {

    @Autowired
    ICurriculumVitaeService curriculumVitaeService;

    @Autowired
    Environment env;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Search a 'Curriculum Vitae' by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The 'Curriculum Vitae' was found and is in the response", response = CurriculumVitae.class),
            @ApiResponse(code = 404, message = "The 'Curriculum Vitae' cannot be found", response = void.class)
    })
    public ResponseEntity get(@ApiParam(value = "The given 'Curriculum Vitae' id", required = true) @PathVariable("id") String id) {
        CurriculumVitae curriculumVitae = curriculumVitaeService.get(id);
        return (curriculumVitae==null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(curriculumVitae);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Returns all existing 'Curriculum Vitae'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All existing 'Curriculum Vitae' are returned in a potentially empty list", response = Iterable.class)
    })
    public ResponseEntity getAll() {
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeService.getAll();
        return ResponseEntity.ok(curriculumVitaeList);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Adds a new 'Curriculum Vitae'")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New 'Curriculum Vitae' successfully created", response = URI.class)
    })
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
        return ResponseEntity.created(URI.create("/api/cv/"+curriculumVitae.getId())).build();
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Updates an existing 'Curriculum Vitae'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Curriculum Vitae' successfully updated", response = void.class)
    })
    public ResponseEntity update(@ApiParam(value = "The 'Curriculum Vitae' to update", required = true) @RequestBody CurriculumVitae curriculumVitae) {
        curriculumVitaeService.update(curriculumVitae);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Deletes an existing 'Curriculum Vitae'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Curriculum Vitae' successfully deleted", response = void.class)
    })
    public ResponseEntity remove(@PathVariable("id") String id) {
        curriculumVitaeService.remove(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = {"/health"},method = RequestMethod.GET)
    @ApiOperation(value = "Checks the service's health and reactivity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service is up and running", response = String.class)
    })
    public ResponseEntity health(){
        return ResponseEntity.ok().build();

    }
}
