package org.ipc.synapsis.curriculumvitae.resource.impl;

import io.swagger.annotations.*;
import org.ipc.synapsis.curriculumvitae.bean.exception.ResourceNotFound;
import org.ipc.synapsis.curriculumvitae.bean.in.LanguageIn;
import org.ipc.synapsis.curriculumvitae.bean.in.ProfessionalExperienceIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.bean.out.LanguageOut;
import org.ipc.synapsis.curriculumvitae.bean.out.ProfessionalExperienceOut;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.resource.ILanguageResource;
import org.ipc.synapsis.curriculumvitae.resource.IProfessionalExperienceResource;
import org.ipc.synapsis.curriculumvitae.service.ILanguageService;
import org.ipc.synapsis.curriculumvitae.service.IProfessionalExperienceService;
import org.ipc.synapsis.curriculumvitae.util.constant.ParseExceptionConstant;
import org.ipc.synapsis.curriculumvitae.util.constant.ResourceExceptionConstant;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

/**
 * Created by mbasri on 03/07/2016.
 */
@RestController
@RequestMapping(value = "/api/pro")
@Api(value = "Professional Experience", description = "'Professional Experience' resource base endpoint")
public class ProfessionalExperienceResource implements IProfessionalExperienceResource{

    private static Logger LOGGER = LoggerFactory.getLogger(CurriculumVitaeResource.class);

    @Autowired
    IProfessionalExperienceService professionalExperienceService;

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Add a new 'Professional Experience'")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New 'Professional Experience' successfully created", response = URI.class)
    })
    public ResponseEntity add(@ApiParam(value = "The 'Professional Experience' to add", required = true) @RequestBody ProfessionalExperienceIn professionalExperienceIn) {
        LOGGER.debug("Start call of the web service add new 'Professional Experience',{}",professionalExperienceIn);
        UUID id = professionalExperienceService.add(professionalExperienceIn);
        LOGGER.debug("End call of the web service add new 'Professional Experience',{}",professionalExperienceIn);
        return ResponseEntity.created(URI.create("/api/pro/"+id)).build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Updates an existing 'Professional Experience'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Professional Experience' successfully updated", response = void.class)
    })
    public ResponseEntity update(@ApiParam(value = "The given 'Professional Experience' id", required = true) @PathVariable("id") String id,
                                 @ApiParam(value = "The 'Professional Experience' to update", required = true) @RequestBody ProfessionalExperienceIn professionalExperienceIn) {
        LOGGER.debug("Start call of the web service update 'Professional Experience',{}",professionalExperienceIn);
        professionalExperienceService.update(id,professionalExperienceIn);
        LOGGER.debug("End call of the web service update 'Professional Experience',{}",professionalExperienceIn);
        return ResponseEntity.ok().build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Search a 'Academic Background' by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The 'Professional Experience' was found and is in the response", response = ProfessionalExperienceOut.class),
            @ApiResponse(code = 404, message = "The 'Professional Experience' cannot be found", response = ResourceNotFound.class)
    })
    public ResponseEntity get(@ApiParam(value = "The given 'Professional Experience' id", required = true) @PathVariable("id") String id) throws HttpResourceNotFoundException, HttpParseException {
        LOGGER.debug("Start call of the web service get 'Professional Experience' by id, id={}",id);
        ProfessionalExperienceOut professionalExperienceOut = null;
        try {
            professionalExperienceOut = professionalExperienceService.get(id);
        } catch (ResourceNotFoundException e) {
            LOGGER.warn("Resource 'Professional Experience' OUT not found, id:{}",id);
            throw  new HttpResourceNotFoundException(e.getResourceID(), e.getResourceName(),
                    ResourceExceptionConstant.PROFESSIONNAL_EXPERIENCE_NOT_FOUND_CODE, ResourceExceptionConstant.PROFESSIONNAL_EXPERIENCE_NOT_FOUND_VALUE);
        } catch (ParseException e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");
            throw new HttpParseException(e.getSource(),e.getTarget(),
                    ParseExceptionConstant.PARSE_ERROR_STRING_UUID_CODE,ParseExceptionConstant.PARSE_ERROR_STRING_UUID_VALUE);
        }
        LOGGER.debug("End call of  the web service get 'Professional Experience' by id, id={}",id);
        return ResponseEntity.ok(professionalExperienceOut);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Returns all existing 'Professional Experience'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All existing 'Professional Experience' are returned in a potentially empty list", response = Iterable.class)
    })
    public ResponseEntity getAll() {
        LOGGER.debug("Start call of the web service get all 'Professional Experience'");
        Iterable<ProfessionalExperienceOut> professionalExperienceOutList = professionalExperienceService.getAll();
        LOGGER.debug("End call of the web service get all 'Professional Experience'");
        return ResponseEntity.ok(professionalExperienceOutList);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Deletes an existing 'Professional Experience'")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Existing 'Professional Experience' successfully deleted", response = void.class)
    })
    public ResponseEntity remove(@ApiParam(value = "The given 'Professional Experience' id", required = true) @PathVariable("id") String id) throws HttpParseException {
        LOGGER.debug("Start call of the web service delete 'Professional Experience' by id,id={}",id);
        try {
            professionalExperienceService.remove(id);
        }catch (ParseException e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");
            throw new HttpParseException(e.getSource(),e.getTarget(),
                ParseExceptionConstant.PARSE_ERROR_STRING_UUID_CODE,ParseExceptionConstant.PARSE_ERROR_STRING_UUID_VALUE);
            }
            LOGGER.debug("End call of the web service delete 'Professional Experience' by id,id={}",id);
        return ResponseEntity.ok().build();
    }
}
