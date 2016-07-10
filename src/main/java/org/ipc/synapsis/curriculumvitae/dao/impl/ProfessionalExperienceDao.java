package org.ipc.synapsis.curriculumvitae.dao.impl;

import org.ipc.synapsis.curriculumvitae.dao.IProfessionalExperienceDao;
import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.ipc.synapsis.curriculumvitae.proxy.IProfessionalExperienceProxy;
import org.ipc.synapsis.curriculumvitae.repository.IProfessionalExperienceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class ProfessionalExperienceDao implements IProfessionalExperienceDao {

    private static Logger LOGGER = LoggerFactory.getLogger(MiscallenousDao.class);

    @Autowired
    IProfessionalExperienceRepository professionalExperienceRepository;

    @Override
    public ProfessionalExperience get(final String id) {
        LOGGER.debug("Start call Dao layer get a 'Professional Experience',id:{}",id);
        ProfessionalExperience professionalExperience = professionalExperienceRepository.findOne(UUID.fromString(id));
        LOGGER.debug("End call Dao layer get a 'Professional Experience',id:{}",id);
        return professionalExperience;
    }

    @Override
    public Iterable<ProfessionalExperience> getAll() {
        LOGGER.debug("Start call Dao layer get all 'Professional Experience'");
        Iterable<ProfessionalExperience> professionalExperienceList = professionalExperienceRepository.findAll();
        LOGGER.debug("End call Dao layer get all 'Professional Experience'");
        return professionalExperienceList;
    }

    @Override
    public ProfessionalExperience add(final ProfessionalExperience professionalExperience) {
        LOGGER.debug("Start call Dao layer add new 'Professional Experience',{}",professionalExperience);
        ProfessionalExperience professionalExperience1 = professionalExperienceRepository.save(professionalExperience);
        LOGGER.debug("End call Dao layer add new 'Professional Experience',{}",professionalExperience1);
        return professionalExperience1;
    }

    @Override
    public ProfessionalExperience update(final ProfessionalExperience professionalExperience) {
        LOGGER.debug("End call Dao layer update 'Professional Experience',{}",professionalExperience);
        ProfessionalExperience professionalExperience1 = professionalExperienceRepository.save(professionalExperience);
        LOGGER.debug("End call Dao layer update 'Professional Experience',{}",professionalExperience1);
        return professionalExperience1;
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Dao layer remove 'Professional Experience',id:{}",id);
        professionalExperienceRepository.delete(UUID.fromString(id));
        LOGGER.debug("End call Dao layer remove 'Professional Experience',id:{}",id);
    }

}