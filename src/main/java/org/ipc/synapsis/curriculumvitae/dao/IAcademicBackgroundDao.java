package org.ipc.synapsis.curriculumvitae.dao;

import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface IAcademicBackgroundDao {
    AcademicBackground get(final String id) throws ParseException;
    Iterable<AcademicBackground> getAll();
    AcademicBackground add(final AcademicBackground academicBackground);
    AcademicBackground update(final AcademicBackground academicBackground);
    void remove(final String id);
}
