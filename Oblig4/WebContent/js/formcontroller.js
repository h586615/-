"use strict"

class formcontroller {
	constructor(root = null) {
		this.root = root;
		this.validator = new Validator();
	}

	run() {
		const root = document.getElementById("root");
		const fornavn = root.querySelector("input[name=fornavn]");
		fornavn.addEventListener("input", this.validator.validerFornavn());

	}
}