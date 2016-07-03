package org.ipc.synapsis.curriculumvitae.bean.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Miscallenous'", description = "The 'Miscallenous' model")
public class MiscallenousOut {

    @ApiModelProperty(value = "'Miscallenous' id property", dataType = "java.util.UUID")
    private UUID id;

    @ApiModelProperty(value = "'Miscallenous' title property", dataType = "java.lang.String")
    private String title;

    @ApiModelProperty(value = "Reference to 'Curriculum Vitae'", dataType = "org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae")
    private CurriculumVitae curriculumVitae;


    public MiscallenousOut() {
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
