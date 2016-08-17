package org.ipc.synapsis.curriculumvitae.bean.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Curriculum Vitae'", description = "The 'Curriculum Vitae' IN model")
public class CurriculumVitaeIn {

    @NotNull
    @ApiModelProperty(value = "'Curriculum Vitae' IN title property", dataType = "java.lang.String")
    private String title;

    @NotNull
    @ApiModelProperty(value = "'Curriculum Vitae' IN collaborator reference property", dataType = "java.lang.String")
    private String collaborator;

    public CurriculumVitaeIn() {
    }

    public CurriculumVitaeIn(String title) {
        this.setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(String collaborator) {
        this.collaborator = collaborator;
    }

    @Override
    public String toString() {
        return "CurriculumVitaeIn{" +
                "title='" + title + '\'' +
                ", collaborator='" + collaborator + '\'' +
                '}';
    }
}