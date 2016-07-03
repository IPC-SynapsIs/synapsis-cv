package org.ipc.synapsis.curriculumvitae.bean.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Academic Background' OUT", description = "The 'Academic Background' OUT model")
public class AcademicBackgroundOut {

    @ApiModelProperty(value = "'Academic Background' OUT id property", dataType = "java.util.UUID")
    private UUID id;

    @ApiModelProperty(value = "'Academic Background' OUT title property", dataType = "java.lang.String")
    private String title;

    @ApiModelProperty(value = "Reference to 'Curriculum Vitae'", dataType = "org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae")
    private CurriculumVitae curriculumVitae;

    public AcademicBackgroundOut() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        return "AcademicBackgroundOut{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", curriculumVitae=" + curriculumVitae +
                '}';
    }
}
