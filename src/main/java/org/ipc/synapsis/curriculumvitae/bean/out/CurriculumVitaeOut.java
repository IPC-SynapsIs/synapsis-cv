package org.ipc.synapsis.curriculumvitae.bean.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */

@ApiModel(value = "'Curriculum Vitae'", description = "The 'Curriculum Vitae' model")
public class CurriculumVitaeOut {

    @ApiModelProperty(value = "'Curriculum Vitae' id property", dataType = "java.util.UUID")
    private UUID id;

    @NotNull
    @ApiModelProperty(value = "'Curriculum Vitae' collaborator reference property", dataType = "java.lang.String")
    private String collaborator;

    @ApiModelProperty(value = "'Curriculum Vitae' title property", dataType = "java.lang.String")
    private String title;

    public CurriculumVitaeOut() {
    }

    public CurriculumVitaeOut(UUID id, String title) {
        this.setId(id);
        this.setTitle(title);
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

    public String getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(String collaborator) {
        this.collaborator = collaborator;
    }


    @Override
    public String toString() {
        return "CurriculumVitaeOut{" +
                "id=" + id +
                ", collaborator='" + collaborator + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}