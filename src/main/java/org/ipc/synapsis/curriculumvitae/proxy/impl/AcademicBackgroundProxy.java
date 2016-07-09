package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.dao.IAcademicBackgroundDao;
import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;
import org.ipc.synapsis.curriculumvitae.proxy.IAcademicBackgroundProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class AcademicBackgroundProxy implements IAcademicBackgroundProxy {

    @Autowired
    IAcademicBackgroundDao academicBackgroundDao;

    @Override
    public AcademicBackground get(final String id) {
        return academicBackgroundDao.get(id);
    }

    @Override
    public Iterable<AcademicBackground> getAll() {
        return academicBackgroundDao.getAll();
    }

    @Override
    public AcademicBackground add(final AcademicBackground academicBackground) {
        return academicBackgroundDao.add(academicBackground);
    }

    @Override
    public AcademicBackground update(final AcademicBackground academicBackground) {
        return academicBackgroundDao.update(academicBackground);
    }

    @Override
    public void remove(final String id) {
        academicBackgroundDao.remove(id);
    }
}
