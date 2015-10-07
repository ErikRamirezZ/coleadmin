package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.TipoNivelEducativoRepository;
import com.raze.coleadmin.service.TipoNivelEducativoService;
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
@RooIntegrationTest(entity = TipoNivelEducativo.class)
public class TipoNivelEducativoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    TipoNivelEducativoDataOnDemand dod;

	@Autowired
    TipoNivelEducativoService tipoNivelEducativoService;

	@Autowired
    TipoNivelEducativoRepository tipoNivelEducativoRepository;

	@Test
    public void testCountAllTipoNivelEducativoes() {
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to initialize correctly", dod.getRandomTipoNivelEducativo());
        long count = tipoNivelEducativoService.countAllTipoNivelEducativoes();
        Assert.assertTrue("Counter for 'TipoNivelEducativo' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindTipoNivelEducativo() {
        TipoNivelEducativo obj = dod.getRandomTipoNivelEducativo();
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to provide an identifier", id);
        obj = tipoNivelEducativoService.findTipoNivelEducativo(id);
        Assert.assertNotNull("Find method for 'TipoNivelEducativo' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'TipoNivelEducativo' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllTipoNivelEducativoes() {
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to initialize correctly", dod.getRandomTipoNivelEducativo());
        long count = tipoNivelEducativoService.countAllTipoNivelEducativoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'TipoNivelEducativo', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<TipoNivelEducativo> result = tipoNivelEducativoService.findAllTipoNivelEducativoes();
        Assert.assertNotNull("Find all method for 'TipoNivelEducativo' illegally returned null", result);
        Assert.assertTrue("Find all method for 'TipoNivelEducativo' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindTipoNivelEducativoEntries() {
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to initialize correctly", dod.getRandomTipoNivelEducativo());
        long count = tipoNivelEducativoService.countAllTipoNivelEducativoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<TipoNivelEducativo> result = tipoNivelEducativoService.findTipoNivelEducativoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'TipoNivelEducativo' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'TipoNivelEducativo' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveTipoNivelEducativo() {
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to initialize correctly", dod.getRandomTipoNivelEducativo());
        TipoNivelEducativo obj = dod.getNewTransientTipoNivelEducativo(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'TipoNivelEducativo' identifier to be null", obj.getId());
        try {
            tipoNivelEducativoService.saveTipoNivelEducativo(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        tipoNivelEducativoRepository.flush();
        Assert.assertNotNull("Expected 'TipoNivelEducativo' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteTipoNivelEducativo() {
        TipoNivelEducativo obj = dod.getRandomTipoNivelEducativo();
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoNivelEducativo' failed to provide an identifier", id);
        obj = tipoNivelEducativoService.findTipoNivelEducativo(id);
        tipoNivelEducativoService.deleteTipoNivelEducativo(obj);
        tipoNivelEducativoRepository.flush();
        Assert.assertNull("Failed to remove 'TipoNivelEducativo' with identifier '" + id + "'", tipoNivelEducativoService.findTipoNivelEducativo(id));
    }
}
