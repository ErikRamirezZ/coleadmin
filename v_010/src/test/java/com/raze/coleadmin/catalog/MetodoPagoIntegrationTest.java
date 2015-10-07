package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.MetodoPagoRepository;
import com.raze.coleadmin.service.MetodoPagoService;
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
@RooIntegrationTest(entity = MetodoPago.class)
public class MetodoPagoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    MetodoPagoDataOnDemand dod;

	@Autowired
    MetodoPagoService metodoPagoService;

	@Autowired
    MetodoPagoRepository metodoPagoRepository;

	@Test
    public void testCountAllMetodoPagoes() {
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to initialize correctly", dod.getRandomMetodoPago());
        long count = metodoPagoService.countAllMetodoPagoes();
        Assert.assertTrue("Counter for 'MetodoPago' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindMetodoPago() {
        MetodoPago obj = dod.getRandomMetodoPago();
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to provide an identifier", id);
        obj = metodoPagoService.findMetodoPago(id);
        Assert.assertNotNull("Find method for 'MetodoPago' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'MetodoPago' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllMetodoPagoes() {
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to initialize correctly", dod.getRandomMetodoPago());
        long count = metodoPagoService.countAllMetodoPagoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'MetodoPago', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<MetodoPago> result = metodoPagoService.findAllMetodoPagoes();
        Assert.assertNotNull("Find all method for 'MetodoPago' illegally returned null", result);
        Assert.assertTrue("Find all method for 'MetodoPago' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindMetodoPagoEntries() {
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to initialize correctly", dod.getRandomMetodoPago());
        long count = metodoPagoService.countAllMetodoPagoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<MetodoPago> result = metodoPagoService.findMetodoPagoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'MetodoPago' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'MetodoPago' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveMetodoPago() {
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to initialize correctly", dod.getRandomMetodoPago());
        MetodoPago obj = dod.getNewTransientMetodoPago(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'MetodoPago' identifier to be null", obj.getId());
        try {
            metodoPagoService.saveMetodoPago(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        metodoPagoRepository.flush();
        Assert.assertNotNull("Expected 'MetodoPago' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteMetodoPago() {
        MetodoPago obj = dod.getRandomMetodoPago();
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'MetodoPago' failed to provide an identifier", id);
        obj = metodoPagoService.findMetodoPago(id);
        metodoPagoService.deleteMetodoPago(obj);
        metodoPagoRepository.flush();
        Assert.assertNull("Failed to remove 'MetodoPago' with identifier '" + id + "'", metodoPagoService.findMetodoPago(id));
    }
}
