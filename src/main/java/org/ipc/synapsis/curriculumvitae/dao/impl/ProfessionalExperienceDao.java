package org.ipc.synapsis.curriculumvitae.dao.impl;

import org.ipc.synapsis.curriculumvitae.dao.IProfessionalExperienceDao;
import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.ipc.synapsis.curriculumvitae.proxy.IProfessionalExperienceProxy;
import org.ipc.synapsis.curriculumvitae.repository.IProfessionalExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class ProfessionalExperienceDao implements IProfessionalExperienceDao {

    @Autowired
    IProfessionalExperienceRepository professionalExperienceRepository;

    @Override
    public ProfessionalExperience get(final String id) {
        return professionalExperienceRepository.findOne(UUID.fromString(id));
    }

    @Override
    public Iterable<ProfessionalExperience> getAll() {
        return professionalExperienceRepository.findAll();
    }

    @Override
    public ProfessionalExperience add(final ProfessionalExperience professionalExperience) {
        return professionalExperienceRepository.save(professionalExperience);
    }

    @Override
    public ProfessionalExperience update(final ProfessionalExperience professionalExperience) {
        return professionalExperienceRepository.save(professionalExperience);
    }

    @Override
    public void remove(final String id) {
        professionalExperienceRepository.delete(UUID.fromString(id));
    }

}