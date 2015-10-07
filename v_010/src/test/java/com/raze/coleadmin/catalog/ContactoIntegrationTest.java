package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.ContactoRepository;
import com.raze.coleadmin.service.ContactoService;
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
@RooIntegrationTest(entity = Contacto.class)
public class ContactoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    ContactoDataOnDemand dod;

	@Autowired
    ContactoService contactoService;

	@Autowired
    ContactoRepository contactoRepository;

	@Test
    public void testCountAllContactoes() {
        Assert.assertNotNull("Data on demand for 'Contacto' failed to initialize correctly", dod.getRandomContacto());
        long count = contactoService.countAllContactoes();
        Assert.assertTrue("Counter for 'Contacto' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindContacto() {
        Contacto obj = dod.getRandomContacto();
        Assert.assertNotNull("Data on demand for 'Contacto' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Contacto' failed to provide an identifier", id);
        obj = contactoService.findContacto(id);
        Assert.assertNotNull("Find method for 'Contacto' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Contacto' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllContactoes() {
        Assert.assertNotNull("Data on demand for 'Contacto' failed to initialize correctly", dod.getRandomContacto());
        long count = contactoService.countAllContactoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Contacto', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Contacto> result = contactoService.findAllContactoes();
        Assert.assertNotNull("Find all method for 'Contacto' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Contacto' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindContactoEntries() {
        Assert.assertNotNull("Data on demand for 'Contacto' failed to initialize correctly", dod.getRandomContacto());
        long count = contactoService.countAllContactoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Contacto> result = contactoService.findContactoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Contacto' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Contacto' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveContacto() {
        Assert.assertNotNull("Data on demand for 'Contacto' failed to initialize correctly", dod.getRandomContacto());
        Contacto obj = dod.getNewTransientContacto(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Contacto' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Contacto' identifier to be null", obj.getId());
        try {
            contactoService.saveContacto(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        contactoRepository.flush();
        Assert.assertNotNull("Expected 'Contacto' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteContacto() {
        Contacto obj = dod.getRandomContacto();
        Assert.assertNotNull("Data on demand for 'Contacto' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Contacto' failed to provide an identifier", id);
        obj = contactoService.findContacto(id);
        contactoService.deleteContacto(obj);
        contactoRepository.flush();
        Assert.assertNull("Failed to remove 'Contacto' with identifier '" + id + "'", contactoService.findContacto(id));
    }
}
