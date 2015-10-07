package com.raze.coleadmin.domain;
import com.raze.coleadmin.catalog.TipoAsistencia;
import com.raze.coleadmin.catalog.TipoAsistenciaDataOnDemand;
import com.raze.coleadmin.repository.AsistenciaRepository;
import com.raze.coleadmin.service.AsistenciaService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.dod.RooDataOnDemand;
import org.springframework.stereotype.Component;

@Configurable
@Component
@RooDataOnDemand(entity = Asistencia.class)
public class AsistenciaDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Asistencia> data;

	@Autowired
    AlumnoDataOnDemand alumnoDataOnDemand;

	@Autowired
    TipoAsistenciaDataOnDemand tipoAsistenciaDataOnDemand;

	@Autowired
    AsistenciaService asistenciaService;

	@Autowired
    AsistenciaRepository asistenciaRepository;

	public Asistencia getNewTransientAsistencia(int index) {
        Asistencia obj = new Asistencia();
        setActivo(obj, index);
        setAlumno(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setTipoAsistencia(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Asistencia obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setAlumno(Asistencia obj, int index) {
        Alumno alumno = alumnoDataOnDemand.getRandomAlumno();
        obj.setAlumno(alumno);
    }

	public void setFechaCreacion(Asistencia obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Asistencia obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setTipoAsistencia(Asistencia obj, int index) {
        TipoAsistencia tipoAsistencia = tipoAsistenciaDataOnDemand.getRandomTipoAsistencia();
        obj.setTipoAsistencia(tipoAsistencia);
    }

	public void setUsuarioCrea(Asistencia obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Asistencia obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Asistencia getSpecificAsistencia(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Asistencia obj = data.get(index);
        Long id = obj.getId();
        return asistenciaService.findAsistencia(id);
    }

	public Asistencia getRandomAsistencia() {
        init();
        Asistencia obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return asistenciaService.findAsistencia(id);
    }

	public boolean modifyAsistencia(Asistencia obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = asistenciaService.findAsistenciaEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Asistencia' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Asistencia>();
        for (int i = 0; i < 10; i++) {
            Asistencia obj = getNewTransientAsistencia(i);
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
            data.add(obj);
        }
    }
}
