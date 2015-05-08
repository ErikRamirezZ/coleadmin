package com.raze.coleadmin.controller;

import com.raze.coleadmin.domain.AlumnoGrupo;
import com.raze.coleadmin.domain.Asistencia;
import com.raze.coleadmin.domain.Cargo;
import com.raze.coleadmin.domain.CicloEscolar;
import com.raze.coleadmin.domain.Concepto;
import com.raze.coleadmin.domain.ConfiguracionCurso;
import com.raze.coleadmin.domain.ConfiguracionPagoEscuela;
import com.raze.coleadmin.domain.Cuenta;
import com.raze.coleadmin.domain.Curso;
import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.domain.Grupo;
import com.raze.coleadmin.domain.Modulo;
import com.raze.coleadmin.domain.Pago;
import com.raze.coleadmin.domain.PagoEscuela;
import com.raze.coleadmin.domain.Permiso;
import com.raze.coleadmin.domain.Plantel;
import com.raze.coleadmin.domain.Repeticiones;
import com.raze.coleadmin.domain.Rol;
import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.service.domain.AlumnoGrupoService;
import com.raze.coleadmin.service.domain.AsistenciaService;
import com.raze.coleadmin.service.domain.CargoService;
import com.raze.coleadmin.service.domain.CicloEscolarService;
import com.raze.coleadmin.service.domain.ConceptoService;
import com.raze.coleadmin.service.domain.ConfiguracionCursoService;
import com.raze.coleadmin.service.domain.ConfiguracionPagoEscuelaService;
import com.raze.coleadmin.service.domain.CuentaService;
import com.raze.coleadmin.service.domain.CursoService;
import com.raze.coleadmin.service.domain.EscuelaService;
import com.raze.coleadmin.service.domain.GrupoService;
import com.raze.coleadmin.service.domain.ModuloService;
import com.raze.coleadmin.service.domain.PagoEscuelaService;
import com.raze.coleadmin.service.domain.PagoService;
import com.raze.coleadmin.service.domain.PermisoService;
import com.raze.coleadmin.service.domain.PlantelService;
import com.raze.coleadmin.service.domain.RepeticionesService;
import com.raze.coleadmin.service.domain.RolService;
import com.raze.coleadmin.service.domain.UsuarioService;
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
    EscuelaService escuelaService;

	@Autowired
    GrupoService grupoService;

	@Autowired
    ModuloService moduloService;

	@Autowired
    PagoService pagoService;

	@Autowired
    PagoEscuelaService pagoEscuelaService;

	@Autowired
    PermisoService permisoService;

	@Autowired
    PlantelService plantelService;

	@Autowired
    RepeticionesService repeticionesService;

	@Autowired
    RolService rolService;

	@Autowired
    UsuarioService usuarioService;

	public Converter<AlumnoGrupo, String> getAlumnoGrupoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.AlumnoGrupo, java.lang.String>() {
            public String convert(AlumnoGrupo alumnoGrupo) {
                return new StringBuilder().append(alumnoGrupo.getObservaciones()).append(' ').append(alumnoGrupo.getFechaCreacion()).append(' ').append(alumnoGrupo.getFechaModificacion()).toString();
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
                return new StringBuilder().append(asistencia.getFecha()).append(' ').append(asistencia.getFechaCreacion()).append(' ').append(asistencia.getFechaModificacion()).toString();
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
                return new StringBuilder().append(cicloEscolar.getNombre()).append(' ').append(cicloEscolar.getFechaInicio()).append(' ').append(cicloEscolar.getFechaFin()).append(' ').append(cicloEscolar.getFechaCreacion()).toString();
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
                return new StringBuilder().append(concepto.getNombreConcepto()).append(' ').append(concepto.getMonto()).append(' ').append(concepto.getDescripcion()).append(' ').append(concepto.getFechaCreacion()).toString();
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
                return new StringBuilder().append(configuracionPagoEscuela.getDiaPago()).append(' ').append(configuracionPagoEscuela.getTarjetaCredito()).append(' ').append(configuracionPagoEscuela.getNip()).append(' ').append(configuracionPagoEscuela.getFechaVencimiento()).toString();
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
                return new StringBuilder().append(cuenta.getBeca()).append(' ').append(cuenta.getEstatus()).append(' ').append(cuenta.getSaldoTotal()).append(' ').append(cuenta.getFechaCreacion()).toString();
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
                return new StringBuilder().append(curso.getNombre()).append(' ').append(curso.getFechaCreacion()).append(' ').append(curso.getFechaModificacion()).toString();
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

	public Converter<Escuela, String> getEscuelaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Escuela, java.lang.String>() {
            public String convert(Escuela escuela) {
                return new StringBuilder().append(escuela.getClave()).append(' ').append(escuela.getNombreEscuela()).append(' ').append(escuela.getRazonSocial()).append(' ').append(escuela.getFechaCreacion()).toString();
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
                return new StringBuilder().append(grupo.getSalon()).append(' ').append(grupo.getNombreGrupo()).append(' ').append(grupo.getDescripcion()).append(' ').append(grupo.getFechaCreacion()).toString();
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

	public Converter<Modulo, String> getModuloToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Modulo, java.lang.String>() {
            public String convert(Modulo modulo) {
                return new StringBuilder().append(modulo.getNombre()).append(' ').append(modulo.getDescripcion()).append(' ').append(modulo.getFechaCreacion()).append(' ').append(modulo.getFechaModificacion()).toString();
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
                return new StringBuilder().append(pagoEscuela.getFechaPago()).append(' ').append(pagoEscuela.getFechaCreacion()).append(' ').append(pagoEscuela.getFechaModificacion()).toString();
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
                return new StringBuilder().append(permiso.getNombre()).toString();
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

	public Converter<Repeticiones, String> getRepeticionesToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Repeticiones, java.lang.String>() {
            public String convert(Repeticiones repeticiones) {
                return new StringBuilder().append(repeticiones.getNumeroVeces()).append(' ').append(repeticiones.getFechaCreacion()).append(' ').append(repeticiones.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Repeticiones> getIdToRepeticionesConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Repeticiones>() {
            public com.raze.coleadmin.domain.Repeticiones convert(java.lang.Long id) {
                return repeticionesService.findRepeticiones(id);
            }
        };
    }

	public Converter<String, Repeticiones> getStringToRepeticionesConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Repeticiones>() {
            public com.raze.coleadmin.domain.Repeticiones convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Repeticiones.class);
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

	public Converter<Usuario, String> getUsuarioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.coleadmin.domain.Usuario, java.lang.String>() {
            public String convert(Usuario usuario) {
                return new StringBuilder().append(usuario.getNombre()).append(' ').append(usuario.getApellidoPaterno()).append(' ').append(usuario.getApellidoMaterno()).append(' ').append(usuario.getFechaNacimiento()).toString();
            }
        };
    }

	public Converter<Long, Usuario> getIdToUsuarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.coleadmin.domain.Usuario>() {
            public com.raze.coleadmin.domain.Usuario convert(java.lang.Long id) {
                return usuarioService.findUsuario(id);
            }
        };
    }

	public Converter<String, Usuario> getStringToUsuarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.coleadmin.domain.Usuario>() {
            public com.raze.coleadmin.domain.Usuario convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Usuario.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
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
        registry.addConverter(getEscuelaToStringConverter());
        registry.addConverter(getIdToEscuelaConverter());
        registry.addConverter(getStringToEscuelaConverter());
        registry.addConverter(getGrupoToStringConverter());
        registry.addConverter(getIdToGrupoConverter());
        registry.addConverter(getStringToGrupoConverter());
        registry.addConverter(getModuloToStringConverter());
        registry.addConverter(getIdToModuloConverter());
        registry.addConverter(getStringToModuloConverter());
        registry.addConverter(getPagoToStringConverter());
        registry.addConverter(getIdToPagoConverter());
        registry.addConverter(getStringToPagoConverter());
        registry.addConverter(getPagoEscuelaToStringConverter());
        registry.addConverter(getIdToPagoEscuelaConverter());
        registry.addConverter(getStringToPagoEscuelaConverter());
        registry.addConverter(getPermisoToStringConverter());
        registry.addConverter(getIdToPermisoConverter());
        registry.addConverter(getStringToPermisoConverter());
        registry.addConverter(getPlantelToStringConverter());
        registry.addConverter(getIdToPlantelConverter());
        registry.addConverter(getStringToPlantelConverter());
        registry.addConverter(getRepeticionesToStringConverter());
        registry.addConverter(getIdToRepeticionesConverter());
        registry.addConverter(getStringToRepeticionesConverter());
        registry.addConverter(getRolToStringConverter());
        registry.addConverter(getIdToRolConverter());
        registry.addConverter(getStringToRolConverter());
        registry.addConverter(getUsuarioToStringConverter());
        registry.addConverter(getIdToUsuarioConverter());
        registry.addConverter(getStringToUsuarioConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
