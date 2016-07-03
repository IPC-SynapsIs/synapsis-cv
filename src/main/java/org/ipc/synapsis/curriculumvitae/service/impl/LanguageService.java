package org.ipc.synapsis.curriculumvitae.service.impl;

import org.ipc.synapsis.curriculumvitae.bean.in.LanguageIn;
import org.ipc.synapsis.curriculumvitae.bean.out.LanguageOut;
import org.ipc.synapsis.curriculumvitae.entity.Language;
import org.ipc.synapsis.curriculumvitae.repository.ILanguageRepository;
import org.ipc.synapsis.curriculumvitae.service.ILanguageService;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean.POJOToBeanOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Component
public class LanguageService implements ILanguageService {

    @Autowired
    ILanguageRepository languageRepository;

    @Override
    public LanguageOut get(final String id) {
        LanguageOut languageOut = null;
        Language language = languageRepository.findOne(UUID.fromString(id));
        languageOut = POJOToBeanOut.getLanguageOut(language);
        return languageOut;
    }

    @Override
    public Iterable<LanguageOut> getAll() {
        ArrayList<LanguageOut> languageOutList = new ArrayList<>();
        Iterable<Language> languageList = languageRepository.findAll();
        for (Language language : languageList){
            LanguageOut languageOut = POJOToBeanOut.getLanguageOut(language);
            languageOutList.add(languageOut);
        }
        return (Iterable) languageOutList;
    }

    @Override
    public UUID add(final LanguageIn languageIn) {
        UUID id= UUID.randomUUID();
        Language language = BeanInToPOJO.getLanguage(languageIn);
        language.setId(id);
        languageRepository.save(language);
        return id;
    }

    @Override
    public void update(final String id,final LanguageIn languageIn) {
        Language language = BeanInToPOJO.getLanguage(languageIn);
        language.setId(UUID.fromString(id));
        languageRepository.save(language);
    }

    @Override
    public void remove(final String id) {
        languageRepository.delete(UUID.fromString(id));

    }
}
