package org.ipc.synapsis.curriculumvitae.service;

import org.ipc.synapsis.curriculumvitae.bean.in.MiscallenousIn;
import org.ipc.synapsis.curriculumvitae.bean.out.MiscallenousOut;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;

import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IMiscallenousService {
    MiscallenousOut get(final String id) throws ResourceNotFoundException, ParseException;
    Iterable<MiscallenousOut> getAll();
    UUID add(final MiscallenousIn miscallenousIn);
    void update(final String id, final MiscallenousIn miscallenousIn);
    void remove(final String id) throws ParseException;
}
