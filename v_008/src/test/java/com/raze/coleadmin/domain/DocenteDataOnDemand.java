package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.DocenteRepository;
import com.raze.coleadmin.service.DocenteService;
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
import org.springframework.stereotype.Component;

@Configurable
@Component
public class DocenteDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Docente> data;

	@Autowired
    DocenteService docenteService;

	@Autowired
    DocenteRepository docenteRepository;

	public Docente getNewTransientDocente(int index) {
        Docente obj = new Docente();
        setActivo(obj, index);
        setCiudad(obj, index);
        setContentType(obj, index);
        setCorreoE(obj, index);
        setDomicilio(obj, index);
        setEscuela(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setFechaNacimiento(obj, index);
        setFoto(obj, index);
        setIdUsuario(obj, index);
        setNombre(obj, index);
        setPlantel(obj, index);
        setPrimerApellido(obj, index);
        setSegundoApellido(obj, index);
        setTelefono(obj, index);
        return obj;
    }

	public void setActivo(Docente obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setCiudad(Docente obj, int index) {
        String ciudad = "ciudad_" + index;
        obj.setCiudad(ciudad);
    }

	public void setContentType(Docente obj, int index) {
        String contentType = "contentType_" + index;
        obj.setContentType(contentType);
    }

	public void setCorreoE(Docente obj, int index) {
        String correoE = "correoE_" + index;
        obj.setCorreoE(correoE);
    }

	public void setDomicilio(Docente obj, int index) {
        String domicilio = "domicilio_" + index;
        if (domicilio.length() > 250) {
            domicilio = domicilio.substring(0, 250);
        }
        obj.setDomicilio(domicilio);
    }

	public void setEscuela(Docente obj, int index) {
        Escuela escuela = null;
        obj.setEscuela(escuela);
    }

	public void setFechaCreacion(Docente obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Docente obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setFechaNacimiento(Docente obj, int index) {
        Date fechaNacimiento = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaNacimiento(fechaNacimiento);
    }

	public void setFoto(Docente obj, int index) {
        byte[] foto = String.valueOf(index).getBytes();
        obj.setFoto(foto);
    }

	public void setIdUsuario(Docente obj, int index) {
        Long idUsuario = new Integer(index).longValue();
        obj.setIdUsuario(idUsuario);
    }

	public void setNombre(Docente obj, int index) {
        String nombre = "nombre_" + index;
        if (nombre.length() > 30) {
            nombre = nombre.substring(0, 30);
        }
        obj.setNombre(nombre);
    }

	public void setPlantel(Docente obj, int index) {
        Plantel plantel = null;
        obj.setPlantel(plantel);
    }

	public void setPrimerApellido(Docente obj, int index) {
        String primerApellido = "primerApellido_" + index;
        if (primerApellido.length() > 30) {
            primerApellido = primerApellido.substring(0, 30);
        }
        obj.setPrimerApellido(primerApellido);
    }

	public void setSegundoApellido(Docente obj, int index) {
        String segundoApellido = "segundoApellido_" + index;
        if (segundoApellido.length() > 30) {
            segundoApellido = segundoApellido.substring(0, 30);
        }
        obj.setSegundoApellido(segundoApellido);
    }

	public void setTelefono(Docente obj, int index) {
        String telefono = "telefono_" + index;
        obj.setTelefono(telefono);
    }

	public Docente getSpecificDocente(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Docente obj = data.get(index);
        Long id = obj.getId();
        return docenteService.findDocente(id);
    }

	public Docente getRandomDocente() {
        init();
        Docente obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return docenteService.findDocente(id);
    }

	public boolean modifyDocente(Docente obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = docenteService.findDocenteEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Docente' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Docente>();
        for (int i = 0; i < 10; i++) {
            Docente obj = getNewTransientDocente(i);
            try {
                docenteService.saveDocente(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            docenteRepository.flush();
            data.add(obj);
        }
    }
}
