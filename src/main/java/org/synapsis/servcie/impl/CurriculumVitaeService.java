package org.synapsis.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.synapsis.entity.CurriculumVitae;
import org.synapsis.repository.ICurriculumVitaeRepository;
import org.synapsis.servcie.ICurriculumVitaeService;

import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class CurriculumVitaeService implements ICurriculumVitaeService {

    @Autowired
    ICurriculumVitaeRepository curriculumVitaeRepository;

    @Override
    public CurriculumVitae get(String id) {
        CurriculumVitae curriculumVitae = curriculumVitaeRepository.findOne(UUID.fromString(id));
        return curriculumVitae;
    }

    @Override
    public Iterable<CurriculumVitae> gelAll() {
        Iterable<CurriculumVitae> curriculumVitaeList = curriculumVitaeRepository.findAll();
        return curriculumVitaeList;
    }

    @Override
    public void add(CurriculumVitae curriculumVitae) {
        curriculumVitaeRepository.save(curriculumVitae);

    }

    @Override
    public void update(CurriculumVitae curriculumVitae) {
        curriculumVitaeRepository.save(curriculumVitae);

    }

    @Override
    public void remove(String id) {
        curriculumVitaeRepository.delete(UUID.fromString(id));

    }
}
