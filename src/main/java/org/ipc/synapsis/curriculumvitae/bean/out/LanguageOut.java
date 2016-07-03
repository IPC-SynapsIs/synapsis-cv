package org.ipc.synapsis.curriculumvitae.bean.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Language' OUT", description = "The 'Language' OUT model")
public class LanguageOut {

    @ApiModelProperty(value = "'Language' OUT id property", dataType = "java.util.UUID")
    private UUID id;

    @ApiModelProperty(value = "'Language' OUT language property", dataType = "java.lang.String")
    private String Language;

    @ApiModelProperty(value = "Reference to 'Curriculum Vitae'", dataType = "org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae")
    private CurriculumVitae curriculumVitae;

    public LanguageOut() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        return "LanguageOut{" +
                "id=" + id +
                ", Language='" + Language + '\'' +
                ", curriculumVitae=" + curriculumVitae +
                '}';
    }
}
