package org.synapsis.entity;

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

    public CurriculumVitae() {
    }

    public CurriculumVitae(UUID id) {

        this.setId(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
