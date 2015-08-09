package com.raze.coleadmin.controller;

import com.raze.coleadmin.catalog.Concepto;
import com.raze.coleadmin.catalog.Correo;
import com.raze.coleadmin.catalog.EstatusCuenta;
import com.raze.coleadmin.catalog.MetodoPago;
import com.raze.coleadmin.catalog.Modulo;
import com.raze.coleadmin.catalog.NivelEducativo;
import com.raze.coleadmin.catalog.Permiso;
import com.raze.coleadmin.catalog.Rol;
import com.raze.coleadmin.catalog.TipoAsistencia;
import com.raze.coleadmin.catalog.TipoConcepto;
import com.raze.coleadmin.domain.Alumno;
import com.raze.coleadmin.domain.AlumnoGrupo;
import com.raze.coleadmin.domain.Asistencia;
import com.raze.coleadmin.domain.CicloEscolar;
import com.raze.coleadmin.domain.ConfiguracionCurso;
import com.raze.coleadmin.domain.ConfiguracionPagoEscuela;
import com.raze.coleadmin.domain.Cuenta;
import com.raze.coleadmin.domain.Curso;
import com.raze.coleadmin.domain.Docente;
import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.domain.Grupo;
import com.raze.coleadmin.domain.Padre;
import com.raze.coleadmin.domain.Pago;
import com.raze.coleadmin.domain.PagoEscuela;
import com.raze.coleadmin.domain.Personal;
import com.raze.coleadmin.domain.Plantel;
import com.raze.coleadmin.service.AlumnoGrupoService;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.AsistenciaService;
import com.raze.coleadmin.service.CicloEscolarService;
import com.raze.coleadmin.service.ConceptoService;
import com.raze.coleadmin.service.ConfiguracionCursoService;
import com.raze.coleadmin.service.ConfiguracionPagoEscuelaService;
import com.raze.coleadmin.service.CorreoService;
import com.raze.coleadmin.service.CuentaService;
import com.raze.coleadmin.service.CursoService;
import com.raze.coleadmin.service.DocenteService;
import com.raze.coleadmin.service.EscuelaService;
import com.raze.coleadmin.service.EstatusCuentaService;
import com.raze.coleadmin.service.GrupoService;
import com.raze.coleadmin.service.MetodoPagoService;
import com.raze.coleadmin.service.ModuloService;
import com.raze.coleadmin.service.NivelEducativoService;
import com.raze.coleadmin.service.PadreService;
import com.raze.coleadmin.service.PagoEscuelaService;
import com.raze.coleadmin.service.PagoService;
import com.raze.coleadmin.service.PermisoService;
import com.raze.coleadmin.service.PersonalService;
import com.raze.coleadmin.service.PlantelService;
import com.raze.coleadmin.service.RolService;
import com.raze.coleadmin.service.TipoAsistenciaService;
import com.raze.coleadmin.service.TipoConceptoService;
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
    ConceptoService conceptoService;

	@Autowired
    CorreoService correoService;

	@Autowired
    EstatusCuentaService estatusCuentaService;

	@Autowired
    MetodoPagoService metodoPagoService;

	@Autowired
    ModuloService moduloService;

	@Autowired
    NivelEducativoService nivelEducativoService;

	@Autowired
    PermisoService permisoService;

	@Autowired
    RolService rolService;

	@Autowired
    TipoAsistenciaService tipoAsistenciaService;

	@Autowired
    TipoConceptoService tipoConceptoService;

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    AlumnoGrupoService alumnoGrupoService;

	@Autowired
    AsistenciaService asistenciaService;

	@Autowired
    CicloEscolarService cicloEscolarService;

	@Autowired
    ConfiguracionCursoService configuracionCursoService;

	@Autowired
    ConfiguracionPagoEscuelaService configuracionPagoEscuelaService;

	@Autowired
    CuentaService cuentaService;

	@Autowired
    CursoService cursoService;

	@Autowired
    DocenteService docenteService;

	@Autowired
    EscuelaService escuelaService;

	@Autowired
    GrupoService grupoService;

	@Autowired
    PadreService padreService;

	@Autowired
    PagoService pagoService;

	@Autowired
    PagoEscuelaService pagoEscuelaService;

	@Autowired
    PersonalService personalService;

	@Autowired
    PlantelService plantelService;

	public Converter<Concepto, String> getConceptoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.Concepto, java.lang.String>() {
            public String convert(Concepto concepto) {
                return new StringBuilder().append(concepto.getNombreConcepto()).append(' ').append(concepto.getMonto()).append(' ').append(concepto.getDescripcion()).append(' ').append(concepto.getUsuarioCrea()).toString();
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

	public Converter<Correo, String> getCorreoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.Correo, java.lang.String>() {
            public String convert(Correo correo) {
                return new StringBuilder().append(correo.getEmail()).append(' ').append(correo.getHost()).append(' ').append(correo.getPassword()).append(' ').append(correo.getPort()).toString();
            }
        };
    }

	public Converter<Long, Correo> getIdToCorreoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.Correo>() {
            public com.raze.coleadmin.catalog.Correo convert(java.lang.Long id) {
                return correoService.findCorreo(id);
            }
        };
    }

	public Converter<String, Correo> getStringToCorreoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.Correo>() {
            public com.raze.coleadmin.catalog.Correo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Correo.class);
            }
        };
    }

	public Converter<EstatusCuenta, String> getEstatusCuentaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.EstatusCuenta, java.lang.String>() {
            public String convert(EstatusCuenta estatusCuenta) {
                return new StringBuilder().append(estatusCuenta.getNombreEstatusCuenta()).append(' ').append(estatusCuenta.getDescripcion()).append(' ').append(estatusCuenta.getUsuarioCrea()).append(' ').append(estatusCuenta.getUsuarioModifica()).toString();
            }
        };
    }

	public Converter<Long, EstatusCuenta> getIdToEstatusCuentaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.EstatusCuenta>() {
            public com.raze.coleadmin.catalog.EstatusCuenta convert(java.lang.Long id) {
                return estatusCuentaService.findEstatusCuenta(id);
            }
        };
    }

	public Converter<String, EstatusCuenta> getStringToEstatusCuentaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.EstatusCuenta>() {
            public com.raze.coleadmin.catalog.EstatusCuenta convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), EstatusCuenta.class);
            }
        };
    }

	public Converter<MetodoPago, String> getMetodoPagoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.MetodoPago, java.lang.String>() {
            public String convert(MetodoPago metodoPago) {
                return new StringBuilder().append(metodoPago.getNombreMetodoPago()).append(' ').append(metodoPago.getDescripcion()).append(' ').append(metodoPago.getUsuarioCrea()).append(' ').append(metodoPago.getUsuarioModifica()).toString();
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

	public Converter<Modulo, String> getModuloToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.Modulo, java.lang.String>() {
            public String convert(Modulo modulo) {
                return new StringBuilder().append(modulo.getNombreModulo()).append(' ').append(modulo.getDescripcion()).append(' ').append(modulo.getUsuarioCrea()).append(' ').append(modulo.getUsuarioModifica()).toString();
            }
        };
    }

	public Converter<Long, Modulo> getIdToModuloConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.Modulo>() {
            public com.raze.coleadmin.catalog.Modulo convert(java.lang.Long id) {
                return moduloService.findModulo(id);
            }
        };
    }

	public Converter<String, Modulo> getStringToModuloConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.Modulo>() {
            public com.raze.coleadmin.catalog.Modulo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Modulo.class);
            }
        };
    }

	public Converter<NivelEducativo, String> getNivelEducativoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.NivelEducativo, java.lang.String>() {
            public String convert(NivelEducativo nivelEducativo) {
                return new StringBuilder().append(nivelEducativo.getNombreNivelEducativo()).append(' ').append(nivelEducativo.getDescripcion()).append(' ').append(nivelEducativo.getUsuarioCrea()).append(' ').append(nivelEducativo.getUsuarioModifica()).toString();
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
                return new StringBuilder().append(permiso.getNombrePermiso()).append(' ').append(permiso.getDescripcion()).append(' ').append(permiso.getUsuarioCrea()).append(' ').append(permiso.getUsuarioModifica()).toString();
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
                return new StringBuilder().append(rol.getNombreRol()).append(' ').append(rol.getDescripcion()).append(' ').append(rol.getUsuarioCrea()).append(' ').append(rol.getUsuarioModifica()).toString();
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
                return new StringBuilder().append(tipoAsistencia.getNombreTipoAsistencia()).append(' ').append(tipoAsistencia.getDescripcion()).append(' ').append(tipoAsistencia.getUsuarioCrea()).append(' ').append(tipoAsistencia.getUsuarioModifica()).toString();
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

	public Converter<TipoConcepto, String> getTipoConceptoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.catalog.TipoConcepto, java.lang.String>() {
            public String convert(TipoConcepto tipoConcepto) {
                return new StringBuilder().append(tipoConcepto.getNombreTipoConcepto()).append(' ').append(tipoConcepto.getDescripcion()).append(' ').append(tipoConcepto.getUsuarioCrea()).append(' ').append(tipoConcepto.getUsuarioModifica()).toString();
            }
        };
    }

	public Converter<Long, TipoConcepto> getIdToTipoConceptoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.catalog.TipoConcepto>() {
            public com.raze.coleadmin.catalog.TipoConcepto convert(java.lang.Long id) {
                return tipoConceptoService.findTipoConcepto(id);
            }
        };
    }

	public Converter<String, TipoConcepto> getStringToTipoConceptoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.catalog.TipoConcepto>() {
            public com.raze.coleadmin.catalog.TipoConcepto convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), TipoConcepto.class);
            }
        };
    }

	public Converter<Alumno, String> getAlumnoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Alumno, java.lang.String>() {
            public String convert(Alumno alumno) {
                return new StringBuilder().append(alumno.getCorreoE()).append(' ').append(alumno.getNombre()).append(' ').append(alumno.getPrimerApellido()).append(' ').append(alumno.getSegundoApellido()).toString();
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

	public Converter<AlumnoGrupo, String> getAlumnoGrupoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.AlumnoGrupo, java.lang.String>() {
            public String convert(AlumnoGrupo alumnoGrupo) {
                return new StringBuilder().append(alumnoGrupo.getObservaciones()).append(' ').append(alumnoGrupo.getUsuarioCrea()).append(' ').append(alumnoGrupo.getUsuarioModifica()).append(' ').append(alumnoGrupo.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, AlumnoGrupo> getIdToAlumnoGrupoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.AlumnoGrupo>() {
            public com.raze.coleadmin.domain.AlumnoGrupo convert(java.lang.Long id) {
                return alumnoGrupoService.findAlumnoGrupo(id);
            }
        };
    }

	public Converter<String, AlumnoGrupo> getStringToAlumnoGrupoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.AlumnoGrupo>() {
            public com.raze.coleadmin.domain.AlumnoGrupo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), AlumnoGrupo.class);
            }
        };
    }

	public Converter<Asistencia, String> getAsistenciaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Asistencia, java.lang.String>() {
            public String convert(Asistencia asistencia) {
                return new StringBuilder().append(asistencia.getUsuarioCrea()).append(' ').append(asistencia.getUsuarioModifica()).append(' ').append(asistencia.getFechaCreacion()).append(' ').append(asistencia.getFechaModificacion()).toString();
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

	public Converter<CicloEscolar, String> getCicloEscolarToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.CicloEscolar, java.lang.String>() {
            public String convert(CicloEscolar cicloEscolar) {
                return new StringBuilder().append(cicloEscolar.getNombre()).append(' ').append(cicloEscolar.getFechaInicio()).append(' ').append(cicloEscolar.getFechaFin()).append(' ').append(cicloEscolar.getUsuarioCrea()).toString();
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

	public Converter<ConfiguracionCurso, String> getConfiguracionCursoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.ConfiguracionCurso, java.lang.String>() {
            public String convert(ConfiguracionCurso configuracionCurso) {
                return new StringBuilder().append(configuracionCurso.getCuotaInscripcion()).append(' ').append(configuracionCurso.getCuotaMensual()).append(' ').append(configuracionCurso.getSeguro()).append(' ').append(configuracionCurso.getCuotaPadres()).toString();
            }
        };
    }

	public Converter<Long, ConfiguracionCurso> getIdToConfiguracionCursoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.ConfiguracionCurso>() {
            public com.raze.coleadmin.domain.ConfiguracionCurso convert(java.lang.Long id) {
                return configuracionCursoService.findConfiguracionCurso(id);
            }
        };
    }

	public Converter<String, ConfiguracionCurso> getStringToConfiguracionCursoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.ConfiguracionCurso>() {
            public com.raze.coleadmin.domain.ConfiguracionCurso convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ConfiguracionCurso.class);
            }
        };
    }

	public Converter<ConfiguracionPagoEscuela, String> getConfiguracionPagoEscuelaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.ConfiguracionPagoEscuela, java.lang.String>() {
            public String convert(ConfiguracionPagoEscuela configuracionPagoEscuela) {
                return new StringBuilder().append(configuracionPagoEscuela.getDiaPago()).append(' ').append(configuracionPagoEscuela.getNip()).append(' ').append(configuracionPagoEscuela.getFechaVencimiento()).append(' ').append(configuracionPagoEscuela.getCorreoE()).toString();
            }
        };
    }

	public Converter<Long, ConfiguracionPagoEscuela> getIdToConfiguracionPagoEscuelaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.ConfiguracionPagoEscuela>() {
            public com.raze.coleadmin.domain.ConfiguracionPagoEscuela convert(java.lang.Long id) {
                return configuracionPagoEscuelaService.findConfiguracionPagoEscuela(id);
            }
        };
    }

	public Converter<String, ConfiguracionPagoEscuela> getStringToConfiguracionPagoEscuelaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.ConfiguracionPagoEscuela>() {
            public com.raze.coleadmin.domain.ConfiguracionPagoEscuela convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ConfiguracionPagoEscuela.class);
            }
        };
    }

	public Converter<Cuenta, String> getCuentaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Cuenta, java.lang.String>() {
            public String convert(Cuenta cuenta) {
                return new StringBuilder().append(cuenta.getDescuentoInscripcion()).append(' ').append(cuenta.getDescuentoMensualidad()).append(' ').append(cuenta.getSaldoTotal()).append(' ').append(cuenta.getUsuarioCrea()).toString();
            }
        };
    }

	public Converter<Long, Cuenta> getIdToCuentaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Cuenta>() {
            public com.raze.coleadmin.domain.Cuenta convert(java.lang.Long id) {
                return cuentaService.findCuenta(id);
            }
        };
    }

	public Converter<String, Cuenta> getStringToCuentaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Cuenta>() {
            public com.raze.coleadmin.domain.Cuenta convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Cuenta.class);
            }
        };
    }

	public Converter<Curso, String> getCursoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Curso, java.lang.String>() {
            public String convert(Curso curso) {
                return new StringBuilder().append(curso.getNombre()).append(' ').append(curso.getUsuarioCrea()).append(' ').append(curso.getUsuarioModifica()).append(' ').append(curso.getFechaCreacion()).toString();
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

	public Converter<Docente, String> getDocenteToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Docente, java.lang.String>() {
            public String convert(Docente docente) {
                return new StringBuilder().append(docente.getCorreoE()).append(' ').append(docente.getNombre()).append(' ').append(docente.getPrimerApellido()).append(' ').append(docente.getSegundoApellido()).toString();
            }
        };
    }

	public Converter<Long, Docente> getIdToDocenteConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Docente>() {
            public com.raze.coleadmin.domain.Docente convert(java.lang.Long id) {
                return docenteService.findDocente(id);
            }
        };
    }

	public Converter<String, Docente> getStringToDocenteConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Docente>() {
            public com.raze.coleadmin.domain.Docente convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Docente.class);
            }
        };
    }

	public Converter<Escuela, String> getEscuelaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Escuela, java.lang.String>() {
            public String convert(Escuela escuela) {
                return new StringBuilder().append(escuela.getNombre()).append(' ').append(escuela.getClave()).append(' ').append(escuela.getRazonSocial()).append(' ').append(escuela.getUsuarioCrea()).toString();
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
                return new StringBuilder().append(grupo.getNombreGrupo()).append(' ').append(grupo.getSalon()).append(' ').append(grupo.getDescripcion()).append(' ').append(grupo.getUsuarioCrea()).toString();
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

	public Converter<Padre, String> getPadreToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Padre, java.lang.String>() {
            public String convert(Padre padre) {
                return new StringBuilder().append(padre.getCorreoE()).append(' ').append(padre.getNombre()).append(' ').append(padre.getPrimerApellido()).append(' ').append(padre.getSegundoApellido()).toString();
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

	public Converter<Pago, String> getPagoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Pago, java.lang.String>() {
            public String convert(Pago pago) {
                return new StringBuilder().append(pago.getCantidad()).append(' ').append(pago.getSubtotal()).append(' ').append(pago.getTotal()).append(' ').append(pago.getFechaCargo()).toString();
            }
        };
    }

	public Converter<Long, Pago> getIdToPagoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Pago>() {
            public com.raze.coleadmin.domain.Pago convert(java.lang.Long id) {
                return pagoService.findPago(id);
            }
        };
    }

	public Converter<String, Pago> getStringToPagoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Pago>() {
            public com.raze.coleadmin.domain.Pago convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Pago.class);
            }
        };
    }

	public Converter<PagoEscuela, String> getPagoEscuelaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.PagoEscuela, java.lang.String>() {
            public String convert(PagoEscuela pagoEscuela) {
                return new StringBuilder().append(pagoEscuela.getFechaPago()).append(' ').append(pagoEscuela.getUsuarioCrea()).append(' ').append(pagoEscuela.getUsuarioModifica()).append(' ').append(pagoEscuela.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, PagoEscuela> getIdToPagoEscuelaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.PagoEscuela>() {
            public com.raze.coleadmin.domain.PagoEscuela convert(java.lang.Long id) {
                return pagoEscuelaService.findPagoEscuela(id);
            }
        };
    }

	public Converter<String, PagoEscuela> getStringToPagoEscuelaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.PagoEscuela>() {
            public com.raze.coleadmin.domain.PagoEscuela convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), PagoEscuela.class);
            }
        };
    }

	public Converter<Personal, String> getPersonalToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Personal, java.lang.String>() {
            public String convert(Personal personal) {
                return new StringBuilder().append(personal.getCorreoE()).append(' ').append(personal.getNombre()).append(' ').append(personal.getPrimerApellido()).append(' ').append(personal.getSegundoApellido()).toString();
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

	public Converter<Plantel, String> getPlantelToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Plantel, java.lang.String>() {
            public String convert(Plantel plantel) {
                return new StringBuilder().append(plantel.getNombre()).append(' ').append(plantel.getCalle()).append(' ').append(plantel.getNumero()).append(' ').append(plantel.getCodigoPostal()).toString();
            }
        };
    }

	public Converter<Long, Plantel> getIdToPlantelConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Plantel>() {
            public com.raze.coleadmin.domain.Plantel convert(java.lang.Long id) {
                return plantelService.findPlantel(id);
            }
        };
    }

	public Converter<String, Plantel> getStringToPlantelConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Plantel>() {
            public com.raze.coleadmin.domain.Plantel convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Plantel.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getConceptoToStringConverter());
        registry.addConverter(getIdToConceptoConverter());
        registry.addConverter(getStringToConceptoConverter());
        registry.addConverter(getCorreoToStringConverter());
        registry.addConverter(getIdToCorreoConverter());
        registry.addConverter(getStringToCorreoConverter());
        registry.addConverter(getEstatusCuentaToStringConverter());
        registry.addConverter(getIdToEstatusCuentaConverter());
        registry.addConverter(getStringToEstatusCuentaConverter());
        registry.addConverter(getMetodoPagoToStringConverter());
        registry.addConverter(getIdToMetodoPagoConverter());
        registry.addConverter(getStringToMetodoPagoConverter());
        registry.addConverter(getModuloToStringConverter());
        registry.addConverter(getIdToModuloConverter());
        registry.addConverter(getStringToModuloConverter());
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
        registry.addConverter(getTipoConceptoToStringConverter());
        registry.addConverter(getIdToTipoConceptoConverter());
        registry.addConverter(getStringToTipoConceptoConverter());
        registry.addConverter(getAlumnoToStringConverter());
        registry.addConverter(getIdToAlumnoConverter());
        registry.addConverter(getStringToAlumnoConverter());
        registry.addConverter(getAlumnoGrupoToStringConverter());
        registry.addConverter(getIdToAlumnoGrupoConverter());
        registry.addConverter(getStringToAlumnoGrupoConverter());
        registry.addConverter(getAsistenciaToStringConverter());
        registry.addConverter(getIdToAsistenciaConverter());
        registry.addConverter(getStringToAsistenciaConverter());
        registry.addConverter(getCicloEscolarToStringConverter());
        registry.addConverter(getIdToCicloEscolarConverter());
        registry.addConverter(getStringToCicloEscolarConverter());
        registry.addConverter(getConfiguracionCursoToStringConverter());
        registry.addConverter(getIdToConfiguracionCursoConverter());
        registry.addConverter(getStringToConfiguracionCursoConverter());
        registry.addConverter(getConfiguracionPagoEscuelaToStringConverter());
        registry.addConverter(getIdToConfiguracionPagoEscuelaConverter());
        registry.addConverter(getStringToConfiguracionPagoEscuelaConverter());
        registry.addConverter(getCuentaToStringConverter());
        registry.addConverter(getIdToCuentaConverter());
        registry.addConverter(getStringToCuentaConverter());
        registry.addConverter(getCursoToStringConverter());
        registry.addConverter(getIdToCursoConverter());
        registry.addConverter(getStringToCursoConverter());
        registry.addConverter(getDocenteToStringConverter());
        registry.addConverter(getIdToDocenteConverter());
        registry.addConverter(getStringToDocenteConverter());
        registry.addConverter(getEscuelaToStringConverter());
        registry.addConverter(getIdToEscuelaConverter());
        registry.addConverter(getStringToEscuelaConverter());
        registry.addConverter(getGrupoToStringConverter());
        registry.addConverter(getIdToGrupoConverter());
        registry.addConverter(getStringToGrupoConverter());
        registry.addConverter(getPadreToStringConverter());
        registry.addConverter(getIdToPadreConverter());
        registry.addConverter(getStringToPadreConverter());
        registry.addConverter(getPagoToStringConverter());
        registry.addConverter(getIdToPagoConverter());
        registry.addConverter(getStringToPagoConverter());
        registry.addConverter(getPagoEscuelaToStringConverter());
        registry.addConverter(getIdToPagoEscuelaConverter());
        registry.addConverter(getStringToPagoEscuelaConverter());
        registry.addConverter(getPersonalToStringConverter());
        registry.addConverter(getIdToPersonalConverter());
        registry.addConverter(getStringToPersonalConverter());
        registry.addConverter(getPlantelToStringConverter());
        registry.addConverter(getIdToPlantelConverter());
        registry.addConverter(getStringToPlantelConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
