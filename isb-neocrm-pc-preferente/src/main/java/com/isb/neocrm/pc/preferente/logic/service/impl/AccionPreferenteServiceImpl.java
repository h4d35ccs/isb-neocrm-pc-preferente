package com.isb.neocrm.pc.preferente.logic.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.neocrm.pc.preferente.dao.AccPreferenteDAO;
import com.isb.neocrm.pc.preferente.dao.exception.DAOException;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccPreferenteEntity;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccReactivaEntity;
import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.logic.domain.AccionPreferente;
import com.isb.neocrm.pc.preferente.logic.domain.AccionReactiva;
import com.isb.neocrm.pc.preferente.logic.domain.NoAccion;
import com.isb.neocrm.pc.preferente.logic.exception.NotValidEventIDException;
import com.isb.neocrm.pc.preferente.logic.exception.ServiceException;
import com.isb.neocrm.pc.preferente.logic.service.AccionPreferenteService;
import com.isb.neocrm.pc.preferente.util.ConstantsProvider;

/**
 * Implementación del servicio de Accion Preferente. Author: schamorro Date:
 * 16/09/14.
 */
@Service("accprefService")
public class AccionPreferenteServiceImpl implements AccionPreferenteService {

	private static final Logger log = LoggerFactory
			.getLogger(AccionPreferenteServiceImpl.class);

	@Autowired
	private AccPreferenteDAO accPrefDao;

	@Autowired
	private ConstantsProvider constantProvider;

	@Override
	public Accion getAccPrefById(String personType, String personCode) {

		Accion accion = null;
		try {
			accion = this.getAction(personType, personCode);

		} catch (Exception e) {
			this.handleError(e);
		}
		return accion;
	}

	private Accion getAction(String personType, String personCode) {

		this.validateInputParams(personType, personCode);
		int codePersInt = Integer.parseInt(personCode);
		Accion accion = this.getAccionByClient(personType, codePersInt);

		if (accion == null) {
			log.debug("Referente accion not found, returning reactive");
			accion = new NoAccion();
		}

		return accion;
	}

	private Accion getAccionByClient(String personType, int codePersInt) {
		log.debug("Getting Preferente accion");
		Accion action = this.getPrefActionById(personType, codePersInt);

		if (action == null) {
			log.debug("Preferente accion not found, getting reactive");
			action = this.getReactActionById(personType, codePersInt);
		}
		return action;
	}

	private Accion getPrefActionById(String personType, int codePersInt) {
		Accion action = null;

		AccPreferenteEntity entityPref = accPrefDao.getAccionPreferente(
				personType, codePersInt);

		if (entityPref != null) {
			action = AccionPreferenteToClientFactory(entityPref);
		}

		return action;
	}

	private static Accion AccionPreferenteToClientFactory(
			AccPreferenteEntity accPref) {

		AccionPreferente accionPref = new AccionPreferente();
		accionPref.setActionText(accPref.getLongDescription());
		accionPref.setActionImage(accPref.getIMAGEN());
		return accionPref;
	}

	private Accion getReactActionById(String personType, int codePersInt) {
		Accion action = null;

		AccReactivaEntity accReact = accPrefDao.getAccionReactiva(personType,
				codePersInt);

		if (accReact != null) {
			action = AccionReactToClientFactory(accReact);
		}

		return action;
	}

	private static Accion AccionReactToClientFactory(AccReactivaEntity accReact) {

		AccionReactiva accionReact = new AccionReactiva();
		accionReact.setActionText(accReact.getDESC_LARGA());
		accionReact.setActionDescription(accReact.getDESC_CORTA());
		accionReact.setActionImage(accReact.getIMAGEN());
		return accionReact;
	}

	private void handleError(Exception e) {

		if (e instanceof DAOException) {
			throw (DAOException) e;
		} else if (e instanceof NotValidEventIDException) {
			throw (NotValidEventIDException) e;
		}
		log.error("Can not get the data because an error: ", e);
		throw new ServiceException(e);
	}

	private void validateInputParams(String personType, String personCode) {
		if (personType != null && personCode != null) {
			this.validatePersonType(personType);
			this.validatePersonCode(personCode);
		} else {
			log.error(NotValidEventIDException.NOT_VALID_NULL_PARAM
					+ personType + " - " + personCode);
			throw new NotValidEventIDException(
					NotValidEventIDException.NOT_VALID_NULL_PARAM + personType
							+ " - " + personCode);
		}
	}

	private void validatePersonType(String personType) {

		this.validateParams(this.constantProvider.getTypePersonRegex(),
				personType);
	}

	private void validatePersonCode(String personCode) {
		this.validateParams(this.constantProvider.getCodePersonRegex(),
				personCode);
	}

	private void validateParams(String regex, String toValidate) {
		log.debug("Validating with regex:" + regex + " - " + toValidate);
		Matcher matcher = this.getMatcher(regex, toValidate);
		boolean valid = matcher.matches();
		log.debug("is valid? " + valid);
		if (!valid) {
			log.error(NotValidEventIDException.NOT_VALID_PARAM + toValidate);
			throw new NotValidEventIDException(
					NotValidEventIDException.NOT_VALID_PARAM + toValidate);
		}

	}

	private Matcher getMatcher(String regex, String scan) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(scan);
		return matcher;
	}
}