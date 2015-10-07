package com.raze.coleadmin.catalog;
import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.repository.TipoAsistenciaRepository;
import com.raze.coleadmin.service.TipoAsistenciaService;
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
@RooDataOnDemand(entity = TipoAsistencia.class)
public class TipoAsistenciaDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<TipoAsistencia> data;

	@Autowired
    TipoAsistenciaService tipoAsistenciaService;

	@Autowired
    TipoAsistenciaRepository tipoAsistenciaRepository;

	public TipoAsistencia getNewTransientTipoAsistencia(int index) {
        TipoAsistencia obj = new TipoAsistencia();
        setActivo(obj, index);
        setDescripcion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setNombreTipoAsistencia(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(TipoAsistencia obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescripcion(TipoAsistencia obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setFechaCreacion(TipoAsistencia obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(TipoAsistencia obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNombreTipoAsistencia(TipoAsistencia obj, int index) {
        String nombreTipoAsistencia = "nombreTipoAsistencia_" + index;
        obj.setNombreTipoAsistencia(nombreTipoAsistencia);
    }

	public void setUsuarioCrea(TipoAsistencia obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(TipoAsistencia obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public TipoAsistencia getSpecificTipoAsistencia(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        TipoAsistencia obj = data.get(index);
        Long id = obj.getId();
        return tipoAsistenciaService.findTipoAsistencia(id);
    }

	public TipoAsistencia getRandomTipoAsistencia() {
        init();
        TipoAsistencia obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return tipoAsistenciaService.findTipoAsistencia(id);
    }

	public boolean modifyTipoAsistencia(TipoAsistencia obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = tipoAsistenciaService.findTipoAsistenciaEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'TipoAsistencia' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<TipoAsistencia>();
        for (int i = 0; i < 10; i++) {
            TipoAsistencia obj = getNewTransientTipoAsistencia(i);
            try {
                tipoAsistenciaService.saveTipoAsistencia(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            tipoAsistenciaRepository.flush();
            data.add(obj);
        }
    }
}
