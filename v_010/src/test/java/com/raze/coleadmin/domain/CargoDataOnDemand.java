package com.raze.coleadmin.domain;
import com.raze.coleadmin.catalog.Concepto;
import com.raze.coleadmin.catalog.ConceptoDataOnDemand;
import com.raze.coleadmin.catalog.EstatusCargoDataOnDemand;
import com.raze.coleadmin.repository.CargoRepository;
import com.raze.coleadmin.service.CargoService;
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
@RooDataOnDemand(entity = Cargo.class)
public class CargoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Cargo> data;

	@Autowired
    AlumnoDataOnDemand alumnoDataOnDemand;

	@Autowired
    ConceptoDataOnDemand conceptoDataOnDemand;

	@Autowired
    EstatusCargoDataOnDemand estatusCargoDataOnDemand;

	@Autowired
    CargoService cargoService;

	@Autowired
    CargoRepository cargoRepository;

	public Cargo getNewTransientCargo(int index) {
        Cargo obj = new Cargo();
        setActivo(obj, index);
        setAlumno(obj, index);
        setCantidad(obj, index);
        setConcepto(obj, index);
        setDescuentoPesos(obj, index);
        setDescuentoPorcentaje(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setSubtotal(obj, index);
        setTotal(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Cargo obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setAlumno(Cargo obj, int index) {
        Alumno alumno = alumnoDataOnDemand.getRandomAlumno();
        obj.setAlumno(alumno);
    }

	public void setCantidad(Cargo obj, int index) {
        Double cantidad = new Integer(index).doubleValue();
        obj.setCantidad(cantidad);
    }

	public void setConcepto(Cargo obj, int index) {
        Concepto concepto = conceptoDataOnDemand.getRandomConcepto();
        obj.setConcepto(concepto);
    }

	public void setDescuentoPesos(Cargo obj, int index) {
        Double descuentoPesos = new Integer(index).doubleValue();
        obj.setDescuentoPesos(descuentoPesos);
    }

	public void setDescuentoPorcentaje(Cargo obj, int index) {
        Double descuentoPorcentaje = new Integer(index).doubleValue();
        obj.setDescuentoPorcentaje(descuentoPorcentaje);
    }

	public void setFechaCreacion(Cargo obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Cargo obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setSubtotal(Cargo obj, int index) {
        Double subtotal = new Integer(index).doubleValue();
        obj.setSubtotal(subtotal);
    }

	public void setTotal(Cargo obj, int index) {
        Double total = new Integer(index).doubleValue();
        obj.setTotal(total);
    }

	public void setUsuarioCrea(Cargo obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Cargo obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Cargo getSpecificCargo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Cargo obj = data.get(index);
        Long id = obj.getId();
        return cargoService.findCargo(id);
    }

	public Cargo getRandomCargo() {
        init();
        Cargo obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return cargoService.findCargo(id);
    }

	public boolean modifyCargo(Cargo obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = cargoService.findCargoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Cargo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Cargo>();
        for (int i = 0; i < 10; i++) {
            Cargo obj = getNewTransientCargo(i);
            try {
                cargoService.saveCargo(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            cargoRepository.flush();
            data.add(obj);
        }
    }
}
