package org.ipc.synapsis.curriculumvitae.service.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.proxy.ICurriculumVitaeProxy;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean.POJOToBeanOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.service.ICurriculumVitaeService;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class CurriculumVitaeService implements ICurriculumVitaeService {

    @Autowired
    ICurriculumVitaeProxy curriculumVitaeProxy;

    @Override
    public CurriculumVitaeOut get(final String id) {
        CurriculumVitaeOut curriculumVitaeOut = null;
        CurriculumVitae curriculumVitae = curriculumVitaeProxy.get(id);
        curriculumVitaeOut = POJOToBeanOut.getCurriculumVitaeOut(curriculumVitae);
        return curriculumVitaeOut;
    }

    @Override
    public Iterable<CurriculumVitaeOut> getAll() {
        ArrayList<CurriculumVitae> curriculumVitaesOutList = new ArrayList<>();
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeProxy.getAll();
        for (CurriculumVitae curriculumVitae : curriculumVitaeList){
            CurriculumVitaeOut curriculumVitaeOut = POJOToBeanOut.getCurriculumVitaeOut(curriculumVitae);
            curriculumVitaesOutList.add(curriculumVitae);
        }
        return (Iterable) curriculumVitaesOutList;
    }

    @Override
    public UUID add(final CurriculumVitaeIn curriculumVitaeIn) {
        UUID id= UUID.randomUUID();
        CurriculumVitae curriculumVitae = BeanInToPOJO.getCurriculumVitae(curriculumVitaeIn);
        curriculumVitae.setId(id);
        curriculumVitaeProxy.add(curriculumVitae);
        return id;
    }

    @Override
    public void update(final String id,final CurriculumVitaeIn curriculumVitaeIn) {
        CurriculumVitae curriculumVitae = BeanInToPOJO.getCurriculumVitae(curriculumVitaeIn);
        curriculumVitae.setId(UUID.fromString(id));
        curriculumVitaeProxy.update(curriculumVitae);
    }

    @Override
    public void remove(final String id) {
        curriculumVitaeProxy.remove(id);

    }
}
