/**
 * 
 */
package test.com.isb.neocrm.pc.preferente.testhelper;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.com.isb.neocrm.pc.preferente.testhelper.setup.DerbyDBSetup;

/**
 * @author ottoabreu
 *
 */
public abstract class GenericDBTestClass extends GenericTestClass {
	
	public static int CODE_IN_DATASET_TO_TEST_1111 = 1111;
	public static String TYPE_IN_DATASET_TO_TEST_PREF_E = "e";
	public static String TYPE_IN_DATASET_TO_TEST_REACT_P = "g";
	
	public static int CODE_NOT_IN_DATASET_TO_TEST = 8888;
	public static String TYPE_NOT_IN_DATASET_TO_TEST = "n";
	
	public static final String INVALID_STRING_CODE="invalidNotANumber";
	public static final String INVALID_STRING_TYPE="invalidShouldBeACharacter";
	
	
	@BeforeClass
	public static void setUp() throws ClassNotFoundException,
			UnsupportedEncodingException, SQLException, DatabaseUnitException {
		DerbyDBSetup derbySetup = getDerbyDBSetupBean();
		derbySetup.setUpDerby();
	}

	@AfterClass
	public static void tearDown() throws ClassNotFoundException, SQLException {
		DerbyDBSetup derbySetup = getDerbyDBSetupBean();
		derbySetup.dropDatabase();
	}
	
	public static DerbyDBSetup getDerbyDBSetupBean() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		return ctx.getBean(DerbyDBSetup.class);
	}
}
