package objekt;

import java.util.List;

public class Validator {

	/**
	 * Passord m� ha en lengde st�rre enn 4
	 * 
	 * @param passord
	 * @return
	 */
	public static boolean validPassord(String passord) {
		return passord != null && passord.length() > 4;
	}

	public boolean validerPassordRepetert(String passordRepetert, String passord) {
		return passordRepetert == null ? passord == null : passordRepetert.equals(passord);
	}

	/**
	 * Tester om mobilnummeret er korrekt med �tte siffere
	 * 
	 * @param mobil
	 * @return
	 */
	public static boolean validMobil(String mobil) {
		return mobil != null && mobil.matches("^[0-9]{8}");
	}

	/**
	 * Tester om kjonnet er enten mann eller kvinne
	 * 
	 * @param kjonn
	 * @return
	 */
	public static boolean validKjonn(String kjonn) {
		return "kvinne".equals(kjonn) || "mann".equals(kjonn);
	}

	/**
	 * Tester om gitt streng er et gyldig fornavn M� starte med stor bokstav og
	 * inneholde bokstaver, " ", eller - Minimums lengde 2, maxs 20
	 * 
	 * @param navn
	 * @return
	 */
	public static boolean validFornavn(String navn) {
		return navn != null && navn.length() <= 20 && navn.matches("^([A-Z���][\\-\\sa-zA-Z������]+)");
	}

	/**
	 * Tester om gitt streng er et gyldig etternavn M� starte med stor bokstav og
	 * inneholde bokstaver, eller - Minimums lengde 2, maxs 20
	 * 
	 * @param navn
	 * @return
	 */
	public static boolean validEtternavn(String navn) {
		return navn != null && navn.length() <= 20 && navn.matches("^([A-Z���][\\sa-zA-Z������]+)");
	}
}