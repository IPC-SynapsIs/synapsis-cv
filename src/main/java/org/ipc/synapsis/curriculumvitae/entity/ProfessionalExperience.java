package org.ipc.synapsis.curriculumvitae.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@Entity
@ApiModel(value = "'Professional Experience'", description = "The 'Professional Experience' model")
public class ProfessionalExperience {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "ID_CURRICULUM_VITAE",nullable = false)
    private CurriculumVitae curriculumVitae;

    public ProfessionalExperience() {
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
}
