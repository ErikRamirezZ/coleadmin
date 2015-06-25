package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Alumno;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.EscuelaService;
import com.raze.coleadmin.service.PlantelService;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.joda.time.format.DateTimeFormat;
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

@Controller
@RequestMapping("/alumnoes")
public class AlumnoController {

	@InitBinder
	protected void initBinder(HttpServletRequest request,
	        ServletRequestDataBinder binder) throws ServletException {
	    binder.registerCustomEditor(byte[].class,
	            new ByteArrayMultipartFileEditor());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            Alumno alumno = alumnoService.findAlumno(id);
            if (alumno == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(alumno.toJson(), headers, HttpStatus.OK);
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
            List<Alumno> result = alumnoService.findAllAlumnoes();
            return new ResponseEntity<String>(Alumno.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Alumno alumno = Alumno.fromJsonToAlumno(json);
            alumnoService.saveAlumno(alumno);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+alumno.getId().toString()).build().toUriString());
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
            for (Alumno alumno: Alumno.fromJsonArrayToAlumnoes(json)) {
                alumnoService.saveAlumno(alumno);
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
            Alumno alumno = Alumno.fromJsonToAlumno(json);
            alumno.setId(id);
            if (alumnoService.updateAlumno(alumno) == null) {
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
            Alumno alumno = alumnoService.findAlumno(id);
            if (alumno == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            alumnoService.deleteAlumno(alumno);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@Autowired
    EscuelaService escuelaService;

	@Autowired
    PlantelService plantelService;

	@Autowired
    AlumnoService alumnoService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Alumno alumno, BindingResult bindingResult, Model uiModel, 
    		@RequestParam("foto") MultipartFile multipartFile,
    		HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, alumno);
            return "alumnoes/create";
        }
        uiModel.asMap().clear();
        alumno.setContentType(multipartFile.getContentType());
        alumnoService.saveAlumno(alumno);
        return "redirect:/alumnoes/" + encodeUrlPathSegment(alumno.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Alumno());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (escuelaService.countAllEscuelas() == 0) {
            dependencies.add(new String[] { "escuela", "escuelas" });
        }
        if (plantelService.countAllPlantels() == 0) {
            dependencies.add(new String[] { "plantel", "plantels" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "alumnoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("alumno", alumnoService.findAlumno(id));
        uiModel.addAttribute("itemId", id);
        return "alumnoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("alumnoes", alumnoService.findAlumnoEntries(firstResult, sizeNo));
            float nrOfPages = (float) alumnoService.countAllAlumnoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("alumnoes", alumnoService.findAllAlumnoes());
        }
        addDateTimeFormatPatterns(uiModel);
        return "alumnoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Alumno alumno, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, alumno);
            return "alumnoes/update";
        }
        uiModel.asMap().clear();
        alumnoService.updateAlumno(alumno);
        return "redirect:/alumnoes/" + encodeUrlPathSegment(alumno.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, alumnoService.findAlumno(id));
        return "alumnoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Alumno alumno = alumnoService.findAlumno(id);
        alumnoService.deleteAlumno(alumno);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/alumnoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("alumno_fechanacimiento_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("alumno_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("alumno_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Alumno alumno) {
        uiModel.addAttribute("alumno", alumno);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("escuelas", escuelaService.findAllEscuelas());
        uiModel.addAttribute("plantels", plantelService.findAllPlantels());
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
	
	@RequestMapping(value = "/{id}/image", method = RequestMethod.GET)
    public String showImage(@PathVariable("id") Long id, HttpServletResponse response, Model model) {
        Alumno logItem = (Alumno) Alumno.findUsuario(id);
        if (logItem != null) {
            byte[] image = logItem.getFoto();
            if (image != null) {
                try {
                    response.setContentType(logItem.getContentType());
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
	
}
