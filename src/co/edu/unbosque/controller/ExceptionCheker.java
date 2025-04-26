package co.edu.unbosque.controller;

import co.edu.unbosque.util.exception.CapitalException;
import co.edu.unbosque.util.exception.CharacterException;
import co.edu.unbosque.util.exception.EqualPasswordException;
import co.edu.unbosque.util.exception.NumberException;
import co.edu.unbosque.util.exception.SymbolException;
import co.edu.unbosque.util.exception.SmallException;

/**
 * Clase ExceptionCheker.
 * Proporciona métodos para validar contraseñas según diferentes criterios.
 */
public class ExceptionCheker {

	/**
	 * Verifica que una contraseña cumpla con todos los criterios de validación.
	 * 
	 * @param a La contraseña a validar.
	 * @throws CapitalException       Si no contiene al menos una letra mayúscula.
	 * @throws CharacterException     Si no tiene al menos 8 caracteres.
	 * @throws NumberException        Si no contiene al menos un número.
	 * @throws SymbolException        Si no contiene al menos un símbolo especial.
	 * @throws SmallException         Si no contiene al menos una letra minúscula.
	 */
	public static void checkerPasword(String a)
			throws CapitalException, CharacterException, NumberException, SymbolException, SmallException {
		checkerCapital(a);
		checkerCharacter(a);
		checkerNumber(a);
		checkerSymbol(a); 
		checkerSmall(a);

	}

	/**
	 * Verifica que la contraseña tenga al menos 8 caracteres.
	 * 
	 * @param a La contraseña a validar.
	 * @throws CharacterException Si la longitud es menor a 8 caracteres.
	 */
	public static void checkerCharacter(String a) throws CharacterException {
		if (a.length() < 8) {
			throw new CharacterException();
		}
	}

	/**
	 * Verifica que dos contraseñas sean iguales.
	 * 
	 * @param a La primera contraseña.
	 * @param b La segunda contraseña.
	 * @throws EqualPasswordException Si las contraseñas no coinciden.
	 */
	public static void checkerEqualPassword(String a, String b) throws EqualPasswordException {
		if (!a.equals(b)) {
			throw new EqualPasswordException();
		}
	}

	/**
	 * Verifica que la contraseña contenga al menos una letra mayúscula.
	 * 
	 * @param a La contraseña a validar.
	 * @throws CapitalException Si no contiene letras mayúsculas.
	 */
	public static void checkerCapital(String a) throws CapitalException {
		if (!a.matches(".*[A-Z].*")) {
			throw new CapitalException();
		}
	}

	/**
	 * Verifica que la contraseña contenga al menos una letra minúscula.
	 * 
	 * @param a La contraseña a validar.
	 * @throws SmallException Si no contiene letras minúsculas.
	 */
	public static void checkerSmall(String a) throws SmallException {
		if (!a.matches(".*[a-z].*")) {
			throw new SmallException(); 
		}
	}

	/**
	 * Verifica que la contraseña contenga al menos un número.
	 * 
	 * @param a La contraseña a validar.
	 * @throws NumberException Si no contiene números.
	 */
	public static void checkerNumber(String a) throws NumberException {

		if (!a.matches(".*\\d.*")) {
			throw new NumberException();
		}
	}

	/**
	 * Verifica que la contraseña contenga al menos un símbolo especial.
	 * 
	 * @param a La contraseña a validar.
	 * @throws SymbolException Si no contiene símbolos especiales.
	 */
	public static void checkerSymbol(String a) throws SymbolException {

		if (!a.matches(".*[^A-Za-z0-9].*")) {
			throw new SymbolException();
		}
	}

}
