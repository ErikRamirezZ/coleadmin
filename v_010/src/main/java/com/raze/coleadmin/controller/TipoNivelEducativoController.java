package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.TipoNivelEducativo;
import com.raze.coleadmin.service.TipoNivelEducativoService;
import com.raze.coleadmin.service.UsuarioService;
import java.io.UnsupportedEncodingException;
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

@RooWebJson(jsonObject = TipoNivelEducativo.class)
@Controller
@RequestMapping("/tiponiveleducativoes")
@RooWebScaffold(path = "tiponiveleducativoes", formBackingObject = TipoNivelEducativo.class)
public class TipoNivelEducativoController {

	@Autowired
    TipoNivelEducativoService tipoNivelEducativoService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid TipoNivelEducativo tipoNivelEducativo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, tipoNivelEducativo);
            return "tiponiveleducativoes/create";
        }
        uiModel.asMap().clear();
        tipoNivelEducativoService.saveTipoNivelEducativo(tipoNivelEducativo);
        return "redirect:/tiponiveleducativoes/" + encodeUrlPathSegment(tipoNivelEducativo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new TipoNivelEducativo());
        return "tiponiveleducativoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("tiponiveleducativo", tipoNivelEducativoService.findTipoNivelEducativo(id));
        uiModel.addAttribute("itemId", id);
        return "tiponiveleducativoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("tiponiveleducativoes", tipoNivelEducativoService.findTipoNivelEducativoEntries(firstResult, sizeNo));
            float nrOfPages = (float) tipoNivelEducativoService.countAllTipoNivelEducativoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("tiponiveleducativoes", tipoNivelEducativoService.findAllTipoNivelEducativoes());
        }
        addDateTimeFormatPatterns(uiModel);
        return "tiponiveleducativoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid TipoNivelEducativo tipoNivelEducativo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, tipoNivelEducativo);
            return "tiponiveleducativoes/update";
        }
        uiModel.asMap().clear();
        tipoNivelEducativoService.updateTipoNivelEducativo(tipoNivelEducativo);
        return "redirect:/tiponiveleducativoes/" + encodeUrlPathSegment(tipoNivelEducativo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, tipoNivelEducativoService.findTipoNivelEducativo(id));
        return "tiponiveleducativoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        TipoNivelEducativo tipoNivelEducativo = tipoNivelEducativoService.findTipoNivelEducativo(id);
        tipoNivelEducativoService.deleteTipoNivelEducativo(tipoNivelEducativo);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/tiponiveleducativoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("tipoNivelEducativo_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("tipoNivelEducativo_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, TipoNivelEducativo tipoNivelEducativo) {
        uiModel.addAttribute("tipoNivelEducativo", tipoNivelEducativo);
        addDateTimeFormatPatterns(uiModel);
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
            TipoNivelEducativo tipoNivelEducativo = tipoNivelEducativoService.findTipoNivelEducativo(id);
            if (tipoNivelEducativo == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(tipoNivelEducativo.toJson(), headers, HttpStatus.OK);
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
            List<TipoNivelEducativo> result = tipoNivelEducativoService.findAllTipoNivelEducativoes();
            return new ResponseEntity<String>(TipoNivelEducativo.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            TipoNivelEducativo tipoNivelEducativo = TipoNivelEducativo.fromJsonToTipoNivelEducativo(json);
            tipoNivelEducativoService.saveTipoNivelEducativo(tipoNivelEducativo);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+tipoNivelEducativo.getId().toString()).build().toUriString());
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
            for (TipoNivelEducativo tipoNivelEducativo: TipoNivelEducativo.fromJsonArrayToTipoNivelEducativoes(json)) {
                tipoNivelEducativoService.saveTipoNivelEducativo(tipoNivelEducativo);
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
            TipoNivelEducativo tipoNivelEducativo = TipoNivelEducativo.fromJsonToTipoNivelEducativo(json);
            tipoNivelEducativo.setId(id);
            if (tipoNivelEducativoService.updateTipoNivelEducativo(tipoNivelEducativo) == null) {
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
            TipoNivelEducativo tipoNivelEducativo = tipoNivelEducativoService.findTipoNivelEducativo(id);
            if (tipoNivelEducativo == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            tipoNivelEducativoService.deleteTipoNivelEducativo(tipoNivelEducativo);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
