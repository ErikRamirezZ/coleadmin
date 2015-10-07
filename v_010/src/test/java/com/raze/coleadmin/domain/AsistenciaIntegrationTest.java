package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.AsistenciaRepository;
import com.raze.coleadmin.service.AsistenciaService;
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
@RooIntegrationTest(entity = Asistencia.class)
public class AsistenciaIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    AsistenciaDataOnDemand dod;

	@Autowired
    AsistenciaService asistenciaService;

	@Autowired
    AsistenciaRepository asistenciaRepository;

	@Test
    public void testCountAllAsistencias() {
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to initialize correctly", dod.getRandomAsistencia());
        long count = asistenciaService.countAllAsistencias();
        Assert.assertTrue("Counter for 'Asistencia' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindAsistencia() {
        Asistencia obj = dod.getRandomAsistencia();
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to provide an identifier", id);
        obj = asistenciaService.findAsistencia(id);
        Assert.assertNotNull("Find method for 'Asistencia' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Asistencia' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllAsistencias() {
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to initialize correctly", dod.getRandomAsistencia());
        long count = asistenciaService.countAllAsistencias();
        Assert.assertTrue("Too expensive to perform a find all test for 'Asistencia', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Asistencia> result = asistenciaService.findAllAsistencias();
        Assert.assertNotNull("Find all method for 'Asistencia' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Asistencia' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindAsistenciaEntries() {
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to initialize correctly", dod.getRandomAsistencia());
        long count = asistenciaService.countAllAsistencias();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Asistencia> result = asistenciaService.findAsistenciaEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Asistencia' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Asistencia' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveAsistencia() {
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to initialize correctly", dod.getRandomAsistencia());
        Asistencia obj = dod.getNewTransientAsistencia(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Asistencia' identifier to be null", obj.getId());
        try {
            asistenciaService.saveAsistencia(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        asistenciaRepository.flush();
        Assert.assertNotNull("Expected 'Asistencia' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteAsistencia() {
        Asistencia obj = dod.getRandomAsistencia();
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Asistencia' failed to provide an identifier", id);
        obj = asistenciaService.findAsistencia(id);
        asistenciaService.deleteAsistencia(obj);
        asistenciaRepository.flush();
        Assert.assertNull("Failed to remove 'Asistencia' with identifier '" + id + "'", asistenciaService.findAsistencia(id));
    }
}
