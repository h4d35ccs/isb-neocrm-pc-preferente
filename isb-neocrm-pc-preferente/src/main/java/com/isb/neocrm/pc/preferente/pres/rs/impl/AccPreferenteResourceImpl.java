/**
 * 
 */
package com.isb.neocrm.pc.preferente.pres.rs.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.logic.domain.AccionPreferente;
import com.isb.neocrm.pc.preferente.logic.domain.AccionReactiva;
import com.isb.neocrm.pc.preferente.logic.domain.NoAccion;
import com.isb.neocrm.pc.preferente.logic.service.AccionPreferenteService;
import com.isb.neocrm.pc.preferente.pres.rs.AccionPreferenteResource;
import com.isb.neocrm.pc.preferente.util.ConstantsProvider;

/**
 * @author ottoabreu
 * 
 */
@Component
public class AccPreferenteResourceImpl implements AccionPreferenteResource {

	@Autowired
	private AccionPreferenteService accPrefservice;

	@Autowired
	private ConstantsProvider constantProvider;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.isb.neocrm.pc.preferente.pres.rs.AccionPreferenteResource#getAccPrefById
	 * (java.lang.String)
	 */
	@Override
	public Accion getAccPrefById(String personType, String personCode) {
		Accion accPref = accPrefservice.getAccPrefById(personType, personCode);
		this.setActionAndIndicator(accPref);
		return accPref;
	}

	private void setActionAndIndicator(Accion action) {
		int indicator = 0;
		int reactive = 0;

		if (!(action instanceof NoAccion)) {
			AccionPreferente actionPrf = (AccionPreferente) action;
			if (action instanceof AccionReactiva) {

				indicator = Integer.parseInt(this.constantProvider
						.getIndicatorClientExist());
				reactive = Integer.parseInt(this.constantProvider
						.getIndicatorReactiva());

			} else if (action instanceof AccionPreferente) {

				indicator = Integer.parseInt(this.constantProvider
						.getIndicatorClientExist());
				reactive = Integer.parseInt(this.constantProvider
						.getIndicatorPreferente());

			}

			actionPrf.setIndicator(indicator);
			actionPrf.setAction(reactive);
		}
	}

}
