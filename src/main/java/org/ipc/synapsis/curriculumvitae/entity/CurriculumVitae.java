package org.ipc.synapsis.curriculumvitae.entity;

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
    private String idCollaborator;

    @Column
    private String title;

    @Column
    private String description;

    public CurriculumVitae() {
    }

    public CurriculumVitae(UUID id, String title, String idCollaborator) {
        this.setId(id);
        this.setTitle(title);
        this.setIdCollaborator(idCollaborator);
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

    public String getIdCollaborator() {
        return idCollaborator;
    }

    public void setIdCollaborator(String idCollaborator) {
        this.idCollaborator = idCollaborator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
