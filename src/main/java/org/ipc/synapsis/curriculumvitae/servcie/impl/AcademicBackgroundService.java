package org.ipc.synapsis.curriculumvitae.servcie.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.AcademicBackgroundIn;
import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.AcademicBackgroundOut;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.repository.IAcademicBackgroundRepository;
import org.ipc.synapsis.curriculumvitae.repository.ICurriculumVitaeRepository;
import org.ipc.synapsis.curriculumvitae.servcie.IAcademicBackgroundService;
import org.ipc.synapsis.curriculumvitae.servcie.ICurriculumVitaeService;
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
public class AcademicBackgroundService implements IAcademicBackgroundService {

    @Autowired
    IAcademicBackgroundRepository academicBackgroundRepository;

    @Override
    public AcademicBackgroundOut get(final String id) {
        AcademicBackgroundOut academicBackgroundOut = null;
        AcademicBackground academicBackground = academicBackgroundRepository.findOne(UUID.fromString(id));
        academicBackgroundOut = POJOToBeanOut.getAcademicBackgroundOut(academicBackground);
        return academicBackgroundOut;
    }

    @Override
    public Iterable<AcademicBackgroundOut> getAll() {
        ArrayList<AcademicBackgroundOut> academicBackgroundOutList = new ArrayList<>();
        Iterable<AcademicBackground> academicBackgroundList = academicBackgroundRepository.findAll();
        for (AcademicBackground academicBackground : academicBackgroundList){
            AcademicBackgroundOut academicBackgroundOut = POJOToBeanOut.getAcademicBackgroundOut(academicBackground);
            academicBackgroundOutList.add(academicBackgroundOut);
        }
        return (Iterable) academicBackgroundOutList;
    }

    @Override
    public UUID add(final AcademicBackgroundIn academicBackgroundIn) {
        UUID id= UUID.randomUUID();
        AcademicBackground academicBackground = BeanInToPOJO.getAcademicBackground(academicBackgroundIn);
        academicBackground.setId(id);
        academicBackgroundRepository.save(academicBackground);
        return id;
    }

    @Override
    public void update(final String id,final AcademicBackgroundIn academicBackgroundIn) {
        AcademicBackground academicBackground = BeanInToPOJO.getAcademicBackground(academicBackgroundIn);
        academicBackground.setId(UUID.fromString(id));
        academicBackgroundRepository.save(academicBackground);
    }

    @Override
    public void remove(final String id) {
        academicBackgroundRepository.delete(UUID.fromString(id));

    }
}
