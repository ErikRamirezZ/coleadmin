package com.raze.coleadmin.catalog;
import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.domain.EscuelaDataOnDemand;
import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.repository.ConceptoRepository;
import com.raze.coleadmin.service.ConceptoService;
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
@RooDataOnDemand(entity = Concepto.class)
public class ConceptoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Concepto> data;

	@Autowired
    CategoriaDataOnDemand categoriaDataOnDemand;

	@Autowired
    EscuelaDataOnDemand escuelaDataOnDemand;

	@Autowired
    ConceptoService conceptoService;

	@Autowired
    ConceptoRepository conceptoRepository;

	public Concepto getNewTransientConcepto(int index) {
        Concepto obj = new Concepto();
        setActivo(obj, index);
        setEscuela(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setMonto(obj, index);
        setNombreConcepto(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Concepto obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setEscuela(Concepto obj, int index) {
        Escuela escuela = escuelaDataOnDemand.getRandomEscuela();
        obj.setEscuela(escuela);
    }

	public void setFechaCreacion(Concepto obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Concepto obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setMonto(Concepto obj, int index) {
        Double monto = new Integer(index).doubleValue();
        obj.setMonto(monto);
    }

	public void setNombreConcepto(Concepto obj, int index) {
        String nombreConcepto = "nombreConcepto_" + index;
        obj.setNombreConcepto(nombreConcepto);
    }

	public void setUsuarioCrea(Concepto obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Concepto obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Concepto getSpecificConcepto(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Concepto obj = data.get(index);
        Long id = obj.getId();
        return conceptoService.findConcepto(id);
    }

	public Concepto getRandomConcepto() {
        init();
        Concepto obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return conceptoService.findConcepto(id);
    }

	public boolean modifyConcepto(Concepto obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = conceptoService.findConceptoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Concepto' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Concepto>();
        for (int i = 0; i < 10; i++) {
            Concepto obj = getNewTransientConcepto(i);
            try {
                conceptoService.saveConcepto(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            conceptoRepository.flush();
            data.add(obj);
        }
    }
}
