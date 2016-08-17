package org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo;

import org.ipc.synapsis.curriculumvitae.bean.in.*;
import org.ipc.synapsis.curriculumvitae.entity.*;

/**
 * Created by mbasri on 03/07/2016.
 */
public class BeanInToPOJO {

    public static CurriculumVitae getCurriculumVitae(CurriculumVitaeIn curriculumVitaeIn){
        CurriculumVitae curriculumVitae = new CurriculumVitae();
        curriculumVitae.setTitle(curriculumVitaeIn.getTitle());
        curriculumVitae.setCollaborator(curriculumVitaeIn.getCollaborator());
        return curriculumVitae;
    }

    public static AcademicBackground getAcademicBackground(AcademicBackgroundIn academicBackgroundIn){
        AcademicBackground academicBackground = new AcademicBackground();
        academicBackground.setTitle(academicBackgroundIn.getTitle());
        academicBackground.setCurriculumVitae(academicBackgroundIn.getCurriculumVitae());
        return academicBackground;
    }

    public static Language getLanguage(LanguageIn languageIn){
        Language language = new Language();
        language.setLanguage(languageIn.getLanguage());
        language.setCurriculumVitae(languageIn.getCurriculumVitae());
        return language;
    }

    public static Miscallenous getMiscallenous(MiscallenousIn miscallenousIn){
        Miscallenous miscallenous = new Miscallenous();
        miscallenous.setText(miscallenousIn.getText());
        miscallenous.setCurriculumVitae(miscallenousIn.getCurriculumVitae());
        return miscallenous;
    }

    public static ProfessionalExperience getProfessionalExperience(ProfessionalExperienceIn professionalExperienceIn){
        ProfessionalExperience professionalExperience = new ProfessionalExperience();
        professionalExperience.setTitle(professionalExperienceIn.getTitle());
        professionalExperience.setIdProject(professionalExperienceIn.getIdProject());
        professionalExperience.setCurriculumVitae(professionalExperienceIn.getCurriculumVitae());
        professionalExperience.setDateStart(professionalExperienceIn.getDateStart());
        professionalExperience.setDateEnd(professionalExperienceIn.getDateEnd());
        return professionalExperience;
    }
}
