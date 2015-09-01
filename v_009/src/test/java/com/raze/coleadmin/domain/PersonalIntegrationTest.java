package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.PersonalRepository;
import com.raze.coleadmin.service.PersonalService;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class PersonalIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    PersonalDataOnDemand dod;

	@Autowired
    PersonalService personalService;

	@Autowired
    PersonalRepository personalRepository;

	@Test
    public void testCountAllPersonals() {
        Assert.assertNotNull("Data on demand for 'Personal' failed to initialize correctly", dod.getRandomPersonal());
        long count = personalService.countAllPersonals();
        Assert.assertTrue("Counter for 'Personal' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindPersonal() {
        Personal obj = dod.getRandomPersonal();
        Assert.assertNotNull("Data on demand for 'Personal' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Personal' failed to provide an identifier", id);
        obj = personalService.findPersonal(id);
        Assert.assertNotNull("Find method for 'Personal' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Personal' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllPersonals() {
        Assert.assertNotNull("Data on demand for 'Personal' failed to initialize correctly", dod.getRandomPersonal());
        long count = personalService.countAllPersonals();
        Assert.assertTrue("Too expensive to perform a find all test for 'Personal', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Personal> result = personalService.findAllPersonals();
        Assert.assertNotNull("Find all method for 'Personal' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Personal' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindPersonalEntries() {
        Assert.assertNotNull("Data on demand for 'Personal' failed to initialize correctly", dod.getRandomPersonal());
        long count = personalService.countAllPersonals();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Personal> result = personalService.findPersonalEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Personal' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Personal' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Personal obj = dod.getRandomPersonal();
        Assert.assertNotNull("Data on demand for 'Personal' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Personal' failed to provide an identifier", id);
        obj = personalService.findPersonal(id);
        Assert.assertNotNull("Find method for 'Personal' illegally returned null for id '" + id + "'", obj);
//        boolean modified =  dod.modifyPersonal(obj);
//        Integer currentVersion = obj.getVersion();
//        personalRepository.flush();
//        Assert.assertTrue("Version for 'Personal' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdatePersonalUpdate() {
        Personal obj = dod.getRandomPersonal();
        Assert.assertNotNull("Data on demand for 'Personal' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Personal' failed to provide an identifier", id);
        obj = personalService.findPersonal(id);
        boolean modified =  dod.modifyPersonal(obj);
//        Integer currentVersion = obj.getVersion();
        Personal merged = (Personal)personalService.updatePersonal(obj);
        personalRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
//        Assert.assertTrue("Version for 'Personal' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSavePersonal() {
        Assert.assertNotNull("Data on demand for 'Personal' failed to initialize correctly", dod.getRandomPersonal());
        Personal obj = dod.getNewTransientPersonal(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Personal' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Personal' identifier to be null", obj.getId());
        try {
            personalService.savePersonal(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        personalRepository.flush();
        Assert.assertNotNull("Expected 'Personal' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeletePersonal() {
        Personal obj = dod.getRandomPersonal();
        Assert.assertNotNull("Data on demand for 'Personal' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Personal' failed to provide an identifier", id);
        obj = personalService.findPersonal(id);
        personalService.deletePersonal(obj);
        personalRepository.flush();
        Assert.assertNull("Failed to remove 'Personal' with identifier '" + id + "'", personalService.findPersonal(id));
    }
}
