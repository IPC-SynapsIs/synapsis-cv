package org.ipc.synapsis.curriculumvitae.servcie.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.AcademicBackgroundIn;
import org.ipc.synapsis.curriculumvitae.bean.in.ProfessionalExperienceIn;
import org.ipc.synapsis.curriculumvitae.bean.out.AcademicBackgroundOut;
import org.ipc.synapsis.curriculumvitae.bean.out.ProfessionalExperienceOut;
import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;
import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.ipc.synapsis.curriculumvitae.repository.IAcademicBackgroundRepository;
import org.ipc.synapsis.curriculumvitae.repository.IProfessionalExperienceRepository;
import org.ipc.synapsis.curriculumvitae.servcie.IAcademicBackgroundService;
import org.ipc.synapsis.curriculumvitae.servcie.IProfessionalExperienceService;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean.POJOToBeanOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class ProfessionalExperienceService implements IProfessionalExperienceService {

    @Autowired
    IProfessionalExperienceRepository professionalExperienceRepository;

    @Override
    public ProfessionalExperienceOut get(final String id) {
        ProfessionalExperienceOut professionalExperienceOut = null;
        ProfessionalExperience professionalExperience = professionalExperienceRepository.findOne(UUID.fromString(id));
        professionalExperienceOut = POJOToBeanOut.getProfessionalExperienceOut(professionalExperience);
        return professionalExperienceOut;
    }

    @Override
    public Iterable<ProfessionalExperienceOut> getAll() {
        ArrayList<ProfessionalExperienceOut> professionalExperienceOutList = new ArrayList<>();
        Iterable<ProfessionalExperience> professionalExperienceList = professionalExperienceRepository.findAll();
        for (ProfessionalExperience professionalExperience : professionalExperienceList){
            ProfessionalExperienceOut professionalExperienceOut = POJOToBeanOut.getProfessionalExperienceOut(professionalExperience);
            professionalExperienceOutList.add(professionalExperienceOut);
        }
        return (Iterable) professionalExperienceOutList;
    }

    @Override
    public UUID add(final ProfessionalExperienceIn professionalExperienceIn) {
        UUID id= UUID.randomUUID();
        ProfessionalExperience professionalExperience = BeanInToPOJO.getProfessionalExperience(professionalExperienceIn);
        professionalExperience.setId(id);
        professionalExperienceRepository.save(professionalExperience);
        return id;
    }

    @Override
    public void update(final String id,final ProfessionalExperienceIn professionalExperienceIn) {
        ProfessionalExperience professionalExperience = BeanInToPOJO.getProfessionalExperience(professionalExperienceIn);
        professionalExperience.setId(UUID.fromString(id));
        professionalExperienceRepository.save(professionalExperience);
    }

    @Override
    public void remove(final String id) {
        professionalExperienceRepository.delete(UUID.fromString(id));

    }
}
