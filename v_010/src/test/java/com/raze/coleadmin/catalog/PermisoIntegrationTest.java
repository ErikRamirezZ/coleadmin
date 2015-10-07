package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.PermisoRepository;
import com.raze.coleadmin.service.PermisoService;
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
@RooIntegrationTest(entity = Permiso.class)
public class PermisoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    PermisoDataOnDemand dod;

	@Autowired
    PermisoService permisoService;

	@Autowired
    PermisoRepository permisoRepository;

	@Test
    public void testCountAllPermisoes() {
        Assert.assertNotNull("Data on demand for 'Permiso' failed to initialize correctly", dod.getRandomPermiso());
        long count = permisoService.countAllPermisoes();
        Assert.assertTrue("Counter for 'Permiso' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindPermiso() {
        Permiso obj = dod.getRandomPermiso();
        Assert.assertNotNull("Data on demand for 'Permiso' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Permiso' failed to provide an identifier", id);
        obj = permisoService.findPermiso(id);
        Assert.assertNotNull("Find method for 'Permiso' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Permiso' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllPermisoes() {
        Assert.assertNotNull("Data on demand for 'Permiso' failed to initialize correctly", dod.getRandomPermiso());
        long count = permisoService.countAllPermisoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Permiso', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Permiso> result = permisoService.findAllPermisoes();
        Assert.assertNotNull("Find all method for 'Permiso' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Permiso' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindPermisoEntries() {
        Assert.assertNotNull("Data on demand for 'Permiso' failed to initialize correctly", dod.getRandomPermiso());
        long count = permisoService.countAllPermisoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Permiso> result = permisoService.findPermisoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Permiso' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Permiso' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSavePermiso() {
        Assert.assertNotNull("Data on demand for 'Permiso' failed to initialize correctly", dod.getRandomPermiso());
        Permiso obj = dod.getNewTransientPermiso(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Permiso' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Permiso' identifier to be null", obj.getId());
        try {
            permisoService.savePermiso(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        permisoRepository.flush();
        Assert.assertNotNull("Expected 'Permiso' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeletePermiso() {
        Permiso obj = dod.getRandomPermiso();
        Assert.assertNotNull("Data on demand for 'Permiso' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Permiso' failed to provide an identifier", id);
        obj = permisoService.findPermiso(id);
        permisoService.deletePermiso(obj);
        permisoRepository.flush();
        Assert.assertNull("Failed to remove 'Permiso' with identifier '" + id + "'", permisoService.findPermiso(id));
    }
}
