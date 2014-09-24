package test.com.isb.neocrm.pc.preferente.pres.rs.api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.com.isb.neocrm.pc.preferente.testhelper.GenericTestClass;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.pres.rs.api.AccionResponse;
import com.isb.neocrm.pc.preferente.pres.rs.api.ErrorResponse;
import com.isb.neocrm.pc.preferente.pres.rs.api.Response;
import com.isb.neocrm.pc.preferente.pres.rs.api.ResponseFactory;

/**
 * The class <code>ResponseFactoryTest</code> contains tests for the class
 * {@link <code>ResponseFactory</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 22/09/14 23:05
 *
 * @author ottoabreu
 *
 * @version $Revision$
 */
public class ResponseFactoryTest extends GenericTestClass {

	
	@Autowired
	private ResponseFactory responseFactory;
	
	@Test
	public void testInstanciateEventoResponse(){
		Response response = responseFactory.instanciateAccionResponse(new Accion(){
			private static final long serialVersionUID = 1L;});
		assertTrue(response != null);
		assertTrue(response instanceof AccionResponse);
	}
	
	@Test
	public void testInstanciateErrorResponse(){
		Response response = responseFactory.instanciateErrorResponse(new Exception());
		assertTrue(response != null);
		assertTrue(response instanceof ErrorResponse);
	}
}

