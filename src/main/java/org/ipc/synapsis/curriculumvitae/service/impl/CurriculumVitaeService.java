package org.ipc.synapsis.curriculumvitae.service.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.proxy.ICurriculumVitaeProxy;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean.POJOToBeanOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.service.ICurriculumVitaeService;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class CurriculumVitaeService implements ICurriculumVitaeService {

    private static Logger LOGGER = LoggerFactory.getLogger(CurriculumVitaeService.class);

    @Autowired
    ICurriculumVitaeProxy curriculumVitaeProxy;

    @Override
    public CurriculumVitaeOut get(final String id) throws ResourceNotFoundException, ParseException {
        LOGGER.debug("Start call Service layer get a 'Curriculum Vitae OUT',id:{}",id);
        CurriculumVitaeOut curriculumVitaeOut = null;
        CurriculumVitae curriculumVitae = curriculumVitaeProxy.get(id);
        if (curriculumVitae == null){
            LOGGER.warn("Resource 'Curriculum Vitae' not found, id:{}",id);
            throw new ResourceNotFoundException(id,"Curriculum Vitae");
        }
        curriculumVitaeOut = POJOToBeanOut.getCurriculumVitaeOut(curriculumVitae);
        LOGGER.debug("End call Service layer get a 'Curriculum Vitae OUT',{}",curriculumVitaeOut);
        return curriculumVitaeOut;
    }

    @Override
    public Iterable<CurriculumVitaeOut> getAll() {
        LOGGER.debug("Start call Service layer get all 'Curriculum Vitae OUT'");
        ArrayList<CurriculumVitae> curriculumVitaesOutList = new ArrayList<>();
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeProxy.getAll();
        for (CurriculumVitae curriculumVitae : curriculumVitaeList){
            CurriculumVitaeOut curriculumVitaeOut = POJOToBeanOut.getCurriculumVitaeOut(curriculumVitae);
            curriculumVitaesOutList.add(curriculumVitae);
        }
        LOGGER.debug("End call Service layer get all 'Curriculum Vitae OUT'");
        return (Iterable) curriculumVitaesOutList;
    }

    @Override
    public UUID add(final CurriculumVitaeIn curriculumVitaeIn) {
        LOGGER.debug("Start call Service layer add new 'Curriculum Vitae IN',{}",curriculumVitaeIn);
        UUID id= UUID.randomUUID();
        CurriculumVitae curriculumVitae = BeanInToPOJO.getCurriculumVitae(curriculumVitaeIn);
        curriculumVitae.setId(id);
        curriculumVitaeProxy.add(curriculumVitae);
        LOGGER.debug("End call Service layer add new 'Curriculum Vitae',{}",curriculumVitae);
        return id;
    }

    @Override
    public void update(final String id,final CurriculumVitaeIn curriculumVitaeIn) {
        LOGGER.debug("End call Service layer update 'Curriculum Vitae IN',{}",curriculumVitaeIn);
        CurriculumVitae curriculumVitae = BeanInToPOJO.getCurriculumVitae(curriculumVitaeIn);
        curriculumVitae.setId(UUID.fromString(id));
        curriculumVitaeProxy.update(curriculumVitae);
        LOGGER.debug("End call Service layer update 'Curriculum Vitae',{}",curriculumVitae);
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Service layer remove 'Curriculum Vitae',id:{}",id);
        curriculumVitaeProxy.remove(id);
        LOGGER.debug("Start call Service layer remove 'Curriculum Vitae',id:{}",id);
    }
}
