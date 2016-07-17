package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.dao.IProfessionalExperienceDao;
import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.ipc.synapsis.curriculumvitae.proxy.IProfessionalExperienceProxy;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class ProfessionalExperienceProxy implements IProfessionalExperienceProxy {

    private static Logger LOGGER = LoggerFactory.getLogger(ProfessionalExperienceProxy.class);

    @Autowired
    IProfessionalExperienceDao professionalExperienceDao;

    @Override
    public ProfessionalExperience get(final String id) throws ResourceNotFoundException {
        LOGGER.debug("Start call Proxy layer get a 'Professional Experience',id:{}",id);
        ProfessionalExperience professionalExperience = professionalExperienceDao.get(id);
        LOGGER.debug("End call Proxy layer get a 'Professional Experience',id:{}",id);
        return professionalExperience;
    }

    @Override
    public Iterable<ProfessionalExperience> getAll() {
        LOGGER.debug("Start call Proxy layer get all 'Professional Experience'");
        Iterable<ProfessionalExperience> professionalExperienceList = professionalExperienceDao.getAll();
        LOGGER.debug("End call Proxy layer get all 'Professional Experience'");
        return professionalExperienceList;
    }

    @Override
    public ProfessionalExperience add(final ProfessionalExperience professionalExperience) {
        LOGGER.debug("Start call Proxy layer add new 'Professional Experience',{}",professionalExperience);
        ProfessionalExperience professionalExperience1 = professionalExperienceDao.add(professionalExperience);
        LOGGER.debug("End call Proxy layer add new 'Professional Experience',{}",professionalExperience1);
        return professionalExperience1;
    }

    @Override
    public ProfessionalExperience update(final ProfessionalExperience professionalExperience) {
        LOGGER.debug("End call Proxy layer update 'Professional Experience',{}",professionalExperience);
        ProfessionalExperience professionalExperience1 = professionalExperienceDao.update(professionalExperience);
        LOGGER.debug("End call Proxy layer update 'Professional Experience',{}",professionalExperience1);
        return professionalExperience1;
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Proxy layer remove 'Professional Experience',id:{}",id);
        professionalExperienceDao.remove(id);
        LOGGER.debug("End call Proxy layer remove 'Professional Experience',id:{}",id);
    }

}