package org.ipc.synapsis.curriculumvitae.bean.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import java.util.Date;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Professional Experience' IN", description = "The 'Professional Experience' IN model")
public class ProfessionalExperienceOut {

    @ApiModelProperty(value = "'Professional Experience' OUT id property", dataType = "java.util.UUID")
    private UUID id;

    @ApiModelProperty(value = "'Professional Experience' OUT title property", dataType = "java.lang.String")
    private String title;

    @ApiModelProperty(value = "'Professional Experience' OUT project reference property", dataType = "java.lang.String")
    private String idProject;

    @ApiModelProperty(value = "'Professional Experience' OUT dateStart property", dataType = "java.lang.Date")
    private Date dateStart;

    @ApiModelProperty(value = "'Professional Experience' OUT dateEnd property", dataType = "java.lang.Date")
    private Date dateEnd;

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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    @Override
    public String toString() {
        return "ProfessionalExperienceOut{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", idProject='" + idProject + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", curriculumVitae=" + curriculumVitae +
                '}';
    }
}
