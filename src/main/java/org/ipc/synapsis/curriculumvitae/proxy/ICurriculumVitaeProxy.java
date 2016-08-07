package org.ipc.synapsis.curriculumvitae.proxy;

import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface ICurriculumVitaeProxy {
    CurriculumVitae get(final String id) throws ParseException;
    Iterable<CurriculumVitae> getAll();
    CurriculumVitae add(final CurriculumVitae curriculumVitae);
    CurriculumVitae update(final CurriculumVitae curriculumVitae);
    void remove(final String id);
}
