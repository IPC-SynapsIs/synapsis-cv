package org.ipc.synapsis.curriculumvitae.service;

import org.ipc.synapsis.curriculumvitae.bean.in.ProfessionalExperienceIn;
import org.ipc.synapsis.curriculumvitae.bean.out.ProfessionalExperienceOut;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;

import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IProfessionalExperienceService {
    ProfessionalExperienceOut get(final String id) throws ResourceNotFoundException, ParseException;
    Iterable<ProfessionalExperienceOut> getAll();
    UUID add(final ProfessionalExperienceIn professionalExperienceIn);
    void update(final String id, final ProfessionalExperienceIn professionalExperienceIn);
    void remove(final String id);
}
