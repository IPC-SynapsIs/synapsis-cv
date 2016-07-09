package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.dao.ICurriculumVitaeDao;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.proxy.ICurriculumVitaeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class CurriculumVitaeProxy implements ICurriculumVitaeProxy {

    @Autowired
    ICurriculumVitaeDao curriculumVitaeDao;

    @Override
    public CurriculumVitae get(String id) {
        return curriculumVitaeDao.get(id);
    }

    @Override
    public Iterable<CurriculumVitae> getAll() {
        return curriculumVitaeDao.getAll();
    }

    @Override
    public CurriculumVitae add(CurriculumVitae curriculumVitae) {
        return curriculumVitaeDao.add(curriculumVitae);
    }

    @Override
    public CurriculumVitae update(CurriculumVitae curriculumVitae) {
        return curriculumVitaeDao.update(curriculumVitae);
    }

    @Override
    public void remove(String id) {
        curriculumVitaeDao.remove(id);
    }
}
