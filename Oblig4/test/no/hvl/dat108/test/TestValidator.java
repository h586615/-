package no.hvl.dat108.test;

import org.junit.Assert;
import org.junit.Test;

import objekt.Validator;

public class TestValidator {

	private final Validator validator = new Validator();

	@Test
	public void testValiderFornavn() {
		Assert.assertTrue(validator.validFornavn("Tallah"));
		Assert.assertFalse(validator.validFornavn("ola"));
		Assert.assertFalse(validator.validFornavn(null));
		Assert.assertFalse(validator.validFornavn("ajjajajajajaajajajeijjioqweoqwjoiejqweqweqweqw"));
		Assert.assertFalse(validator.validFornavn("123124122131241"));
		Assert.assertFalse(validator.validFornavn("     "));
	}

	@Test
	public void testValiderEtternavn() {
		Assert.assertTrue(validator.validEtternavn("Nilsen"));
		Assert.assertFalse(validator.validEtternavn(null));
		Assert.assertFalse(validator.validEtternavn("Ole_nord"));
		Assert.assertFalse(validator.validEtternavn("iqweiqweiqwiejiqwehoqwhodqowhudqwuidqwuiqwekpqkwe"));
		Assert.assertFalse(validator.validEtternavn("21831273172371"));
		Assert.assertFalse(validator.validEtternavn("ole"));

		// Assert.assertFalse(validator.validEtternavn("Ola nordmann"));
	}

	@Test
	public void testValiderMobil() {
		Assert.assertTrue(validator.validMobil("98674553"));
		Assert.assertFalse(validator.validMobil("7327"));
		Assert.assertFalse(validator.validMobil("uwqueueq"));
		Assert.assertFalse(validator.validMobil(null));
	}

	@Test
	public void testValiderKjonn() {
		Assert.assertTrue(validator.validKjonn("mann"));
		Assert.assertTrue(validator.validKjonn("kvinne"));
		Assert.assertFalse(validator.validKjonn(null));
		Assert.assertFalse(validator.validKjonn("annet"));
	}

	@Test
	public void testValiderPassord() {
		Assert.assertTrue(validator.validPassord("12345"));
		Assert.assertFalse(validator.validPassord("123"));
		Assert.assertFalse(validator.validPassord(null));
		Assert.assertFalse(validator.validPassord(""));
	}

	@Test
	public void testRepValiderPassord() {
		Assert.assertTrue(validator.validerPassordRepetert("12345", "12345"));
		Assert.assertTrue(validator.validerPassordRepetert(null, null));
		Assert.assertFalse(validator.validerPassordRepetert("12345", "56789"));
		Assert.assertFalse(validator.validerPassordRepetert(null, "12345"));
	}

}
