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

    @Column
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
