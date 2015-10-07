package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.ConceptoRepository;
import com.raze.coleadmin.service.ConceptoService;
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
@RooIntegrationTest(entity = Concepto.class)
public class ConceptoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    ConceptoDataOnDemand dod;

	@Autowired
    ConceptoService conceptoService;

	@Autowired
    ConceptoRepository conceptoRepository;

	@Test
    public void testCountAllConceptoes() {
        Assert.assertNotNull("Data on demand for 'Concepto' failed to initialize correctly", dod.getRandomConcepto());
        long count = conceptoService.countAllConceptoes();
        Assert.assertTrue("Counter for 'Concepto' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindConcepto() {
        Concepto obj = dod.getRandomConcepto();
        Assert.assertNotNull("Data on demand for 'Concepto' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Concepto' failed to provide an identifier", id);
        obj = conceptoService.findConcepto(id);
        Assert.assertNotNull("Find method for 'Concepto' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Concepto' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllConceptoes() {
        Assert.assertNotNull("Data on demand for 'Concepto' failed to initialize correctly", dod.getRandomConcepto());
        long count = conceptoService.countAllConceptoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Concepto', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Concepto> result = conceptoService.findAllConceptoes();
        Assert.assertNotNull("Find all method for 'Concepto' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Concepto' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindConceptoEntries() {
        Assert.assertNotNull("Data on demand for 'Concepto' failed to initialize correctly", dod.getRandomConcepto());
        long count = conceptoService.countAllConceptoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Concepto> result = conceptoService.findConceptoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Concepto' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Concepto' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveConcepto() {
        Assert.assertNotNull("Data on demand for 'Concepto' failed to initialize correctly", dod.getRandomConcepto());
        Concepto obj = dod.getNewTransientConcepto(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Concepto' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Concepto' identifier to be null", obj.getId());
        try {
            conceptoService.saveConcepto(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        conceptoRepository.flush();
        Assert.assertNotNull("Expected 'Concepto' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteConcepto() {
        Concepto obj = dod.getRandomConcepto();
        Assert.assertNotNull("Data on demand for 'Concepto' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Concepto' failed to provide an identifier", id);
        obj = conceptoService.findConcepto(id);
        conceptoService.deleteConcepto(obj);
        conceptoRepository.flush();
        Assert.assertNull("Failed to remove 'Concepto' with identifier '" + id + "'", conceptoService.findConcepto(id));
    }
}
