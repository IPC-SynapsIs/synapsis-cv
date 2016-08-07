package org.ipc.synapsis.curriculumvitae.resource.impl;

import io.swagger.annotations.*;
import org.ipc.synapsis.curriculumvitae.bean.exception.ResourceNotFound;
import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.resource.ICurriculumVitaeResource;
import org.ipc.synapsis.curriculumvitae.service.ICurriculumVitaeService;
import org.ipc.synapsis.curriculumvitae.util.constant.ParseExceptionConstant;
import org.ipc.synapsis.curriculumvitae.util.constant.ResourceExceptionConstant;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@RestController
@RequestMapping(value = "/api/cv")
@Api(value = "Curriculum Vitae", description = "'Curriculum Vitae' resource base endpoint")
public class CurriculumVitaeResource implements ICurriculumVitaeResource {

    private static Logger LOGGER = LoggerFactory.getLogger(CurriculumVitaeResource.class);

    @Autowired
    ICurriculumVitaeService curriculumVitaeService;

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Add a new 'Curriculum Vitae'")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New 'Curriculum Vitae' successfully created", response = URI.class)
    })
    public ResponseEntity add(@ApiParam(value = "The 'Curriculum Vitae' to add", required = true)@RequestBody final CurriculumVitaeIn curriculumVitaeIn) {
        LOGGER.debug("Start call of the web service add new 'Curriculum Vitae',{}",curriculumVitaeIn);
        UUID id = curriculumVitaeService.add(curriculumVitaeIn);
        LOGGER.debug("End call of the web service add new 'Curriculum Vitae',{}",curriculumVitaeIn);
        return ResponseEntity.created(URI.create("/api/cv/"+id)).build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Updates an existing 'Curriculum Vitae'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Curriculum Vitae' successfully updated", response = void.class)
    })
    public ResponseEntity update(@ApiParam(value = "Id of the 'Curriculum Vitae' to update", required = true) @PathVariable("id") final String id,
                                 @ApiParam(value = "The 'Curriculum Vitae' to update", required = true) @RequestBody final CurriculumVitaeIn curriculumVitaeIn) {
        LOGGER.debug("Start call of the web service update 'Curriculum Vitae',{}",curriculumVitaeIn);
        curriculumVitaeService.update(id,curriculumVitaeIn);
        LOGGER.debug("End call of the web service update 'Curriculum Vitae',{}",curriculumVitaeIn);
        return ResponseEntity.ok().build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Search a 'Curriculum Vitae' by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The 'Curriculum Vitae' was found and is in the response", response = CurriculumVitaeOut.class),
            @ApiResponse(code = 404, message = "The 'Curriculum Vitae' cannot be found", response = ResourceNotFound.class)
    })
    public ResponseEntity get(@ApiParam(value = "The given 'Curriculum Vitae' id", required = true) @PathVariable("id") final String id) throws ResourceNotFoundException, HttpParseException {
        LOGGER.debug("Start call of the web service get 'Curriculum Vitae' by id, id={}",id);
        CurriculumVitaeOut curriculumVitaeOut = null;
        try {
            curriculumVitaeOut = curriculumVitaeService.get(id);
        } catch (ResourceNotFoundException e) {
            LOGGER.warn("Resource 'Curriculum Vitae' OUT not found, id:{}",id);
            throw  new HttpResourceNotFoundException(e.getResourceID(), e.getResourceName(),
                    ResourceExceptionConstant.CURRICULUM_VITAE_NOT_FOUND_CODE, ResourceExceptionConstant.CURRICULUM_VITAE_NOT_FOUND_VALUE);
        } catch (ParseException e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");
            throw new HttpParseException(e.getSource(),e.getTarget(),
                    ParseExceptionConstant.PARSE_ERROR_STRING_UUID_CODE,ParseExceptionConstant.PARSE_ERROR_STRING_UUID_VALUE);
        }
        LOGGER.debug("End call of  the web service get 'Curriculum Vitae' by id, id={}",id);
        return ResponseEntity.ok(curriculumVitaeOut);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Returns all existing 'Curriculum Vitae'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All existing 'Curriculum Vitae' are returned in a potentially empty list", response = Iterable.class)
    })
    public ResponseEntity getAll() {
        LOGGER.debug("Start call of the web service get all 'Curriculum Vitae'");
        Iterable<CurriculumVitaeOut> curriculumVitaeOutList = curriculumVitaeService.getAll();
        LOGGER.debug("End call of the web service get all 'Curriculum Vitae'");
        return ResponseEntity.ok(curriculumVitaeOutList);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Deletes an existing 'Curriculum Vitae'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Curriculum Vitae' successfully deleted", response = void.class)
    })
    public ResponseEntity remove(@PathVariable("id") final String id) throws HttpParseException {
        LOGGER.debug("Start call of the web service delete 'Curriculum Vitae' by id,id={}",id);
        try {
            curriculumVitaeService.remove(id);
        }catch (ParseException e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");
            throw new HttpParseException(e.getSource(),e.getTarget(),
                    ParseExceptionConstant.PARSE_ERROR_STRING_UUID_CODE,ParseExceptionConstant.PARSE_ERROR_STRING_UUID_VALUE);
        }
        LOGGER.debug("End call of the web service delete 'Curriculum Vitae' by id,id={}",id);
        return ResponseEntity.ok().build();
    }

    @Override
    @RequestMapping(value = {"/health"},method = RequestMethod.GET)
    @ApiOperation(value = "Checks the service's health and reactivity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service is up and running", response = String.class)
    })
    public ResponseEntity health(){
        LOGGER.debug("Call of the web service health");
        return ResponseEntity.ok().build();
    }
}
