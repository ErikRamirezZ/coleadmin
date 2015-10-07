package com.raze.coleadmin.controller;

import com.raze.coleadmin.catalog.Categoria;
import com.raze.coleadmin.catalog.Concepto;
import com.raze.coleadmin.catalog.Contacto;
import com.raze.coleadmin.catalog.CorreoNotificaciones;
import com.raze.coleadmin.catalog.EstatusCargo;
import com.raze.coleadmin.catalog.EstatusInscripcion;
import com.raze.coleadmin.catalog.MetodoPago;
import com.raze.coleadmin.catalog.NivelEducativo;
import com.raze.coleadmin.catalog.Permiso;
import com.raze.coleadmin.catalog.Rol;
import com.raze.coleadmin.catalog.TipoAsistencia;
import com.raze.coleadmin.catalog.TipoNivelEducativo;
import com.raze.coleadmin.domain.Abono;
import com.raze.coleadmin.domain.Alumno;
import com.raze.coleadmin.domain.Asistencia;
import com.raze.coleadmin.domain.Cargo;
import com.raze.coleadmin.domain.CicloEscolar;
import com.raze.coleadmin.domain.ConceptoInscripcionCurso;
import com.raze.coleadmin.domain.Curso;
import com.raze.coleadmin.domain.Domicilio;
import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.domain.Grupo;
import com.raze.coleadmin.domain.Inscrpcion;
import com.raze.coleadmin.domain.Padre;
import com.raze.coleadmin.domain.Personal;
import com.raze.coleadmin.domain.Salon;
import com.raze.coleadmin.service.AbonoService;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.AsistenciaService;
import com.raze.coleadmin.service.CargoService;
import com.raze.coleadmin.service.CategoriaService;
import com.raze.coleadmin.service.CicloEscolarService;
import com.raze.coleadmin.service.ConceptoInscripcionCursoService;
import com.raze.coleadmin.service.ConceptoService;
import com.raze.coleadmin.service.ContactoService;
import com.raze.coleadmin.service.CorreoNotificacionesService;
import com.raze.coleadmin.service.CursoService;
import com.raze.coleadmin.service.DomicilioService;
import com.raze.coleadmin.service.EscuelaService;
import com.raze.coleadmin.service.EstatusCargoService;
import com.raze.coleadmin.service.EstatusInscripcionService;
import com.raze.coleadmin.service.GrupoService;
import com.raze.coleadmin.service.InscrpcionService;
import com.raze.coleadmin.service.MetodoPagoService;
import com.raze.coleadmin.service.NivelEducativoService;
import com.raze.coleadmin.service.PadreService;
import com.raze.coleadmin.service.PermisoService;
import com.raze.coleadmin.service.PersonalService;
import com.raze.coleadmin.service.RolService;
import com.raze.coleadmin.service.SalonService;
import com.raze.coleadmin.service.TipoAsistenciaService;
import com.raze.coleadmin.service.TipoNivelEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

