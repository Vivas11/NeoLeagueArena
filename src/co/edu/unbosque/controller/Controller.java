package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.swing.JButton;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.TorneoLigaDTO;
import co.edu.unbosque.model.TorneoLlave;
import co.edu.unbosque.model.TorneoLlaveDTO;
import co.edu.unbosque.model.TorneoLiga;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.util.exception.CapitalException;
import co.edu.unbosque.util.exception.CharacterException;
import co.edu.unbosque.util.exception.CountryException;
import co.edu.unbosque.util.exception.EqualPasswordException;
import co.edu.unbosque.util.exception.ImageException;
import co.edu.unbosque.util.exception.MailException;
import co.edu.unbosque.util.exception.NumberException;
import co.edu.unbosque.util.exception.PowerOfTwoException;
import co.edu.unbosque.util.exception.SmallException;
import co.edu.unbosque.util.exception.SymbolException;
import co.edu.unbosque.view.SelectorEquipo;
import co.edu.unbosque.view.ViewFacade;

/**
 * Clase Controlador que maneja la interacción entre el modelo y la vista.
 * Implementa ActionListener para gestionar las acciones del usuario.
 */
public class Controller implements ActionListener {

	/** Facade para gestionar la capa del modelo. */
	private ModelFacade mf;

	/** Facade para gestionar la capa de la vista. */
	private ViewFacade vf;
	private Properties prop;

