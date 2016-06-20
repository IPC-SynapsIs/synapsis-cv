package org.synapsis.resource;

import org.springframework.http.ResponseEntity;
import org.synapsis.entity.CurriculumVitae;

import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface ICurriculumVitaeResource {
    ResponseEntity add(CurriculumVitae curriculumVitae);
    ResponseEntity update(CurriculumVitae curriculumVitae);
    ResponseEntity get(UUID id);
    ResponseEntity getAll();
    ResponseEntity remove(UUID id);

    ResponseEntity ping();

}
