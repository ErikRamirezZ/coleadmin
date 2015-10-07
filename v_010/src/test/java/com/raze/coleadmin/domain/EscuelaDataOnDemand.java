package com.raze.coleadmin.domain;
import com.raze.coleadmin.catalog.CorreoNotificacionesDataOnDemand;
import com.raze.coleadmin.repository.EscuelaRepository;
import com.raze.coleadmin.service.EscuelaService;
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
@RooDataOnDemand(entity = Escuela.class)
public class EscuelaDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Escuela> data;

	@Autowired
    CorreoNotificacionesDataOnDemand correoNotificacionesDataOnDemand;

	@Autowired
    DomicilioDataOnDemand domicilioDataOnDemand;

	@Autowired
    EscuelaService escuelaService;

	@Autowired
    EscuelaRepository escuelaRepository;

	public Escuela getNewTransientEscuela(int index) {
        Escuela obj = new Escuela();
        setActivo(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setLogo(obj, index);
        setNombre(obj, index);
        setRazonSocial(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        setWeb(obj, index);
        return obj;
    }

	public void setActivo(Escuela obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setFechaCreacion(Escuela obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Escuela obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setLogo(Escuela obj, int index) {
        byte[] logo = String.valueOf(index).getBytes();
        obj.setLogo(logo);
    }

	public void setNombre(Escuela obj, int index) {
        String nombre = "nombre_" + index;
        obj.setNombre(nombre);
    }

	public void setRazonSocial(Escuela obj, int index) {
        String razonSocial = "razonSocial_" + index;
        obj.setRazonSocial(razonSocial);
    }

	public void setUsuarioCrea(Escuela obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Escuela obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public void setWeb(Escuela obj, int index) {
        String web = "web_" + index;
        obj.setWeb(web);
    }

	public Escuela getSpecificEscuela(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Escuela obj = data.get(index);
        Long id = obj.getId();
        return escuelaService.findEscuela(id);
    }

	public Escuela getRandomEscuela() {
        init();
        Escuela obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return escuelaService.findEscuela(id);
    }

	public boolean modifyEscuela(Escuela obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = escuelaService.findEscuelaEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Escuela' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Escuela>();
        for (int i = 0; i < 10; i++) {
            Escuela obj = getNewTransientEscuela(i);
            try {
                escuelaService.saveEscuela(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            escuelaRepository.flush();
            data.add(obj);
        }
    }
}
