package org.ipc.synapsis.curriculumvitae.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@Entity
@ApiModel(value = "'Miscallenous'", description = "The 'Miscallenous' model")
public class Miscallenous {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "ID_CURRICULUM_VITAE",nullable = false)
    private CurriculumVitae curriculumVitae;

    public Miscallenous() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CurriculumVitae getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }
}
