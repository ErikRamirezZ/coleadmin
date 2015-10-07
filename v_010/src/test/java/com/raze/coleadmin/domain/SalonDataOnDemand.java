package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.SalonRepository;
import com.raze.coleadmin.service.SalonService;
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
@RooDataOnDemand(entity = Salon.class)
public class SalonDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Salon> data;

	@Autowired
    EscuelaDataOnDemand escuelaDataOnDemand;

	@Autowired
    SalonService salonService;

	@Autowired
    SalonRepository salonRepository;

	public Salon getNewTransientSalon(int index) {
        Salon obj = new Salon();
        setActivo(obj, index);
        setDescripcion(obj, index);
        setEscuela(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setNombreSalon(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Salon obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescripcion(Salon obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setEscuela(Salon obj, int index) {
        Escuela escuela = escuelaDataOnDemand.getRandomEscuela();
        obj.setEscuela(escuela);
    }

	public void setFechaCreacion(Salon obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Salon obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNombreSalon(Salon obj, int index) {
        String nombreSalon = "nombreSalon_" + index;
        obj.setNombreSalon(nombreSalon);
    }

	public void setUsuarioCrea(Salon obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Salon obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Salon getSpecificSalon(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Salon obj = data.get(index);
        Long id = obj.getId();
        return salonService.findSalon(id);
    }

	public Salon getRandomSalon() {
        init();
        Salon obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return salonService.findSalon(id);
    }

	public boolean modifySalon(Salon obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = salonService.findSalonEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Salon' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Salon>();
        for (int i = 0; i < 10; i++) {
            Salon obj = getNewTransientSalon(i);
            try {
                salonService.saveSalon(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            salonRepository.flush();
            data.add(obj);
        }
    }
}
