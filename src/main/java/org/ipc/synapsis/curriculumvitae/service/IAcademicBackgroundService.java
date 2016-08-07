package org.ipc.synapsis.curriculumvitae.service;

import org.ipc.synapsis.curriculumvitae.bean.in.AcademicBackgroundIn;
import org.ipc.synapsis.curriculumvitae.bean.out.AcademicBackgroundOut;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;

import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IAcademicBackgroundService {
    AcademicBackgroundOut get(final String id) throws ResourceNotFoundException, ParseException;
    Iterable<AcademicBackgroundOut> getAll();
    UUID add(final AcademicBackgroundIn academicBackgroundIn);
    void update(final String id, final AcademicBackgroundIn academicBackgroundIn);
    void remove(final String id) throws ParseException;
}
