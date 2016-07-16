package org.ipc.synapsis.curriculumvitae.bean.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Academic Background' IN", description = "The 'Academic Background' IN model")
public class AcademicBackgroundIn {

    @NotNull
    @ApiModelProperty(value = "'Academic Background' IN title property", dataType = "java.lang.String")
    private String title;

    @ApiModelProperty(value = "Reference to 'Curriculum Vitae'", dataType = "org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae")
    private CurriculumVitae curriculumVitae;

    public AcademicBackgroundIn() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CurriculumVitae getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }

    @Override
    public String toString() {
        return "AcademicBackgroundIn{" +
                "title='" + title + '\'' +
                ", curriculumVitae=" + curriculumVitae +
                '}';
    }
}
