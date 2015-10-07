package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.GrupoRepository;
import com.raze.coleadmin.service.GrupoService;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@RooIntegrationTest(entity = Grupo.class)
public class GrupoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    GrupoDataOnDemand dod;

	@Autowired
    GrupoService grupoService;

	@Autowired
    GrupoRepository grupoRepository;

	@Test
    public void testCountAllGrupoes() {
        Assert.assertNotNull("Data on demand for 'Grupo' failed to initialize correctly", dod.getRandomGrupo());
        long count = grupoService.countAllGrupoes();
        Assert.assertTrue("Counter for 'Grupo' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindGrupo() {
        Grupo obj = dod.getRandomGrupo();
        Assert.assertNotNull("Data on demand for 'Grupo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Grupo' failed to provide an identifier", id);
        obj = grupoService.findGrupo(id);
        Assert.assertNotNull("Find method for 'Grupo' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Grupo' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllGrupoes() {
        Assert.assertNotNull("Data on demand for 'Grupo' failed to initialize correctly", dod.getRandomGrupo());
        long count = grupoService.countAllGrupoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Grupo', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Grupo> result = grupoService.findAllGrupoes();
        Assert.assertNotNull("Find all method for 'Grupo' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Grupo' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindGrupoEntries() {
        Assert.assertNotNull("Data on demand for 'Grupo' failed to initialize correctly", dod.getRandomGrupo());
        long count = grupoService.countAllGrupoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Grupo> result = grupoService.findGrupoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Grupo' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Grupo' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveGrupo() {
        Assert.assertNotNull("Data on demand for 'Grupo' failed to initialize correctly", dod.getRandomGrupo());
        Grupo obj = dod.getNewTransientGrupo(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Grupo' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Grupo' identifier to be null", obj.getId());
        try {
            grupoService.saveGrupo(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        grupoRepository.flush();
        Assert.assertNotNull("Expected 'Grupo' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteGrupo() {
        Grupo obj = dod.getRandomGrupo();
        Assert.assertNotNull("Data on demand for 'Grupo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Grupo' failed to provide an identifier", id);
        obj = grupoService.findGrupo(id);
        grupoService.deleteGrupo(obj);
        grupoRepository.flush();
        Assert.assertNull("Failed to remove 'Grupo' with identifier '" + id + "'", grupoService.findGrupo(id));
    }
}
