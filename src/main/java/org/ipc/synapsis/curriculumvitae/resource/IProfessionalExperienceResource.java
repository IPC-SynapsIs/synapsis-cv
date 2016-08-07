package org.ipc.synapsis.curriculumvitae.resource;


import org.ipc.synapsis.curriculumvitae.bean.in.ProfessionalExperienceIn;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpResourceNotFoundException;
import org.springframework.http.ResponseEntity;

/**
 * Created by mbasri on 04/07/2016.
 */
public interface IProfessionalExperienceResource {
    ResponseEntity add(final ProfessionalExperienceIn professionalExperienceIn);
    ResponseEntity update(final String id, final ProfessionalExperienceIn professionalExperienceIn);
    ResponseEntity get(final String id) throws HttpResourceNotFoundException, HttpParseException;
    ResponseEntity getAll();
    ResponseEntity remove(final String id) throws HttpParseException;
}
