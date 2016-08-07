package org.ipc.synapsis.curriculumvitae.service.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.ProfessionalExperienceIn;
import org.ipc.synapsis.curriculumvitae.bean.out.ProfessionalExperienceOut;
import org.ipc.synapsis.curriculumvitae.entity.ProfessionalExperience;
import org.ipc.synapsis.curriculumvitae.proxy.IProfessionalExperienceProxy;
import org.ipc.synapsis.curriculumvitae.proxy.impl.LanguageProxy;
import org.ipc.synapsis.curriculumvitae.service.IProfessionalExperienceService;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean.POJOToBeanOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class ProfessionalExperienceService implements IProfessionalExperienceService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProfessionalExperienceService.class);

    @Autowired
    IProfessionalExperienceProxy professionalExperienceProxy;

    @Override
    public ProfessionalExperienceOut get(final String id) throws ResourceNotFoundException, ParseException {
        LOGGER.debug("Start call Service layer get a 'Professional Experience OUT',id:{}",id);
        ProfessionalExperienceOut professionalExperienceOut = null;
        ProfessionalExperience professionalExperience = professionalExperienceProxy.get(id);
        if (professionalExperience == null){
            LOGGER.warn("Resource 'Professional Experience' not found, id:{}",id);
            throw new ResourceNotFoundException(id,"Professional Experience");
        }
        professionalExperienceOut = POJOToBeanOut.getProfessionalExperienceOut(professionalExperience);
        LOGGER.debug("End call Service layer get a 'Professional Experience OUT',{}",professionalExperienceOut);
        return professionalExperienceOut;
    }

    @Override
    public Iterable<ProfessionalExperienceOut> getAll() {
        LOGGER.debug("Start call Service layer get all 'Professional Experience OUT'");
        ArrayList<ProfessionalExperienceOut> professionalExperienceOutList = new ArrayList<>();
        Iterable<ProfessionalExperience> professionalExperienceList = professionalExperienceProxy.getAll();
        for (ProfessionalExperience professionalExperience : professionalExperienceList){
            ProfessionalExperienceOut professionalExperienceOut = POJOToBeanOut.getProfessionalExperienceOut(professionalExperience);
            professionalExperienceOutList.add(professionalExperienceOut);
        }
        LOGGER.debug("End call Service layer get all 'Professional Experience OUT'");
        return (Iterable) professionalExperienceOutList;
    }

    @Override
    public UUID add(final ProfessionalExperienceIn professionalExperienceIn) {
        LOGGER.debug("Start call Service layer add new 'Professional Experience IN',{}",professionalExperienceIn);
        UUID id= UUID.randomUUID();
        ProfessionalExperience professionalExperience = BeanInToPOJO.getProfessionalExperience(professionalExperienceIn);
        professionalExperience.setId(id);
        professionalExperienceProxy.add(professionalExperience);
        LOGGER.debug("End call Service layer add new 'Professional Experience',{}",professionalExperience);
        return id;
    }

    @Override
    public void update(final String id,final ProfessionalExperienceIn professionalExperienceIn) {
        LOGGER.debug("End call Service layer update 'Professional Experience IN',{}",professionalExperienceIn);
        ProfessionalExperience professionalExperience = BeanInToPOJO.getProfessionalExperience(professionalExperienceIn);
        professionalExperience.setId(UUID.fromString(id));
        professionalExperienceProxy.update(professionalExperience);
        LOGGER.debug("End call Service layer update 'Professional Experience IN',{}",professionalExperienceIn);
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Service layer remove 'Professional Experience',id:{}",id);
        professionalExperienceProxy.remove(id);
        LOGGER.debug("End call Service layer remove 'Professional Experience',id:{}",id);
    }
}
