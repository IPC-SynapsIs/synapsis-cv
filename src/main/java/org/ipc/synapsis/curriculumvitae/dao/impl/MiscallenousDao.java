package org.ipc.synapsis.curriculumvitae.dao.impl;


import org.ipc.synapsis.curriculumvitae.dao.IMiscallenousDao;
import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;
import org.ipc.synapsis.curriculumvitae.proxy.IMiscallenousProxy;
import org.ipc.synapsis.curriculumvitae.repository.IMiscallenousRepository;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class MiscallenousDao implements IMiscallenousDao {

    private static Logger LOGGER = LoggerFactory.getLogger(MiscallenousDao.class);

    @Autowired
    IMiscallenousRepository miscallenousRepository;

    @Override
    public Miscallenous get(final String id) throws ParseException {
        LOGGER.debug("Start call Dao layer get a 'Miscallenous',id:{}",id);
        Miscallenous miscallenous = null;
        try {
            miscallenous = miscallenousRepository.findOne(UUID.fromString(id));
        }catch (IllegalArgumentException e){
            LOGGER.error("Dao layer Cannot parse String:{} to UUID",id);
            throw new ParseException(String.class.toString(),UUID.class.toString());
        }
        LOGGER.debug("End call Dao layer get a 'Miscallenous',id:{}",id);
        return miscallenous;
    }

    @Override
    public Iterable<Miscallenous> getAll() {
        LOGGER.debug("Start call Dao layer get all 'Miscallenous'");
        Iterable<Miscallenous>  miscallenouseList = miscallenousRepository.findAll();
        LOGGER.debug("End call Dao layer get all 'Miscallenous'");
        return  miscallenouseList;
    }

    @Override
    public Miscallenous add(final Miscallenous miscallenous) {
        LOGGER.debug("Start call Dao layer add new 'Miscallenous',{}",miscallenous);
        Miscallenous miscallenous1 = miscallenousRepository.save(miscallenous);
        LOGGER.debug("End call Dao layer add new 'Miscallenous',{}",miscallenous1);
        return miscallenous1;
    }

    @Override
    public Miscallenous update(final Miscallenous miscallenous) {
        LOGGER.debug("End call Dao layer update 'Miscallenous',{}",miscallenous);
        Miscallenous miscallenous1 = miscallenousRepository.save(miscallenous);
        LOGGER.debug("End call Dao layer update 'Miscallenous',{}",miscallenous1);
        return miscallenous1;
    }

    @Override
    public void remove(final String id) throws ParseException {
        LOGGER.debug("Start call Dao layer remove 'Miscallenous',id:{}",id);
        try {
        miscallenousRepository.delete(UUID.fromString(id));
        }catch (IllegalArgumentException e){
            LOGGER.error("Dao layer Cannot parse String:{} to UUID",id);
            throw new ParseException(String.class.toString(),UUID.class.toString());
        }
        LOGGER.debug("End call Dao layer remove 'Miscallenous',id:{}",id);
    }
}
