package org.ipc.synapsis.curriculumvitae.util.exception;

import org.ipc.synapsis.curriculumvitae.bean.exception.ResourceNotFound;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mbasri on 16/07/2016.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = HttpResourceNotFoundException.class)
    public ResponseEntity handleHttpResourceNotFoundException(HttpResourceNotFoundException e){
        ResourceNotFound resourceNotFound = null;
        resourceNotFound = new ResourceNotFound(e.getCode(), e.getLabel(), e.getResourceID(), e.getResourceName());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceNotFound);
    }
}
