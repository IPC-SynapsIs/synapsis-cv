package org.ipc.synapsis.curriculumvitae.service.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.MiscallenousIn;
import org.ipc.synapsis.curriculumvitae.bean.out.MiscallenousOut;
import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;
import org.ipc.synapsis.curriculumvitae.repository.IMiscallenousRepository;
import org.ipc.synapsis.curriculumvitae.service.IMiscallenousService;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean.POJOToBeanOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class MiscallenousService implements IMiscallenousService {

    @Autowired
    IMiscallenousRepository miscallenousRepository;

    @Override
    public MiscallenousOut get(final String id) {
        MiscallenousOut miscallenousOut = null;
        Miscallenous miscallenous = miscallenousRepository.findOne(UUID.fromString(id));
        miscallenousOut = POJOToBeanOut.getMiscallenousOut(miscallenous);
        return miscallenousOut;
    }

    @Override
    public Iterable<MiscallenousOut> getAll() {
        ArrayList<MiscallenousOut> miscallenousOutList = new ArrayList<>();
        Iterable<Miscallenous> miscallenousList = miscallenousRepository.findAll();
        for (Miscallenous miscallenous : miscallenousList){
            MiscallenousOut miscallenouOut = POJOToBeanOut.getMiscallenousOut(miscallenous);
            miscallenousOutList.add(miscallenouOut);
        }
        return (Iterable) miscallenousOutList;
    }

    @Override
    public UUID add(final MiscallenousIn miscallenousIn) {
        UUID id= UUID.randomUUID();
        Miscallenous miscallenous = BeanInToPOJO.getMiscallenous(miscallenousIn);
        miscallenous.setId(id);
        miscallenousRepository.save(miscallenous);
        return id;
    }

    @Override
    public void update(final String id,final MiscallenousIn miscallenousIn) {
        Miscallenous miscallenous = BeanInToPOJO.getMiscallenous(miscallenousIn);
        miscallenous.setId(UUID.fromString(id));
        miscallenousRepository.save(miscallenous);
    }

    @Override
    public void remove(final String id) {
        miscallenousRepository.delete(UUID.fromString(id));

    }
}
