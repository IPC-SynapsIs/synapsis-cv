package org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean;

import org.ipc.synapsis.curriculumvitae.bean.out.*;
import org.ipc.synapsis.curriculumvitae.entity.*;

/**
 * Created by mbasri on 03/07/2016.
 */
public class POJOToBeanOut {

    public static CurriculumVitaeOut getCurriculumVitaeOut(CurriculumVitae curriculumVitae){
        CurriculumVitaeOut curriculumVitaeOut = new CurriculumVitaeOut();
        curriculumVitaeOut.setId(curriculumVitae.getId());
        curriculumVitaeOut.setTitle(curriculumVitae.getTitle());
        return curriculumVitaeOut;
    }

    public static AcademicBackgroundOut getAcademicBackgroundOut(AcademicBackground academicBackground){
        AcademicBackgroundOut academicBackgroundOut = new AcademicBackgroundOut();
        academicBackgroundOut.setId(academicBackground.getId());
        academicBackgroundOut.setTitle(academicBackground.getTitle());
        academicBackgroundOut.setCurriculumVitae(academicBackground.getCurriculumVitae());
        return academicBackgroundOut;
    }

    public static LanguageOut getLanguageOut(Language language){
        LanguageOut languageOut = new LanguageOut();
        languageOut.setId(language.getId());
        languageOut.setLanguage(language.getLanguage());
        languageOut.setCurriculumVitae(language.getCurriculumVitae());
        return languageOut;
    }

    public static MiscallenousOut getMiscallenousOut(Miscallenous miscallenous){
        MiscallenousOut miscallenousOut = new MiscallenousOut();
        miscallenousOut.setId(miscallenous.getId());
        miscallenousOut.setText(miscallenous.getText());
        miscallenousOut.setCurriculumVitae(miscallenous.getCurriculumVitae());
        return miscallenousOut;
    }

    public static ProfessionalExperienceOut getProfessionalExperienceOut(ProfessionalExperience professionalExperience){
        ProfessionalExperienceOut professionalExperienceOut = new ProfessionalExperienceOut();
        professionalExperienceOut.setId(professionalExperience.getId());
        professionalExperienceOut.setTitle(professionalExperience.getTitle());
        professionalExperienceOut.setCurriculumVitae(professionalExperience.getCurriculumVitae());
        return professionalExperienceOut;
    }
}
