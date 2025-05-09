package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.util.exception.CapitalException;
import co.edu.unbosque.util.exception.CharacterException;
import co.edu.unbosque.util.exception.CountryException;
import co.edu.unbosque.util.exception.EqualPasswordException;
import co.edu.unbosque.util.exception.ImageException;
import co.edu.unbosque.util.exception.MailException;
import co.edu.unbosque.util.exception.NumberException;
import co.edu.unbosque.util.exception.SmallException;
import co.edu.unbosque.util.exception.SymbolException;
import co.edu.unbosque.util.exception.UsernameException;
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

		vf.getVp().getpAdmin().getBtnVolver().addActionListener(this);
		vf.getVp().getpAdmin().getBtnVolver().setActionCommand("btnVolverAdmin");
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
					
					//SelectorImagen
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
							// Cambiar el nombre del archivo de destino para que sea el nombre del usuario con la extensión correcta
							String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
							File destino = new File("src/archivos/imagenperfil/" + usuario + "." + extension);

							// Guardar la imagen con el formato correcto
							FileManager.guardarImagen(selectedFile, destino);
							imagen = destino.getPath();

							if (mf.getJugadorDAO().add(new JugadorDTO(usuario, contrasena2, correo, pais, ciudad, imagen))) {
								vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correctosesion"));
							}
							
						} catch (IOException ex) {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.cargaimagen"));
						} catch (IllegalArgumentException ex) {
							vf.getVemer().mostrarError(prop.getProperty("archivospropiedad.emergente.archivoseleccionado"));
						}
					} else {
						ExceptionCheker.checkerImage();
					}
					//FinSelectorImagen
					
					break;
				}
				case "Entrenador": {
					ExceptionCheker.checkerCountry(ciudad);
					ExceptionCheker.checkerCountry(pais);
					
					//SelectorImagen
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
							// Cambiar el nombre del archivo de destino para que sea el nombre del usuario con la extensión correcta
							String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
							File destino = new File("src/archivos/imagenperfil/" + usuario + "." + extension);

							// Guardar la imagen con el formato correcto
							FileManager.guardarImagen(selectedFile, destino);
							imagen = destino.getPath();

							if (mf.getEntrenadorDAO().add(new EntrenadorDTO(usuario, contrasena2, correo, pais, ciudad, imagen))) {
								vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.correctosesion"));
							} else {
								vf.getVemer().mostrar(prop.getProperty("archivospropiedad.emergente.tipousuario"));
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
					//FinSelectorImagen
					
					
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
		case "btnVolverAdmin": {
			vf.getVp().getpAdmin().setVisible(false);
			vf.getVp().getPnP().setVisible(true);

			break;
		}

		}
	}

}
