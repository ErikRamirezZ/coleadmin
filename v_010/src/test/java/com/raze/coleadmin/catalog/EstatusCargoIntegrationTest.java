package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.EstatusCargoRepository;
import com.raze.coleadmin.service.EstatusCargoService;
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
@RooIntegrationTest(entity = EstatusCargo.class)
public class EstatusCargoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    EstatusCargoDataOnDemand dod;

	@Autowired
    EstatusCargoService estatusCargoService;

	@Autowired
    EstatusCargoRepository estatusCargoRepository;

	@Test
    public void testCountAllEstatusCargoes() {
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to initialize correctly", dod.getRandomEstatusCargo());
        long count = estatusCargoService.countAllEstatusCargoes();
        Assert.assertTrue("Counter for 'EstatusCargo' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindEstatusCargo() {
        EstatusCargo obj = dod.getRandomEstatusCargo();
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to provide an identifier", id);
        obj = estatusCargoService.findEstatusCargo(id);
        Assert.assertNotNull("Find method for 'EstatusCargo' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'EstatusCargo' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllEstatusCargoes() {
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to initialize correctly", dod.getRandomEstatusCargo());
        long count = estatusCargoService.countAllEstatusCargoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'EstatusCargo', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<EstatusCargo> result = estatusCargoService.findAllEstatusCargoes();
        Assert.assertNotNull("Find all method for 'EstatusCargo' illegally returned null", result);
        Assert.assertTrue("Find all method for 'EstatusCargo' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEstatusCargoEntries() {
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to initialize correctly", dod.getRandomEstatusCargo());
        long count = estatusCargoService.countAllEstatusCargoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<EstatusCargo> result = estatusCargoService.findEstatusCargoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'EstatusCargo' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'EstatusCargo' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveEstatusCargo() {
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to initialize correctly", dod.getRandomEstatusCargo());
        EstatusCargo obj = dod.getNewTransientEstatusCargo(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'EstatusCargo' identifier to be null", obj.getId());
        try {
            estatusCargoService.saveEstatusCargo(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        estatusCargoRepository.flush();
        Assert.assertNotNull("Expected 'EstatusCargo' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteEstatusCargo() {
        EstatusCargo obj = dod.getRandomEstatusCargo();
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'EstatusCargo' failed to provide an identifier", id);
        obj = estatusCargoService.findEstatusCargo(id);
        estatusCargoService.deleteEstatusCargo(obj);
        estatusCargoRepository.flush();
        Assert.assertNull("Failed to remove 'EstatusCargo' with identifier '" + id + "'", estatusCargoService.findEstatusCargo(id));
    }
}
