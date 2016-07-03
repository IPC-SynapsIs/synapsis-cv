package org.ipc.synapsis.curriculumvitae.repository;

import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;
import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface IProfessionalExperienceRepository extends CrudRepository<ProfessionalExperience, UUID> {
}
