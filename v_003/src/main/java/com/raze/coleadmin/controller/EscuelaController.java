package com.raze.coleadmin.controller;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.raze.coleadmin.catalog.TipoEscuela;
import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.service.domain.EscuelaService;
import com.raze.coleadmin.service.domain.UsuarioService;

@Controller
@RequestMapping("/escuelas")
public class EscuelaController {

	@Autowired
    EscuelaService escuelaService;

	@Autowired
    UsuarioService usuarioService;

	static Logger log = LoggerFactory.getLogger(EscuelaController.class);
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
	        ServletRequestDataBinder binder) throws ServletException {
	    binder.registerCustomEditor(byte[].class,
	            new ByteArrayMultipartFileEditor());
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid Escuela escuela, BindingResult bindingResult, Model uiModel, 
	        @RequestParam("logo") MultipartFile logo,
	        HttpServletRequest httpServletRequest) {
		log.info("Ya estoy en el controller");
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, escuela);
            return "escuelas/create";
        }
        escuela.setContentType(logo.getContentType());
        uiModel.asMap().clear();
        escuelaService.saveEscuela(escuela);
        return "redirect:/escuelas/" + encodeUrlPathSegment(escuela.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}/image", method = RequestMethod.GET)
    public String showImage(@PathVariable("id") Long id, HttpServletResponse response, Model model) {
        Escuela escuela = escuelaService.findEscuela(id);
        if (escuela != null) {
            byte[] image = escuela.getLogo();
            if (image != null) {
                try {
                    response.setContentType(escuela.getContentType());
                    OutputStream out = response.getOutputStream();
                    IOUtils.copy(new ByteArrayInputStream(image), out);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
	
	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Escuela());
        return "escuelas/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("escuela", escuelaService.findEscuela(id));
        uiModel.addAttribute("itemId", id);
        return "escuelas/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("escuelas", escuelaService.findEscuelaEntries(firstResult, sizeNo));
            float nrOfPages = (float) escuelaService.countAllEscuelas() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("escuelas", escuelaService.findAllEscuelas());
        }
        addDateTimeFormatPatterns(uiModel);
        return "escuelas/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Escuela escuela, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, escuela);
            return "escuelas/update";
        }
        uiModel.asMap().clear();
        escuelaService.updateEscuela(escuela);
        return "redirect:/escuelas/" + encodeUrlPathSegment(escuela.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, escuelaService.findEscuela(id));
        return "escuelas/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Escuela escuela = escuelaService.findEscuela(id);
        escuelaService.deleteEscuela(escuela);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/escuelas";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("escuela_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("escuela_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Escuela escuela) {
        uiModel.addAttribute("escuela", escuela);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("tipoescuelas", Arrays.asList(TipoEscuela.values()));
        uiModel.addAttribute("usuarios", usuarioService.findAllUsuarios());
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            Escuela escuela = escuelaService.findEscuela(id);
            if (escuela == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(escuela.toJson(), headers, HttpStatus.OK);
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
            List<Escuela> result = escuelaService.findAllEscuelas();
            return new ResponseEntity<String>(Escuela.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Escuela escuela = Escuela.fromJsonToEscuela(json);
            escuelaService.saveEscuela(escuela);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+escuela.getId().toString()).build().toUriString());
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
            for (Escuela escuela: Escuela.fromJsonArrayToEscuelas(json)) {
                escuelaService.saveEscuela(escuela);
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
            Escuela escuela = Escuela.fromJsonToEscuela(json);
            escuela.setId(id);
            if (escuelaService.updateEscuela(escuela) == null) {
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
            Escuela escuela = escuelaService.findEscuela(id);
            if (escuela == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            escuelaService.deleteEscuela(escuela);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
