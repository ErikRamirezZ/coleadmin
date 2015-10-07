package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.CicloEscolarRepository;
import com.raze.coleadmin.service.CicloEscolarService;
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
@RooDataOnDemand(entity = CicloEscolar.class)
public class CicloEscolarDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<CicloEscolar> data;

	@Autowired
    EscuelaDataOnDemand escuelaDataOnDemand;

	@Autowired
    CicloEscolarService cicloEscolarService;

	@Autowired
    CicloEscolarRepository cicloEscolarRepository;

	public CicloEscolar getNewTransientCicloEscolar(int index) {
        CicloEscolar obj = new CicloEscolar();
        setActivo(obj, index);
        setEscuela(obj, index);
        setFechaCreacion(obj, index);
        setFechaFin(obj, index);
        setFechaInicio(obj, index);
        setFechaModificacion(obj, index);
        setNombreCiclo(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(CicloEscolar obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setEscuela(CicloEscolar obj, int index) {
        Escuela escuela = escuelaDataOnDemand.getRandomEscuela();
        obj.setEscuela(escuela);
    }

	public void setFechaCreacion(CicloEscolar obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaFin(CicloEscolar obj, int index) {
        Date fechaFin = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaFin(fechaFin);
    }

	public void setFechaInicio(CicloEscolar obj, int index) {
        Date fechaInicio = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaInicio(fechaInicio);
    }

	public void setFechaModificacion(CicloEscolar obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNombreCiclo(CicloEscolar obj, int index) {
        String nombreCiclo = "nombreCiclo_" + index;
        obj.setNombreCiclo(nombreCiclo);
    }

	public void setUsuarioCrea(CicloEscolar obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(CicloEscolar obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public CicloEscolar getSpecificCicloEscolar(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        CicloEscolar obj = data.get(index);
        Long id = obj.getId();
        return cicloEscolarService.findCicloEscolar(id);
    }

	public CicloEscolar getRandomCicloEscolar() {
        init();
        CicloEscolar obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return cicloEscolarService.findCicloEscolar(id);
    }

	public boolean modifyCicloEscolar(CicloEscolar obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = cicloEscolarService.findCicloEscolarEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'CicloEscolar' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<CicloEscolar>();
        for (int i = 0; i < 10; i++) {
            CicloEscolar obj = getNewTransientCicloEscolar(i);
            try {
                cicloEscolarService.saveCicloEscolar(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            cicloEscolarRepository.flush();
            data.add(obj);
        }
    }
}
