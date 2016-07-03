package org.ipc.synapsis.curriculumvitae.bean.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Professional Experience' IN", description = "The 'Professional Experience' IN model")
public class ProfessionalExperienceOut {

    @ApiModelProperty(value = "'Professional Experience' IN id property", dataType = "java.util.UUID")
    private UUID id;

    @ApiModelProperty(value = "'Professional Experience' IN title property", dataType = "java.lang.String")
    private String title;

    @ApiModelProperty(value = "Reference to 'Curriculum Vitae'", dataType = "org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae")
    private CurriculumVitae curriculumVitae;

    public ProfessionalExperienceOut() {
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
        return "ProfessionalExperienceOut{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", curriculumVitae=" + curriculumVitae +
                '}';
    }
}
