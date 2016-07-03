package org.ipc.synapsis.curriculumvitae.service;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;

import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface ICurriculumVitaeService {
    CurriculumVitaeOut get(final String id);
    Iterable<CurriculumVitaeOut> getAll();
    UUID add(final CurriculumVitaeIn curriculumVitaeIn);
    void update(final String id, final CurriculumVitaeIn curriculumVitaeIn);
    void remove(final String id);
}
