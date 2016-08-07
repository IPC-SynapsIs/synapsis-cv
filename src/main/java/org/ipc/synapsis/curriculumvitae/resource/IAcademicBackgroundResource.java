package org.ipc.synapsis.curriculumvitae.resource;

import org.ipc.synapsis.curriculumvitae.bean.in.AcademicBackgroundIn;
import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpResourceNotFoundException;
import org.springframework.http.ResponseEntity;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IAcademicBackgroundResource {
    ResponseEntity add(final AcademicBackgroundIn academicBackgroundIn);
    ResponseEntity update(final String id, final AcademicBackgroundIn academicBackgroundIn);
    ResponseEntity get(final String id) throws HttpResourceNotFoundException, HttpParseException;
    ResponseEntity getAll();
    ResponseEntity remove(final String id);
}
