package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.CicloEscolarRepository;
import com.raze.coleadmin.service.CicloEscolarService;
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
@RooIntegrationTest(entity = CicloEscolar.class)
public class CicloEscolarIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    CicloEscolarDataOnDemand dod;

	@Autowired
    CicloEscolarService cicloEscolarService;

	@Autowired
    CicloEscolarRepository cicloEscolarRepository;

	@Test
    public void testCountAllCicloEscolars() {
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to initialize correctly", dod.getRandomCicloEscolar());
        long count = cicloEscolarService.countAllCicloEscolars();
        Assert.assertTrue("Counter for 'CicloEscolar' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindCicloEscolar() {
        CicloEscolar obj = dod.getRandomCicloEscolar();
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to provide an identifier", id);
        obj = cicloEscolarService.findCicloEscolar(id);
        Assert.assertNotNull("Find method for 'CicloEscolar' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'CicloEscolar' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllCicloEscolars() {
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to initialize correctly", dod.getRandomCicloEscolar());
        long count = cicloEscolarService.countAllCicloEscolars();
        Assert.assertTrue("Too expensive to perform a find all test for 'CicloEscolar', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<CicloEscolar> result = cicloEscolarService.findAllCicloEscolars();
        Assert.assertNotNull("Find all method for 'CicloEscolar' illegally returned null", result);
        Assert.assertTrue("Find all method for 'CicloEscolar' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindCicloEscolarEntries() {
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to initialize correctly", dod.getRandomCicloEscolar());
        long count = cicloEscolarService.countAllCicloEscolars();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<CicloEscolar> result = cicloEscolarService.findCicloEscolarEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'CicloEscolar' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'CicloEscolar' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveCicloEscolar() {
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to initialize correctly", dod.getRandomCicloEscolar());
        CicloEscolar obj = dod.getNewTransientCicloEscolar(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'CicloEscolar' identifier to be null", obj.getId());
        try {
            cicloEscolarService.saveCicloEscolar(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        cicloEscolarRepository.flush();
        Assert.assertNotNull("Expected 'CicloEscolar' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteCicloEscolar() {
        CicloEscolar obj = dod.getRandomCicloEscolar();
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'CicloEscolar' failed to provide an identifier", id);
        obj = cicloEscolarService.findCicloEscolar(id);
        cicloEscolarService.deleteCicloEscolar(obj);
        cicloEscolarRepository.flush();
        Assert.assertNull("Failed to remove 'CicloEscolar' with identifier '" + id + "'", cicloEscolarService.findCicloEscolar(id));
    }
}
