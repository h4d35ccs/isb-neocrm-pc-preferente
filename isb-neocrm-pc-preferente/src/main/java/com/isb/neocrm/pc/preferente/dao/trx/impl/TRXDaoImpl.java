/**
 * 
 */
package com.isb.neocrm.pc.preferente.dao.trx.impl;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BeansB8IP.DatosCampania;
import BeansB8IP.Persona;
import Gea.Estigia.HOSTInterface;
import Gea.Tanatos.FunctionalException;
import Gea.Tanatos.TechnicalException;

import com.isb.neocrm.pc.preferente.dao.exception.DAOException;
import com.isb.neocrm.pc.preferente.dao.jpa.impl.AccPreferenteDAOimpl;
import com.isb.neocrm.pc.preferente.dao.trx.TRXDao;
import com.isb.neocrm.pc.preferente.util.ConstantsProvider;

/**
 * @author ottoabreu
 *
 */
@Repository
public class TRXDaoImpl implements TRXDao {
	
	private static final Logger log = LoggerFactory
			.getLogger(TRXDaoImpl.class);
	
	@Autowired
	private ConstantsProvider constantProvider;
	
	public DatosCampania getCompanyData(Persona pers) {
		DatosCampania datos = null;

		HOSTInterface host = this.getHOSTInterface();

		try {
			datos = this.getCompanyDataFromHOSTInterface(host, pers);
		} catch (FunctionalException fx) {
			log.error(
					"Functional Error while getting the company data: "
							+ fx.getErrorDescription(), fx);
			throw new DAOException(fx);
		} catch (TechnicalException fx) {
			log.error(
					"Functional Error while getting the company data: "
							+ fx.getErrorDescription(), fx);
			throw new DAOException(fx);
		} catch (Exception e) {
			log.error(
					"General Error while getting the company data: "
							+ e.getMessage(), e);
			throw new DAOException(e);
		}

		return datos;
	}

	private HOSTInterface getHOSTInterface() {
		log.info("Invoking HOSTInterface");
		log.debug("properties: "+constantProvider );
		HOSTInterface host = new HOSTInterface(constantProvider.getDev1(),
				constantProvider.getTrx2());
		return host;
	}

	private DatosCampania getCompanyDataFromHOSTInterface(HOSTInterface host,
			Persona pers) throws TechnicalException, FunctionalException {
		DatosCampania dc = null;

		if (this.constantProvider.isTestEnv()) {
			log.info("USING SIMULATED TRX IN PROPERTIES (trxvaluessimulator.properties)");
			dc = this.readSimulatedDataForTesting(pers.getTipopersona(),
					pers.getCodigopersona());
		} else {
			log.info("executing TRX");
			dc = (DatosCampania) host.executeTRX(
					constantProvider.getB8ipspec(), constantProvider.getB8ip(),
					pers, constantProvider.getBeansb8ip());
		}

		return dc;
	}


	// METODOS SOLO USADOS PARA PRUEBAS
	private DatosCampania readSimulatedDataForTesting(String personType,
			String personCode) {

		DatosCampania dc = null;
		java.util.Properties prop = new Properties();
		java.io.InputStream is = AccPreferenteDAOimpl.class.getClassLoader()
				.getResourceAsStream("trxvaluessimulator.properties");
		try {
			prop.load(is);
			String values = prop.getProperty(personType + personCode);
			if (values != null) {
				String[] valuesArray = values.split(",");
				String codClass = valuesArray[0];
				String eventType = valuesArray[1];
				String subeEvent = valuesArray[2];
				dc = new DatosCampania();
				dc.setCodigoclase(codClass);
				dc.setTipoevento(eventType);
				dc.setSubevento(subeEvent);
				this.setLongDescriptionForTesting(dc);
			}

		} catch (IOException e) {
			log.debug("TRX SIMULATED VALUES NOT FOUND (trxvaluessimulator.properties) ");
		}
		return dc;
	}

	private void setLongDescriptionForTesting(DatosCampania dc) {
		String desc1 = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean";
		String desc2 = "commodo ligula eget dolor. Aenean massa. Cum sociis natoque ";
		String desc3 = "penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ";
		String desc4 = "ultricies nec, pellentesque eu, pretium quis, sem. ";
		String desc5 = "Nulla consequat massa quis enim. Donec pede justo, ";
		String desc6 = "fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, ";
		String desc7 = "imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. ";
		String desc8 = "Integer tincidunt. ";
		String desc9 = "Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend";
		String desc10 = " tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, ";
		String desc11 = "dapibus in, viverra quis, feugiat a, tellus. ";
		String desc12 = "Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. ";
		String desc13 = "Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum ";
		String desc14 = "rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, ";
		String desc15 = "blandit vel, luctus pulvinar, hendrerit id, ";
		String desc16 = "lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis ";
		String desc17 = "faucibus. Nullam quis ante. ";
		String desc18 = "Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit";
		String desc19 = " amet nibh. Donec sodales sagittis magna. Sed consequat, ";
		String desc20 = "leo eget bibendum sodales, augue velit cursus nunc";
		dc.setDescripcion1(desc1);
		dc.setDescripcion2(desc2);
		dc.setDescripcion3(desc3);
		dc.setDescripcion4(desc4);
		dc.setDescripcion5(desc5);
		dc.setDescripcion6(desc6);
		dc.setDescripcion7(desc7);
		dc.setDescripcion8(desc8);
		dc.setDescripcion9(desc9);
		dc.setDescripcion10(desc10);
		dc.setDescripcion11(desc11);
		dc.setDescripcion12(desc12);
		dc.setDescripcion13(desc13);
		dc.setDescripcion14(desc14);
		dc.setDescripcion15(desc15);
		dc.setDescripcion16(desc16);
		dc.setDescripcion17(desc17);
		dc.setDescripcion18(desc18);
		dc.setDescripcion19(desc19);
		dc.setDescripcion20(desc20);

	}
}
