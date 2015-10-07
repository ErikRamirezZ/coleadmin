package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.NivelEducativoRepository;
import com.raze.coleadmin.service.NivelEducativoService;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@Configurable
@RooIntegrationTest(entity = NivelEducativo.class)
public class NivelEducativoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    NivelEducativoDataOnDemand dod;

	@Autowired
    NivelEducativoService nivelEducativoService;

	@Autowired
    NivelEducativoRepository nivelEducativoRepository;

	@Test
    public void testCountAllNivelEducativoes() {
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to initialize correctly", dod.getRandomNivelEducativo());
        long count = nivelEducativoService.countAllNivelEducativoes();
        Assert.assertTrue("Counter for 'NivelEducativo' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindNivelEducativo() {
        NivelEducativo obj = dod.getRandomNivelEducativo();
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to provide an identifier", id);
        obj = nivelEducativoService.findNivelEducativo(id);
        Assert.assertNotNull("Find method for 'NivelEducativo' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'NivelEducativo' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllNivelEducativoes() {
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to initialize correctly", dod.getRandomNivelEducativo());
        long count = nivelEducativoService.countAllNivelEducativoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'NivelEducativo', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<NivelEducativo> result = nivelEducativoService.findAllNivelEducativoes();
        Assert.assertNotNull("Find all method for 'NivelEducativo' illegally returned null", result);
        Assert.assertTrue("Find all method for 'NivelEducativo' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindNivelEducativoEntries() {
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to initialize correctly", dod.getRandomNivelEducativo());
        long count = nivelEducativoService.countAllNivelEducativoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<NivelEducativo> result = nivelEducativoService.findNivelEducativoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'NivelEducativo' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'NivelEducativo' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveNivelEducativo() {
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to initialize correctly", dod.getRandomNivelEducativo());
        NivelEducativo obj = dod.getNewTransientNivelEducativo(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'NivelEducativo' identifier to be null", obj.getId());
        try {
            nivelEducativoService.saveNivelEducativo(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        nivelEducativoRepository.flush();
        Assert.assertNotNull("Expected 'NivelEducativo' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteNivelEducativo() {
        NivelEducativo obj = dod.getRandomNivelEducativo();
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'NivelEducativo' failed to provide an identifier", id);
        obj = nivelEducativoService.findNivelEducativo(id);
        nivelEducativoService.deleteNivelEducativo(obj);
        nivelEducativoRepository.flush();
        Assert.assertNull("Failed to remove 'NivelEducativo' with identifier '" + id + "'", nivelEducativoService.findNivelEducativo(id));
    }
}
