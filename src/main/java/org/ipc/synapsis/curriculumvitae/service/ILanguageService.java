package org.ipc.synapsis.curriculumvitae.service;

import org.ipc.synapsis.curriculumvitae.bean.in.LanguageIn;
import org.ipc.synapsis.curriculumvitae.bean.out.LanguageOut;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;

import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface ILanguageService {
    LanguageOut get(final String id) throws ResourceNotFoundException, ParseException;
    Iterable<LanguageOut> getAll();
    UUID add(final LanguageIn languageIn);
    void update(final String id, final LanguageIn languageIn);
    void remove(final String id) throws ParseException;
}
