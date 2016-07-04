package org.ipc.synapsis.curriculumvitae.resource;

import org.ipc.synapsis.curriculumvitae.bean.in.AcademicBackgroundIn;
import org.ipc.synapsis.curriculumvitae.bean.in.MiscallenousIn;
import org.springframework.http.ResponseEntity;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IMiscallenousResource {
    ResponseEntity add(final MiscallenousIn miscallenousIn);
    ResponseEntity update(final String id, final MiscallenousIn miscallenousIn);
    ResponseEntity get(final String id);
    ResponseEntity getAll();
    ResponseEntity remove(final String id);
}
