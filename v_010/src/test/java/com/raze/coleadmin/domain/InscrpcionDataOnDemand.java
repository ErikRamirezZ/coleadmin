package com.raze.coleadmin.domain;
import com.raze.coleadmin.catalog.EstatusInscripcionDataOnDemand;
import com.raze.coleadmin.repository.InscrpcionRepository;
import com.raze.coleadmin.service.InscrpcionService;
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
@RooDataOnDemand(entity = Inscrpcion.class)
public class InscrpcionDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Inscrpcion> data;

	@Autowired
    AlumnoDataOnDemand alumnoDataOnDemand;

	@Autowired
    CicloEscolarDataOnDemand cicloEscolarDataOnDemand;

	@Autowired
    CursoDataOnDemand cursoDataOnDemand;

	@Autowired
    EscuelaDataOnDemand escuelaDataOnDemand;

	@Autowired
    EstatusInscripcionDataOnDemand estatusInscripcionDataOnDemand;

	@Autowired
    GrupoDataOnDemand grupoDataOnDemand;

	@Autowired
    PadreDataOnDemand padreDataOnDemand;

	@Autowired
    InscrpcionService inscrpcionService;

	@Autowired
    InscrpcionRepository inscrpcionRepository;

	public Inscrpcion getNewTransientInscrpcion(int index) {
        Inscrpcion obj = new Inscrpcion();
        setActivo(obj, index);
        setDescuentoColegiatura(obj, index);
        setDescuentoInscripcion(obj, index);
        setEnviarRecordatorios(obj, index);
        setEscuela(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setSaldoActual(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Inscrpcion obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescuentoColegiatura(Inscrpcion obj, int index) {
        Double descuentoColegiatura = new Integer(index).doubleValue();
        obj.setDescuentoColegiatura(descuentoColegiatura);
    }

	public void setDescuentoInscripcion(Inscrpcion obj, int index) {
        Double descuentoInscripcion = new Integer(index).doubleValue();
        obj.setDescuentoInscripcion(descuentoInscripcion);
    }

	public void setEnviarRecordatorios(Inscrpcion obj, int index) {
        Boolean enviarRecordatorios = Boolean.TRUE;
        obj.setEnviarRecordatorios(enviarRecordatorios);
    }

	public void setEscuela(Inscrpcion obj, int index) {
        Escuela escuela = escuelaDataOnDemand.getRandomEscuela();
        obj.setEscuela(escuela);
    }

	public void setFechaCreacion(Inscrpcion obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Inscrpcion obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setSaldoActual(Inscrpcion obj, int index) {
        Double saldoActual = new Integer(index).doubleValue();
        obj.setSaldoActual(saldoActual);
    }

	public void setUsuarioCrea(Inscrpcion obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Inscrpcion obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Inscrpcion getSpecificInscrpcion(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Inscrpcion obj = data.get(index);
        Long id = obj.getId();
        return inscrpcionService.findInscrpcion(id);
    }

	public Inscrpcion getRandomInscrpcion() {
        init();
        Inscrpcion obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return inscrpcionService.findInscrpcion(id);
    }

	public boolean modifyInscrpcion(Inscrpcion obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = inscrpcionService.findInscrpcionEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Inscrpcion' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Inscrpcion>();
        for (int i = 0; i < 10; i++) {
            Inscrpcion obj = getNewTransientInscrpcion(i);
            try {
                inscrpcionService.saveInscrpcion(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            inscrpcionRepository.flush();
            data.add(obj);
        }
    }
}
