package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.PersonalRepository;
import com.raze.coleadmin.service.PersonalService;
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
@RooDataOnDemand(entity = Personal.class)
public class PersonalDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Personal> data;

	@Autowired
    DomicilioDataOnDemand domicilioDataOnDemand;

	@Autowired
    EscuelaDataOnDemand escuelaDataOnDemand;

	@Autowired
    PersonalService personalService;

	@Autowired
    PersonalRepository personalRepository;

	public Personal getNewTransientPersonal(int index) {
        Personal obj = new Personal();
        setActivo(obj, index);
        setCorreoE(obj, index);
        setEscuela(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setFechaNacimiento(obj, index);
        setFoto(obj, index);
        setNombre(obj, index);
        setObservaciones(obj, index);
        setPassword(obj, index);
        setPrimerApellido(obj, index);
        setSegundoApellido(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Personal obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setCorreoE(Personal obj, int index) {
        String correoE = "correoE_" + index;
        obj.setCorreoE(correoE);
    }

	public void setEscuela(Personal obj, int index) {
        Escuela escuela = escuelaDataOnDemand.getRandomEscuela();
        obj.setEscuela(escuela);
    }

	public void setFechaCreacion(Personal obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Personal obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setFechaNacimiento(Personal obj, int index) {
        Date fechaNacimiento = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaNacimiento(fechaNacimiento);
    }

	public void setFoto(Personal obj, int index) {
        byte[] foto = String.valueOf(index).getBytes();
        obj.setFoto(foto);
    }

	public void setNombre(Personal obj, int index) {
        String nombre = "nombre_" + index;
        if (nombre.length() > 30) {
            nombre = nombre.substring(0, 30);
        }
        obj.setNombre(nombre);
    }

	public void setObservaciones(Personal obj, int index) {
        String observaciones = "observaciones_" + index;
        if (observaciones.length() > 250) {
            observaciones = observaciones.substring(0, 250);
        }
        obj.setObservaciones(observaciones);
    }

	public void setPassword(Personal obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }

	public void setPrimerApellido(Personal obj, int index) {
        String primerApellido = "primerApellido_" + index;
        if (primerApellido.length() > 30) {
            primerApellido = primerApellido.substring(0, 30);
        }
        obj.setPrimerApellido(primerApellido);
    }

	public void setSegundoApellido(Personal obj, int index) {
        String segundoApellido = "segundoApellido_" + index;
        if (segundoApellido.length() > 30) {
            segundoApellido = segundoApellido.substring(0, 30);
        }
        obj.setSegundoApellido(segundoApellido);
    }

	public void setUsuarioCrea(Personal obj, int index) {
        Long usuarioCrea = new Integer(index).longValue();
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Personal obj, int index) {
        Long usuarioModifica = new Integer(index).longValue();
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Personal getSpecificPersonal(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Personal obj = data.get(index);
        Long id = obj.getId();
        return personalService.findPersonal(id);
    }

	public Personal getRandomPersonal() {
        init();
        Personal obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return personalService.findPersonal(id);
    }

	public boolean modifyPersonal(Personal obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = personalService.findPersonalEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Personal' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Personal>();
        for (int i = 0; i < 10; i++) {
            Personal obj = getNewTransientPersonal(i);
            try {
                personalService.savePersonal(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            personalRepository.flush();
            data.add(obj);
        }
    }
}
