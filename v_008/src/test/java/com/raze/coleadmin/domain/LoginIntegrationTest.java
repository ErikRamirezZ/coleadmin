package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.LoginRepository;
import com.raze.coleadmin.service.LoginService;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@Configurable
public class LoginIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    LoginDataOnDemand dod;

	@Autowired
    LoginService loginService;

	@Autowired
    LoginRepository loginRepository;

	@Test
    public void testCountAllLogins() {
        Assert.assertNotNull("Data on demand for 'Login' failed to initialize correctly", dod.getRandomLogin());
        long count = loginService.countAllLogins();
        Assert.assertTrue("Counter for 'Login' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindLogin() {
        Login obj = dod.getRandomLogin();
        Assert.assertNotNull("Data on demand for 'Login' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Login' failed to provide an identifier", id);
        obj = loginService.findLogin(id);
        Assert.assertNotNull("Find method for 'Login' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Login' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllLogins() {
        Assert.assertNotNull("Data on demand for 'Login' failed to initialize correctly", dod.getRandomLogin());
        long count = loginService.countAllLogins();
        Assert.assertTrue("Too expensive to perform a find all test for 'Login', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Login> result = loginService.findAllLogins();
        Assert.assertNotNull("Find all method for 'Login' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Login' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindLoginEntries() {
        Assert.assertNotNull("Data on demand for 'Login' failed to initialize correctly", dod.getRandomLogin());
        long count = loginService.countAllLogins();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Login> result = loginService.findLoginEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Login' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Login' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Login obj = dod.getRandomLogin();
        Assert.assertNotNull("Data on demand for 'Login' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Login' failed to provide an identifier", id);
        obj = loginService.findLogin(id);
        Assert.assertNotNull("Find method for 'Login' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyLogin(obj);
        Integer currentVersion = obj.getVersion();
        loginRepository.flush();
        Assert.assertTrue("Version for 'Login' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdateLoginUpdate() {
        Login obj = dod.getRandomLogin();
        Assert.assertNotNull("Data on demand for 'Login' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Login' failed to provide an identifier", id);
        obj = loginService.findLogin(id);
        boolean modified =  dod.modifyLogin(obj);
        Integer currentVersion = obj.getVersion();
        Login merged = loginService.updateLogin(obj);
        loginRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Login' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSaveLogin() {
        Assert.assertNotNull("Data on demand for 'Login' failed to initialize correctly", dod.getRandomLogin());
        Login obj = dod.getNewTransientLogin(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Login' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Login' identifier to be null", obj.getId());
        try {
            loginService.saveLogin(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        loginRepository.flush();
        Assert.assertNotNull("Expected 'Login' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteLogin() {
        Login obj = dod.getRandomLogin();
        Assert.assertNotNull("Data on demand for 'Login' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Login' failed to provide an identifier", id);
        obj = loginService.findLogin(id);
        loginService.deleteLogin(obj);
        loginRepository.flush();
        Assert.assertNull("Failed to remove 'Login' with identifier '" + id + "'", loginService.findLogin(id));
    }
}
