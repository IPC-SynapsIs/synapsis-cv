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
@ApiModel(value = "'Curriculum Vitae'", description = "POJO pour represanté un 'Curriculum Vitae'")
public class CurriculumVitae {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @ApiModelProperty(value = "L'id de la ressource 'Curriculum Vitae'")
    private UUID id;

    @Column
    @ApiModelProperty(value = "Le nom de la ressource 'Curriculum Vitae'")
    private String name;

    public CurriculumVitae() {
        this.setId(UUID.randomUUID());
    }

    public CurriculumVitae(String name) {
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
