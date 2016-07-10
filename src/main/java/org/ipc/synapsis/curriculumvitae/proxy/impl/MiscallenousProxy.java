package org.ipc.synapsis.curriculumvitae.proxy.impl;


import org.ipc.synapsis.curriculumvitae.dao.IMiscallenousDao;
import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;
import org.ipc.synapsis.curriculumvitae.proxy.IMiscallenousProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class MiscallenousProxy implements IMiscallenousProxy {

    private static Logger LOGGER = LoggerFactory.getLogger(MiscallenousProxy.class);

    @Autowired
    IMiscallenousDao miscallenousDao;

    @Override
    public Miscallenous get(final String id) {
        LOGGER.debug("Start call Proxy layer get a 'Miscallenous',id:{}",id);
        Miscallenous miscallenous =  miscallenousDao.get(id);
        LOGGER.debug("End call Proxy layer get a 'Miscallenous',id:{}",id);
        return miscallenous;
    }

    @Override
    public Iterable<Miscallenous> getAll() {
        LOGGER.debug("Start call Proxy layer get all 'Miscallenous'");
        Iterable<Miscallenous>  miscallenouseList = miscallenousDao.getAll();
        LOGGER.debug("End call Proxy layer get all 'Miscallenous'");
        return  miscallenouseList;
    }

    @Override
    public Miscallenous add(final Miscallenous miscallenous) {
        LOGGER.debug("Start call Proxy layer add new 'Miscallenous',{}",miscallenous);
        Miscallenous miscallenous1 = miscallenousDao.add(miscallenous);
        LOGGER.debug("End call Proxy layer add new 'Miscallenous',{}",miscallenous1);
        return miscallenous1;
    }

    @Override
    public Miscallenous update(final Miscallenous miscallenous) {
        LOGGER.debug("End call Proxy layer update 'Miscallenous',{}",miscallenous);
        Miscallenous miscallenous1 = miscallenousDao.update(miscallenous);
        LOGGER.debug("End call Proxy layer update 'Miscallenous',{}",miscallenous1);
        return miscallenous1;
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Proxy layer remove 'Miscallenous',id:{}",id);
        miscallenousDao.remove(id);
        LOGGER.debug("End call Proxy layer remove 'Miscallenous',id:{}",id);
    }
}
