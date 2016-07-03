package org.ipc.synapsis.curriculumvitae.util.mapping.beantopojo;

import org.ipc.synapsis.curriculumvitae.bean.in.CurriculumVitaeIn;
import org.ipc.synapsis.curriculumvitae.entity.CurriculumVitae;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mbasri on 03/07/2016.
 */
public class BeanInToPOJOTest {

    private static String TITLE="My title";
    CurriculumVitae curriculumVitae;

    @Before
    public void init(){
        curriculumVitae = new CurriculumVitae();
        curriculumVitae.setTitle(TITLE);
    }

    @Test
    public void mappingBeanToPOJO(){
        CurriculumVitaeIn curriculumVitaeIn = new CurriculumVitaeIn();
        curriculumVitaeIn.setTitle(TITLE);
        CurriculumVitae curriculumVitaeTest = BeanInToPOJO.getCurriculumVitae(curriculumVitaeIn);
        Assert.assertEquals(curriculumVitaeTest.getTitle(),curriculumVitae.getTitle());
    }
}
