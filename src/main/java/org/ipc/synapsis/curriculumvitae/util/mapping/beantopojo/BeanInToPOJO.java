package org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

/**
 * Created by mbasri on 03/07/2016.
 */
public class BeanInToPOJO {

    public static CurriculumVitae getCurriculumVitae(CurriculumVitaeIn curriculumVitaeIn){
        CurriculumVitae curriculumVitae = new CurriculumVitae();
        curriculumVitae.setTitle(curriculumVitaeIn.getTitle());
        return curriculumVitae;
    }
}
