package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;
import org.ipc.synapsis.curriculumvitae.proxy.IAcademicBackgroundProxy;
import org.ipc.synapsis.curriculumvitae.repository.IAcademicBackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class AcademicBackgroundProxy implements IAcademicBackgroundProxy {

    @Autowired
    IAcademicBackgroundRepository academicBackgroundRepository;

    @Override
    public AcademicBackground get(final String id) {
        return academicBackgroundRepository.findOne(UUID.fromString(id));
    }

    @Override
    public Iterable<AcademicBackground> getAll() {
        return academicBackgroundRepository.findAll();
    }

    @Override
    public AcademicBackground add(final AcademicBackground academicBackground) {
        return academicBackgroundRepository.save(academicBackground);
    }

    @Override
    public AcademicBackground update(final AcademicBackground academicBackground) {
        return academicBackgroundRepository.save(academicBackground);
    }

    @Override
    public void remove(final String id) {
        academicBackgroundRepository.delete(UUID.fromString(id));
    }
}
