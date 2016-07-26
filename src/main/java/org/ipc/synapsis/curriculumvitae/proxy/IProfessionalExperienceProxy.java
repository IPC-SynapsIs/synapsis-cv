package org.ipc.synapsis.curriculumvitae.proxy;

import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IProfessionalExperienceProxy {
    ProfessionalExperience get(final String id);
    Iterable<ProfessionalExperience> getAll();
    ProfessionalExperience add(final ProfessionalExperience professionalExperience);
    ProfessionalExperience update(final ProfessionalExperience professionalExperience);
    void remove(final String id);
}
