package com.isb.neocrm.pc.preferente.dao.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import BeansB8IP.DatosCampania;
import BeansB8IP.Persona;

import com.isb.neocrm.pc.preferente.dao.AccPreferenteDAO;
import com.isb.neocrm.pc.preferente.dao.exception.DAOException;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccPreferenteEntity;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccReactivaEntity;
import com.isb.neocrm.pc.preferente.dao.trx.TRXDao;
import com.isb.neocrm.pc.preferente.util.ConstantsProvider;

/**
 * Implementación del AccPreferenteDAO Author: schamorro Date: 16/09/14.
 */

@Repository("accPrefDao")
public class AccPreferenteDAOimpl implements AccPreferenteDAO {

	private static final Logger log = LoggerFactory
			.getLogger(AccPreferenteDAOimpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private TRXDao trxDao;
	@Autowired
	private ConstantsProvider constantProvider;

	@Override
	@Transactional
	public AccPreferenteEntity getAccionPreferente(String personType,
			int codePerson) {
		AccPreferenteEntity result = null;
		log.info("Obteniendo la AccionPreferente");
		Persona pers = getPersona(personType, codePerson);
		log.info("Se obtienen los datos de la Campaña");
		DatosCampania datos = trxDao.getCompanyData(pers);
		log.info("Se consulta por la Acci—n Preferente");
		if (datos != null) {
			result = getEntityFromDB(datos, personType, codePerson);
			this.setLongDescripcion(result, datos);
		}

		return result;
	}

	private Persona getPersona(String personType, int codePerson) {
		Persona pers = new Persona();
		pers.setCodigopersona(Integer.valueOf(codePerson).toString());
		pers.setEmpresa(constantProvider.getIdempr());
		pers.setTipopersona(personType);
		return pers;
	}

	private AccPreferenteEntity getEntityFromDB(DatosCampania datos,
			String personType, int codePerson) {
		AccPreferenteEntity result = null;

		try {
			String codClass = datos.getCodigoclase();
			String eventType = datos.getTipoevento();
			String subEvent = datos.getSubevento();
			log.debug("Executing query with obtained values: Codigoclase:"
					+ codClass + " Tipoevento: " + eventType + "subEvent "
					+ subEvent);
			result = (AccPreferenteEntity) this.entityManager
					.createNamedQuery("findAccionPreferente")
					.setParameter("TIPOPERS", personType)
					.setParameter("CODPERS", codePerson)
					.setParameter("CODCLASE", codClass)
					.setParameter("IDTIPEVE", eventType)
					.setParameter("IDSUBEVE", subEvent).getSingleResult();

		} catch (NoResultException e) {
			log.info("No preferente results found for: " + personType + " - "
					+ codePerson);
		} catch (Exception e) {
			log.error("Error while getting the data from the DB", e);
			throw new DAOException(e);
		}

		return result;

	}

	private void setLongDescripcion(AccPreferenteEntity entity,
			DatosCampania datos) {
		if (entity != null) {
			String longDescription = datos.getDescripcion1()
					+ datos.getDescripcion2() + datos.getDescripcion3()
					+ datos.getDescripcion4() + datos.getDescripcion5()
					+ datos.getDescripcion6() + datos.getDescripcion7()
					+ datos.getDescripcion8() + datos.getDescripcion9()
					+ datos.getDescripcion10() + datos.getDescripcion11()
					+ datos.getDescripcion12() + datos.getDescripcion13()
					+ datos.getDescripcion14() + datos.getDescripcion15()
					+ datos.getDescripcion16() + datos.getDescripcion17()
					+ datos.getDescripcion18() + datos.getDescripcion19()
					+ datos.getDescripcion20();
			entity.setLongDescription(longDescription);
		}
	}

	@Override
	@Transactional
	public AccReactivaEntity getAccionReactiva(String personType, int codePerson) {
		AccReactivaEntity result = null;
		log.info("Se consulta por la Acción Reactiva");
		try {
			result = (AccReactivaEntity) this.entityManager
					.createNamedQuery("findAccionReactiva")
					.setParameter("TIPOPERS", personType)
					.setParameter("CODPERS", codePerson)
					.setParameter("IDEMPR", this.constantProvider.getIdempr())
					.getSingleResult();

		} catch (NoResultException e) {
			log.info("No reactiva results found for: " + personType + " - "
					+ codePerson);
		} catch (Exception e) {
			log.error("Error while getting the data from the DB", e);
			throw new DAOException(e);
		}
		return result;
	}

}
