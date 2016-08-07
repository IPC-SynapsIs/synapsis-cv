package org.ipc.synapsis.curriculumvitae.dao;

import org.ipc.synapsis.curriculumvitae.entity.Language;
import org.ipc.synapsis.curriculumvitae.util.exception.ParseException;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface ILanguageDao {
    Language get(final String id) throws ParseException;
    Iterable<Language> getAll();
    Language add(final Language language);
    Language update(final Language language);
    void remove(final String id) throws ParseException;
}
