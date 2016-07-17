package org.ipc.synapsis.curriculumvitae.dao;

import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IMiscallenousDao {
    Miscallenous get(final String id) throws ResourceNotFoundException;
    Iterable<Miscallenous> getAll();
    Miscallenous add(final Miscallenous miscallenous);
    Miscallenous update(final Miscallenous miscallenous);
    void remove(final String id);
}
