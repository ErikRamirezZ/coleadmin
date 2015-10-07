package com.raze.coleadmin.catalog;
import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.domain.EscuelaDataOnDemand;
import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.repository.CorreoNotificacionesRepository;
import com.raze.coleadmin.service.CorreoNotificacionesService;
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
@RooDataOnDemand(entity = CorreoNotificaciones.class)
public class CorreoNotificacionesDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<CorreoNotificaciones> data;

	@Autowired
    EscuelaDataOnDemand escuelaDataOnDemand;

	@Autowired
    CorreoNotificacionesService correoNotificacionesService;

	@Autowired
    CorreoNotificacionesRepository correoNotificacionesRepository;

	public CorreoNotificaciones getNewTransientCorreoNotificaciones(int index) {
        CorreoNotificaciones obj = new CorreoNotificaciones();
        setActivo(obj, index);
        setEmail(obj, index);
        setEscuela(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setHost(obj, index);
        setPassword(obj, index);
        setPort(obj, index);
        setProtocol(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(CorreoNotificaciones obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setEmail(CorreoNotificaciones obj, int index) {
        String email = "foo" + index + "@bar.com";
        obj.setEmail(email);
    }

	public void setEscuela(CorreoNotificaciones obj, int index) {
        Escuela escuela = escuelaDataOnDemand.getRandomEscuela();
        obj.setEscuela(escuela);
    }

	public void setFechaCreacion(CorreoNotificaciones obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(CorreoNotificaciones obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setHost(CorreoNotificaciones obj, int index) {
        String host = "host_" + index;
        obj.setHost(host);
    }

	public void setPassword(CorreoNotificaciones obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }

	public void setPort(CorreoNotificaciones obj, int index) {
        String port = "port_" + index;
        obj.setPort(port);
    }

	public void setProtocol(CorreoNotificaciones obj, int index) {
        String protocol = "protocol_" + index;
        obj.setProtocol(protocol);
    }

	public void setUsuarioCrea(CorreoNotificaciones obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(CorreoNotificaciones obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public CorreoNotificaciones getSpecificCorreoNotificaciones(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        CorreoNotificaciones obj = data.get(index);
        Long id = obj.getId();
        return correoNotificacionesService.findCorreoNotificaciones(id);
    }

	public CorreoNotificaciones getRandomCorreoNotificaciones() {
        init();
        CorreoNotificaciones obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return correoNotificacionesService.findCorreoNotificaciones(id);
    }

	public boolean modifyCorreoNotificaciones(CorreoNotificaciones obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = correoNotificacionesService.findCorreoNotificacionesEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'CorreoNotificaciones' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<CorreoNotificaciones>();
        for (int i = 0; i < 10; i++) {
            CorreoNotificaciones obj = getNewTransientCorreoNotificaciones(i);
            try {
                correoNotificacionesService.saveCorreoNotificaciones(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            correoNotificacionesRepository.flush();
            data.add(obj);
        }
    }
}
