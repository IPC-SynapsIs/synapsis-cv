package org.ipc.synapsis.curriculumvitae.bean.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */

@ApiModel(value = "'Curriculum Vitae'", description = "The 'Curriculum Vitae' model")
public class CurriculumVitaeOut {

    @ApiModelProperty(value = "'Curriculum Vitae' id property", dataType = "java.util.UUID")
    private UUID id;

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

    @Override
    public String toString() {
        return "CurriculumVitaeOut{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}