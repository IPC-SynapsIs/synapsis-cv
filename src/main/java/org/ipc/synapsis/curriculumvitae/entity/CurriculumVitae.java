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
public class CurriculumVitae {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    private String title;

    public CurriculumVitae() {
    }

    public CurriculumVitae(UUID id, String title) {
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
}
