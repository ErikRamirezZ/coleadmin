package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.CategoriaRepository;
import com.raze.coleadmin.service.CategoriaService;
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
@RooIntegrationTest(entity = Categoria.class)
public class CategoriaIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    CategoriaDataOnDemand dod;

	@Autowired
    CategoriaService categoriaService;

	@Autowired
    CategoriaRepository categoriaRepository;

	@Test
    public void testCountAllCategorias() {
        Assert.assertNotNull("Data on demand for 'Categoria' failed to initialize correctly", dod.getRandomCategoria());
        long count = categoriaService.countAllCategorias();
        Assert.assertTrue("Counter for 'Categoria' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindCategoria() {
        Categoria obj = dod.getRandomCategoria();
        Assert.assertNotNull("Data on demand for 'Categoria' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Categoria' failed to provide an identifier", id);
        obj = categoriaService.findCategoria(id);
        Assert.assertNotNull("Find method for 'Categoria' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Categoria' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllCategorias() {
        Assert.assertNotNull("Data on demand for 'Categoria' failed to initialize correctly", dod.getRandomCategoria());
        long count = categoriaService.countAllCategorias();
        Assert.assertTrue("Too expensive to perform a find all test for 'Categoria', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Categoria> result = categoriaService.findAllCategorias();
        Assert.assertNotNull("Find all method for 'Categoria' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Categoria' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindCategoriaEntries() {
        Assert.assertNotNull("Data on demand for 'Categoria' failed to initialize correctly", dod.getRandomCategoria());
        long count = categoriaService.countAllCategorias();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Categoria> result = categoriaService.findCategoriaEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Categoria' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Categoria' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testSaveCategoria() {
        Assert.assertNotNull("Data on demand for 'Categoria' failed to initialize correctly", dod.getRandomCategoria());
        Categoria obj = dod.getNewTransientCategoria(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Categoria' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Categoria' identifier to be null", obj.getId());
        try {
            categoriaService.saveCategoria(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        categoriaRepository.flush();
        Assert.assertNotNull("Expected 'Categoria' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteCategoria() {
        Categoria obj = dod.getRandomCategoria();
        Assert.assertNotNull("Data on demand for 'Categoria' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Categoria' failed to provide an identifier", id);
        obj = categoriaService.findCategoria(id);
        categoriaService.deleteCategoria(obj);
        categoriaRepository.flush();
        Assert.assertNull("Failed to remove 'Categoria' with identifier '" + id + "'", categoriaService.findCategoria(id));
    }
}
