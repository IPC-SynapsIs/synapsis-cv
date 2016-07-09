package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.dao.IProfessionalExperienceDao;
import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.ipc.synapsis.curriculumvitae.proxy.IProfessionalExperienceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class ProfessionalExperienceProxy implements IProfessionalExperienceProxy {

    @Autowired
    IProfessionalExperienceDao professionalExperienceDao;

    @Override
    public ProfessionalExperience get(final String id) {
        return professionalExperienceDao.get(id);
    }

    @Override
    public Iterable<ProfessionalExperience> getAll() {
        return professionalExperienceDao.getAll();
    }

    @Override
    public ProfessionalExperience add(final ProfessionalExperience professionalExperience) {
        return professionalExperienceDao.add(professionalExperience);
    }

    @Override
    public ProfessionalExperience update(final ProfessionalExperience professionalExperience) {
        return professionalExperienceDao.update(professionalExperience);
    }

    @Override
    public void remove(final String id) {
        professionalExperienceDao.remove(id);
    }

}