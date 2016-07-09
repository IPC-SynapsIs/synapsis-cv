package org.ipc.synapsis.curriculumvitae.proxy;

import org.ipc.synapsis.curriculumvitae.entity.Language;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface ILanguageProxy {
    Language get(final String id);
    Iterable<Language> getAll();
    Language add(final Language language);
    Language update(final Language language);
    void remove(final String id);
}
