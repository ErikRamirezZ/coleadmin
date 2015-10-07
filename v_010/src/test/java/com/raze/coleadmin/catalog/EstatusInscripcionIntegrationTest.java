package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.EstatusInscripcionRepository;
import com.raze.coleadmin.service.EstatusInscripcionService;
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
@RooIntegrationTest(entity = EstatusInscripcion.class)
public class EstatusInscripcionIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    EstatusInscripcionDataOnDemand dod;

	@Autowired
    EstatusInscripcionService estatusInscripcionService;

	@Autowired
    EstatusInscripcionRepository estatusInscripcionRepository;

	@Test
    public void testCountAllEstatusInscripcions() {
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to initialize correctly", dod.getRandomEstatusInscripcion());
        long count = estatusInscripcionService.countAllEstatusInscripcions();
        Assert.assertTrue("Counter for 'EstatusInscripcion' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindEstatusInscripcion() {
        EstatusInscripcion obj = dod.getRandomEstatusInscripcion();
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to provide an identifier", id);
        obj = estatusInscripcionService.findEstatusInscripcion(id);
        Assert.assertNotNull("Find method for 'EstatusInscripcion' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'EstatusInscripcion' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllEstatusInscripcions() {
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to initialize correctly", dod.getRandomEstatusInscripcion());
        long count = estatusInscripcionService.countAllEstatusInscripcions();
        Assert.assertTrue("Too expensive to perform a find all test for 'EstatusInscripcion', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<EstatusInscripcion> result = estatusInscripcionService.findAllEstatusInscripcions();
        Assert.assertNotNull("Find all method for 'EstatusInscripcion' illegally returned null", result);
        Assert.assertTrue("Find all method for 'EstatusInscripcion' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEstatusInscripcionEntries() {
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to initialize correctly", dod.getRandomEstatusInscripcion());
        long count = estatusInscripcionService.countAllEstatusInscripcions();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<EstatusInscripcion> result = estatusInscripcionService.findEstatusInscripcionEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'EstatusInscripcion' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'EstatusInscripcion' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveEstatusInscripcion() {
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to initialize correctly", dod.getRandomEstatusInscripcion());
        EstatusInscripcion obj = dod.getNewTransientEstatusInscripcion(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'EstatusInscripcion' identifier to be null", obj.getId());
        try {
            estatusInscripcionService.saveEstatusInscripcion(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        estatusInscripcionRepository.flush();
        Assert.assertNotNull("Expected 'EstatusInscripcion' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteEstatusInscripcion() {
        EstatusInscripcion obj = dod.getRandomEstatusInscripcion();
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'EstatusInscripcion' failed to provide an identifier", id);
        obj = estatusInscripcionService.findEstatusInscripcion(id);
        estatusInscripcionService.deleteEstatusInscripcion(obj);
        estatusInscripcionRepository.flush();
        Assert.assertNull("Failed to remove 'EstatusInscripcion' with identifier '" + id + "'", estatusInscripcionService.findEstatusInscripcion(id));
    }
}
