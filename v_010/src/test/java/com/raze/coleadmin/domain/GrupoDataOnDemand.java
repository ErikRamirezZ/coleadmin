package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.GrupoRepository;
import com.raze.coleadmin.service.GrupoService;
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
@RooDataOnDemand(entity = Grupo.class)
public class GrupoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Grupo> data;

	@Autowired
    CursoDataOnDemand cursoDataOnDemand;

	@Autowired
    SalonDataOnDemand salonDataOnDemand;

	@Autowired
    GrupoService grupoService;

	@Autowired
    GrupoRepository grupoRepository;

	public Grupo getNewTransientGrupo(int index) {
        Grupo obj = new Grupo();
        setActivo(obj, index);
        setCurso(obj, index);
        setDescripcion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setNombreGrupo(obj, index);
        setUsuarioCrea(obj, index);
        setUsuarioModifica(obj, index);
        return obj;
    }

	public void setActivo(Grupo obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setCurso(Grupo obj, int index) {
        Curso curso = cursoDataOnDemand.getRandomCurso();
        obj.setCurso(curso);
    }

	public void setDescripcion(Grupo obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setFechaCreacion(Grupo obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Grupo obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNombreGrupo(Grupo obj, int index) {
        String nombreGrupo = "nombreGrupo_" + index;
        obj.setNombreGrupo(nombreGrupo);
    }

	public void setUsuarioCrea(Grupo obj, int index) {
        Usuario usuarioCrea = null;
        obj.setUsuarioCrea(usuarioCrea);
    }

	public void setUsuarioModifica(Grupo obj, int index) {
        Usuario usuarioModifica = null;
        obj.setUsuarioModifica(usuarioModifica);
    }

	public Grupo getSpecificGrupo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Grupo obj = data.get(index);
        Long id = obj.getId();
        return grupoService.findGrupo(id);
    }

	public Grupo getRandomGrupo() {
        init();
        Grupo obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return grupoService.findGrupo(id);
    }

	public boolean modifyGrupo(Grupo obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = grupoService.findGrupoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Grupo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Grupo>();
        for (int i = 0; i < 10; i++) {
            Grupo obj = getNewTransientGrupo(i);
            try {
                grupoService.saveGrupo(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            grupoRepository.flush();
            data.add(obj);
        }
    }
}
