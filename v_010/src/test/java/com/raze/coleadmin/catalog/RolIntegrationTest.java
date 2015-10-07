package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.RolRepository;
import com.raze.coleadmin.service.RolService;
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
@RooIntegrationTest(entity = Rol.class)
public class RolIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    RolDataOnDemand dod;

	@Autowired
    RolService rolService;

	@Autowired
    RolRepository rolRepository;

	@Test
    public void testCountAllRols() {
        Assert.assertNotNull("Data on demand for 'Rol' failed to initialize correctly", dod.getRandomRol());
        long count = rolService.countAllRols();
        Assert.assertTrue("Counter for 'Rol' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindRol() {
        Rol obj = dod.getRandomRol();
        Assert.assertNotNull("Data on demand for 'Rol' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Rol' failed to provide an identifier", id);
        obj = rolService.findRol(id);
        Assert.assertNotNull("Find method for 'Rol' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Rol' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllRols() {
        Assert.assertNotNull("Data on demand for 'Rol' failed to initialize correctly", dod.getRandomRol());
        long count = rolService.countAllRols();
        Assert.assertTrue("Too expensive to perform a find all test for 'Rol', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Rol> result = rolService.findAllRols();
        Assert.assertNotNull("Find all method for 'Rol' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Rol' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindRolEntries() {
        Assert.assertNotNull("Data on demand for 'Rol' failed to initialize correctly", dod.getRandomRol());
        long count = rolService.countAllRols();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Rol> result = rolService.findRolEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Rol' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Rol' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveRol() {
        Assert.assertNotNull("Data on demand for 'Rol' failed to initialize correctly", dod.getRandomRol());
        Rol obj = dod.getNewTransientRol(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Rol' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Rol' identifier to be null", obj.getId());
        try {
            rolService.saveRol(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        rolRepository.flush();
        Assert.assertNotNull("Expected 'Rol' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteRol() {
        Rol obj = dod.getRandomRol();
        Assert.assertNotNull("Data on demand for 'Rol' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Rol' failed to provide an identifier", id);
        obj = rolService.findRol(id);
        rolService.deleteRol(obj);
        rolRepository.flush();
        Assert.assertNull("Failed to remove 'Rol' with identifier '" + id + "'", rolService.findRol(id));
    }
}
