package org.ipc.synapsis.curriculumvitae.dao.impl;

import org.ipc.synapsis.curriculumvitae.dao.ILanguageDao;
import org.ipc.synapsis.curriculumvitae.entity.Language;
import org.ipc.synapsis.curriculumvitae.proxy.ILanguageProxy;
import org.ipc.synapsis.curriculumvitae.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class LanguageDao implements ILanguageDao {

    @Autowired
    ILanguageRepository languageRepository;

    @Override
    public Language get(final String id) {
        return languageRepository.findOne(UUID.fromString(id));
    }

    @Override
    public Iterable<Language> getAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language add(final Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language update(final Language language) {
        return languageRepository.save(language);
    }

    @Override
    public void remove(final String id) {
        languageRepository.delete(UUID.fromString(id));
    }
}
