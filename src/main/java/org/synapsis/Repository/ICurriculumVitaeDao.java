package org.synapsis.Repository;

import org.springframework.data.repository.CrudRepository;
import org.synapsis.entity.CurriculumVitae;

import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface ICurriculumVitaeDao extends CrudRepository<CurriculumVitae, UUID> {
}
