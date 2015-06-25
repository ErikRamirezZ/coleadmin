package com.raze.coleadmin.controller;

import com.raze.coleadmin.domain.Alumno;
import com.raze.coleadmin.domain.AlumnoGrupo;
import com.raze.coleadmin.domain.Asistencia;
import com.raze.coleadmin.domain.Cargo;
import com.raze.coleadmin.domain.CicloEscolar;
import com.raze.coleadmin.domain.Concepto;
import com.raze.coleadmin.domain.ConfiguracionCurso;
import com.raze.coleadmin.domain.ConfiguracionPagoEscuela;
import com.raze.coleadmin.domain.Cuenta;
import com.raze.coleadmin.domain.Curso;
import com.raze.coleadmin.domain.Docente;
import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.domain.Grupo;
import com.raze.coleadmin.domain.Login;
import com.raze.coleadmin.domain.Modulo;
import com.raze.coleadmin.domain.Padre;
import com.raze.coleadmin.domain.Pago;
import com.raze.coleadmin.domain.PagoEscuela;
import com.raze.coleadmin.domain.Permiso;
import com.raze.coleadmin.domain.Personal;
import com.raze.coleadmin.domain.Plantel;
import com.raze.coleadmin.domain.Repeticion;
import com.raze.coleadmin.domain.Rol;
import com.raze.coleadmin.service.AlumnoGrupoService;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.AsistenciaService;
import com.raze.coleadmin.service.CargoService;
import com.raze.coleadmin.service.CicloEscolarService;
import com.raze.coleadmin.service.ConceptoService;
import com.raze.coleadmin.service.ConfiguracionCursoService;
import com.raze.coleadmin.service.ConfiguracionPagoEscuelaService;
import com.raze.coleadmin.service.CuentaService;
import com.raze.coleadmin.service.CursoService;
import com.raze.coleadmin.service.DocenteService;
import com.raze.coleadmin.service.EscuelaService;
import com.raze.coleadmin.service.GrupoService;
import com.raze.coleadmin.service.LoginService;
import com.raze.coleadmin.service.ModuloService;
import com.raze.coleadmin.service.PadreService;
import com.raze.coleadmin.service.PagoEscuelaService;
import com.raze.coleadmin.service.PagoService;
import com.raze.coleadmin.service.PermisoService;
import com.raze.coleadmin.service.PersonalService;
import com.raze.coleadmin.service.PlantelService;
import com.raze.coleadmin.service.RepeticionService;
import com.raze.coleadmin.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

