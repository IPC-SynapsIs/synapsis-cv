package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.dao.ILanguageDao;
import org.ipc.synapsis.curriculumvitae.entity.Language;
import org.ipc.synapsis.curriculumvitae.proxy.ILanguageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class LanguageProxy implements ILanguageProxy {

    @Autowired
    ILanguageDao languageDao;

    @Override
    public Language get(final String id) {
        return languageDao.get(id);
    }

    @Override
    public Iterable<Language> getAll() {
        return languageDao.getAll();
    }

    @Override
    public Language add(final Language language) {
        return languageDao.add(language);
    }

    @Override
    public Language update(final Language language) {
        return languageDao.update(language);
    }

    @Override
    public void remove(final String id) {
        languageDao.remove(id);
    }
}
