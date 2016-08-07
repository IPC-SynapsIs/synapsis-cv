package org.ipc.synapsis.curriculumvitae.resource.impl;

import io.swagger.annotations.*;
import org.ipc.synapsis.curriculumvitae.bean.exception.ResourceNotFound;
import org.ipc.synapsis.curriculumvitae.bean.in.LanguageIn;
import org.ipc.synapsis.curriculumvitae.bean.out.LanguageOut;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.resource.ILanguageResource;
import org.ipc.synapsis.curriculumvitae.service.ILanguageService;
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
@RequestMapping(value = "/api/language")
@Api(value = "Language", description = "'Language' resource base endpoint")
public class LanguageResource implements ILanguageResource {

    private static Logger LOGGER = LoggerFactory.getLogger(CurriculumVitaeResource.class);

    @Autowired
    ILanguageService languageService;

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Add a new 'Language'")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New 'Language' successfully created", response = URI.class)
    })
    public ResponseEntity add(@ApiParam(value = "The 'Language' to add", required = true) @RequestBody LanguageIn languageIn) {
        LOGGER.debug("Start call of the web service add new 'Language',{}",languageIn);
        UUID id = languageService.add(languageIn);
        LOGGER.debug("End call of the web service add new 'Language',{}",languageIn);
        return ResponseEntity.created(URI.create("/api/academic/"+id)).build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Updates an existing 'Language'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Language' successfully updated", response = void.class)
    })
    public ResponseEntity update(@ApiParam(value = "The given 'Language' id", required = true) @PathVariable("id") String id,
                                 @ApiParam(value = "The 'Language' to update", required = true) @RequestBody LanguageIn languageIn) {
        LOGGER.debug("Start call of the web service update 'Language',{}",languageIn);
        languageService.update(id,languageIn);
        LOGGER.debug("End call of the web service update 'Language',{}",languageIn);
        return ResponseEntity.ok().build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Search a 'Academic Background' by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The 'Language' was found and is in the response", response = LanguageOut.class),
            @ApiResponse(code = 404, message = "The 'Language' cannot be found", response = ResourceNotFound.class)
    })
    public ResponseEntity get(@ApiParam(value = "The given 'Language' id", required = true) @PathVariable("id") String id) throws HttpResourceNotFoundException, HttpParseException {
        LOGGER.debug("Start call of the web service get 'Language' by id, id={}",id);
        LanguageOut languageOut = null;
        try {
            languageOut = languageService.get(id);
        } catch (ResourceNotFoundException e) {
            LOGGER.warn("Resource 'Language' OUT not found, id:{}",id);
            throw  new HttpResourceNotFoundException(e.getResourceID(), e.getResourceName(),
                    ResourceExceptionConstant.LANGUAGE_NOT_FOUND_CODE, ResourceExceptionConstant.LANGUAGE_NOT_FOUND_VALUE);
        } catch (ParseException e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");
            throw new HttpParseException(e.getSource(),e.getTarget(),
                    ParseExceptionConstant.PARSE_ERROR_STRING_UUID_CODE,ParseExceptionConstant.PARSE_ERROR_STRING_UUID_VALUE);
        }
        LOGGER.debug("End call of  the web service get 'Language' by id, id={}",id);
        return ResponseEntity.ok(languageOut);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Returns all existing 'Language'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All existing 'Language' are returned in a potentially empty list", response = Iterable.class)
    })
    public ResponseEntity getAll() {
        LOGGER.debug("Start call of the web service get all 'Language'");
        Iterable<LanguageOut> languageOutList = languageService.getAll();
        LOGGER.debug("End call of the web service get all 'Language'");
        return ResponseEntity.ok(languageOutList);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Deletes an existing 'Language'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Language' successfully deleted", response = void.class)
    })
    public ResponseEntity remove(@ApiParam(value = "The given 'Language' id", required = true) @PathVariable("id") String id) {
        LOGGER.debug("Start call of the web service delete 'Language' by id,id={}",id);
        languageService.remove(id);
        LOGGER.debug("End call of the web service delete 'Language' by id,id={}",id);
        return ResponseEntity.ok().build();
    }
}
