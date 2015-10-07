package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.TipoAsistenciaRepository;
import com.raze.coleadmin.service.TipoAsistenciaService;
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
@RooIntegrationTest(entity = TipoAsistencia.class)
public class TipoAsistenciaIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    TipoAsistenciaDataOnDemand dod;

	@Autowired
    TipoAsistenciaService tipoAsistenciaService;

	@Autowired
    TipoAsistenciaRepository tipoAsistenciaRepository;

	@Test
    public void testCountAllTipoAsistencias() {
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to initialize correctly", dod.getRandomTipoAsistencia());
        long count = tipoAsistenciaService.countAllTipoAsistencias();
        Assert.assertTrue("Counter for 'TipoAsistencia' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindTipoAsistencia() {
        TipoAsistencia obj = dod.getRandomTipoAsistencia();
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to provide an identifier", id);
        obj = tipoAsistenciaService.findTipoAsistencia(id);
        Assert.assertNotNull("Find method for 'TipoAsistencia' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'TipoAsistencia' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllTipoAsistencias() {
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to initialize correctly", dod.getRandomTipoAsistencia());
        long count = tipoAsistenciaService.countAllTipoAsistencias();
        Assert.assertTrue("Too expensive to perform a find all test for 'TipoAsistencia', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<TipoAsistencia> result = tipoAsistenciaService.findAllTipoAsistencias();
        Assert.assertNotNull("Find all method for 'TipoAsistencia' illegally returned null", result);
        Assert.assertTrue("Find all method for 'TipoAsistencia' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindTipoAsistenciaEntries() {
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to initialize correctly", dod.getRandomTipoAsistencia());
        long count = tipoAsistenciaService.countAllTipoAsistencias();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<TipoAsistencia> result = tipoAsistenciaService.findTipoAsistenciaEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'TipoAsistencia' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'TipoAsistencia' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveTipoAsistencia() {
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to initialize correctly", dod.getRandomTipoAsistencia());
        TipoAsistencia obj = dod.getNewTransientTipoAsistencia(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'TipoAsistencia' identifier to be null", obj.getId());
        try {
            tipoAsistenciaService.saveTipoAsistencia(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        tipoAsistenciaRepository.flush();
        Assert.assertNotNull("Expected 'TipoAsistencia' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteTipoAsistencia() {
        TipoAsistencia obj = dod.getRandomTipoAsistencia();
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoAsistencia' failed to provide an identifier", id);
        obj = tipoAsistenciaService.findTipoAsistencia(id);
        tipoAsistenciaService.deleteTipoAsistencia(obj);
        tipoAsistenciaRepository.flush();
        Assert.assertNull("Failed to remove 'TipoAsistencia' with identifier '" + id + "'", tipoAsistenciaService.findTipoAsistencia(id));
    }
}
