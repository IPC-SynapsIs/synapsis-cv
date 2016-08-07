package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.dao.ICurriculumVitaeDao;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.proxy.ICurriculumVitaeProxy;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class CurriculumVitaeProxy implements ICurriculumVitaeProxy{

    private static Logger LOGGER = LoggerFactory.getLogger(CurriculumVitaeProxy.class);

    @Autowired
    ICurriculumVitaeDao curriculumVitaeDao;

    @Override
    public CurriculumVitae get(String id) throws ParseException {
        LOGGER.debug("Start call Proxy layer get a 'Curriculum Vitae',id:{}",id);
        CurriculumVitae curriculumVitae = curriculumVitaeDao.get(id);
        LOGGER.debug("End call Proxy layer get a 'Curriculum Vitae',id:{}",id);
        return curriculumVitae;
    }

    @Override
    public Iterable<CurriculumVitae> getAll() {
        LOGGER.debug("Start call Proxy layer get all 'Curriculum Vitae'");
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeDao.getAll();
        LOGGER.debug("End call Proxy layer get all 'Curriculum Vitae'");
        return curriculumVitaeList;
    }

    @Override
    public CurriculumVitae add(CurriculumVitae curriculumVitae) {
        LOGGER.debug("Start call Proxy layer add new 'Curriculum Vitae',{}",curriculumVitae);
        CurriculumVitae curriculumVitae1 = curriculumVitaeDao.add(curriculumVitae);
        LOGGER.debug("End call Proxy layer add new 'Curriculum Vitae',{}",curriculumVitae1);
        return curriculumVitae1;
    }

    @Override
    public CurriculumVitae update(CurriculumVitae curriculumVitae) {
        LOGGER.debug("End call Proxy layer update 'Curriculum Vitae',{}",curriculumVitae);
        CurriculumVitae curriculumVitae1 = curriculumVitaeDao.update(curriculumVitae);
        LOGGER.debug("End call Proxy layer update 'Curriculum Vitae',{}",curriculumVitae1);
        return curriculumVitae1;
    }

    @Override
    public void remove(String id) {
        LOGGER.debug("Start call Proxy layer remove 'Curriculum Vitae',id:{}",id);
        curriculumVitaeDao.remove(id);
        LOGGER.debug("End call Proxy layer remove 'Curriculum Vitae',id:{}",id);
    }
}
