package org.ipc.synapsis.curriculumvitae.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by mbasri on 19/06/2016.
 */
@Entity
@ApiModel(value = "'Curriculum Vitae'", description = "The 'Curriculum Vitae' model")
public class CurriculumVitae {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @ApiModelProperty(value = "'Curriculum Vitae' id property", dataType = "java.util.UUID")
    private UUID id;

    @Column
    @ApiModelProperty(value = "'Curriculum Vitae' name property", dataType = "java.lang.String")
    private String name;

    public CurriculumVitae() {
    }

    public CurriculumVitae(UUID id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
