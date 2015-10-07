package com.raze.coleadmin.catalog;
import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.repository.TipoNivelEducativoRepository;
import com.raze.coleadmin.service.TipoNivelEducativoService;
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
@RooDataOnDemand(entity = TipoNivelEducativo.class)
public class TipoNivelEducativoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<TipoNivelEducativo> data;

	@Autowired
    TipoNivelEducativoService tipoNivelEducativoService;

	@Autowired
    TipoNivelEducativoRepository tipoNivelEducativoRepository;

	public TipoNivelEducativo getNewTransientTipoNivelEducativo(int index) {
        TipoNivelEducativo obj = new TipoNivelEducativo();
        setActivo(obj, index);
        setDescripcion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setNombreTipoNivelEducativo(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(TipoNivelEducativo obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescripcion(TipoNivelEducativo obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setFechaCreacion(TipoNivelEducativo obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(TipoNivelEducativo obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNombreTipoNivelEducativo(TipoNivelEducativo obj, int index) {
        String nombreTipoNivelEducativo = "nombreTipoNivelEducativo_" + index;
        obj.setNombreTipoNivelEducativo(nombreTipoNivelEducativo);
    }

	public void setUsuarioCrea(TipoNivelEducativo obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(TipoNivelEducativo obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public TipoNivelEducativo getSpecificTipoNivelEducativo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        TipoNivelEducativo obj = data.get(index);
        Long id = obj.getId();
        return tipoNivelEducativoService.findTipoNivelEducativo(id);
    }

	public TipoNivelEducativo getRandomTipoNivelEducativo() {
        init();
        TipoNivelEducativo obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return tipoNivelEducativoService.findTipoNivelEducativo(id);
    }

	public boolean modifyTipoNivelEducativo(TipoNivelEducativo obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = tipoNivelEducativoService.findTipoNivelEducativoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'TipoNivelEducativo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<TipoNivelEducativo>();
        for (int i = 0; i < 10; i++) {
            TipoNivelEducativo obj = getNewTransientTipoNivelEducativo(i);
            try {
                tipoNivelEducativoService.saveTipoNivelEducativo(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            tipoNivelEducativoRepository.flush();
            data.add(obj);
        }
    }
}
