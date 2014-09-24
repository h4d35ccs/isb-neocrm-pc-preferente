package test.com.isb.neocrm.pc.preferente.dao.jpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.isb.neocrm.pc.preferente.dao.AccPreferenteDAO;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccPreferenteEntity;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccReactivaEntity;

import test.com.isb.neocrm.pc.preferente.testhelper.GenericDBTestClass;

public class AccPreferenteDAOTest extends GenericDBTestClass {

	@Autowired
	private AccPreferenteDAO accPrefDao;

	@Test
	public void testGetAccionPreferente() {
		AccPreferenteEntity entity = accPrefDao.getAccionPreferente(
				TYPE_IN_DATASET_TO_TEST_PREF_E, CODE_IN_DATASET_TO_TEST_1111);
		assertTrue(entity != null);

	}
	
	@Test
	public void testGetAccionPreferenteNotPresent() {
		AccPreferenteEntity entity = accPrefDao.getAccionPreferente(
				TYPE_NOT_IN_DATASET_TO_TEST, CODE_NOT_IN_DATASET_TO_TEST);
		assertTrue(entity== null);

	}

	@Test
	public void testGetAccionReactiva() {
		AccReactivaEntity entity = accPrefDao.getAccionReactiva(
				TYPE_IN_DATASET_TO_TEST_REACT_P, CODE_IN_DATASET_TO_TEST_1111);
		assertTrue(entity != null);

	}
	
	@Test
	public void testGetAccionReactivaNotPresent() {
		AccReactivaEntity entity = accPrefDao.getAccionReactiva(
				TYPE_NOT_IN_DATASET_TO_TEST, CODE_NOT_IN_DATASET_TO_TEST);
		assertTrue(entity == null);

	}

}
