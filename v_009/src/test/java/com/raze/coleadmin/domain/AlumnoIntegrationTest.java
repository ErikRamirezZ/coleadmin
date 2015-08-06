package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.AlumnoRepository;
import com.raze.coleadmin.service.AlumnoService;
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
public class AlumnoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    AlumnoDataOnDemand dod;

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    AlumnoRepository alumnoRepository;

	@Test
    public void testCountAllAlumnoes() {
        Assert.assertNotNull("Data on demand for 'Alumno' failed to initialize correctly", dod.getRandomAlumno());
        long count = alumnoService.countAllAlumnoes();
        Assert.assertTrue("Counter for 'Alumno' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindAlumno() {
        Alumno obj = dod.getRandomAlumno();
        Assert.assertNotNull("Data on demand for 'Alumno' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Alumno' failed to provide an identifier", id);
        obj = alumnoService.findAlumno(id);
        Assert.assertNotNull("Find method for 'Alumno' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Alumno' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllAlumnoes() {
        Assert.assertNotNull("Data on demand for 'Alumno' failed to initialize correctly", dod.getRandomAlumno());
        long count = alumnoService.countAllAlumnoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Alumno', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Alumno> result = alumnoService.findAllAlumnoes();
        Assert.assertNotNull("Find all method for 'Alumno' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Alumno' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindAlumnoEntries() {
        Assert.assertNotNull("Data on demand for 'Alumno' failed to initialize correctly", dod.getRandomAlumno());
        long count = alumnoService.countAllAlumnoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Alumno> result = alumnoService.findAlumnoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Alumno' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Alumno' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Alumno obj = dod.getRandomAlumno();
        Assert.assertNotNull("Data on demand for 'Alumno' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Alumno' failed to provide an identifier", id);
        obj = alumnoService.findAlumno(id);
        Assert.assertNotNull("Find method for 'Alumno' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyAlumno(obj);
        Integer currentVersion = obj.getVersion();
        alumnoRepository.flush();
        Assert.assertTrue("Version for 'Alumno' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testUpdateAlumnoUpdate() {
        Alumno obj = dod.getRandomAlumno();
        Assert.assertNotNull("Data on demand for 'Alumno' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Alumno' failed to provide an identifier", id);
        obj = alumnoService.findAlumno(id);
        boolean modified =  dod.modifyAlumno(obj);
        Integer currentVersion = obj.getVersion();
        Alumno merged = (Alumno)alumnoService.updateAlumno(obj);
        alumnoRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Alumno' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testSaveAlumno() {
        Assert.assertNotNull("Data on demand for 'Alumno' failed to initialize correctly", dod.getRandomAlumno());
        Alumno obj = dod.getNewTransientAlumno(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Alumno' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Alumno' identifier to be null", obj.getId());
        try {
            alumnoService.saveAlumno(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        alumnoRepository.flush();
        Assert.assertNotNull("Expected 'Alumno' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testDeleteAlumno() {
        Alumno obj = dod.getRandomAlumno();
        Assert.assertNotNull("Data on demand for 'Alumno' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Alumno' failed to provide an identifier", id);
        obj = alumnoService.findAlumno(id);
        alumnoService.deleteAlumno(obj);
        alumnoRepository.flush();
        Assert.assertNull("Failed to remove 'Alumno' with identifier '" + id + "'", alumnoService.findAlumno(id));
    }
}