	public Controller() throws IOException {
		prop = new Properties();

		try {
			prop.load(new FileInputStream(new File("src/archivos/espanol.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}

		mf = new ModelFacade();
		vf = new ViewFacade(prop);
		mf.setUsuarioActual(new Administrador("VivasAdmin", "Lc1234.", "lc.vivascruz@gmail.com"));

	}

	public void run() {
		vf.getVp().setVisible(true);
		asignarLectores();
	}

	public void asignarLectores() {
		vf.getVp().getPnP().getBtnIniciarS().addActionListener(this);
		vf.getVp().getPnP().getBtnIniciarS().setActionCommand("btnPanelIniciarS");
		vf.getVp().getPnP().getBtnRegistrarse().addActionListener(this);
		vf.getVp().getPnP().getBtnRegistrarse().setActionCommand("btnPanelRegistrarse");
		vf.getVp().getPnP().getBtnVerE().addActionListener(this);
		vf.getVp().getPnP().getBtnVerE().setActionCommand("btnVerE");
		vf.getVp().getPnP().getBtnHistoriaP().addActionListener(this);
		vf.getVp().getPnP().getBtnHistoriaP().setActionCommand("btnHistoriaP");
		vf.getVp().getPnP().getBtnJugadoresD().addActionListener(this);
		vf.getVp().getPnP().getBtnJugadoresD().setActionCommand("btnJugadoresD");
		vf.getVp().getPnP().getBtnAdministrar().addActionListener(this);
		vf.getVp().getPnP().getBtnAdministrar().setActionCommand("btnAdministrar");
		vf.getVp().getPnP().getBtnCerrarSesion().addActionListener(this);
		vf.getVp().getPnP().getBtnCerrarSesion().setActionCommand("btnCerrarS");

		vf.getVp().getPnlIniciarS().getBtnIngresar().addActionListener(this);
		vf.getVp().getPnlIniciarS().getBtnIngresar().setActionCommand("btnIniciarSesion");
		vf.getVp().getPnlIniciarS().getBtnVolver().addActionListener(this);
		vf.getVp().getPnlIniciarS().getBtnVolver().setActionCommand("btnVolverAInicioS");

		vf.getVp().getPnlRegistro().getBtnVolver().addActionListener(this);
		vf.getVp().getPnlRegistro().getBtnVolver().setActionCommand("btnVolverAInicioR");
		vf.getVp().getPnlRegistro().getBtnRegistrar().addActionListener(this);
		vf.getVp().getPnlRegistro().getBtnRegistrar().setActionCommand("btnRegistrar");

		vf.getVp().getPnE().getBtnVolver().addActionListener(this);
		vf.getVp().getPnE().getBtnVolver().setActionCommand("btnVolverAInicioE");

		vf.getVp().getPnH().getBtnVolverHistorial().addActionListener(this);
		vf.getVp().getPnH().getBtnVolverHistorial().setActionCommand("btnVolverAInicioH");

		vf.getVp().getPnJD().getBtnVolverJugadore().addActionListener(this);
		vf.getVp().getPnJD().getBtnVolverJugadore().setActionCommand("btnVolverDestacados");

		vf.getVp().getpAdmin().getBtnUsuario().addActionListener(this);
		vf.getVp().getpAdmin().getBtnUsuario().setActionCommand("btnAdminU");
		vf.getVp().getpAdmin().getBtnPartido().addActionListener(this);
		vf.getVp().getpAdmin().getBtnPartido().setActionCommand("btnAdminP");
		vf.getVp().getpAdmin().getBtnTorneo().addActionListener(this);
		vf.getVp().getpAdmin().getBtnTorneo().setActionCommand("btnAdminT");
		vf.getVp().getpAdmin().getBtnEquipo().addActionListener(this);
		vf.getVp().getpAdmin().getBtnEquipo().setActionCommand("btnAdminEq");
		vf.getVp().getpAdmin().getBtnVolver().addActionListener(this);
		vf.getVp().getpAdmin().getBtnVolver().setActionCommand("btnVolverAdmin");

		vf.getVp().getpAdminT().getBtnCrear().addActionListener(this);
		vf.getVp().getpAdminT().getBtnCrear().setActionCommand("btnCrearT");
		vf.getVp().getpAdminT().getBtnVolver().addActionListener(this);
		vf.getVp().getpAdminT().getBtnVolver().setActionCommand("btnVolverAdminT");

		vf.getVp().getpAdminE().getBtnCrearEquipo().addActionListener(this);
		vf.getVp().getpAdminE().getBtnCrearEquipo().setActionCommand("btnCrearEq");
		vf.getVp().getpAdminE().getBtnVolver().addActionListener(this);
		vf.getVp().getpAdminE().getBtnVolver().setActionCommand("btnVolverAdminEq");

		vf.getVp().getpAdminU().getBtnJugadores().addActionListener(this);
		vf.getVp().getpAdminU().getBtnJugadores().setActionCommand("btnAdminJ");
		vf.getVp().getpAdminU().getBtnEntrenadores().addActionListener(this);
		vf.getVp().getpAdminU().getBtnEntrenadores().setActionCommand("btnAdminE");
		vf.getVp().getpAdminU().getBtnAdministradores().addActionListener(this);
		vf.getVp().getpAdminU().getBtnAdministradores().setActionCommand("btnAdminA");
		vf.getVp().getpAdminU().getBtnVolver().addActionListener(this);
		vf.getVp().getpAdminU().getBtnVolver().setActionCommand("btnVolverAdminU");

		vf.getVp().getpAdminUE().getBtnVolverJugador().addActionListener(this);
		vf.getVp().getpAdminUE().getBtnVolverJugador().setActionCommand("btnVolverAdminUE");
	}

	/**
	 * Método que gestiona las acciones realizadas por el usuario en la interfaz
	 * gráfica.
	 * 
	 * @param e Evento de acción generado por el usuario.
	 */
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "btnPanelIniciarS": {
			if (mf.getUsuarioActual() != null) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.yadentro"));
				break;
			}
			vf.getVp().getPnP().setVisible(false);
			vf.getVp().getPnlIniciarS().setVisible(true);
			break;
		}
		case "btnIniciarSesion": {
			String user = vf.getVp().getPnlIniciarS().getNombreUsuario().getText();
			String contrasena = vf.getVp().getPnlIniciarS().getContrasena();

			if (mf.findUser(new Jugador(user, "", "")) != null
					&& mf.findUser(new Jugador(user, "", "")).getContrasena().equals(contrasena)) {
				mf.setUsuarioActual(mf.findUser(new Jugador(user, "", "")));
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.iniciosesion") + " "
						+ mf.getUsuarioActual().getNombre());
				vf.getVp().getPnlIniciarS().setVisible(false);
				vf.getVp().getPnP().setVisible(true);
			} else {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.errorsesion"));
			}
			break;
		}
		case "btnVolverAInicioS": {
			vf.getVp().getPnlIniciarS().setVisible(false);
			vf.getVp().getPnP().setVisible(true);
			break;
		}

		case "btnPanelRegistrarse": {
			if (mf.getUsuarioActual() != null) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.yadentro"));
				break;
			}
			vf.getVp().getPnP().setVisible(false);
			vf.getVp().getPnlRegistro().setVisible(true);
			break;
		}
		case "btnVolverAInicioR": {
			vf.getVp().getPnlRegistro().setVisible(false);
			vf.getVp().getPnP().setVisible(true);
			break;
		}

		case "btnVerE": {
			vf.getVp().getPnE().agregarEquipos(mf.getEquipoDAO().getListaEquipos().size(),
					mf.getEquipoDAO().getListaEquipos());
			vf.getVp().getPnE().actualizarInfo();
			asignarComponentes("Equipo");

			vf.getVp().getPnP().setVisible(false);
			vf.getVp().getPnE().setVisible(true);
			break;
		}
		case "btnVolverAInicioE": {
			vf.getVp().getPnP().setVisible(true);
			vf.getVp().getPnE().setVisible(false);
			break;
		}

		case "btnHistoriaP": {
			
			vf.getVp().getPnH().agregarPartida(mf.obtenerTodasPartidas().size(), mf.obtenerTodasPartidas());
			vf.getVp().getPnH().actualizarInfo();
			asignarComponentes("Partida");
			
			vf.getVp().getPnP().setVisible(false);
			vf.getVp().getPnH().setVisible(true);
			break;
		}
		case "btnVolverAInicioH": {
			vf.getVp().getPnH().setVisible(false);
			vf.getVp().getPnP().setVisible(true);
			break;
		}

		case "btnJugadoresD": {
			if (mf.getJugadorDAO().getListaJugadores() == null) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.nojugadores"));
			} else {
				vf.getVp().getPnJD().actualizarInfo(mf.getJugadorDAO().getListaJugadores());
				vf.getVp().getPnP().setVisible(false);
				vf.getVp().getPnJD().setVisible(true);
			}
			break;
		}
		case "btnVolverDestacados": {
			vf.getVp().getPnP().setVisible(true);
			vf.getVp().getPnJD().setVisible(false);
			break;
		}
		case "btnRegistrar": {
			String usuario = (String) vf.getVp().getPnlRegistro().getNombreUsuario();
			String contrasena1 = (String) vf.getVp().getPnlRegistro().getContrasena1();
			String contrasena2 = (String) vf.getVp().getPnlRegistro().getContrasena2();
			String correo = (String) vf.getVp().getPnlRegistro().getTxtCorreo();
			String ciudad = vf.getVp().getPnlRegistro().getTxtCiudad().getText();
			String pais = vf.getVp().getPnlRegistro().getTxtPais().getText();

			if (mf.usuarioRepetido(usuario)) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.usuariorepetido"));
				return;
			}

