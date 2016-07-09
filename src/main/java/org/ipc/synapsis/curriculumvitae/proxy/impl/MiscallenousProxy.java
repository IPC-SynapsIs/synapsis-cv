package org.ipc.synapsis.curriculumvitae.proxy.impl;


import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;
import org.ipc.synapsis.curriculumvitae.proxy.IMiscallenousProxy;
import org.ipc.synapsis.curriculumvitae.repository.IMiscallenousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class MiscallenousProxy implements IMiscallenousProxy {

    @Autowired
    IMiscallenousRepository miscallenousRepository;

    @Override
    public Miscallenous get(final String id) {
        return miscallenousRepository.findOne(UUID.fromString(id));
    }

    @Override
    public Iterable<Miscallenous> getAll() {
        return miscallenousRepository.findAll();
    }

    @Override
    public Miscallenous add(final Miscallenous miscallenous) {
        return miscallenousRepository.save(miscallenous);
    }

    @Override
    public Miscallenous update(final Miscallenous miscallenous) {
        return miscallenousRepository.save(miscallenous);
    }

    @Override
    public void remove(final String id) {
        miscallenousRepository.delete(UUID.fromString(id));
    }
}
