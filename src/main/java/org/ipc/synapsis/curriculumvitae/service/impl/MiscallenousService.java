package org.ipc.synapsis.curriculumvitae.service.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.MiscallenousIn;
import org.ipc.synapsis.curriculumvitae.bean.out.MiscallenousOut;
import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;
import org.ipc.synapsis.curriculumvitae.proxy.IMiscallenousProxy;
import org.ipc.synapsis.curriculumvitae.proxy.impl.LanguageProxy;
import org.ipc.synapsis.curriculumvitae.service.IMiscallenousService;
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
public class MiscallenousService implements IMiscallenousService {

    private static Logger LOGGER = LoggerFactory.getLogger(MiscallenousService.class);

    @Autowired
    IMiscallenousProxy miscallenousProxy;

    @Override
    public MiscallenousOut get(final String id) throws ResourceNotFoundException, ParseException {
        LOGGER.debug("Start call Service layer get a 'Miscallenous OUT',id:{}",id);
        MiscallenousOut miscallenousOut = null;
        Miscallenous miscallenous = miscallenousProxy.get(id);
        if (miscallenous == null){
            LOGGER.warn("Resource 'Miscallenous' not found, id:{}",id);
            throw new ResourceNotFoundException(id,"Miscallenous");
        }
        miscallenousOut = POJOToBeanOut.getMiscallenousOut(miscallenous);
        LOGGER.debug("End call Service layer get a 'Miscallenous OUT',{}",miscallenousOut);
        return miscallenousOut;
    }

    @Override
    public Iterable<MiscallenousOut> getAll() {
        LOGGER.debug("Start call Service layer get all 'Miscallenous OUT'");
        ArrayList<MiscallenousOut> miscallenousOutList = new ArrayList<>();
        Iterable<Miscallenous> miscallenousList = miscallenousProxy.getAll();
        for (Miscallenous miscallenous : miscallenousList){
            MiscallenousOut miscallenouOut = POJOToBeanOut.getMiscallenousOut(miscallenous);
            miscallenousOutList.add(miscallenouOut);
        }
        LOGGER.debug("End call Service layer get all 'Miscallenous OUT'");
        return (Iterable) miscallenousOutList;
    }

    @Override
    public UUID add(final MiscallenousIn miscallenousIn) {
        LOGGER.debug("Start call Service layer add new 'Miscallenous IN',{}",miscallenousIn);
        UUID id= UUID.randomUUID();
        Miscallenous miscallenous = BeanInToPOJO.getMiscallenous(miscallenousIn);
        miscallenous.setId(id);
        miscallenousProxy.add(miscallenous);
        LOGGER.debug("End call Service layer add new 'Miscallenous',{}",miscallenous);
        return id;
    }

    @Override
    public void update(final String id,final MiscallenousIn miscallenousIn) {
        LOGGER.debug("End call Service layer update 'Miscallenous IN',{}",miscallenousIn);
        Miscallenous miscallenous = BeanInToPOJO.getMiscallenous(miscallenousIn);
        miscallenous.setId(UUID.fromString(id));
        miscallenousProxy.update(miscallenous);
        LOGGER.debug("End call Service layer update 'Miscallenous',{}",miscallenous);
    }

    @Override
    public void remove(final String id) throws ParseException {
        LOGGER.debug("Start call Service layer remove 'Miscallenous',id:{}",id);
        miscallenousProxy.remove(id);
        LOGGER.debug("End call Service layer remove 'Miscallenous',id:{}",id);
    }
}
