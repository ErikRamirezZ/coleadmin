package com.raze.coleadmin.catalog;
import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.repository.CategoriaRepository;
import com.raze.coleadmin.service.CategoriaService;
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
@RooDataOnDemand(entity = Categoria.class)
public class CategoriaDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Categoria> data;

	@Autowired
    CategoriaService categoriaService;

	@Autowired
    CategoriaRepository categoriaRepository;

	public Categoria getNewTransientCategoria(int index) {
        Categoria obj = new Categoria();
        setActivo(obj, index);
        setDescripcion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setNombreCategoria(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Categoria obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescripcion(Categoria obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setFechaCreacion(Categoria obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Categoria obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNombreCategoria(Categoria obj, int index) {
        String nombreCategoria = "nombreCategoria_" + index;
        obj.setNombreCategoria(nombreCategoria);
    }

	public void setUsuarioCrea(Categoria obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Categoria obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Categoria getSpecificCategoria(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Categoria obj = data.get(index);
        Long id = obj.getId();
        return categoriaService.findCategoria(id);
    }

	public Categoria getRandomCategoria() {
        init();
        Categoria obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return categoriaService.findCategoria(id);
    }

	public boolean modifyCategoria(Categoria obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = categoriaService.findCategoriaEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Categoria' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Categoria>();
        for (int i = 0; i < 10; i++) {
            Categoria obj = getNewTransientCategoria(i);
            try {
                categoriaService.saveCategoria(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            categoriaRepository.flush();
            data.add(obj);
        }
    }
}
