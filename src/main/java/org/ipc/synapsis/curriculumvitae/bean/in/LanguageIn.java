package org.ipc.synapsis.curriculumvitae.bean.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import javax.validation.constraints.NotNull;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Language' IN", description = "The 'Language' IN model")
public class LanguageIn {

    @NotNull
    @ApiModelProperty(value = "'Language' IN language property", dataType = "java.lang.String")
    private String Language;

    @ApiModelProperty(value = "Reference to 'Curriculum Vitae'", dataType = "org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae")
    private CurriculumVitae curriculumVitae;

    public LanguageIn() {
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public CurriculumVitae getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }

    @Override
    public String toString() {
        return "LanguageIn{" +
                "Language='" + Language + '\'' +
                ", curriculumVitae=" + curriculumVitae +
                '}';
    }
}
