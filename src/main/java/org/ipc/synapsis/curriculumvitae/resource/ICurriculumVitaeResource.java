package org.ipc.synapsis.curriculumvitae.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface ICurriculumVitaeResource {
    ResponseEntity add(CurriculumVitae curriculumVitae);
    ResponseEntity update(CurriculumVitae curriculumVitae);
    ResponseEntity get(String id);
    ResponseEntity getAll();
    ResponseEntity remove(String id);
    ResponseEntity health();
}
