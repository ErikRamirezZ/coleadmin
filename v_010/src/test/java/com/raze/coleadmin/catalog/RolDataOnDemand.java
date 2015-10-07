package com.raze.coleadmin.catalog;
import com.raze.coleadmin.repository.RolRepository;
import com.raze.coleadmin.service.RolService;
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
@RooDataOnDemand(entity = Rol.class)
public class RolDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Rol> data;

	@Autowired
    RolService rolService;

	@Autowired
    RolRepository rolRepository;

	public Rol getNewTransientRol(int index) {
        Rol obj = new Rol();
        setActivo(obj, index);
        setDescripcion(obj, index);
        setNombreRol(obj, index);
        return obj;
    }

	public void setActivo(Rol obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescripcion(Rol obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setNombreRol(Rol obj, int index) {
        String nombreRol = "nombreRol_" + index;
        obj.setNombreRol(nombreRol);
    }

	public Rol getSpecificRol(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Rol obj = data.get(index);
        Long id = obj.getId();
        return rolService.findRol(id);
    }

	public Rol getRandomRol() {
        init();
        Rol obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return rolService.findRol(id);
    }

	public boolean modifyRol(Rol obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = rolService.findRolEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Rol' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Rol>();
        for (int i = 0; i < 10; i++) {
            Rol obj = getNewTransientRol(i);
            try {
                rolService.saveRol(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            rolRepository.flush();
            data.add(obj);
        }
    }
}
