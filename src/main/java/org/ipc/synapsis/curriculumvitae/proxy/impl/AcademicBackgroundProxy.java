package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.dao.IAcademicBackgroundDao;
import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;
import org.ipc.synapsis.curriculumvitae.proxy.IAcademicBackgroundProxy;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class AcademicBackgroundProxy implements IAcademicBackgroundProxy {

    private static Logger LOGGER = LoggerFactory.getLogger(AcademicBackgroundProxy.class);

    @Autowired
    IAcademicBackgroundDao academicBackgroundDao;

    @Override
    public AcademicBackground get(final String id) throws ResourceNotFoundException {
        LOGGER.debug("Start call Proxy layer get a 'Academic Background',id:{}",id);
        AcademicBackground academicBackground = academicBackgroundDao.get(id);
        LOGGER.debug("End call Proxy layer get a 'Academic Background',id:{}",id);
        return academicBackground;
    }

    @Override
    public Iterable<AcademicBackground> getAll() {
        LOGGER.debug("Start call Proxy layer get all 'Academic Background'");
        Iterable<AcademicBackground> academicBackgroundsList = academicBackgroundDao.getAll();
        LOGGER.debug("End call Proxy layer get all 'Academic Background'");
        return  academicBackgroundsList;
    }

    @Override
    public AcademicBackground add(final AcademicBackground academicBackground) {
        LOGGER.debug("Start call Proxy layer add new 'Academic Background',{}",academicBackground);
        AcademicBackground academicBackground1 = academicBackgroundDao.add(academicBackground);
        LOGGER.debug("End call Proxy layer add new 'Academic Background',{}",academicBackground1);
        return academicBackground1;
    }

    @Override
    public AcademicBackground update(final AcademicBackground academicBackground) {
        LOGGER.debug("End call Proxy layer update 'Academic Background',{}",academicBackground);
        AcademicBackground academicBackground1 = academicBackgroundDao.update(academicBackground);
        LOGGER.debug("End call Proxy layer update 'Academic Background',{}",academicBackground1);
        return academicBackground1;
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Proxy layer remove 'Academic Background',id:{}",id);
        academicBackgroundDao.remove(id);
        LOGGER.debug("End call Proxy layer remove 'Academic Background',id:{}",id);
    }
}
