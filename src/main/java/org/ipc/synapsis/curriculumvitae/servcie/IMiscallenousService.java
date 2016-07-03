package org.ipc.synapsis.curriculumvitae.servcie;

import org.ipc.synapsis.curriculumvitae.bean.in.LanguageIn;
import org.ipc.synapsis.curriculumvitae.bean.in.MiscallenousIn;
import org.ipc.synapsis.curriculumvitae.bean.out.LanguageOut;
import org.ipc.synapsis.curriculumvitae.bean.out.MiscallenousOut;

import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IMiscallenousService {
    MiscallenousOut get(final String id);
    Iterable<MiscallenousOut> getAll();
    UUID add(final MiscallenousIn miscallenousIn);
    void update(final String id, final MiscallenousIn miscallenousIn);
    void remove(final String id);
}
