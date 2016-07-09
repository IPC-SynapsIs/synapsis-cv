package org.ipc.synapsis.curriculumvitae.dao;

import org.ipc.synapsis.curriculumvitae.entity.Language;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface ILanguageDao {
    Language get(final String id);
    Iterable<Language> getAll();
    Language add(final Language language);
    Language update(final Language language);
    void remove(final String id);
}
