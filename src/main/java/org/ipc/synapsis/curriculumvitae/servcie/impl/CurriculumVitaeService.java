package org.ipc.synapsis.curriculumvitae.servcie.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.repository.ICurriculumVitaeRepository;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean.POJOToBeanOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.servcie.ICurriculumVitaeService;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class CurriculumVitaeService implements ICurriculumVitaeService {

    @Autowired
    ICurriculumVitaeRepository curriculumVitaeRepository;

    @Override
    public CurriculumVitaeOut get(String id) {
        CurriculumVitaeOut curriculumVitaeOut = null;
        CurriculumVitae curriculumVitae = curriculumVitaeRepository.findOne(UUID.fromString(id));
        curriculumVitaeOut = POJOToBeanOut.getCurriculumVitaeOut(curriculumVitae);
        return curriculumVitaeOut;
    }

    @Override
    public Iterable<CurriculumVitaeOut> getAll() {
        ArrayList<CurriculumVitae> curriculumVitaesOutList = new ArrayList<>();
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeRepository.findAll();
        for (CurriculumVitae curriculumVitae : curriculumVitaeList){
            CurriculumVitaeOut curriculumVitaeOut = POJOToBeanOut.getCurriculumVitaeOut(curriculumVitae);
            curriculumVitaesOutList.add(curriculumVitae);
        }
        return (Iterable) curriculumVitaesOutList;
    }

    @Override
    public UUID add(CurriculumVitaeIn curriculumVitaeIn) {
        UUID id= UUID.randomUUID();
        CurriculumVitae curriculumVitae = BeanInToPOJO.getCurriculumVitae(curriculumVitaeIn);
        curriculumVitae.setId(id);

        curriculumVitaeRepository.save(curriculumVitae);
        return id;
    }

    @Override
    public void update(String id, CurriculumVitaeIn curriculumVitaeIn) {
        CurriculumVitae curriculumVitae = BeanInToPOJO.getCurriculumVitae(curriculumVitaeIn);
        curriculumVitae.setId(UUID.fromString(id));
        curriculumVitaeRepository.save(curriculumVitae);
    }

    @Override
    public void remove(String id) {
        curriculumVitaeRepository.delete(UUID.fromString(id));

    }
}
