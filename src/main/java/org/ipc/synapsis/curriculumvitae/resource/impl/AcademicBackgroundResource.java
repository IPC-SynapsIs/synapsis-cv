package org.ipc.synapsis.curriculumvitae.resource.impl;

import io.swagger.annotations.*;
import org.ipc.synapsis.curriculumvitae.bean.exception.ResourceNotFound;
import org.ipc.synapsis.curriculumvitae.bean.in.AcademicBackgroundIn;
import org.ipc.synapsis.curriculumvitae.bean.out.AcademicBackgroundOut;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.resource.IAcademicBackgroundResource;
import org.ipc.synapsis.curriculumvitae.service.IAcademicBackgroundService;
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
            @ApiResponse(code = 200, message = "The 'Academic Background' was found and is in the response", response = AcademicBackgroundOut.class),
            @ApiResponse(code = 404, message = "The 'Academic Background' cannot be found", response = ResourceNotFound.class)
    })
    public ResponseEntity get(@ApiParam(value = "The given 'Academic Background' id", required = true) @PathVariable("id") String id) throws HttpResourceNotFoundException, HttpParseException {
        LOGGER.debug("Start call of the web service get 'Academic Background' by id, id={}",id);
        AcademicBackgroundOut academicBackgroundOut = null;
        try {
            academicBackgroundOut = academicBackgroundService.get(id);
        } catch (ResourceNotFoundException e) {
            LOGGER.warn("Resource 'Academic Background' OUT not found, id:{}",id);
            throw  new HttpResourceNotFoundException(e.getResourceID(), e.getResourceName(),
                    ResourceExceptionConstant.ACADEMIC_BACKGROUND_NOT_FOUND_CODE, ResourceExceptionConstant.ACADEMIC_BACKGROUND_NOT_FOUND_VALUE);
        } catch (ParseException e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");
            throw new HttpParseException(e.getSource(),e.getTarget(),
                    ParseExceptionConstant.PARSE_ERROR_STRING_UUID_CODE,ParseExceptionConstant.PARSE_ERROR_STRING_UUID_VALUE);
        }
        LOGGER.debug("End call of  the web service get 'Academic Background' by id, id={}",id);
        return ResponseEntity.ok(academicBackgroundOut);
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
    public ResponseEntity remove(@ApiParam(value = "The given 'Academic Background' id", required = true) @PathVariable("id") String id) throws HttpParseException {
        LOGGER.debug("Start call of the web service delete 'Academic Background' by id,id={}",id);
        try {
            academicBackgroundService.remove(id);
        }
            catch (ParseException e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");
            throw new HttpParseException(e.getSource(),e.getTarget(),
                ParseExceptionConstant.PARSE_ERROR_STRING_UUID_CODE,ParseExceptionConstant.PARSE_ERROR_STRING_UUID_VALUE);
            }
        LOGGER.debug("End call of the web service delete 'Academic Background' by id,id={}",id);
        return ResponseEntity.ok().build();
    }
}
