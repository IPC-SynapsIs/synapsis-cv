package org.ipc.synapsis.curriculumvitae.repository;

import org.springframework.data.repository.CrudRepository;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface ICurriculumVitaeRepository extends CrudRepository<CurriculumVitae, UUID> {
}
