package org.ipc.synapsis.curriculumvitae.resource;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface ICurriculumVitaeResource {
    ResponseEntity add(final CurriculumVitaeIn curriculumVitaeIn);
    ResponseEntity update(final String id,final CurriculumVitaeIn curriculumVitaeIn);
    ResponseEntity get(final String id) throws ResourceNotFoundException;
    ResponseEntity getAll();
    ResponseEntity remove(final String id);
    ResponseEntity health();
}
