package org.ipc.synapsis.curriculumvitae.proxy;

import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IMiscallenousProxy {
    Miscallenous get(final String id);
    Iterable<Miscallenous> getAll();
    Miscallenous add(final Miscallenous miscallenous);
    Miscallenous update(final Miscallenous miscallenous);
    void remove(final String id);
}