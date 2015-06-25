package com.raze.coleadmin.domain;
import com.raze.coleadmin.repository.LoginRepository;
import com.raze.coleadmin.service.LoginService;
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
import org.springframework.stereotype.Component;

@Configurable
@Component
public class LoginDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Login> data;

	@Autowired
    LoginService loginService;

	@Autowired
    LoginRepository loginRepository;

	public Login getNewTransientLogin(int index) {
        Login obj = new Login();
        setActivo(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setIdUsuario(obj, index);
        setPassword(obj, index);
        setUsuario(obj, index);
        return obj;
    }

	public void setActivo(Login obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setFechaCreacion(Login obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Login obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setIdUsuario(Login obj, int index) {
        Long idUsuario = new Integer(index).longValue();
        obj.setIdUsuario(idUsuario);
    }

	public void setPassword(Login obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }

	public void setUsuario(Login obj, int index) {
        Usuario usuario = null;
        obj.setUsuario(usuario);
    }

	public Login getSpecificLogin(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Login obj = data.get(index);
        Long id = obj.getId();
        return loginService.findLogin(id);
    }

	public Login getRandomLogin() {
        init();
        Login obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return loginService.findLogin(id);
    }

	public boolean modifyLogin(Login obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = loginService.findLoginEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Login' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Login>();
        for (int i = 0; i < 10; i++) {
            Login obj = getNewTransientLogin(i);
            try {
                loginService.saveLogin(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            loginRepository.flush();
            data.add(obj);
        }
    }
}
