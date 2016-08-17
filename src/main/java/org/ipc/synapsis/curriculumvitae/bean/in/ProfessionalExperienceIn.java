package org.ipc.synapsis.curriculumvitae.bean.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Professional Experience' IN", description = "The 'Professional Experience' IN model")
public class ProfessionalExperienceIn {

    @NotNull
    @ApiModelProperty(value = "'Professional Experience' IN title property", dataType = "java.lang.String")
    private String title;

    @ApiModelProperty(value = "'Professional Experience' IN project reference property", dataType = "java.lang.String")
    private String idProject;

    @ApiModelProperty(value = "Reference to 'Curriculum Vitae'", dataType = "org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae")
    private CurriculumVitae curriculumVitae;

    @ApiModelProperty(value = "'Professional Experience' IN dateStart property", dataType = "java.lang.Date")
    private Date dateStart;

    @ApiModelProperty(value = "'Professional Experience' IN dateEnd property", dataType = "java.lang.Date")
    private Date dateEnd;


    public ProfessionalExperienceIn() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
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

    @Override
    public String toString() {
        return "ProfessionalExperienceIn{" +
                "title='" + title + '\'' +
                ", idProject='" + idProject + '\'' +
                ", curriculumVitae=" + curriculumVitae +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