			try {
				String selected = (String) vf.getVp().getPnlRegistro().getCbxTipoUsuario().getSelectedItem();
				ExceptionCheker.checkerEqualPassword(contrasena1, contrasena2);
				ExceptionCheker.checkerPasword(contrasena1);
				ExceptionCheker.checkerMail(correo);
				switch (selected) {
				case "Tipo de usuario": {
					vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.tipousuario"));
					break;
				}
				case "Jugador": {
					ExceptionCheker.checkerCountry(ciudad);
					ExceptionCheker.checkerCountry(pais);

					// SelectorImagen
					String imagen = "src/archivos/imagenperfil/";
					File selectedFile = vf.getVemer().seleccionarArchivo();
					if (selectedFile != null) {
						String fileName = selectedFile.getName().toLowerCase();
						if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
							vf.getVemer().mostrarError(
									"El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png");
							break;
						}
						try {
							// Cambiar el nombre del archivo de destino para que sea el nombre del usuario
							// con la extensión correcta
							String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
							File destino = new File("src/archivos/imagenperfil/" + usuario + "." + extension);

							// Guardar la imagen con el formato correcto
							FileManager.guardarImagen(selectedFile, destino);
							imagen = destino.getPath();

							if (mf.getJugadorDAO()
									.add(new JugadorDTO(usuario, contrasena2, correo, pais, ciudad, imagen))) {
								vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correctosesion"));
							}

						} catch (IOException ex) {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.cargaimagen"));
						} catch (IllegalArgumentException ex) {
							vf.getVemer()
									.mostrarError(prop.getProperty("archivospropiedad.emergente.archivoseleccionado"));
						}
					} else {
						ExceptionCheker.checkerImage();
					}
					// FinSelectorImagen

					break;
				}
				case "Entrenador": {
					ExceptionCheker.checkerCountry(ciudad);
					ExceptionCheker.checkerCountry(pais);

					// SelectorImagen
					String imagen = "src/archivos/imagenperfil/";
					File selectedFile = vf.getVemer().seleccionarArchivo();
					if (selectedFile != null) {
						String fileName = selectedFile.getName().toLowerCase();
						if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
							vf.getVemer().mostrarError(
									"El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png");
							break;
						}
						try {
							String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
							File destino = new File("src/archivos/imagenperfil/" + usuario + "." + extension);

							FileManager.guardarImagen(selectedFile, destino);
							imagen = destino.getPath();

							if (mf.getEntrenadorDAO()
									.add(new EntrenadorDTO(usuario, contrasena2, correo, pais, ciudad, imagen))) {
								vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correctosesion"));
							} else {
								vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.tipousuario"));
							}
							break;

						} catch (IOException ex) {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.cargaimagen"));
						} catch (IllegalArgumentException ex) {
							vf.getVemer()
									.mostrarError(prop.getProperty("archivospropiedad.emergente.archivoseleccionado"));
						}
					} else {
						ExceptionCheker.checkerImage();
					}
					// FinSelectorImagen

				}
				case "Administrador": {
					if (mf.getAdministradorDAO().add(new AdministradorDTO(usuario, contrasena2, correo))) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correctosesion"));
					} else {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.tipousuario"));
					}
					break;
				}
				default:
					break;
				}

			} catch (CharacterException e1) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.caracteres"));
			} catch (EqualPasswordException e1) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.contrasenasdiferentes"));
			} catch (CapitalException e1) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.mayus"));
			} catch (SmallException e1) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.minus"));
			} catch (NumberException e1) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.numero"));
			} catch (SymbolException e1) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.simbolo"));
			} catch (MailException e1) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correo"));
			} catch (CountryException e1) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.paiserror"));
				e1.printStackTrace();
			} catch (ImageException e1) {
				vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.imagen"));
			}

			break;

		}
		case "btnCerrarS": {
			if (mf.getUsuarioActual() != null) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.sesioncerrada") + " "
						+ mf.getUsuarioActual().getNombre() + ".");
				mf.setUsuarioActual(null);
			} else {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.errorsesioncerrada"));
			}
			break;
		}

		case "btnAdministrar": {
			if (!(mf.getUsuarioActual() instanceof Administrador)) {
				vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.noesadmin"));
				break;
			}

			vf.getVp().getpAdmin().setVisible(true);
			vf.getVp().getPnP().setVisible(false);

			break;
		}
		case "btnAdminU": {
			vf.getVp().getpAdmin().setVisible(false);
			vf.getVp().getpAdminU().setVisible(true);

			break;
		}
		case "btnVolverAdminU": {
			vf.getVp().getpAdmin().setVisible(true);
			vf.getVp().getpAdminU().setVisible(false);

			break;
		}

		case "btnAdminJ": {
			vf.getVp().getpAdminUE().agregarJugador(mf.getJugadorDAO().getListaJugadores().size(),
					mf.getJugadorDAO().getListaJugadores());
			vf.getVp().getpAdminUE().actualizarInfo();
			asignarComponentes("Jugador");
			vf.getVp().getpAdminUE().setVisible(true);
			vf.getVp().getpAdminU().setVisible(false);

			break;
		}
		case "btnAdminE": {
			vf.getVp().getpAdminUE().agregarEntrenador(mf.getEntrenadorDAO().getListaEntrenadores().size(),
					mf.getEntrenadorDAO().getListaEntrenadores());
			vf.getVp().getpAdminUE().actualizarInfo();
			asignarComponentes("Entrenador");
			vf.getVp().getpAdminUE().setVisible(true);
			vf.getVp().getpAdminU().setVisible(false);

			break;
		}
		case "btnAdminA": {
			vf.getVp().getpAdminUE().agregarAdministrador(mf.getAdministradorDAO().getListaAdministrador().size(),
					mf.getAdministradorDAO().getListaAdministrador());
			vf.getVp().getpAdminUE().actualizarInfo();
			asignarComponentes("Administrador");
			vf.getVp().getpAdminUE().setVisible(true);
			vf.getVp().getpAdminU().setVisible(false);

			break;
		}
		case "btnVolverAdminUE": {

			vf.getVp().getpAdminUE().setVisible(false);
			vf.getVp().getpAdminU().setVisible(true);
			break;
		}
		case "btnAdminT": {
			vf.getVp().getpAdminT().setVisible(true);
			vf.getVp().getpAdmin().setVisible(false);
			break;
		}
		case "btnCrearT": {
			String nombre = vf.getVp().getpAdminT().getNombreTorneo().getText();
			String juego = vf.getVp().getpAdminT().getNombreJuego().getText();
			String tipo = (String) vf.getVp().getpAdminT().getCbxTipoTorneo().getSelectedItem();
			int equipo = (int) vf.getVp().getpAdminT().getNumeroEquipo().getValue();
			if(nombre == null || nombre.trim().isEmpty()) {
				vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.datosvacios"));
				return;
			}else if(juego== null || juego.trim().isEmpty()) {
				vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.datosvacios"));
				return;
			}
			else if (equipo < 8) {
				vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.cantidadequiposnovalido"));
				return;
			}
			
			switch (tipo) {
			case "Tipo de torneo": {
				vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.notipotorneo"));
				break;
			}
			case "Liga": {
				SelectorEquipo selectorPanel = new SelectorEquipo(mf.getEquipoDAO().getListaEquipos(), equipo, prop);
				selectorPanel.setVisible(true);

				selectorPanel.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosed(java.awt.event.WindowEvent windowEvent) {
						ArrayList<String> equiposSeleccionadosTxt = selectorPanel.getEquiposSeleccionados();
						ArrayList<Equipo> equipos = new ArrayList<>();
						for (String eqs : equiposSeleccionadosTxt) {
							equipos.add(mf.getEquipoDAO().find(new Equipo(eqs, "", "")));
						}

						if (equipos.size() != equipo || equipos.size() < 8) {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.cantidadequiposnovalido"));
						} else {
							if (mf.getTorneoLigaDAO().add(new TorneoLigaDTO(nombre, juego, equipos))) {
								vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.torneocreado"));
							} else {
								vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.torneonovalido"));
							}
						}
					}
				});
				break;
			}
			case "Eliminacion directa": {
				SelectorEquipo selectorPanel = new SelectorEquipo(mf.getEquipoDAO().getListaEquipos(), equipo, prop);
				selectorPanel.setVisible(true);

				selectorPanel.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosed(java.awt.event.WindowEvent windowEvent) {
						ArrayList<String> equiposSeleccionadosTxt = selectorPanel.getEquiposSeleccionados();
						ArrayList<Equipo> equipos = new ArrayList<>();
						for (String eqs : equiposSeleccionadosTxt) {
							equipos.add(mf.getEquipoDAO().find(new Equipo(eqs, "", "")));
						}

						try {
							ExceptionCheker.checkerPowerOfTwo(equipos.size());
							if (equipos.size() != equipo || equipos.size() < 8) {
								vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.cantidadequiposnovalido"));
							} else {
								if (mf.getTorneoLlaveDAO().add(new TorneoLlaveDTO(nombre, juego, equipos))) {
									
									vf.getVemer().mostrar("Torneo de eliminación directa creado correctamente.");
								} else {
									vf.getVemer().mostrarError("No se pudo crear el torneo de eliminación directa.");
								}
							}
						} catch (PowerOfTwoException ex) {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.torneonovalido"));
						}
					}
				});
				break;
			}
			default:
				break;
			}
			break;
		}
		case "btnVolverAdminT": {
			vf.getVp().getpAdminT().setVisible(false);
			vf.getVp().getpAdmin().setVisible(true);
			break;
		}

		case "btnAdminEq": {
			vf.getVp().getpAdminE().setVisible(true);
			vf.getVp().getpAdmin().setVisible(false);
			break;
		}

		case "btnVolverAdminEq": {
			vf.getVp().getpAdminE().setVisible(false);
			vf.getVp().getpAdmin().setVisible(true);
			break;
		}
		case "btnCrearEq": {
			String torneo = vf.getVp().getpAdminE().getTxtNombreEquipo1().getText();
			String pais = vf.getVp().getpAdminE().getTxtPais().getText();
			try {
				ExceptionCheker.checkerCountry(pais);

				String imagen = "src/archivos/imagenequipos/";
				File selectedFile = vf.getVemer().seleccionarArchivo();
				if (selectedFile != null) {
					String fileName = selectedFile.getName().toLowerCase();
					if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
						vf.getVemer().mostrarError(
								"El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png");
						break;
					}
					try {
						String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
						File destino = new File("src/archivos/imagenperfil/" + torneo + "." + extension);

						FileManager.guardarImagen(selectedFile, destino);
						imagen = destino.getPath();

						if (mf.getEquipoDAO().add(new EquipoDTO(torneo, pais, imagen))) {
							vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correctoequipo"));
						} else {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.correctoequipo"));
						}
						break;

					} catch (IOException ex) {
						vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.cargaimagen"));
					} catch (IllegalArgumentException ex) {
						vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.archivoseleccionado"));
					}
				} else {
					ExceptionCheker.checkerImage();
				}
			} catch (Exception e2) {
				System.out.println("Error" + e2);
			}
			break;
		}

		case "btnVolverAdmin": {
			vf.getVp().getpAdmin().setVisible(false);
			vf.getVp().getPnP().setVisible(true);

			break;
		}

		}
	}

	/**
	 * Método que asigna las funciones específicas a los componentes según el tipo
	 * de usuario.
	 * 
	 * @param tipoUsuario Tipo de usuario (Jugador, Entrenador, Administrador).
	 */
	public void asignarComponentes(String tipoUsuario) {
		switch (tipoUsuario) {
		case "Jugador": {
			for (JButton btn : vf.getVp().getpAdminUE().getBtnsEliminar()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getpAdminUE().getBtnsEliminar().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					mf.getJugadorDAO()
							.delete(DataMapper.jugadorToJugadorDTO(mf.getJugadorDAO().getListaJugadores().get(indice)));
					vf.getVp().getpAdminUE().agregarJugador(mf.getJugadorDAO().getListaJugadores().size(),
							mf.getJugadorDAO().getListaJugadores());
					vf.getVp().getpAdminUE().actualizarInfo();
					asignarComponentes("Jugador");
				});
			}

			for (JButton btn : vf.getVp().getpAdminUE().getBtnsActualizar()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getpAdminUE().getBtnsActualizar().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					String nombreNuevo = vf.getVemer().leerTexto("Escriba el nuevo nombre de usuario");

					if (mf.usuarioRepetido(nombreNuevo)) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.usuariorepetido"));
						return;
					}

					String correoNuevo = vf.getVemer().leerTexto("Escriba el nuevo Correo");
					String paisNuevo = vf.getVemer().leerTexto("Escriba el nuevo Pais");
					String ciudadNueva = vf.getVemer().leerTexto("Escriba la nueva Ciudad");
					try {
						ExceptionCheker.checkerMail(correoNuevo);
						ExceptionCheker.checkerCountry(paisNuevo);
						ExceptionCheker.checkerCountry(ciudadNueva);
						mf.getJugadorDAO().update(
								DataMapper.jugadorToJugadorDTO(mf.getJugadorDAO().getListaJugadores().get(indice)),
								new JugadorDTO(nombreNuevo,
										mf.getJugadorDAO().getListaJugadores().get(indice).getContrasena(), correoNuevo,
										paisNuevo, ciudadNueva,
										mf.getJugadorDAO().getListaJugadores().get(indice).getEquipo(),
										mf.getJugadorDAO().getListaJugadores().get(indice).getImagen(),
										mf.getJugadorDAO().getListaJugadores().get(indice).getPartidasJugadas(),
										mf.getJugadorDAO().getListaJugadores().get(indice).getPartidasGanadas()));

					} catch (MailException e1) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correo"));
					} catch (CountryException e1) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.paiserror"));
						e1.printStackTrace();
					}
					vf.getVp().getpAdminUE().agregarJugador(mf.getJugadorDAO().getListaJugadores().size(),
							mf.getJugadorDAO().getListaJugadores());
					vf.getVp().getpAdminUE().actualizarInfo();
					asignarComponentes("Jugador");

				});
			}
			break;
		}

		case "Entrenador": {
			for (JButton btn : vf.getVp().getpAdminUE().getBtnsEliminar()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getpAdminUE().getBtnsEliminar().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					mf.getEntrenadorDAO().delete(DataMapper
							.entrenadorToEntrenadorDTO(mf.getEntrenadorDAO().getListaEntrenadores().get(indice)));
					vf.getVp().getpAdminUE().agregarEntrenador(mf.getEntrenadorDAO().getListaEntrenadores().size(),
							mf.getEntrenadorDAO().getListaEntrenadores());
					vf.getVp().getpAdminUE().actualizarInfo();
					asignarComponentes("Entrenador");
				});
			}

			for (JButton btn : vf.getVp().getpAdminUE().getBtnsActualizar()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getpAdminUE().getBtnsActualizar().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					String nombreNuevo = vf.getVemer().leerTexto("Escriba el nuevo nombre de usuario");

					if (mf.usuarioRepetido(nombreNuevo)) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.usuariorepetido"));
						return;
					}

					String correoNuevo = vf.getVemer().leerTexto("Escriba el nuevo Correo");
					String paisNuevo = vf.getVemer().leerTexto("Escriba el nuevo Pais");
					String ciudadNueva = vf.getVemer().leerTexto("Escriba la nueva Ciudad");
					try {
						ExceptionCheker.checkerMail(correoNuevo);
						ExceptionCheker.checkerCountry(paisNuevo);
						ExceptionCheker.checkerCountry(ciudadNueva);
						mf.getEntrenadorDAO()
								.update(DataMapper.entrenadorToEntrenadorDTO(
										mf.getEntrenadorDAO().getListaEntrenadores().get(indice)),
										new EntrenadorDTO(nombreNuevo,
												mf.getEntrenadorDAO().getListaEntrenadores().get(indice)
														.getContrasena(),
												correoNuevo, paisNuevo, ciudadNueva,
												mf.getEntrenadorDAO().getListaEntrenadores().get(indice).getEquipos(),
												mf.getEntrenadorDAO().getListaEntrenadores().get(indice).getImagen()));
						vf.getVemer().mostrar("Se ha actualizado correctamente");
					} catch (MailException e1) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correo"));
					} catch (CountryException e1) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.paiserror"));
						e1.printStackTrace();
					}
					vf.getVp().getpAdminUE().agregarEntrenador(mf.getEntrenadorDAO().getListaEntrenadores().size(),
							mf.getEntrenadorDAO().getListaEntrenadores());
					vf.getVp().getpAdminUE().actualizarInfo();
					asignarComponentes("Entrenador");
				});
			}
			break;
		}

		case "Administrador": {
			for (JButton btn : vf.getVp().getpAdminUE().getBtnsEliminar()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getpAdminUE().getBtnsEliminar().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					mf.getAdministradorDAO().delete(DataMapper.administradorToAdministradorDTO(
							mf.getAdministradorDAO().getListaAdministrador().get(indice)));
					vf.getVp().getpAdminUE().agregarAdministrador(
							mf.getAdministradorDAO().getListaAdministrador().size(),
							mf.getAdministradorDAO().getListaAdministrador());
					vf.getVp().getpAdminUE().actualizarInfo();
					asignarComponentes("Administrador");
				});
			}

			for (JButton btn : vf.getVp().getpAdminUE().getBtnsActualizar()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getpAdminUE().getBtnsActualizar().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());

					String nombreNuevo = vf.getVemer().leerTexto("Escriba el nuevo nombre de usuario");

					if (mf.usuarioRepetido(nombreNuevo)) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.usuariorepetido"));
						return;
					}

					String correoNuevo = vf.getVemer().leerTexto("Escriba el nuevo Correo");
					try {
						ExceptionCheker.checkerMail(correoNuevo);
						mf.getAdministradorDAO().update(
								DataMapper.administradorToAdministradorDTO(
										mf.getAdministradorDAO().getListaAdministrador().get(indice)),
								new AdministradorDTO(nombreNuevo,
										mf.getEntrenadorDAO().getListaEntrenadores().get(indice).getContrasena(),
										correoNuevo));
						vf.getVemer().mostrar("Se ha actualizado correctamente");
					} catch (MailException e1) {
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correo"));
					}
					vf.getVp().getpAdminUE().agregarAdministrador(
							mf.getAdministradorDAO().getListaAdministrador().size(),
							mf.getAdministradorDAO().getListaAdministrador());
					vf.getVp().getpAdminUE().actualizarInfo();
					asignarComponentes("Administrador");
				});
			}
			break;
		}

		case "Equipo": {
			for (JButton btn : vf.getVp().getPnE().getBtnsIngresar()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getPnE().getBtnsIngresar().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					if (mf.getUsuarioActual() instanceof Jugador) {

						if (mf.getEquipoDAO().getListaEquipos().get(indice).getJugadores().contains(
								mf.getUsuarioActual()) || ((Jugador) mf.getUsuarioActual()).getEquipo() != null) {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.yaenequipo"));
							return;
						}

						mf.getEquipoDAO().getListaEquipos().get(indice).getJugadores()
								.add((Jugador) mf.getUsuarioActual());
						mf.getEquipoDAO().escribirSerializado();
						String usuarioActual = mf.getUsuarioActual().getNombre();

						mf.getJugadorDAO().update(new JugadorDTO(mf.getUsuarioActual().getNombre(), "", ""),
								new JugadorDTO(mf.getUsuarioActual().getNombre(), mf.getUsuarioActual().getContrasena(),
										mf.getUsuarioActual().getCorreo(), ((Jugador) mf.getUsuarioActual()).getPais(),
										((Jugador) mf.getUsuarioActual()).getCiudad(),
										mf.getEquipoDAO().getListaEquipos().get(indice),
										((Jugador) mf.getUsuarioActual()).getImagen(),
										((Jugador) mf.getUsuarioActual()).getPartidasJugadas(),
										((Jugador) mf.getUsuarioActual()).getPartidasGanadas()));
						mf.setUsuarioActual(mf.getJugadorDAO().find(new Jugador(usuarioActual, "", "")));

						vf.getVp().getPnE().agregarEquipos(mf.getEquipoDAO().getListaEquipos().size(),
								mf.getEquipoDAO().getListaEquipos());
						vf.getVp().getpAdminUE().actualizarInfo();
						asignarComponentes("Equipo");
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.inscritoequipo"));

					} else if (mf.getUsuarioActual() instanceof Entrenador) {
						if (mf.getEquipoDAO().getListaEquipos().get(indice).getEntrenador() != null) {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.yaconentrenador"));
							return;
						}
						mf.getEquipoDAO().getListaEquipos().get(indice)
								.setEntrenador(((Entrenador) mf.getUsuarioActual()));
						mf.getEquipoDAO().escribirSerializado();
						((Entrenador) mf.getUsuarioActual()).getEquipos()
								.add(mf.getEquipoDAO().getListaEquipos().get(indice));

						mf.getEntrenadorDAO().update(
								new EntrenadorDTO(mf.getUsuarioActual().getNombre(), "", "", "", ""),
								new EntrenadorDTO(mf.getUsuarioActual().getNombre(),
										mf.getUsuarioActual().getContrasena(), mf.getUsuarioActual().getCorreo(),
										((Entrenador) mf.getUsuarioActual()).getPais(),
										((Entrenador) mf.getUsuarioActual()).getCiudad(),
										((Entrenador) mf.getUsuarioActual()).getEquipos(),
										((Entrenador) mf.getUsuarioActual()).getImagen()));
						mf.setUsuarioActual(mf.getEntrenadorDAO()
								.find(new Entrenador(mf.getUsuarioActual().getNombre(), "", "", "", "")));

						vf.getVp().getPnE().agregarEquipos(mf.getEquipoDAO().getListaEquipos().size(),
								mf.getEquipoDAO().getListaEquipos());
						vf.getVp().getpAdminUE().actualizarInfo();
						asignarComponentes("Equipo");
						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.inscritoequipo"));
					} else {
						vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.nosesion"));
					}
				});
			}

			for (JButton btn : vf.getVp().getPnE().getBtnsSalir()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getPnE().getBtnsSalir().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					if (mf.getUsuarioActual() instanceof Jugador) {

						if (mf.teamHasPlayer(mf.getEquipoDAO().getListaEquipos().get(indice), mf.getJugadorDAO()
								.find(new Jugador(((Jugador) mf.getUsuarioActual()).getNombre(), "", "")))) {
							System.out.println("Si");
							mf.getEquipoDAO().getListaEquipos().get(indice).getJugadores()
									.remove(mf.indexOfJugador(mf.getEquipoDAO().getListaEquipos().get(indice), mf
											.getJugadorDAO()
											.find(new Jugador(((Jugador) mf.getUsuarioActual()).getNombre(), "", ""))));
							mf.getEquipoDAO().escribirSerializado();

							String usuarioActual = mf.getUsuarioActual().getNombre();

							mf.getJugadorDAO().update(new JugadorDTO(mf.getUsuarioActual().getNombre(), "", ""),
									new JugadorDTO(mf.getUsuarioActual().getNombre(),
											mf.getUsuarioActual().getContrasena(), mf.getUsuarioActual().getCorreo(),
											((Jugador) mf.getUsuarioActual()).getPais(),
											((Jugador) mf.getUsuarioActual()).getCiudad(), null,
											((Jugador) mf.getUsuarioActual()).getImagen(),
											((Jugador) mf.getUsuarioActual()).getPartidasJugadas(),
											((Jugador) mf.getUsuarioActual()).getPartidasGanadas()));
							mf.setUsuarioActual(mf.getJugadorDAO().find(new Jugador(usuarioActual, "", "")));

							vf.getVp().getPnE().agregarEquipos(mf.getEquipoDAO().getListaEquipos().size(),
									mf.getEquipoDAO().getListaEquipos());
							vf.getVp().getpAdminUE().actualizarInfo();
							asignarComponentes("Equipo");
							vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.salircorrecto"));
						} else {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.yaenequipo"));
						}

					} else if (mf.getUsuarioActual() instanceof Entrenador) {
						if (mf.getEquipoDAO().getListaEquipos().get(indice).getEntrenador() != null) {
							mf.getEquipoDAO().getListaEquipos().get(indice).setEntrenador(null);
							mf.getEquipoDAO().escribirSerializado();

							((Entrenador) mf.getUsuarioActual()).getEquipos()
									.remove(mf.getEquipoDAO().getListaEquipos().get(indice));

							mf.getEntrenadorDAO().update(
									new EntrenadorDTO(mf.getUsuarioActual().getNombre(), "", "", "", ""),
									new EntrenadorDTO(mf.getUsuarioActual().getNombre(),
											mf.getUsuarioActual().getContrasena(), mf.getUsuarioActual().getCorreo(),
											((Entrenador) mf.getUsuarioActual()).getPais(),
											((Entrenador) mf.getUsuarioActual()).getCiudad(),
											((Entrenador) mf.getUsuarioActual()).getEquipos(),
											((Entrenador) mf.getUsuarioActual()).getImagen()));
						}
						mf.setUsuarioActual(mf.getEntrenadorDAO()
								.find(new Entrenador(mf.getUsuarioActual().getNombre(), "", "", "", "")));

						vf.getVp().getPnE().agregarEquipos(mf.getEquipoDAO().getListaEquipos().size(),
								mf.getEquipoDAO().getListaEquipos());
						vf.getVp().getpAdminUE().actualizarInfo();
						asignarComponentes("Equipo");

						vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.salircorrecto"));
					} else {
						vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.nosesion"));
					}

				});
			}
			break;
		}
		case "Partida":{
			for (JButton btn : vf.getVp().getPnH().getBtnsConfirmar()) {
				btn.setActionCommand(String.valueOf(vf.getVp().getPnH().getBtnsConfirmar().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					
					ArrayList<Partida> ps = mf.obtenerTodasPartidas();
					
					if(ps.get(indice).getGanador() == null) {
						
						
						//TORNEO LIGA
						if(ps.get(indice).getTor() instanceof TorneoLiga) {
							ps.get(indice).setPuntajeEquipoA((int)vf.getVp().getPnH().getSpinnersA().get(indice).getValue());
							ps.get(indice).setPuntajeEquipoB((int)vf.getVp().getPnH().getSpinnersB().get(indice).getValue());
							if((int)vf.getVp().getPnH().getSpinnersA().get(indice).getValue() > (int)vf.getVp().getPnH().getSpinnersB().get(indice).getValue()) {
								Equipo ganador = ps.get(indice).getEquipoA();
								for (Jugador j : ganador.getJugadores()) {
									j.setPartidasGanadas(j.getPartidasGanadas()+1);
									j.setPartidasGanadas(j.getPartidasJugadas()+1);
								}
								ganador.getPartidosJugados().add(ps.get(indice));
								Equipo perdedor = ps.get(indice).getEquipoB();
								for (Jugador j : perdedor.getJugadores()) {
									j.setPartidasGanadas(j.getPartidasJugadas()+1);
								}
								perdedor.getPartidosJugados().add(ps.get(indice));
								
								ps.get(indice).setGanador(ganador);
								((TorneoLiga) ps.get(indice).getTor()).getPuntos().put(ganador, ((TorneoLiga) ps.get(indice).getTor()).getPuntos().get(ganador) + 3);
								((TorneoLiga) ps.get(indice).getTor()).getPuntos().put(perdedor, ((TorneoLiga) ps.get(indice).getTor()).getPuntos().get(perdedor) + 0);
								
								
							}else if((int)vf.getVp().getPnH().getSpinnersA().get(indice).getValue() < (int)vf.getVp().getPnH().getSpinnersB().get(indice).getValue()) {
								Equipo ganador = ps.get(indice).getEquipoB();
								for (Jugador j : ganador.getJugadores()) {
									j.setPartidasGanadas(j.getPartidasGanadas()+1);
									j.setPartidasGanadas(j.getPartidasJugadas()+1);
								}
								ganador.getPartidosJugados().add(ps.get(indice));
								Equipo perdedor = ps.get(indice).getEquipoA();
								for (Jugador j : perdedor.getJugadores()) {
									j.setPartidasGanadas(j.getPartidasJugadas()+1);
								}
								perdedor.getPartidosJugados().add(ps.get(indice));
								ps.get(indice).setGanador(ps.get(indice).getEquipoB());
								
								((TorneoLiga) ps.get(indice).getTor()).getPuntos().put(ganador, ((TorneoLiga) ps.get(indice).getTor()).getPuntos().get(ganador) + 3);
								((TorneoLiga) ps.get(indice).getTor()).getPuntos().put(perdedor, ((TorneoLiga) ps.get(indice).getTor()).getPuntos().get(perdedor) + 0);
								
							}else {
								ps.get(indice).setGanador(null);
								for (Jugador j : ps.get(indice).getEquipoA().getJugadores()) {
									j.setPartidasGanadas(j.getPartidasGanadas()+1);
									j.setPartidasJugadas(j.getPartidasJugadas()+1);
								}
								ps.get(indice).getEquipoB().getPartidosJugados().add(ps.get(indice));
								for (Jugador j : ps.get(indice).getEquipoB().getJugadores()) {
									j.setPartidasGanadas(j.getPartidasGanadas()+1);
									j.setPartidasJugadas(j.getPartidasJugadas()+1);
								}
								ps.get(indice).getEquipoA().getPartidosJugados().add(ps.get(indice));
								((TorneoLiga) ps.get(indice).getTor()).getPuntos().put(ps.get(indice).getEquipoA(), ((TorneoLiga) ps.get(indice).getTor()).getPuntos().get(ps.get(indice).getEquipoA()) + 1);
								((TorneoLiga) ps.get(indice).getTor()).getPuntos().put(ps.get(indice).getEquipoB(), ((TorneoLiga) ps.get(indice).getTor()).getPuntos().get(ps.get(indice).getEquipoB()) + 1);
							}
							for (Partida partida : ps.get(indice).getTor().getPartidas()) {
								if(partida.getPuntajeEquipoA() == -1 || partida.getPuntajeEquipoB() == -1) {
									return;
								}
							}
							
							Map<Equipo, Integer> puntosOrdenados = mf.organizarPuntosLiga((TorneoLiga)ps.get(indice).getTor());
							Equipo primerEquipo = null;

							for (Map.Entry<Equipo, Integer> entry : puntosOrdenados.entrySet()) {
							    primerEquipo = entry.getKey();
							    break;
							}
							ps.get(indice).getTor().setGanador(primerEquipo);
							
						}
						//TORNEO ELIMINACION DIRECTA
						else if(ps.get(indice).getTor() instanceof TorneoLlave) {
							if((int)vf.getVp().getPnH().getSpinnersA().get(indice).getValue() == (int)vf.getVp().getPnH().getSpinnersB().get(indice).getValue()) {
								vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.noempate"));
								return;
							}
							
							ps.get(indice).setPuntajeEquipoA((int)vf.getVp().getPnH().getSpinnersA().get(indice).getValue());
							System.out.println(ps.get(indice).getPuntajeEquipoA());
							ps.get(indice).setPuntajeEquipoB((int)vf.getVp().getPnH().getSpinnersB().get(indice).getValue());
							System.out.println(ps.get(indice).getPuntajeEquipoB());
							Equipo ganador;
							Equipo perdedor;
							if((int)vf.getVp().getPnH().getSpinnersA().get(indice).getValue() > (int)vf.getVp().getPnH().getSpinnersB().get(indice).getValue()) {
								ganador = ps.get(indice).getEquipoA();
								ganador.getPartidosJugados().add(ps.get(indice));
								for (Jugador j : ganador.getJugadores()) {
									j.setPartidasGanadas(j.getPartidasGanadas()+1);
									j.setPartidasJugadas(j.getPartidasJugadas()+1);
								}
								perdedor = ps.get(indice).getEquipoB();
								for (Jugador j : perdedor.getJugadores()) {
									j.setPartidasJugadas(j.getPartidasJugadas()+1);
								}
								ps.get(indice).setGanador(ps.get(indice).getEquipoA());
								perdedor.getPartidosJugados().add(ps.get(indice));
								
								//ps.get(indice).getTor().getEquipos().remove(perdedor);
								
							}else if((int)vf.getVp().getPnH().getSpinnersA().get(indice).getValue() < (int)vf.getVp().getPnH().getSpinnersB().get(indice).getValue()) {
								ganador = ps.get(indice).getEquipoB();
								for (Jugador j : ganador.getJugadores()) {
									j.setPartidasGanadas(j.getPartidasGanadas()+1);
									j.setPartidasGanadas(j.getPartidasJugadas()+1);
								}
								ganador.getPartidosJugados().add(ps.get(indice));
								perdedor = ps.get(indice).getEquipoA();
								for (Jugador j : perdedor.getJugadores()) {
									j.setPartidasGanadas(j.getPartidasJugadas()+1);
								}
								ps.get(indice).setGanador(ps.get(indice).getEquipoB());
								perdedor.getPartidosJugados().add(ps.get(indice));

								//ps.get(indice).getTor().getEquipos().remove(perdedor);
							}else {
								ganador = null;
								perdedor = null;
							}
							
							ArrayList<Equipo> ganadores = new ArrayList<>();
							ArrayList<Partida> partidasTorneo = mf.buscarTorneoPartida(ps.get(indice)).getPartidas();

							int faseActual = 1;
							for (Partida partida : partidasTorneo) {
							    if (partida.getFase() > faseActual) {
							        faseActual = partida.getFase();
							    }
							}

							for (Partida partida : partidasTorneo) {
							    if (partida.getFase() == faseActual) {
							        if(partida.getPuntajeEquipoA() == -1 || partida.getPuntajeEquipoB() == -1) {
							            mf.getTorneoLigaDAO().escribirSerializado();
							            mf.getTorneoLlaveDAO().escribirSerializado();
							            vf.getVp().getPnH().agregarPartida(mf.obtenerTodasPartidas().size(), mf.obtenerTodasPartidas());
							            vf.getVp().getPnH().actualizarInfo();
							            asignarComponentes("Partida");
							            return;
							        } else {
							            ganadores.add(partida.getGanador());
							            
							        }
							    }
							}
							for (Partida partida : partidasTorneo) {
								partida.setFase(0);
							}
							if(ganadores.size() > 1) {
								((TorneoLlave)ps.get(indice).getTor()).crearFasesPost(ganadores);
							}else {
								ps.get(indice).getTor().setGanador(ganadores.get(0));
							}
						}else {
						}
					}
					
					
					mf.getTorneoLigaDAO().escribirSerializado();
					mf.getTorneoLlaveDAO().escribirSerializado();
					
					vf.getVp().getPnH().agregarPartida(mf.obtenerTodasPartidas().size(), mf.obtenerTodasPartidas());
					vf.getVp().getPnH().actualizarInfo();
					asignarComponentes("Partida");
				});
			}
			break;
		}
		default:
			System.err.println("Tipo de usuario no reconocido: " + tipoUsuario);
			break;
		}
	}
}
