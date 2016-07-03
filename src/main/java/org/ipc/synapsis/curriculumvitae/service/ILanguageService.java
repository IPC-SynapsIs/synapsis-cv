package org.ipc.synapsis.curriculumvitae.service;

import org.ipc.synapsis.curriculumvitae.bean.in.LanguageIn;
import org.ipc.synapsis.curriculumvitae.bean.out.LanguageOut;

import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface ILanguageService {
    LanguageOut get(final String id);
    Iterable<LanguageOut> getAll();
    UUID add(final LanguageIn languageIn);
    void update(final String id, final LanguageIn languageIn);
    void remove(final String id);
}
