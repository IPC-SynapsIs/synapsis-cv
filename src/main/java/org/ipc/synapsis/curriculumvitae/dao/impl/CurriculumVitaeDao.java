package org.ipc.synapsis.curriculumvitae.dao.impl;

import org.ipc.synapsis.curriculumvitae.dao.ICurriculumVitaeDao;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.proxy.ICurriculumVitaeProxy;
import org.ipc.synapsis.curriculumvitae.repository.ICurriculumVitaeRepository;
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
public class CurriculumVitaeDao implements ICurriculumVitaeDao {

    private static Logger LOGGER = LoggerFactory.getLogger(CurriculumVitaeDao.class);

    @Autowired
    ICurriculumVitaeRepository curriculumVitaeRepository;

    @Override
    public CurriculumVitae get(final String id) {
        LOGGER.debug("Start call Dao layer get a 'Curriculum Vitae',id:{}",id);
        CurriculumVitae curriculumVitae = null;
        curriculumVitae = curriculumVitaeRepository.findOne(UUID.fromString(id));
        LOGGER.debug("End call Dao layer get a 'Curriculum Vitae',id:{}",id);
        return curriculumVitae;
    }

    @Override
    public Iterable<CurriculumVitae> getAll() {
        LOGGER.debug("Start call Dao layer get all 'Curriculum Vitae'");
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeRepository.findAll();
        LOGGER.debug("End call Dao layer get all 'Curriculum Vitae'");
        return curriculumVitaeList;
    }

    @Override
    public CurriculumVitae add(final CurriculumVitae curriculumVitae) {
        LOGGER.debug("Start call Dao layer add new 'Curriculum Vitae',{}",curriculumVitae);
        CurriculumVitae curriculumVitae1 = curriculumVitaeRepository.save(curriculumVitae);
        LOGGER.debug("End call Dao layer add new 'Curriculum Vitae',{}",curriculumVitae1);
        return curriculumVitae1;
    }

    @Override
    public CurriculumVitae update(CurriculumVitae curriculumVitae) {
        LOGGER.debug("End call Dao layer update 'Curriculum Vitae',{}",curriculumVitae);
        CurriculumVitae curriculumVitae1 = curriculumVitaeRepository.save(curriculumVitae);
        LOGGER.debug("End call Dao layer update 'Curriculum Vitae',{}",curriculumVitae1);
        return curriculumVitae1;
    }

    @Override
    public void remove(String id) {
        LOGGER.debug("Start call Dao layer remove 'Curriculum Vitae',id:{}",id);
        curriculumVitaeRepository.delete(UUID.fromString(id));
        LOGGER.debug("End call Dao layer remove 'Curriculum Vitae',id:{}",id);
    }
}
