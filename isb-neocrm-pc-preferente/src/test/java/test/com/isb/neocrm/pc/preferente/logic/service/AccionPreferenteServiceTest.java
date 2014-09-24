package test.com.isb.neocrm.pc.preferente.logic.service;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;

import test.com.isb.neocrm.pc.preferente.testhelper.GenericDBTestClass;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.logic.domain.AccionPreferente;
import com.isb.neocrm.pc.preferente.logic.domain.AccionReactiva;
import com.isb.neocrm.pc.preferente.logic.domain.NoAccion;
import com.isb.neocrm.pc.preferente.logic.exception.NotValidEventIDException;
import com.isb.neocrm.pc.preferente.logic.service.AccionPreferenteService;

public class AccionPreferenteServiceTest extends GenericDBTestClass {

	@Autowired
	private AccionPreferenteService accionPreferenteService;

	@Test
	public void testGetAccPrefByIdPreferente() {
		Accion accion = this.accionPreferenteService.getAccPrefById(
				TYPE_IN_DATASET_TO_TEST_PREF_E, ""
						+ CODE_IN_DATASET_TO_TEST_1111);
		assertTrue(accion instanceof AccionPreferente);
	}

	@Test
	public void testGetAccPrefByIdReactiva() {
		Accion accion = this.accionPreferenteService.getAccPrefById(
				TYPE_IN_DATASET_TO_TEST_REACT_P, ""
						+ CODE_IN_DATASET_TO_TEST_1111);
		assertTrue(accion instanceof AccionReactiva);
	}

	@Test
	public void testGetAccPrefByIdNoAccion() {
		Accion accion = this.accionPreferenteService.getAccPrefById(
				TYPE_NOT_IN_DATASET_TO_TEST, "" + CODE_NOT_IN_DATASET_TO_TEST);
		assertTrue(accion instanceof NoAccion);
	}

	@Test(expected = NotValidEventIDException.class)
	public void testGetEventoByIdInvalidCode() {
		this.accionPreferenteService.getAccPrefById(
				TYPE_NOT_IN_DATASET_TO_TEST, INVALID_STRING_CODE);
		fail("Should throw an NotValidEventIDException");
	}

	@Test(expected = NotValidEventIDException.class)
	public void testGetEventoByIdInvalidType() {
		this.accionPreferenteService.getAccPrefById(INVALID_STRING_TYPE, ""
				+ CODE_IN_DATASET_TO_TEST_1111);
		fail("Should throw an NotValidEventIDException");
	}

	@Test(expected = NotValidEventIDException.class)
	public void testGetEventoByIdNullType() {
		this.accionPreferenteService.getAccPrefById(null, ""
				+ CODE_IN_DATASET_TO_TEST_1111);
		fail("Should throw an NotValidEventIDException");
	}

	@Test(expected = NotValidEventIDException.class)
	public void testGetEventoByIdNullCode() {
		this.accionPreferenteService.getAccPrefById(
				TYPE_NOT_IN_DATASET_TO_TEST, null);
		fail("Should throw an NotValidEventIDException");
	}

}
