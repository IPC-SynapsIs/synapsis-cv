package org.ipc.synapsis.curriculumvitae.repository;

import org.ipc.synapsis.curriculumvitae.entity.Language;
import org.ipc.synapsis.curriculumvitae.entity.Miscallenous;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface IMiscallenousRepository extends CrudRepository<Miscallenous, UUID> {
}
