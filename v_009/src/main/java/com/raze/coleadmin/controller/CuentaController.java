package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Cuenta;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.CicloEscolarService;
import com.raze.coleadmin.service.CuentaService;
import com.raze.coleadmin.service.CursoService;
import com.raze.coleadmin.service.EscuelaService;
import com.raze.coleadmin.service.EstatusCuentaService;
import com.raze.coleadmin.service.PadreService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Cuenta.class)
@Controller
@RequestMapping("/cuentas")
@RooWebScaffold(path = "cuentas", formBackingObject = Cuenta.class)
public class CuentaController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            Cuenta cuenta = cuentaService.findCuenta(id);
            if (cuenta == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(cuenta.toJson(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            List<Cuenta> result = cuentaService.findAllCuentas();
            return new ResponseEntity<String>(Cuenta.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Cuenta cuenta = Cuenta.fromJsonToCuenta(json);
            cuentaService.saveCuenta(cuenta);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+cuenta.getId().toString()).build().toUriString());
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            for (Cuenta cuenta: Cuenta.fromJsonArrayToCuentas(json)) {
                cuentaService.saveCuenta(cuenta);
            }
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Cuenta cuenta = Cuenta.fromJsonToCuenta(json);
            cuenta.setId(id);
            if (cuentaService.updateCuenta(cuenta) == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Cuenta cuenta = cuentaService.findCuenta(id);
            if (cuenta == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            cuentaService.deleteCuenta(cuenta);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@Autowired
    EstatusCuentaService estatusCuentaService;

	@Autowired
    CuentaService cuentaService;

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    CicloEscolarService cicloEscolarService;

	@Autowired
    CursoService cursoService;

	@Autowired
    EscuelaService escuelaService;

	@Autowired
    PadreService padreService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Cuenta cuenta, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, cuenta);
            return "cuentas/create";
        }
        uiModel.asMap().clear();
        cuentaService.saveCuenta(cuenta);
        return "redirect:/cuentas/" + encodeUrlPathSegment(cuenta.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Cuenta());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (estatusCuentaService.countAllEstatusCuentas() == 0) {
            dependencies.add(new String[] { "escuela", "estatuscuentas" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "cuentas/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("cuenta", cuentaService.findCuenta(id));
        uiModel.addAttribute("itemId", id);
        return "cuentas/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cuentas", cuentaService.findCuentaEntries(firstResult, sizeNo));
            float nrOfPages = (float) cuentaService.countAllCuentas() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cuentas", cuentaService.findAllCuentas());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cuentas/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Cuenta cuenta, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, cuenta);
            return "cuentas/update";
        }
        uiModel.asMap().clear();
        cuentaService.updateCuenta(cuenta);
        return "redirect:/cuentas/" + encodeUrlPathSegment(cuenta.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, cuentaService.findCuenta(id));
        return "cuentas/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Cuenta cuenta = cuentaService.findCuenta(id);
        cuentaService.deleteCuenta(cuenta);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/cuentas";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("cuenta_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("cuenta_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Cuenta cuenta) {
        uiModel.addAttribute("cuenta", cuenta);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("estatuscuentas", estatusCuentaService.findAllEstatusCuentas());
        uiModel.addAttribute("alumnoes", alumnoService.findAllAlumnoes());
        uiModel.addAttribute("cicloescolars", cicloEscolarService.findAllCicloEscolars());
        uiModel.addAttribute("cursoes", cursoService.findAllCursoes());
        uiModel.addAttribute("escuelas", escuelaService.findAllEscuelas());
        uiModel.addAttribute("padres", padreService.findAllPadres());
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