@Configurable
/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	@Autowired
    CategoriaService categoriaService;

	@Autowired
    ConceptoService conceptoService;

	@Autowired
    ContactoService contactoService;

	@Autowired
    CorreoNotificacionesService correoNotificacionesService;

	@Autowired
    EstatusCargoService estatusCargoService;

	@Autowired
    EstatusInscripcionService estatusInscripcionService;

	@Autowired
    MetodoPagoService metodoPagoService;

	@Autowired
    NivelEducativoService nivelEducativoService;

	@Autowired
    PermisoService permisoService;

	@Autowired
    RolService rolService;

	@Autowired
    TipoAsistenciaService tipoAsistenciaService;

	@Autowired
    TipoNivelEducativoService tipoNivelEducativoService;

	@Autowired
    AbonoService abonoService;

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    AsistenciaService asistenciaService;

	@Autowired
    CargoService cargoService;

	@Autowired
    CicloEscolarService cicloEscolarService;

	@Autowired
    ConceptoInscripcionCursoService conceptoInscripcionCursoService;

	@Autowired
    CursoService cursoService;

	@Autowired
    DomicilioService domicilioService;

	@Autowired
    EscuelaService escuelaService;

	@Autowired
    GrupoService grupoService;

	@Autowired
    InscrpcionService inscrpcionService;

	@Autowired
    PadreService padreService;

	@Autowired
    PersonalService personalService;

	@Autowired
    SalonService salonService;

	public Converter<Categoria, String> getCategoriaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.Categoria, java.lang.String>() {
            public String convert(Categoria categoria) {
                return new StringBuilder().append(categoria.getNombreCategoria()).append(' ').append(categoria.getDescripcion()).append(' ').append(categoria.getFechaCreacion()).append(' ').append(categoria.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Categoria> getIdToCategoriaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.Categoria>() {
            public com.raze.coleadmin.catalog.Categoria convert(java.lang.Long id) {
                return categoriaService.findCategoria(id);
            }
        };
    }

	public Converter<String, Categoria> getStringToCategoriaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.Categoria>() {
            public com.raze.coleadmin.catalog.Categoria convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Categoria.class);
            }
        };
    }

	public Converter<Concepto, String> getConceptoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.Concepto, java.lang.String>() {
            public String convert(Concepto concepto) {
                return new StringBuilder().append(concepto.getNombreConcepto()).append(' ').append(concepto.getMonto()).append(' ').append(concepto.getFechaCreacion()).append(' ').append(concepto.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Concepto> getIdToConceptoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.Concepto>() {
            public com.raze.coleadmin.catalog.Concepto convert(java.lang.Long id) {
                return conceptoService.findConcepto(id);
            }
        };
    }

	public Converter<String, Concepto> getStringToConceptoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.Concepto>() {
            public com.raze.coleadmin.catalog.Concepto convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Concepto.class);
            }
        };
    }

	public Converter<Contacto, String> getContactoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.Contacto, java.lang.String>() {
            public String convert(Contacto contacto) {
                return new StringBuilder().append(contacto.getTipoContacto()).append(' ').append(contacto.getValor()).append(' ').append(contacto.getFechaCreacion()).append(' ').append(contacto.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Contacto> getIdToContactoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.Contacto>() {
            public com.raze.coleadmin.catalog.Contacto convert(java.lang.Long id) {
                return contactoService.findContacto(id);
            }
        };
    }

	public Converter<String, Contacto> getStringToContactoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.Contacto>() {
            public com.raze.coleadmin.catalog.Contacto convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Contacto.class);
            }
        };
    }

	public Converter<CorreoNotificaciones, String> getCorreoNotificacionesToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.CorreoNotificaciones, java.lang.String>() {
            public String convert(CorreoNotificaciones correoNotificaciones) {
                return new StringBuilder().append(correoNotificaciones.getEmail()).append(' ').append(correoNotificaciones.getPassword()).append(' ').append(correoNotificaciones.getHost()).append(' ').append(correoNotificaciones.getPort()).toString();
            }
        };
    }

	public Converter<Long, CorreoNotificaciones> getIdToCorreoNotificacionesConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.CorreoNotificaciones>() {
            public com.raze.coleadmin.catalog.CorreoNotificaciones convert(java.lang.Long id) {
                return correoNotificacionesService.findCorreoNotificaciones(id);
            }
        };
    }

	public Converter<String, CorreoNotificaciones> getStringToCorreoNotificacionesConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.CorreoNotificaciones>() {
            public com.raze.coleadmin.catalog.CorreoNotificaciones convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), CorreoNotificaciones.class);
            }
        };
    }

	public Converter<EstatusCargo, String> getEstatusCargoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.EstatusCargo, java.lang.String>() {
            public String convert(EstatusCargo estatusCargo) {
                return new StringBuilder().append(estatusCargo.getNombreEstatusCargo()).append(' ').append(estatusCargo.getDescripcion()).append(' ').append(estatusCargo.getFechaCreacion()).append(' ').append(estatusCargo.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, EstatusCargo> getIdToEstatusCargoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.EstatusCargo>() {
            public com.raze.coleadmin.catalog.EstatusCargo convert(java.lang.Long id) {
                return estatusCargoService.findEstatusCargo(id);
            }
        };
    }

	public Converter<String, EstatusCargo> getStringToEstatusCargoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.EstatusCargo>() {
            public com.raze.coleadmin.catalog.EstatusCargo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), EstatusCargo.class);
            }
        };
    }

	public Converter<EstatusInscripcion, String> getEstatusInscripcionToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.EstatusInscripcion, java.lang.String>() {
            public String convert(EstatusInscripcion estatusInscripcion) {
                return new StringBuilder().append(estatusInscripcion.getNombreEstatusInscripcion()).append(' ').append(estatusInscripcion.getDescripcion()).append(' ').append(estatusInscripcion.getFechaCreacion()).append(' ').append(estatusInscripcion.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, EstatusInscripcion> getIdToEstatusInscripcionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.EstatusInscripcion>() {
            public com.raze.coleadmin.catalog.EstatusInscripcion convert(java.lang.Long id) {
                return estatusInscripcionService.findEstatusInscripcion(id);
            }
        };
    }

	public Converter<String, EstatusInscripcion> getStringToEstatusInscripcionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.EstatusInscripcion>() {
            public com.raze.coleadmin.catalog.EstatusInscripcion convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), EstatusInscripcion.class);
            }
        };
    }

	public Converter<MetodoPago, String> getMetodoPagoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.MetodoPago, java.lang.String>() {
            public String convert(MetodoPago metodoPago) {
                return new StringBuilder().append(metodoPago.getNombreMetodoPago()).append(' ').append(metodoPago.getDescripcion()).append(' ').append(metodoPago.getFechaCreacion()).append(' ').append(metodoPago.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, MetodoPago> getIdToMetodoPagoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.MetodoPago>() {
            public com.raze.coleadmin.catalog.MetodoPago convert(java.lang.Long id) {
                return metodoPagoService.findMetodoPago(id);
            }
        };
    }

	public Converter<String, MetodoPago> getStringToMetodoPagoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.MetodoPago>() {
            public com.raze.coleadmin.catalog.MetodoPago convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), MetodoPago.class);
            }
        };
    }

	public Converter<NivelEducativo, String> getNivelEducativoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.NivelEducativo, java.lang.String>() {
            public String convert(NivelEducativo nivelEducativo) {
                return new StringBuilder().append(nivelEducativo.getNombreNivelEducativo()).append(' ').append(nivelEducativo.getClave()).append(' ').append(nivelEducativo.getDescripcion()).append(' ').append(nivelEducativo.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, NivelEducativo> getIdToNivelEducativoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.NivelEducativo>() {
            public com.raze.coleadmin.catalog.NivelEducativo convert(java.lang.Long id) {
                return nivelEducativoService.findNivelEducativo(id);
            }
        };
    }

	public Converter<String, NivelEducativo> getStringToNivelEducativoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.NivelEducativo>() {
            public com.raze.coleadmin.catalog.NivelEducativo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), NivelEducativo.class);
            }
        };
    }

	public Converter<Permiso, String> getPermisoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.Permiso, java.lang.String>() {
            public String convert(Permiso permiso) {
                return new StringBuilder().append(permiso.getNombrePermiso()).append(' ').append(permiso.getDescripcion()).toString();
            }
        };
    }

	public Converter<Long, Permiso> getIdToPermisoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.Permiso>() {
            public com.raze.coleadmin.catalog.Permiso convert(java.lang.Long id) {
                return permisoService.findPermiso(id);
            }
        };
    }

	public Converter<String, Permiso> getStringToPermisoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.Permiso>() {
            public com.raze.coleadmin.catalog.Permiso convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Permiso.class);
            }
        };
    }

	public Converter<Rol, String> getRolToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.Rol, java.lang.String>() {
            public String convert(Rol rol) {
                return new StringBuilder().append(rol.getNombreRol()).append(' ').append(rol.getDescripcion()).toString();
            }
        };
    }

	public Converter<Long, Rol> getIdToRolConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.Rol>() {
            public com.raze.coleadmin.catalog.Rol convert(java.lang.Long id) {
                return rolService.findRol(id);
            }
        };
    }

	public Converter<String, Rol> getStringToRolConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.Rol>() {
            public com.raze.coleadmin.catalog.Rol convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Rol.class);
            }
        };
    }

	public Converter<TipoAsistencia, String> getTipoAsistenciaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.TipoAsistencia, java.lang.String>() {
            public String convert(TipoAsistencia tipoAsistencia) {
                return new StringBuilder().append(tipoAsistencia.getNombreTipoAsistencia()).append(' ').append(tipoAsistencia.getDescripcion()).append(' ').append(tipoAsistencia.getFechaCreacion()).append(' ').append(tipoAsistencia.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, TipoAsistencia> getIdToTipoAsistenciaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.TipoAsistencia>() {
            public com.raze.coleadmin.catalog.TipoAsistencia convert(java.lang.Long id) {
                return tipoAsistenciaService.findTipoAsistencia(id);
            }
        };
    }

	public Converter<String, TipoAsistencia> getStringToTipoAsistenciaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.TipoAsistencia>() {
            public com.raze.coleadmin.catalog.TipoAsistencia convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), TipoAsistencia.class);
            }
        };
    }

	public Converter<TipoNivelEducativo, String> getTipoNivelEducativoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.TipoNivelEducativo, java.lang.String>() {
            public String convert(TipoNivelEducativo tipoNivelEducativo) {
                return new StringBuilder().append(tipoNivelEducativo.getNombreTipoNivelEducativo()).append(' ').append(tipoNivelEducativo.getDescripcion()).append(' ').append(tipoNivelEducativo.getFechaCreacion()).append(' ').append(tipoNivelEducativo.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, TipoNivelEducativo> getIdToTipoNivelEducativoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.TipoNivelEducativo>() {
            public com.raze.coleadmin.catalog.TipoNivelEducativo convert(java.lang.Long id) {
                return tipoNivelEducativoService.findTipoNivelEducativo(id);
            }
        };
    }

	public Converter<String, TipoNivelEducativo> getStringToTipoNivelEducativoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.TipoNivelEducativo>() {
            public com.raze.coleadmin.catalog.TipoNivelEducativo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), TipoNivelEducativo.class);
            }
        };
    }

	public Converter<Abono, String> getAbonoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Abono, java.lang.String>() {
            public String convert(Abono abono) {
                return new StringBuilder().append(abono.getTotal()).append(' ').append(abono.getFechaCreacion()).append(' ').append(abono.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Abono> getIdToAbonoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Abono>() {
            public com.raze.coleadmin.domain.Abono convert(java.lang.Long id) {
                return abonoService.findAbono(id);
            }
        };
    }

	public Converter<String, Abono> getStringToAbonoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Abono>() {
            public com.raze.coleadmin.domain.Abono convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Abono.class);
            }
        };
    }

	public Converter<Alumno, String> getAlumnoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Alumno, java.lang.String>() {
            public String convert(Alumno alumno) {
                return new StringBuilder().append(alumno.getCorreoE()).append(' ').append(alumno.getPassword()).append(' ').append(alumno.getNombre()).append(' ').append(alumno.getPrimerApellido()).toString();
            }
        };
    }

	public Converter<Long, Alumno> getIdToAlumnoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Alumno>() {
            public com.raze.coleadmin.domain.Alumno convert(java.lang.Long id) {
                return alumnoService.findAlumno(id);
            }
        };
    }

	public Converter<String, Alumno> getStringToAlumnoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Alumno>() {
            public com.raze.coleadmin.domain.Alumno convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Alumno.class);
            }
        };
    }

	public Converter<Asistencia, String> getAsistenciaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Asistencia, java.lang.String>() {
            public String convert(Asistencia asistencia) {
                return new StringBuilder().append(asistencia.getFechaCreacion()).append(' ').append(asistencia.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Asistencia> getIdToAsistenciaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Asistencia>() {
            public com.raze.coleadmin.domain.Asistencia convert(java.lang.Long id) {
                return asistenciaService.findAsistencia(id);
            }
        };
    }

	public Converter<String, Asistencia> getStringToAsistenciaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Asistencia>() {
            public com.raze.coleadmin.domain.Asistencia convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Asistencia.class);
            }
        };
    }

	public Converter<Cargo, String> getCargoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Cargo, java.lang.String>() {
            public String convert(Cargo cargo) {
                return new StringBuilder().append(cargo.getCantidad()).append(' ').append(cargo.getSubtotal()).append(' ').append(cargo.getDescuentoPorcentaje()).append(' ').append(cargo.getDescuentoPesos()).toString();
            }
        };
    }

	public Converter<Long, Cargo> getIdToCargoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Cargo>() {
            public com.raze.coleadmin.domain.Cargo convert(java.lang.Long id) {
                return cargoService.findCargo(id);
            }
        };
    }

	public Converter<String, Cargo> getStringToCargoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Cargo>() {
            public com.raze.coleadmin.domain.Cargo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Cargo.class);
            }
        };
    }

	public Converter<CicloEscolar, String> getCicloEscolarToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.CicloEscolar, java.lang.String>() {
            public String convert(CicloEscolar cicloEscolar) {
                return new StringBuilder().append(cicloEscolar.getNombreCiclo()).append(' ').append(cicloEscolar.getFechaInicio()).append(' ').append(cicloEscolar.getFechaFin()).append(' ').append(cicloEscolar.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, CicloEscolar> getIdToCicloEscolarConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.CicloEscolar>() {
            public com.raze.coleadmin.domain.CicloEscolar convert(java.lang.Long id) {
                return cicloEscolarService.findCicloEscolar(id);
            }
        };
    }

	public Converter<String, CicloEscolar> getStringToCicloEscolarConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.CicloEscolar>() {
            public com.raze.coleadmin.domain.CicloEscolar convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), CicloEscolar.class);
            }
        };
    }

	public Converter<ConceptoInscripcionCurso, String> getConceptoInscripcionCursoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.ConceptoInscripcionCurso, java.lang.String>() {
            public String convert(ConceptoInscripcionCurso conceptoInscripcionCurso) {
                return new StringBuilder().append(conceptoInscripcionCurso.getConcepto()).append(' ').append(conceptoInscripcionCurso.getCantidad()).append(' ').append(conceptoInscripcionCurso.getFechaCreacion()).append(' ').append(conceptoInscripcionCurso.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, ConceptoInscripcionCurso> getIdToConceptoInscripcionCursoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.ConceptoInscripcionCurso>() {
            public com.raze.coleadmin.domain.ConceptoInscripcionCurso convert(java.lang.Long id) {
                return conceptoInscripcionCursoService.findConceptoInscripcionCurso(id);
            }
        };
    }

	public Converter<String, ConceptoInscripcionCurso> getStringToConceptoInscripcionCursoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.ConceptoInscripcionCurso>() {
            public com.raze.coleadmin.domain.ConceptoInscripcionCurso convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ConceptoInscripcionCurso.class);
            }
        };
    }

	public Converter<Curso, String> getCursoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Curso, java.lang.String>() {
            public String convert(Curso curso) {
                return new StringBuilder().append(curso.getNombreCurso()).append(' ').append(curso.getInscripcion()).append(' ').append(curso.getColegiatura()).append(' ').append(curso.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, Curso> getIdToCursoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Curso>() {
            public com.raze.coleadmin.domain.Curso convert(java.lang.Long id) {
                return cursoService.findCurso(id);
            }
        };
    }

	public Converter<String, Curso> getStringToCursoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Curso>() {
            public com.raze.coleadmin.domain.Curso convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Curso.class);
            }
        };
    }

	public Converter<Domicilio, String> getDomicilioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Domicilio, java.lang.String>() {
            public String convert(Domicilio domicilio) {
                return new StringBuilder().append(domicilio.getCalle()).append(' ').append(domicilio.getNumeroInt()).append(' ').append(domicilio.getNumeroExt()).append(' ').append(domicilio.getColonia()).toString();
            }
        };
    }

	public Converter<Long, Domicilio> getIdToDomicilioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Domicilio>() {
            public com.raze.coleadmin.domain.Domicilio convert(java.lang.Long id) {
                return domicilioService.findDomicilio(id);
            }
        };
    }

	public Converter<String, Domicilio> getStringToDomicilioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Domicilio>() {
            public com.raze.coleadmin.domain.Domicilio convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Domicilio.class);
            }
        };
    }

	public Converter<Escuela, String> getEscuelaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Escuela, java.lang.String>() {
            public String convert(Escuela escuela) {
                return new StringBuilder().append(escuela.getNombre()).append(' ').append(escuela.getWeb()).append(' ').append(escuela.getRazonSocial()).append(' ').append(escuela.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, Escuela> getIdToEscuelaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Escuela>() {
            public com.raze.coleadmin.domain.Escuela convert(java.lang.Long id) {
                return escuelaService.findEscuela(id);
            }
        };
    }

	public Converter<String, Escuela> getStringToEscuelaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Escuela>() {
            public com.raze.coleadmin.domain.Escuela convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Escuela.class);
            }
        };
    }

	public Converter<Grupo, String> getGrupoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Grupo, java.lang.String>() {
            public String convert(Grupo grupo) {
                return new StringBuilder().append(grupo.getNombreGrupo()).append(' ').append(grupo.getDescripcion()).append(' ').append(grupo.getFechaCreacion()).append(' ').append(grupo.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Grupo> getIdToGrupoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Grupo>() {
            public com.raze.coleadmin.domain.Grupo convert(java.lang.Long id) {
                return grupoService.findGrupo(id);
            }
        };
    }

	public Converter<String, Grupo> getStringToGrupoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Grupo>() {
            public com.raze.coleadmin.domain.Grupo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Grupo.class);
            }
        };
    }

	public Converter<Inscrpcion, String> getInscrpcionToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Inscrpcion, java.lang.String>() {
            public String convert(Inscrpcion inscrpcion) {
                return new StringBuilder().append(inscrpcion.getDescuentoInscripcion()).append(' ').append(inscrpcion.getDescuentoColegiatura()).append(' ').append(inscrpcion.getSaldoActual()).append(' ').append(inscrpcion.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, Inscrpcion> getIdToInscrpcionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Inscrpcion>() {
            public com.raze.coleadmin.domain.Inscrpcion convert(java.lang.Long id) {
                return inscrpcionService.findInscrpcion(id);
            }
        };
    }

	public Converter<String, Inscrpcion> getStringToInscrpcionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Inscrpcion>() {
            public com.raze.coleadmin.domain.Inscrpcion convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Inscrpcion.class);
            }
        };
    }

	public Converter<Padre, String> getPadreToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Padre, java.lang.String>() {
            public String convert(Padre padre) {
                return new StringBuilder().append(padre.getCorreoE()).append(' ').append(padre.getPassword()).append(' ').append(padre.getNombre()).append(' ').append(padre.getPrimerApellido()).toString();
            }
        };
    }

	public Converter<Long, Padre> getIdToPadreConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Padre>() {
            public com.raze.coleadmin.domain.Padre convert(java.lang.Long id) {
                return padreService.findPadre(id);
            }
        };
    }

	public Converter<String, Padre> getStringToPadreConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Padre>() {
            public com.raze.coleadmin.domain.Padre convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Padre.class);
            }
        };
    }

	public Converter<Personal, String> getPersonalToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Personal, java.lang.String>() {
            public String convert(Personal personal) {
                return new StringBuilder().append(personal.getCorreoE()).append(' ').append(personal.getPassword()).append(' ').append(personal.getNombre()).append(' ').append(personal.getPrimerApellido()).toString();
            }
        };
    }

	public Converter<Long, Personal> getIdToPersonalConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Personal>() {
            public com.raze.coleadmin.domain.Personal convert(java.lang.Long id) {
                return personalService.findPersonal(id);
            }
        };
    }

	public Converter<String, Personal> getStringToPersonalConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Personal>() {
            public com.raze.coleadmin.domain.Personal convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Personal.class);
            }
        };
    }

	public Converter<Salon, String> getSalonToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Salon, java.lang.String>() {
            public String convert(Salon salon) {
                return new StringBuilder().append(salon.getNombreSalon()).append(' ').append(salon.getDescripcion()).append(' ').append(salon.getFechaCreacion()).append(' ').append(salon.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Salon> getIdToSalonConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Salon>() {
            public com.raze.coleadmin.domain.Salon convert(java.lang.Long id) {
                return salonService.findSalon(id);
            }
        };
    }

	public Converter<String, Salon> getStringToSalonConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Salon>() {
            public com.raze.coleadmin.domain.Salon convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Salon.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getCategoriaToStringConverter());
        registry.addConverter(getIdToCategoriaConverter());
        registry.addConverter(getStringToCategoriaConverter());
        registry.addConverter(getConceptoToStringConverter());
        registry.addConverter(getIdToConceptoConverter());
        registry.addConverter(getStringToConceptoConverter());
        registry.addConverter(getContactoToStringConverter());
        registry.addConverter(getIdToContactoConverter());
        registry.addConverter(getStringToContactoConverter());
        registry.addConverter(getCorreoNotificacionesToStringConverter());
        registry.addConverter(getIdToCorreoNotificacionesConverter());
        registry.addConverter(getStringToCorreoNotificacionesConverter());
        registry.addConverter(getEstatusCargoToStringConverter());
        registry.addConverter(getIdToEstatusCargoConverter());
        registry.addConverter(getStringToEstatusCargoConverter());
        registry.addConverter(getEstatusInscripcionToStringConverter());
        registry.addConverter(getIdToEstatusInscripcionConverter());
        registry.addConverter(getStringToEstatusInscripcionConverter());
        registry.addConverter(getMetodoPagoToStringConverter());
        registry.addConverter(getIdToMetodoPagoConverter());
        registry.addConverter(getStringToMetodoPagoConverter());
        registry.addConverter(getNivelEducativoToStringConverter());
        registry.addConverter(getIdToNivelEducativoConverter());
        registry.addConverter(getStringToNivelEducativoConverter());
        registry.addConverter(getPermisoToStringConverter());
        registry.addConverter(getIdToPermisoConverter());
        registry.addConverter(getStringToPermisoConverter());
        registry.addConverter(getRolToStringConverter());
        registry.addConverter(getIdToRolConverter());
        registry.addConverter(getStringToRolConverter());
        registry.addConverter(getTipoAsistenciaToStringConverter());
        registry.addConverter(getIdToTipoAsistenciaConverter());
        registry.addConverter(getStringToTipoAsistenciaConverter());
        registry.addConverter(getTipoNivelEducativoToStringConverter());
        registry.addConverter(getIdToTipoNivelEducativoConverter());
        registry.addConverter(getStringToTipoNivelEducativoConverter());
        registry.addConverter(getAbonoToStringConverter());
        registry.addConverter(getIdToAbonoConverter());
        registry.addConverter(getStringToAbonoConverter());
        registry.addConverter(getAlumnoToStringConverter());
        registry.addConverter(getIdToAlumnoConverter());
        registry.addConverter(getStringToAlumnoConverter());
        registry.addConverter(getAsistenciaToStringConverter());
        registry.addConverter(getIdToAsistenciaConverter());
        registry.addConverter(getStringToAsistenciaConverter());
        registry.addConverter(getCargoToStringConverter());
        registry.addConverter(getIdToCargoConverter());
        registry.addConverter(getStringToCargoConverter());
        registry.addConverter(getCicloEscolarToStringConverter());
        registry.addConverter(getIdToCicloEscolarConverter());
        registry.addConverter(getStringToCicloEscolarConverter());
        registry.addConverter(getConceptoInscripcionCursoToStringConverter());
        registry.addConverter(getIdToConceptoInscripcionCursoConverter());
        registry.addConverter(getStringToConceptoInscripcionCursoConverter());
        registry.addConverter(getCursoToStringConverter());
        registry.addConverter(getIdToCursoConverter());
        registry.addConverter(getStringToCursoConverter());
        registry.addConverter(getDomicilioToStringConverter());
        registry.addConverter(getIdToDomicilioConverter());
        registry.addConverter(getStringToDomicilioConverter());
        registry.addConverter(getEscuelaToStringConverter());
        registry.addConverter(getIdToEscuelaConverter());
        registry.addConverter(getStringToEscuelaConverter());
        registry.addConverter(getGrupoToStringConverter());
        registry.addConverter(getIdToGrupoConverter());
        registry.addConverter(getStringToGrupoConverter());
        registry.addConverter(getInscrpcionToStringConverter());
        registry.addConverter(getIdToInscrpcionConverter());
        registry.addConverter(getStringToInscrpcionConverter());
        registry.addConverter(getPadreToStringConverter());
        registry.addConverter(getIdToPadreConverter());
        registry.addConverter(getStringToPadreConverter());
        registry.addConverter(getPersonalToStringConverter());
        registry.addConverter(getIdToPersonalConverter());
        registry.addConverter(getStringToPersonalConverter());
        registry.addConverter(getSalonToStringConverter());
        registry.addConverter(getIdToSalonConverter());
        registry.addConverter(getStringToSalonConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
