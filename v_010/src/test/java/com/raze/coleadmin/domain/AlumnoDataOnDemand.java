package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.AlumnoRepository;
import com.raze.coleadmin.service.AlumnoService;
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
@RooDataOnDemand(entity = Alumno.class)
public class AlumnoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Alumno> data;

	@Autowired
    DomicilioDataOnDemand domicilioDataOnDemand;

	@Autowired
    EscuelaDataOnDemand escuelaDataOnDemand;

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    AlumnoRepository alumnoRepository;

	public Alumno getNewTransientAlumno(int index) {
        Alumno obj = new Alumno();
        setActivo(obj, index);
        setAlergias(obj, index);
        setCorreoE(obj, index);
        setCurp(obj, index);
        setEscuela(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setFechaNacimiento(obj, index);
        setFolio(obj, index);
        setFoto(obj, index);
        setNombre(obj, index);
        setObservaciones(obj, index);
        setPassword(obj, index);
        setPeso(obj, index);
        setPrimerApellido(obj, index);
        setSegundoApellido(obj, index);
        setTalla(obj, index);
        setTipoSangre(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Alumno obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setAlergias(Alumno obj, int index) {
        String alergias = "alergias_" + index;
        obj.setAlergias(alergias);
    }

	public void setCorreoE(Alumno obj, int index) {
        String correoE = "correoE_" + index;
        obj.setCorreoE(correoE);
    }

	public void setCurp(Alumno obj, int index) {
        String curp = "curp_" + index;
        obj.setCurp(curp);
    }

	public void setEscuela(Alumno obj, int index) {
        Escuela escuela = escuelaDataOnDemand.getRandomEscuela();
        obj.setEscuela(escuela);
    }

	public void setFechaCreacion(Alumno obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Alumno obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setFechaNacimiento(Alumno obj, int index) {
        Date fechaNacimiento = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaNacimiento(fechaNacimiento);
    }

	public void setFolio(Alumno obj, int index) {
        String folio = "folio_" + index;
        obj.setFolio(folio);
    }

	public void setFoto(Alumno obj, int index) {
        byte[] foto = String.valueOf(index).getBytes();
        obj.setFoto(foto);
    }

	public void setNombre(Alumno obj, int index) {
        String nombre = "nombre_" + index;
        if (nombre.length() > 30) {
            nombre = nombre.substring(0, 30);
        }
        obj.setNombre(nombre);
    }

	public void setObservaciones(Alumno obj, int index) {
        String observaciones = "observaciones_" + index;
        if (observaciones.length() > 250) {
            observaciones = observaciones.substring(0, 250);
        }
        obj.setObservaciones(observaciones);
    }

	public void setPassword(Alumno obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }

	public void setPeso(Alumno obj, int index) {
        String peso = "peso_" + index;
        obj.setPeso(peso);
    }

	public void setPrimerApellido(Alumno obj, int index) {
        String primerApellido = "primerApellido_" + index;
        if (primerApellido.length() > 30) {
            primerApellido = primerApellido.substring(0, 30);
        }
        obj.setPrimerApellido(primerApellido);
    }

	public void setSegundoApellido(Alumno obj, int index) {
        String segundoApellido = "segundoApellido_" + index;
        if (segundoApellido.length() > 30) {
            segundoApellido = segundoApellido.substring(0, 30);
        }
        obj.setSegundoApellido(segundoApellido);
    }

	public void setTalla(Alumno obj, int index) {
        String talla = "talla_" + index;
        obj.setTalla(talla);
    }

	public void setTipoSangre(Alumno obj, int index) {
        String tipoSangre = "tipoSangre_" + index;
        obj.setTipoSangre(tipoSangre);
    }

	public void setUsuarioCrea(Alumno obj, int index) {
        Long usuarioCrea = new Integer(index).longValue();
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Alumno obj, int index) {
        Long usuarioModifica = new Integer(index).longValue();
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Alumno getSpecificAlumno(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Alumno obj = data.get(index);
        Long id = obj.getId();
        return alumnoService.findAlumno(id);
    }

	public Alumno getRandomAlumno() {
        init();
        Alumno obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return alumnoService.findAlumno(id);
    }

	public boolean modifyAlumno(Alumno obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = alumnoService.findAlumnoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Alumno' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Alumno>();
        for (int i = 0; i < 10; i++) {
            Alumno obj = getNewTransientAlumno(i);
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
            data.add(obj);
        }
    }
}
