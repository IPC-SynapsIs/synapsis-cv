package org.ipc.synapsis.curriculumvitae.util.mapping.pojotobean;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.bean.out.CurriculumVitaeOut;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo.BeanInToPOJO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by mbasri on 03/07/2016.
 */
public class POJOToBeanTest {

    private static String TITLE="My title";
    private static String ID="f7d5a54d-d227-4c52-9f04-624c6b3af914";
    CurriculumVitaeOut curriculumVitaeOut;

    @Before
    public void init(){
        curriculumVitaeOut = new CurriculumVitaeOut();
        curriculumVitaeOut.setId(UUID.fromString(ID));
        curriculumVitaeOut.setTitle(TITLE);
    }

    @Test
    public void mappingPOJOToBean(){
        CurriculumVitae curriculumVitae = new CurriculumVitae();
        curriculumVitae.setId(UUID.fromString(ID));
        curriculumVitae.setTitle(TITLE);
        CurriculumVitaeOut curriculumVitaeOutTest = POJOToBeanOut.getCurriculumVitaeOut(curriculumVitae);
        Assert.assertEquals(curriculumVitaeOutTest.getId(),curriculumVitae.getId());
        Assert.assertEquals(curriculumVitaeOutTest.getTitle(),curriculumVitae.getTitle());
    }
}
