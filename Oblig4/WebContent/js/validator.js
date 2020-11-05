"use strict"

class Validator {

	constructor() {
	}


	validerFornavn(str) {
		return str.length <= 20 && /^([A-ZØÆÅ][\\-\\sa-zA-ZæøåÆØÅ]+)/.test(str);

	}
	validerEtternavn(str) {
		return str.length <= 20 && /^([A-ZØÆÅ][\\sa-zA-ZæøåÆØÅ]+)/.test(str);
	}

	validerMobil(str) {
		return /^[0-9]{8}/.test(str);
	}

	validerPassord(str) {
		return str.length >= 4;
	}





}
