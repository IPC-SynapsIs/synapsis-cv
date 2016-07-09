package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.proxy.ICurriculumVitaeProxy;
import org.ipc.synapsis.curriculumvitae.repository.ICurriculumVitaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class CurriculumVitaeProxy implements ICurriculumVitaeProxy {

    @Autowired
    ICurriculumVitaeRepository curriculumVitaeRepository;

    @Override
    public CurriculumVitae get(String id) {
        return curriculumVitaeRepository.findOne(UUID.fromString(id));
    }

    @Override
    public Iterable<CurriculumVitae> getAll() {
        return curriculumVitaeRepository.findAll();
    }

    @Override
    public CurriculumVitae add(CurriculumVitae curriculumVitae) {
        return curriculumVitaeRepository.save(curriculumVitae);
    }

    @Override
    public CurriculumVitae update(CurriculumVitae curriculumVitae) {
        return curriculumVitaeRepository.save(curriculumVitae);
    }

    @Override
    public void remove(String id) {
        curriculumVitaeRepository.delete(UUID.fromString(id));
    }
}
