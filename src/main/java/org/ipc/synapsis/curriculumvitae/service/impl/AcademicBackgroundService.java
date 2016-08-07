package org.ipc.synapsis.curriculumvitae.service.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.AcademicBackgroundIn;
import org.ipc.synapsis.curriculumvitae.bean.out.AcademicBackgroundOut;
import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;
import org.ipc.synapsis.curriculumvitae.proxy.IAcademicBackgroundProxy;
import org.ipc.synapsis.curriculumvitae.proxy.impl.LanguageProxy;
import org.ipc.synapsis.curriculumvitae.service.IAcademicBackgroundService;
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
public class AcademicBackgroundService implements IAcademicBackgroundService {

    private static Logger LOGGER = LoggerFactory.getLogger(AcademicBackgroundService.class);

    @Autowired
    IAcademicBackgroundProxy academicBackgroundProxy;

    @Override
    public AcademicBackgroundOut get(final String id) throws ResourceNotFoundException, ParseException {
        LOGGER.debug("Start call Service layer get a 'Academic Background OUT',id:{}",id);
        AcademicBackgroundOut academicBackgroundOut = null;
        AcademicBackground academicBackground = academicBackgroundProxy.get(id);
        if (academicBackground == null){
            LOGGER.warn("Resource 'Academic Background' not found, id:{}",id);
            throw new ResourceNotFoundException(id,"Academic Background");
        }
        academicBackgroundOut = POJOToBeanOut.getAcademicBackgroundOut(academicBackground);
        LOGGER.debug("End call Service layer get a 'Academic Background OUT',{}",academicBackgroundOut);
        return academicBackgroundOut;
    }

    @Override
    public Iterable<AcademicBackgroundOut> getAll() {
        LOGGER.debug("Start call Service layer get all 'Academic Background OUT'");
        ArrayList<AcademicBackgroundOut> academicBackgroundOutList = new ArrayList<>();
        Iterable<AcademicBackground> academicBackgroundList = academicBackgroundProxy.getAll();
        for (AcademicBackground academicBackground : academicBackgroundList){
            AcademicBackgroundOut academicBackgroundOut = POJOToBeanOut.getAcademicBackgroundOut(academicBackground);
            academicBackgroundOutList.add(academicBackgroundOut);
        }
        LOGGER.debug("End call Service layer get all 'Academic Background OUT'");
        return (Iterable) academicBackgroundOutList;
    }

    @Override
    public UUID add(final AcademicBackgroundIn academicBackgroundIn) {
        LOGGER.debug("Start call Service layer add new 'Academic Background IN',{}",academicBackgroundIn);
        UUID id= UUID.randomUUID();
        AcademicBackground academicBackground = BeanInToPOJO.getAcademicBackground(academicBackgroundIn);
        academicBackground.setId(id);
        academicBackgroundProxy.add(academicBackground);
        LOGGER.debug("End call Service layer add new 'Academic Background',{}",academicBackground);
        return id;
    }

    @Override
    public void update(final String id,final AcademicBackgroundIn academicBackgroundIn) {
        LOGGER.debug("End call Service layer update 'Academic Background IN',{}",academicBackgroundIn);
        AcademicBackground academicBackground = BeanInToPOJO.getAcademicBackground(academicBackgroundIn);
        academicBackground.setId(UUID.fromString(id));
        academicBackgroundProxy.update(academicBackground);
        LOGGER.debug("End call Service layer update 'Academic Background',{}",academicBackground);
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Service layer remove 'Academic Background',id:{}",id);
        academicBackgroundProxy.remove(id);
        LOGGER.debug("End call Service layer remove 'Academic Background',id:{}",id);
    }
}
