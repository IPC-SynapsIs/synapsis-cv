package org.ipc.synapsis.curriculumvitae.service.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.LanguageIn;
import org.ipc.synapsis.curriculumvitae.bean.out.LanguageOut;
import org.ipc.synapsis.curriculumvitae.entity.Language;
import org.ipc.synapsis.curriculumvitae.proxy.ILanguageProxy;
import org.ipc.synapsis.curriculumvitae.proxy.impl.LanguageProxy;
import org.ipc.synapsis.curriculumvitae.service.ILanguageService;
import org.ipc.synapsis.curriculumvitae.util.exception.ResourceNotFoundException;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean.POJOToBeanOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class LanguageService implements ILanguageService {

    private static Logger LOGGER = LoggerFactory.getLogger(LanguageService.class);

    @Autowired
    ILanguageProxy languageProxy;

    @Override
    public LanguageOut get(final String id) throws ResourceNotFoundException {
        LOGGER.debug("Start call Service layer get a 'Language OUT',id:{}",id);
        LanguageOut languageOut = null;
        Language language = languageProxy.get(id);
        languageOut = POJOToBeanOut.getLanguageOut(language);
        LOGGER.debug("End call Service layer get a 'Language OUT',{}",languageOut);
        return languageOut;
    }

    @Override
    public Iterable<LanguageOut> getAll() {
        LOGGER.debug("Start call Service layer get all 'Language OUT'");
        ArrayList<LanguageOut> languageOutList = new ArrayList<>();
        Iterable<Language> languageList = languageProxy.getAll();
        for (Language language : languageList){
            LanguageOut languageOut = POJOToBeanOut.getLanguageOut(language);
            languageOutList.add(languageOut);
        }
        LOGGER.debug("End call Service layer get all 'Language OUT'");
        return (Iterable) languageOutList;
    }

    @Override
    public UUID add(final LanguageIn languageIn) {
        LOGGER.debug("Start call Service layer add new 'Language IN',{}",languageIn);
        UUID id= UUID.randomUUID();
        Language language = BeanInToPOJO.getLanguage(languageIn);
        language.setId(id);
        languageProxy.add(language);
        LOGGER.debug("End call Service layer add new 'Language',{}",language);
        return id;
    }

    @Override
    public void update(final String id,final LanguageIn languageIn) {
        LOGGER.debug("End call Service layer update 'Language IN',{}",languageIn);
        Language language = BeanInToPOJO.getLanguage(languageIn);
        language.setId(UUID.fromString(id));
        languageProxy.update(language);
        LOGGER.debug("End call Service layer update 'Language IN',{}",languageIn);
    }

    @Override
    public void remove(final String id) {
        LOGGER.debug("Start call Service layer remove 'Language',id:{}",id);
        languageProxy.remove(id);
        LOGGER.debug("End call Service layer remove 'Language',id:{}",id);

    }
}
