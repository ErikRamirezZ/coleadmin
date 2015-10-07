package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.PadreRepository;
import com.raze.coleadmin.service.PadreService;
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
@RooIntegrationTest(entity = Padre.class)
public class PadreIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    PadreDataOnDemand dod;

	@Autowired
    PadreService padreService;

	@Autowired
    PadreRepository padreRepository;

	@Test
    public void testCountAllPadres() {
        Assert.assertNotNull("Data on demand for 'Padre' failed to initialize correctly", dod.getRandomPadre());
        long count = padreService.countAllPadres();
        Assert.assertTrue("Counter for 'Padre' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindPadre() {
        Padre obj = dod.getRandomPadre();
        Assert.assertNotNull("Data on demand for 'Padre' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Padre' failed to provide an identifier", id);
        obj = padreService.findPadre(id);
        Assert.assertNotNull("Find method for 'Padre' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Padre' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllPadres() {
        Assert.assertNotNull("Data on demand for 'Padre' failed to initialize correctly", dod.getRandomPadre());
        long count = padreService.countAllPadres();
        Assert.assertTrue("Too expensive to perform a find all test for 'Padre', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Padre> result = padreService.findAllPadres();
        Assert.assertNotNull("Find all method for 'Padre' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Padre' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindPadreEntries() {
        Assert.assertNotNull("Data on demand for 'Padre' failed to initialize correctly", dod.getRandomPadre());
        long count = padreService.countAllPadres();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Padre> result = padreService.findPadreEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Padre' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Padre' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSavePadre() {
        Assert.assertNotNull("Data on demand for 'Padre' failed to initialize correctly", dod.getRandomPadre());
        Padre obj = dod.getNewTransientPadre(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Padre' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Padre' identifier to be null", obj.getId());
        try {
            padreService.savePadre(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        padreRepository.flush();
        Assert.assertNotNull("Expected 'Padre' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeletePadre() {
        Padre obj = dod.getRandomPadre();
        Assert.assertNotNull("Data on demand for 'Padre' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Padre' failed to provide an identifier", id);
        obj = padreService.findPadre(id);
        padreService.deletePadre(obj);
        padreRepository.flush();
        Assert.assertNull("Failed to remove 'Padre' with identifier '" + id + "'", padreService.findPadre(id));
    }
}
