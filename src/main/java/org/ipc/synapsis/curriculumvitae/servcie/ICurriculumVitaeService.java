package org.ipc.synapsis.curriculumvitae.servcie;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface ICurriculumVitaeService {
    CurriculumVitaeOut get(String id);
    Iterable<CurriculumVitaeOut> getAll();
    UUID add(CurriculumVitaeIn curriculumVitaeIn);
    void update(String id, CurriculumVitaeIn curriculumVitaeIn);
    void remove(String id);
}
