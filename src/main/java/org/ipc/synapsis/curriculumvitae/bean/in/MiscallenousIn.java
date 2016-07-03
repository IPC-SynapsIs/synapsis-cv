package org.ipc.synapsis.curriculumvitae.bean.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by mbasri on 02/07/2016.
 */
@ApiModel(value = "'Miscallenous' IN", description = "The 'Miscallenous' IN model")
public class MiscallenousIn {

    @ApiModelProperty(value = "'Miscallenous' IN title property", dataType = "java.lang.String")
    private String title;

    @ApiModelProperty(value = "Reference to 'Curriculum Vitae'", dataType = "org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae")
    private CurriculumVitae curriculumVitae;

    public MiscallenousIn() {
    }

    public CurriculumVitae getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MiscallenousIn{" +
                "title='" + title + '\'' +
                ", curriculumVitae=" + curriculumVitae +
                '}';
    }
}
