package org.ipc.synapsis.curriculumvitae.resource;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.in.LanguageIn;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.http.HttpResourceNotFoundException;
import org.springframework.http.ResponseEntity;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface ILanguageResource {
    ResponseEntity add(final LanguageIn languageIn);
    ResponseEntity update(final String id, final LanguageIn languageIn);
    ResponseEntity get(final String id) throws HttpResourceNotFoundException, HttpParseException;
    ResponseEntity getAll();
    ResponseEntity remove(final String id) throws HttpParseException;
}