@Configurable
/**
 * A central place to register application converters and formatters. 
 */
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    AlumnoGrupoService alumnoGrupoService;

	@Autowired
    AsistenciaService asistenciaService;

	@Autowired
    CargoService cargoService;

	@Autowired
    CicloEscolarService cicloEscolarService;

	@Autowired
    ConceptoService conceptoService;

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
    LoginService loginService;

	@Autowired
    ModuloService moduloService;

	@Autowired
    PadreService padreService;

	@Autowired
    PagoService pagoService;

	@Autowired
    PagoEscuelaService pagoEscuelaService;

	@Autowired
    PermisoService permisoService;

	@Autowired
    PersonalService personalService;

	@Autowired
    PlantelService plantelService;

	@Autowired
    RepeticionService repeticionService;

	@Autowired
    RolService rolService;

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
                return new StringBuilder().append(alumnoGrupo.getObservaciones()).append(' ').append(alumnoGrupo.getIdUsuario()).append(' ').append(alumnoGrupo.getFechaCreacion()).append(' ').append(alumnoGrupo.getFechaModificacion()).toString();
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
                return new StringBuilder().append(asistencia.getFecha()).append(' ').append(asistencia.getIdUsuario()).append(' ').append(asistencia.getFechaCreacion()).append(' ').append(asistencia.getFechaModificacion()).toString();
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
                return new StringBuilder().append(cargo.getSubtotal()).append(' ').append(cargo.getTotal()).append(' ').append(cargo.getFechaCargo()).append(' ').append(cargo.getFechaPago()).toString();
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
                return new StringBuilder().append(cicloEscolar.getNombre()).append(' ').append(cicloEscolar.getFechaInicio()).append(' ').append(cicloEscolar.getFechaFin()).append(' ').append(cicloEscolar.getIdUsuario()).toString();
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

	public Converter<Concepto, String> getConceptoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Concepto, java.lang.String>() {
            public String convert(Concepto concepto) {
                return new StringBuilder().append(concepto.getNombreConcepto()).append(' ').append(concepto.getMonto()).append(' ').append(concepto.getDescripcion()).append(' ').append(concepto.getContentType()).toString();
            }
        };
    }

	public Converter<Long, Concepto> getIdToConceptoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Concepto>() {
            public com.raze.coleadmin.domain.Concepto convert(java.lang.Long id) {
                return conceptoService.findConcepto(id);
            }
        };
    }

	public Converter<String, Concepto> getStringToConceptoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Concepto>() {
            public com.raze.coleadmin.domain.Concepto convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Concepto.class);
            }
        };
    }

	public Converter<ConfiguracionCurso, String> getConfiguracionCursoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.ConfiguracionCurso, java.lang.String>() {
            public String convert(ConfiguracionCurso configuracionCurso) {
                return new StringBuilder().append(configuracionCurso.getCuotaMensual()).append(' ').append(configuracionCurso.getCuotaInscripcion()).append(' ').append(configuracionCurso.getDiaCorte()).append(' ').append(configuracionCurso.getDiaPago()).toString();
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
                return new StringBuilder().append(cuenta.getBeca()).append(' ').append(cuenta.getSaldoTotal()).append(' ').append(cuenta.getIdUsuario()).append(' ').append(cuenta.getFechaCreacion()).toString();
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
                return new StringBuilder().append(curso.getNombre()).append(' ').append(curso.getIdUsuario()).append(' ').append(curso.getFechaCreacion()).append(' ').append(curso.getFechaModificacion()).toString();
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
                return new StringBuilder().append(escuela.getClave()).append(' ').append(escuela.getNombre()).append(' ').append(escuela.getRazonSocial()).append(' ').append(escuela.getContentType()).toString();
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
                return new StringBuilder().append(grupo.getSalon()).append(' ').append(grupo.getNombreGrupo()).append(' ').append(grupo.getDescripcion()).append(' ').append(grupo.getIdUsuario()).toString();
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

	public Converter<Login, String> getLoginToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Login, java.lang.String>() {
            public String convert(Login login) {
                return new StringBuilder().append(login.getPassword()).append(' ').append(login.getIdUsuario()).append(' ').append(login.getFechaCreacion()).append(' ').append(login.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Login> getIdToLoginConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Login>() {
            public com.raze.coleadmin.domain.Login convert(java.lang.Long id) {
                return loginService.findLogin(id);
            }
        };
    }

	public Converter<String, Login> getStringToLoginConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Login>() {
            public com.raze.coleadmin.domain.Login convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Login.class);
            }
        };
    }

	public Converter<Modulo, String> getModuloToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Modulo, java.lang.String>() {
            public String convert(Modulo modulo) {
                return new StringBuilder().append(modulo.getNombre()).append(' ').append(modulo.getDescripcion()).append(' ').append(modulo.getIdUsuario()).append(' ').append(modulo.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, Modulo> getIdToModuloConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Modulo>() {
            public com.raze.coleadmin.domain.Modulo convert(java.lang.Long id) {
                return moduloService.findModulo(id);
            }
        };
    }

	public Converter<String, Modulo> getStringToModuloConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Modulo>() {
            public com.raze.coleadmin.domain.Modulo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Modulo.class);
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
                return new StringBuilder().append(pago.getMonto()).append(' ').append(pago.getDescuento()).append(' ').append(pago.getFechaPago()).append(' ').append(pago.getObservaciones()).toString();
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
                return new StringBuilder().append(pagoEscuela.getFechaPago()).append(' ').append(pagoEscuela.getContentType()).toString();
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

	public Converter<Permiso, String> getPermisoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Permiso, java.lang.String>() {
            public String convert(Permiso permiso) {
                return new StringBuilder().append(permiso.getNombre()).append(' ').append(permiso.getIdUsuario()).append(' ').append(permiso.getFechaCreacion()).append(' ').append(permiso.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Permiso> getIdToPermisoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Permiso>() {
            public com.raze.coleadmin.domain.Permiso convert(java.lang.Long id) {
                return permisoService.findPermiso(id);
            }
        };
    }

	public Converter<String, Permiso> getStringToPermisoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Permiso>() {
            public com.raze.coleadmin.domain.Permiso convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Permiso.class);
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

	public Converter<Repeticion, String> getRepeticionToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Repeticion, java.lang.String>() {
            public String convert(Repeticion repeticion) {
                return new StringBuilder().append(repeticion.getNumeroVeces()).append(' ').append(repeticion.getIdUsuario()).append(' ').append(repeticion.getFechaCreacion()).append(' ').append(repeticion.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Repeticion> getIdToRepeticionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Repeticion>() {
            public com.raze.coleadmin.domain.Repeticion convert(java.lang.Long id) {
                return repeticionService.findRepeticion(id);
            }
        };
    }

	public Converter<String, Repeticion> getStringToRepeticionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Repeticion>() {
            public com.raze.coleadmin.domain.Repeticion convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Repeticion.class);
            }
        };
    }

	public Converter<Rol, String> getRolToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Rol, java.lang.String>() {
            public String convert(Rol rol) {
                return new StringBuilder().append(rol.getNombre()).toString();
            }
        };
    }

	public Converter<Long, Rol> getIdToRolConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Rol>() {
            public com.raze.coleadmin.domain.Rol convert(java.lang.Long id) {
                return rolService.findRol(id);
            }
        };
    }

	public Converter<String, Rol> getStringToRolConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Rol>() {
            public com.raze.coleadmin.domain.Rol convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Rol.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getAlumnoToStringConverter());
        registry.addConverter(getIdToAlumnoConverter());
        registry.addConverter(getStringToAlumnoConverter());
        registry.addConverter(getAlumnoGrupoToStringConverter());
        registry.addConverter(getIdToAlumnoGrupoConverter());
        registry.addConverter(getStringToAlumnoGrupoConverter());
        registry.addConverter(getAsistenciaToStringConverter());
        registry.addConverter(getIdToAsistenciaConverter());
        registry.addConverter(getStringToAsistenciaConverter());
        registry.addConverter(getCargoToStringConverter());
        registry.addConverter(getIdToCargoConverter());
        registry.addConverter(getStringToCargoConverter());
        registry.addConverter(getCicloEscolarToStringConverter());
        registry.addConverter(getIdToCicloEscolarConverter());
        registry.addConverter(getStringToCicloEscolarConverter());
        registry.addConverter(getConceptoToStringConverter());
        registry.addConverter(getIdToConceptoConverter());
        registry.addConverter(getStringToConceptoConverter());
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
        registry.addConverter(getLoginToStringConverter());
        registry.addConverter(getIdToLoginConverter());
        registry.addConverter(getStringToLoginConverter());
        registry.addConverter(getModuloToStringConverter());
        registry.addConverter(getIdToModuloConverter());
        registry.addConverter(getStringToModuloConverter());
        registry.addConverter(getPadreToStringConverter());
        registry.addConverter(getIdToPadreConverter());
        registry.addConverter(getStringToPadreConverter());
        registry.addConverter(getPagoToStringConverter());
        registry.addConverter(getIdToPagoConverter());
        registry.addConverter(getStringToPagoConverter());
        registry.addConverter(getPagoEscuelaToStringConverter());
        registry.addConverter(getIdToPagoEscuelaConverter());
        registry.addConverter(getStringToPagoEscuelaConverter());
        registry.addConverter(getPermisoToStringConverter());
        registry.addConverter(getIdToPermisoConverter());
        registry.addConverter(getStringToPermisoConverter());
        registry.addConverter(getPersonalToStringConverter());
        registry.addConverter(getIdToPersonalConverter());
        registry.addConverter(getStringToPersonalConverter());
        registry.addConverter(getPlantelToStringConverter());
        registry.addConverter(getIdToPlantelConverter());
        registry.addConverter(getStringToPlantelConverter());
        registry.addConverter(getRepeticionToStringConverter());
        registry.addConverter(getIdToRepeticionConverter());
        registry.addConverter(getStringToRepeticionConverter());
        registry.addConverter(getRolToStringConverter());
        registry.addConverter(getIdToRolConverter());
        registry.addConverter(getStringToRolConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
