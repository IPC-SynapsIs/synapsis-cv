package org.ipc.synapsis.curriculumvitae.resource.impl;

import io.swagger.annotations.*;
import org.ipc.synapsis.curriculumvitae.bean.in.AcademicBackgroundIn;
import org.ipc.synapsis.curriculumvitae.bean.out.AcademicBackgroundOut;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.resource.IAcademicBackgroundResource;
import org.ipc.synapsis.curriculumvitae.service.IAcademicBackgroundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

/**
 * Created by mbasri on 03/07/2016.
 */
@RestController
@RequestMapping(value = "/api/academic")
@Api(value = "Academic Background", description = "'Academic Background' resource base endpoint")
public class AcademicBackgroundResource implements IAcademicBackgroundResource {

    private static Logger LOGGER = LoggerFactory.getLogger(CurriculumVitaeResource.class);

    @Autowired
    IAcademicBackgroundService academicBackgroundService;

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Add a new 'Academic Background'")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New 'Academic Background' successfully created", response = URI.class)
    })
    public ResponseEntity add(@ApiParam(value = "The 'Academic Background' to add", required = true) @RequestBody AcademicBackgroundIn academicBackgroundIn) {
        LOGGER.debug("Start call of the web service add new 'Academic Background',{}",academicBackgroundIn);
        UUID id = academicBackgroundService.add(academicBackgroundIn);
        LOGGER.debug("End call of the web service add new 'Academic Background',{}",academicBackgroundIn);
        return ResponseEntity.created(URI.create("/api/academic/"+id)).build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Updates an existing 'Academic Background'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Academic Background' successfully updated", response = void.class)
    })
    public ResponseEntity update(@ApiParam(value = "The given 'Academic Background' id", required = true) @PathVariable("id") String id,
                                 @ApiParam(value = "The 'Academic Background' to update", required = true) @RequestBody AcademicBackgroundIn academicBackgroundIn) {
        LOGGER.debug("Start call of the web service update 'Academic Background',{}",academicBackgroundIn);
        academicBackgroundService.update(id,academicBackgroundIn);
        LOGGER.debug("End call of the web service update 'Academic Background',{}",academicBackgroundIn);
        return ResponseEntity.ok().build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Search a 'Academic Background' by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The 'Academic Background' was found and is in the response", response = CurriculumVitae.class),
            @ApiResponse(code = 404, message = "The 'Academic Background' cannot be found", response = void.class)
    })
    public ResponseEntity get(@ApiParam(value = "The given 'Academic Background' id", required = true) @PathVariable("id") String id) {
        LOGGER.debug("Start call of the web service get 'Academic Background' by id, id={}",id);
        AcademicBackgroundOut academicBackgroundOut = academicBackgroundService.get(id);
        LOGGER.debug("End call of  the web service get 'Academic Background' by id, id={}",id);
        return (academicBackgroundOut==null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(academicBackgroundOut);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Returns all existing 'Academic Background'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All existing 'Academic Background' are returned in a potentially empty list", response = Iterable.class)
    })
    public ResponseEntity getAll() {
        LOGGER.debug("Start call of the web service get all 'Academic Background'");
        Iterable<AcademicBackgroundOut> academicBackgroundOutList = academicBackgroundService.getAll();
        LOGGER.debug("End call of the web service get all 'Academic Background'");
        return ResponseEntity.ok(academicBackgroundOutList);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Deletes an existing 'Academic Background'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Academic Background' successfully deleted", response = void.class)
    })
    public ResponseEntity remove(@ApiParam(value = "The given 'Academic Background' id", required = true) @PathVariable("id") String id) {
        LOGGER.debug("Start call of the web service delete 'Academic Background' by id,id={}",id);
        academicBackgroundService.remove(id);
        LOGGER.debug("End call of the web service delete 'Academic Background' by id,id={}",id);
        return ResponseEntity.ok().build();
    }
}
