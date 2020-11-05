package objekt;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletRequest;

public class Skjema {
	String fornavn;
	String fornavnFeilmelding;
	String etternavn;
	String etternavnFeilmelding;
	String mobil;
	String mobilFeilmelding;
	String passord;
	String passordFeilmelding;
	String passordKopi;
	String passordKopiFeilmelding;
	String kjonn;
	String kjonnFeilmelding;

	public Skjema(String fornavn, String etternavn, String mobil, String passord, String passordKopi, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.passordKopi = passordKopi;
		this.kjonn = kjonn;
	}

	public Skjema(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passordKopi = request.getParameter("passordRepetert");
		this.kjonn = request.getParameter("kjonn");
	}

	public boolean isFornavnGyldig() {
		return fornavn.length() >= 2 && fornavn.length() <= 20
				&& fornavn.matches("[A-ZÅÆØ][a-zåæøA-ZÅÆØ]+\\s*\\-*([A-ZÅÆØ][a-zåæøA-ZÅÆØ]+)*");
	}

	public boolean isEtternavnGyldig() {
		return etternavn.length() >= 2 && etternavn.length() <= 20
				&& etternavn.matches("[A-ZÅÆØ][a-zåæøA-ZÅÆØ]+\\s*\\-*([A-ZÅÆØ][a-zåæøA-ZÅÆØ]+)*");
	}

	public boolean ismobilGyldig() {
		return mobil.matches("[0-9]{8}");
	}

	public boolean isPassordGyldig() {
		return passord.length() >= 4;
	}

	public boolean isPassordKopiGyldig() {
		return passord.equals(passordKopi);
	}

	public boolean isKjonnGyldig() {
		return !(kjonn == null) && (kjonn.equals("mann") || kjonn.equals("kvinne"));
	}

	public Deltager lagDeltager() {
		Passord passordhash = Passord.lagPassord(passord);
		Deltager d = new Deltager(fornavn, etternavn, mobil, kjonn, passordhash);
		return d;
	}

	public boolean isAllInputGyldig() {
		return isFornavnGyldig() && isEtternavnGyldig() && ismobilGyldig() && isPassordGyldig() && isPassordKopiGyldig()
				&& isKjonnGyldig();
	}

	public void settOppFeilmeldinger() {
		if (!isFornavnGyldig()) {
			fornavn = "";
			fornavnFeilmelding = "Ugyldig navn";
		}
		if (!isEtternavnGyldig()) {
			etternavn = "";
			etternavnFeilmelding = "Ugyldig etternavn";
		}
		if (!ismobilGyldig()) {
			mobil = "";
			mobilFeilmelding = "Ugyldig mobil";
		}
		if (!isPassordGyldig()) {
			passord = "";
			passordKopi = "";
			passordFeilmelding = "Ugyldig passord";
		}
		if (!isPassordKopiGyldig()) {
			passord = "";
			passordKopi = "";
			passordKopiFeilmelding = "Repetert passord stemmer ikke";
		}
		if (!isKjonnGyldig()) {
			kjonnFeilmelding = "Du må oppgi kjønnet ditt";
		}
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getFornavnFeilmelding() {
		return fornavnFeilmelding;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getEtternavnFeilmelding() {
		return etternavnFeilmelding;
	}

	public String getmobil() {
		return mobil;
	}

	public String getmobilFeilmelding() {
		return mobilFeilmelding;
	}

	public String getPassord() {
		return passord;
	}

	public String getPassordFeilmelding() {
		return passordFeilmelding;
	}

	public String getPassordKopi() {
		return passordKopi;
	}

	public String getPassordKopiFeilmelding() {
		return passordKopiFeilmelding;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getKjonnFeilmelding() {
		return kjonnFeilmelding;
	}

}