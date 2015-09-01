package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.DocenteRepository;
import com.raze.coleadmin.service.DocenteService;
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
public class DocenteIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    DocenteDataOnDemand dod;

	@Autowired
    DocenteService docenteService;

	@Autowired
    DocenteRepository docenteRepository;

	@Test
    public void testCountAllDocentes() {
        Assert.assertNotNull("Data on demand for 'Docente' failed to initialize correctly", dod.getRandomDocente());
        long count = docenteService.countAllDocentes();
        Assert.assertTrue("Counter for 'Docente' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindDocente() {
        Docente obj = dod.getRandomDocente();
        Assert.assertNotNull("Data on demand for 'Docente' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Docente' failed to provide an identifier", id);
        obj = docenteService.findDocente(id);
        Assert.assertNotNull("Find method for 'Docente' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Docente' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllDocentes() {
        Assert.assertNotNull("Data on demand for 'Docente' failed to initialize correctly", dod.getRandomDocente());
        long count = docenteService.countAllDocentes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Docente', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Docente> result = docenteService.findAllDocentes();
        Assert.assertNotNull("Find all method for 'Docente' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Docente' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindDocenteEntries() {
        Assert.assertNotNull("Data on demand for 'Docente' failed to initialize correctly", dod.getRandomDocente());
        long count = docenteService.countAllDocentes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Docente> result = docenteService.findDocenteEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Docente' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Docente' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Docente obj = dod.getRandomDocente();
        Assert.assertNotNull("Data on demand for 'Docente' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Docente' failed to provide an identifier", id);
        obj = docenteService.findDocente(id);
        Assert.assertNotNull("Find method for 'Docente' illegally returned null for id '" + id + "'", obj);
//        boolean modified =  dod.modifyDocente(obj);
//        Integer currentVersion = obj.getVersion();
//        docenteRepository.flush();
//        Assert.assertTrue("Version for 'Docente' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdateDocenteUpdate() {
        Docente obj = dod.getRandomDocente();
        Assert.assertNotNull("Data on demand for 'Docente' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Docente' failed to provide an identifier", id);
        obj = docenteService.findDocente(id);
        boolean modified =  dod.modifyDocente(obj);
//        Integer currentVersion = obj.getVersion();
        Docente merged = (Docente)docenteService.updateDocente(obj);
        docenteRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
//        Assert.assertTrue("Version for 'Docente' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSaveDocente() {
        Assert.assertNotNull("Data on demand for 'Docente' failed to initialize correctly", dod.getRandomDocente());
        Docente obj = dod.getNewTransientDocente(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Docente' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Docente' identifier to be null", obj.getId());
        try {
            docenteService.saveDocente(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        docenteRepository.flush();
        Assert.assertNotNull("Expected 'Docente' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteDocente() {
        Docente obj = dod.getRandomDocente();
        Assert.assertNotNull("Data on demand for 'Docente' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Docente' failed to provide an identifier", id);
        obj = docenteService.findDocente(id);
        docenteService.deleteDocente(obj);
        docenteRepository.flush();
        Assert.assertNull("Failed to remove 'Docente' with identifier '" + id + "'", docenteService.findDocente(id));
    }
}
