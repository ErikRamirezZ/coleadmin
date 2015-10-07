package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.DomicilioRepository;
import com.raze.coleadmin.service.DomicilioService;
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
@RooDataOnDemand(entity = Domicilio.class)
public class DomicilioDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Domicilio> data;

	@Autowired
    DomicilioService domicilioService;

	@Autowired
    DomicilioRepository domicilioRepository;

	public Domicilio getNewTransientDomicilio(int index) {
        Domicilio obj = new Domicilio();
        setActivo(obj, index);
        setCalle(obj, index);
        setColonia(obj, index);
        setCp(obj, index);
        setEstado(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setMunicipio(obj, index);
        setNumeroExt(obj, index);
        setNumeroInt(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Domicilio obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setCalle(Domicilio obj, int index) {
        String calle = "calle_" + index;
        obj.setCalle(calle);
    }

	public void setColonia(Domicilio obj, int index) {
        String colonia = "colonia_" + index;
        obj.setColonia(colonia);
    }

	public void setCp(Domicilio obj, int index) {
        String cp = "cp_" + index;
        obj.setCp(cp);
    }

	public void setEstado(Domicilio obj, int index) {
        String estado = "estado_" + index;
        obj.setEstado(estado);
    }

	public void setFechaCreacion(Domicilio obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Domicilio obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setMunicipio(Domicilio obj, int index) {
        String municipio = "municipio_" + index;
        obj.setMunicipio(municipio);
    }

	public void setNumeroExt(Domicilio obj, int index) {
        String numeroExt = "numeroExt_" + index;
        obj.setNumeroExt(numeroExt);
    }

	public void setNumeroInt(Domicilio obj, int index) {
        String numeroInt = "numeroInt_" + index;
        obj.setNumeroInt(numeroInt);
    }

	public void setUsuarioCrea(Domicilio obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Domicilio obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Domicilio getSpecificDomicilio(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Domicilio obj = data.get(index);
        Long id = obj.getId();
        return domicilioService.findDomicilio(id);
    }

	public Domicilio getRandomDomicilio() {
        init();
        Domicilio obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return domicilioService.findDomicilio(id);
    }

	public boolean modifyDomicilio(Domicilio obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = domicilioService.findDomicilioEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Domicilio' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Domicilio>();
        for (int i = 0; i < 10; i++) {
            Domicilio obj = getNewTransientDomicilio(i);
            try {
                domicilioService.saveDomicilio(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            domicilioRepository.flush();
            data.add(obj);
        }
    }
}
