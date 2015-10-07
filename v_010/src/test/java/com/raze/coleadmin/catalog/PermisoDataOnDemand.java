package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.PermisoRepository;
import com.raze.coleadmin.service.PermisoService;
import java.security.SecureRandom;
import java.util.ArrayList;
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
@RooDataOnDemand(entity = Permiso.class)
public class PermisoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Permiso> data;

	@Autowired
    PermisoService permisoService;

	@Autowired
    PermisoRepository permisoRepository;

	public Permiso getNewTransientPermiso(int index) {
        Permiso obj = new Permiso();
        setActivo(obj, index);
        setDescripcion(obj, index);
        setNombrePermiso(obj, index);
        return obj;
    }

	public void setActivo(Permiso obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescripcion(Permiso obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setNombrePermiso(Permiso obj, int index) {
        String nombrePermiso = "nombrePermiso_" + index;
        obj.setNombrePermiso(nombrePermiso);
    }

	public Permiso getSpecificPermiso(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Permiso obj = data.get(index);
        Long id = obj.getId();
        return permisoService.findPermiso(id);
    }

	public Permiso getRandomPermiso() {
        init();
        Permiso obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return permisoService.findPermiso(id);
    }

	public boolean modifyPermiso(Permiso obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = permisoService.findPermisoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Permiso' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Permiso>();
        for (int i = 0; i < 10; i++) {
            Permiso obj = getNewTransientPermiso(i);
            try {
                permisoService.savePermiso(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            permisoRepository.flush();
            data.add(obj);
        }
    }
}
