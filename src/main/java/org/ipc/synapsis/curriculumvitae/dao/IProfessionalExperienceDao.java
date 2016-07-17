package org.ipc.synapsis.curriculumvitae.dao;

import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IProfessionalExperienceDao {
    ProfessionalExperience get(final String id) throws ResourceNotFoundException;
    Iterable<ProfessionalExperience> getAll();
    ProfessionalExperience add(final ProfessionalExperience professionalExperience);
    ProfessionalExperience update(final ProfessionalExperience professionalExperience);
    void remove(final String id);
}
