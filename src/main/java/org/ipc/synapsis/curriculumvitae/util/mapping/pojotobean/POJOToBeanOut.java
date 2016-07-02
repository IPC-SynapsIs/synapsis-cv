package org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;

/**
 * Created by mbasri on 03/07/2016.
 */
public class POJOToBeanOut {

    public static CurriculumVitaeOut getCurriculumVitaeOut(CurriculumVitae curriculumVitae){
        CurriculumVitaeOut curriculumVitaeOut = new CurriculumVitaeOut();
        curriculumVitaeOut.setId(curriculumVitae.getId());
        curriculumVitaeOut.setTitle(curriculumVitae.getTitle());
        return curriculumVitaeOut;
    }
}
