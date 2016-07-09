package org.ipc.synapsis.curriculumvitae.proxy.impl;


import org.ipc.synapsis.curriculumvitae.dao.IMiscallenousDao;
import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;
import org.ipc.synapsis.curriculumvitae.proxy.IMiscallenousProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class MiscallenousProxy implements IMiscallenousProxy {

    @Autowired
    IMiscallenousDao miscallenousDao;

    @Override
    public Miscallenous get(final String id) {
        return miscallenousDao.get(id);
    }

    @Override
    public Iterable<Miscallenous> getAll() {
        return miscallenousDao.getAll();
    }

    @Override
    public Miscallenous add(final Miscallenous miscallenous) {
        return miscallenousDao.add(miscallenous);
    }

    @Override
    public Miscallenous update(final Miscallenous miscallenous) {
        return miscallenousDao.update(miscallenous);
    }

    @Override
    public void remove(final String id) {
        miscallenousDao.remove(id);
    }
}
