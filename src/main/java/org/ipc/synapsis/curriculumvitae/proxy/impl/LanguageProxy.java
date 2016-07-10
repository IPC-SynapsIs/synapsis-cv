package org.ipc.synapsis.curriculumvitae.proxy.impl;

import org.ipc.synapsis.curriculumvitae.dao.ILanguageDao;
import org.ipc.synapsis.curriculumvitae.entity.Language;
import org.ipc.synapsis.curriculumvitae.proxy.ILanguageProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class LanguageProxy implements ILanguageProxy {

    private static Logger LOGGER = LoggerFactory.getLogger(LanguageProxy.class);

    @Autowired
    ILanguageDao languageDao;

    @Override
    public Language get(final String id) {
        LOGGER.debug("Start call Proxy layer get a 'Language',id:{}",id);
        Language language = languageDao.get(id);
        LOGGER.debug("End call Proxy layer get a 'Language',id:{}",id);
        return language;
    }

    @Override
    public Iterable<Language> getAll() {
        LOGGER.debug("Start call Proxy layer get all 'Language'");
        Iterable<Language> languageList = languageDao.getAll();
        LOGGER.debug("End call Proxy layer get all 'Language'");
        return languageList;
    }

    @Override
    public Language add(final Language language) {
        LOGGER.debug("Start call Proxy layer add new 'Language',{}",language);
        Language language1 = languageDao.add(language);
        LOGGER.debug("End call Proxy layer add new 'Language',{}",language1);
        return language1;
    }

    @Override
    public Language update(final Language language) {
        LOGGER.debug("End call Proxy layer update 'Language',{}",language);
        Language language1 = languageDao.update(language);
        LOGGER.debug("End call Proxy layer update 'Language',{}",language1);
        return language1;
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Proxy layer remove 'Language',id:{}",id);
        languageDao.remove(id);
        LOGGER.debug("End call Proxy layer remove 'Language',id:{}",id);
    }
}
