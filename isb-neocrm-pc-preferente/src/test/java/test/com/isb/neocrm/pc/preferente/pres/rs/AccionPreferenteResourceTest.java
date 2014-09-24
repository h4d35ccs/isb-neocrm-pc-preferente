package test.com.isb.neocrm.pc.preferente.pres.rs;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.logic.domain.AccionPreferente;
import com.isb.neocrm.pc.preferente.logic.domain.AccionReactiva;
import com.isb.neocrm.pc.preferente.logic.domain.NoAccion;
import com.isb.neocrm.pc.preferente.pres.rs.AccionPreferenteResource;

import test.com.isb.neocrm.pc.preferente.testhelper.GenericDBTestClass;

public class AccionPreferenteResourceTest extends GenericDBTestClass {

	@Autowired
	private AccionPreferenteResource accionPreferenteResource;
	
	@Test
	public void testGetAccPrefByIdPreferente() {
		Accion accion = this.accionPreferenteResource.getAccPrefById(
				TYPE_IN_DATASET_TO_TEST_PREF_E, ""
						+ CODE_IN_DATASET_TO_TEST_1111);
		assertTrue(accion instanceof AccionPreferente);
	}
	
	@Test
	public void testGetAccPrefByIdReactiva() {
		Accion accion = this.accionPreferenteResource.getAccPrefById(
				TYPE_IN_DATASET_TO_TEST_REACT_P, ""
						+ CODE_IN_DATASET_TO_TEST_1111);
		assertTrue(accion instanceof AccionReactiva);
	}

	@Test
	public void testGetAccPrefByIdNoAccion() {
		Accion accion = this.accionPreferenteResource.getAccPrefById(
				TYPE_NOT_IN_DATASET_TO_TEST, "" + CODE_NOT_IN_DATASET_TO_TEST);
		assertTrue(accion instanceof NoAccion);
	}

}
