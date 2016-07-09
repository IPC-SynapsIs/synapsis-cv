package org.ipc.synapsis.curriculumvitae.dao;

import org.ipc.synapsis.curriculumvitae.entity.AcademicBackground;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface IAcademicBackgroundDao {
    AcademicBackground get(final String id);
    Iterable<AcademicBackground> getAll();
    AcademicBackground add(final AcademicBackground academicBackground);
    AcademicBackground update(final AcademicBackground academicBackground);
    void remove(final String id);
}
