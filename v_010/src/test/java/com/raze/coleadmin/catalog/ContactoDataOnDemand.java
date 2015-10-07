package com.raze.coleadmin.catalog;
import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.repository.ContactoRepository;
import com.raze.coleadmin.service.ContactoService;
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
@RooDataOnDemand(entity = Contacto.class)
public class ContactoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Contacto> data;

	@Autowired
    ContactoService contactoService;

	@Autowired
    ContactoRepository contactoRepository;

	public Contacto getNewTransientContacto(int index) {
        Contacto obj = new Contacto();
        setActivo(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setTipoContacto(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        setValor(obj, index);
        return obj;
    }

	public void setActivo(Contacto obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setFechaCreacion(Contacto obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Contacto obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setTipoContacto(Contacto obj, int index) {
        String tipoContacto = "tipoContacto_" + index;
        obj.setTipoContacto(tipoContacto);
    }

	public void setUsuarioCrea(Contacto obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Contacto obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public void setValor(Contacto obj, int index) {
        String valor = "valor_" + index;
        obj.setValor(valor);
    }

	public Contacto getSpecificContacto(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Contacto obj = data.get(index);
        Long id = obj.getId();
        return contactoService.findContacto(id);
    }

	public Contacto getRandomContacto() {
        init();
        Contacto obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return contactoService.findContacto(id);
    }

	public boolean modifyContacto(Contacto obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = contactoService.findContactoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Contacto' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Contacto>();
        for (int i = 0; i < 10; i++) {
            Contacto obj = getNewTransientContacto(i);
            try {
                contactoService.saveContacto(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            contactoRepository.flush();
            data.add(obj);
        }
    }
}
