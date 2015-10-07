package com.raze.coleadmin.domain;
import com.raze.coleadmin.catalog.MetodoPagoDataOnDemand;
import com.raze.coleadmin.repository.AbonoRepository;
import com.raze.coleadmin.service.AbonoService;
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

@Component
@Configurable
@RooDataOnDemand(entity = Abono.class)
public class AbonoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Abono> data;

	@Autowired
    AlumnoDataOnDemand alumnoDataOnDemand;

	@Autowired
    MetodoPagoDataOnDemand metodoPagoDataOnDemand;

	@Autowired
    AbonoService abonoService;

	@Autowired
    AbonoRepository abonoRepository;

	public Abono getNewTransientAbono(int index) {
        Abono obj = new Abono();
        setActivo(obj, index);
        setAlumno(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setTotal(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Abono obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setAlumno(Abono obj, int index) {
        Alumno alumno = alumnoDataOnDemand.getRandomAlumno();
        obj.setAlumno(alumno);
    }

	public void setFechaCreacion(Abono obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Abono obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setTotal(Abono obj, int index) {
        Double total = new Integer(index).doubleValue();
        obj.setTotal(total);
    }

	public void setUsuarioCrea(Abono obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Abono obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Abono getSpecificAbono(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Abono obj = data.get(index);
        Long id = obj.getId();
        return abonoService.findAbono(id);
    }

	public Abono getRandomAbono() {
        init();
        Abono obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return abonoService.findAbono(id);
    }

	public boolean modifyAbono(Abono obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = abonoService.findAbonoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Abono' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Abono>();
        for (int i = 0; i < 10; i++) {
            Abono obj = getNewTransientAbono(i);
            try {
                abonoService.saveAbono(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            abonoRepository.flush();
            data.add(obj);
        }
    }
}
