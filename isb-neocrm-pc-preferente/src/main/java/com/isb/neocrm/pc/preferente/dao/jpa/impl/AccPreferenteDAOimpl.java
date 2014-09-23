package com.isb.neocrm.pc.preferente.dao.jpa.impl;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import BeansB8IP.DatosCampania;
import BeansB8IP.Persona;
import Gea.Estigia.HOSTInterface;
import Gea.Tanatos.*;

import com.isb.neocrm.pc.preferente.dao.AccPreferenteDAO;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccPreferenteEntity;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccReactivaEntity;

/**
 * Implementación del AccPreferenteDAO
 * Author: schamorro
 * Date: 16/09/14.
 */

@Repository("accPrefDao")
public class AccPreferenteDAOimpl implements AccPreferenteDAO {
	
	private static final Logger log = LoggerFactory.getLogger(AccPreferenteDAOimpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private String n_codclase;
	private String n_codpersona;
	private String n_campania;
	private String d_campania1;
	private String d_campania2;
	private String d_campania3;
	private String fechabolsa;
	private String n_centro;
	private String n_directriz;
	private String n_empresa;
	private String n_subevento;
	private String n_tipoevento;
	private String n_codgestor;
	private String n_ocurrencia;
	private String n_ordensecue;
	private String n_tipopersona;
	
	private String n_descripcion1;
	private String n_descripcion2;
	private String n_descripcion3;
	private String n_descripcion4;
	private String n_descripcion5;
	private String n_descripcion6;
	private String n_descripcion7;
	private String n_descripcion8;
	private String n_descripcion9;
	private String n_descripcion10;
	private String n_descripcion11;
	private String n_descripcion12;
	private String n_descripcion13;
	private String n_descripcion14;
	private String n_descripcion15;
	private String n_descripcion16;
	private String n_descripcion17;
	private String n_descripcion18;
	private String n_descripcion19;
	private String n_descripcion20;
	
	
	
	
	public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    @Transactional
    public AccPreferenteEntity getAccionPreferente(String id) throws DataAccessException{
        
    	AccPreferenteEntity accpref = new AccPreferenteEntity();
    	
    	log.info("Obteniendo la AccionPreferente");
    	n_tipopersona = id.substring(0, 1);
    	n_codpersona = id.substring(1, id.length());
    	
    	
		log.info("Se envian los datos de la transacción");
    	Persona pers=new Persona();
    	pers.setCodigopersona("001284553");
    	pers.setEmpresa("0049");
    	pers.setTipopersona("F");
   
    	
    	DatosCampania datos=new DatosCampania();
    	
    	
    	log.info("Se invoca el componente");
    	HOSTInterface HF=new HOSTInterface("DEV1", "TRX2");
    	    	
    	try{
    		datos=(DatosCampania)HF.executeTRX("B8IP_spec", "B8IP", pers, "BeansB8IP.DatosCampania");
    	}
    	catch(FunctionalException fx){
    		System.out.println("ERROR:"+fx.getErrorDescription());
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	
    	log.info("Se obtienen los datos de la Campaña");
    	n_codclase = datos.getCodigoclase();
    	n_campania = datos.getCampania();
    	d_campania1 = datos.getDescripcampania1();
    	d_campania2 = datos.getDescripcampania2();
    	d_campania3 = datos.getDescripcampania3();
    	fechabolsa = datos.getFechabolsa();
    	n_centro = datos.getCentro();
    	n_directriz = datos.getDirectriz();
    	n_empresa = datos.getEmpresa();
    	n_subevento = datos.getSubevento();
    	n_tipoevento = datos.getTipoevento();
    	n_codgestor = datos.getCodigogestor();
    	n_ocurrencia = datos.getOcurrencia();
    	n_ordensecue = datos.getOrdensecue();
    	    	
    	n_descripcion1 = datos.getDescripcion1();   	
    	n_descripcion2 = datos.getDescripcion2();
    	n_descripcion3 = datos.getDescripcion3();
    	n_descripcion4 = datos.getDescripcion4();
    	n_descripcion5 = datos.getDescripcion5();
    	n_descripcion6 = datos.getDescripcion6();
    	n_descripcion7 = datos.getDescripcion7();
    	n_descripcion8 = datos.getDescripcion8();
    	n_descripcion9 = datos.getDescripcion9();
    	n_descripcion10 = datos.getDescripcion10();
    	n_descripcion11 = datos.getDescripcion11();   	
    	n_descripcion12 = datos.getDescripcion12();
    	n_descripcion13 = datos.getDescripcion13();
    	n_descripcion14 = datos.getDescripcion14();
    	n_descripcion15 = datos.getDescripcion15();
    	n_descripcion16 = datos.getDescripcion16();
    	n_descripcion17 = datos.getDescripcion17();
    	n_descripcion18 = datos.getDescripcion18();
    	n_descripcion19 = datos.getDescripcion19();
    	n_descripcion20 = datos.getDescripcion20();
    	
    	
    	    	
    	int int_n_codpersona = Integer.parseInt(n_codpersona);
    	
    	
    	log.info("Se consulta por la Acción Preferente");
    	Query query = getEntityManager().createQuery("SELECT E FROM AccPreferenteEntity E WHERE E.tipopers = :TIPOPERS AND E.codpers = :CODPERS AND E.codclase = :CODCLASE AND E.idtipeve = :IDTIPEVE AND E.idsubeve = :IDSUBEVE");
    	
    	query = query.setParameter("TIPOPERS",n_tipopersona);
    	query = query.setParameter("CODPERS",int_n_codpersona);
    	query = query.setParameter("CODCLASE",n_codclase);
    	query = query.setParameter("IDTIPEVE",n_tipoevento);
    	query = query.setParameter("IDSUBEVE",n_subevento);
    	
    	try
    	{
    		AccPreferenteEntity results_accpref = (AccPreferenteEntity) query.getSingleResult();
    		if (results_accpref == null){
    		
    		}
    		return results_accpref;
    	}
    	catch (NoResultException nre){
    		System.out.println("ESTE CLIENTE NO TIENE ACCIONES PREFERENTES");
    		}
		return accpref;
   }
    
    @Transactional
    public AccReactivaEntity getAccionReactiva(String id) throws DataAccessException{
    	
    	AccReactivaEntity accreact = new AccReactivaEntity();
    	
    	log.info("Obteniendo la AccionReactiva");
    	n_tipopersona = id.substring(0, 1);
    	n_codpersona = id.substring(1, id.length());
    	   	
    	
		log.info("Se envian los datos de la transacción");
    	Persona pers=new Persona();
    	pers.setCodigopersona("001284553");
    	pers.setEmpresa("0049");
    	pers.setTipopersona("F");
   
    	
    	DatosCampania datos=new DatosCampania();
    	
    	
    	log.info("Se invoca el componente");
    	HOSTInterface HF=new HOSTInterface("DEV1", "TRX2");
    	    	
    	try{
    		datos=(DatosCampania)HF.executeTRX("B8IP_spec", "B8IP", pers, "BeansB8IP.DatosCampania");
    	}
    	catch(FunctionalException fx){
    		System.out.println("ERROR:"+fx.getErrorDescription());
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	
    	log.info("Se obtienen los datos de la Campaña");
    	n_codclase = datos.getCodigoclase();
    	n_campania = datos.getCampania();
    	d_campania1 = datos.getDescripcampania1();
    	d_campania2 = datos.getDescripcampania2();
    	d_campania3 = datos.getDescripcampania3();
    	fechabolsa = datos.getFechabolsa();
    	n_centro = datos.getCentro();
    	n_directriz = datos.getDirectriz();
    	n_empresa = datos.getEmpresa();
    	n_subevento = datos.getSubevento();
    	n_tipoevento = datos.getTipoevento();
    	n_codgestor = datos.getCodigogestor();
    	n_ocurrencia = datos.getOcurrencia();
    	n_ordensecue = datos.getOrdensecue();
    	    	
    	n_descripcion1 = datos.getDescripcion1();   	
    	n_descripcion2 = datos.getDescripcion2();
    	n_descripcion3 = datos.getDescripcion3();
    	n_descripcion4 = datos.getDescripcion4();
    	n_descripcion5 = datos.getDescripcion5();
    	n_descripcion6 = datos.getDescripcion6();
    	n_descripcion7 = datos.getDescripcion7();
    	n_descripcion8 = datos.getDescripcion8();
    	n_descripcion9 = datos.getDescripcion9();
    	n_descripcion10 = datos.getDescripcion10();
    	n_descripcion11 = datos.getDescripcion11();   	
    	n_descripcion12 = datos.getDescripcion12();
    	n_descripcion13 = datos.getDescripcion13();
    	n_descripcion14 = datos.getDescripcion14();
    	n_descripcion15 = datos.getDescripcion15();
    	n_descripcion16 = datos.getDescripcion16();
    	n_descripcion17 = datos.getDescripcion17();
    	n_descripcion18 = datos.getDescripcion18();
    	n_descripcion19 = datos.getDescripcion19();
    	n_descripcion20 = datos.getDescripcion20();
    	
    	
    	
    	int int_n_codpersona = Integer.parseInt(n_codpersona);
    	    	
    	log.info("Se consulta por la Acción Reactiva");
    	Query query2 = getEntityManager().createQuery("SELECT E FROM AccReactivaEntity E WHERE E.idempr = :IDEMPR AND E.tipopers = :TIPOPERS AND E.codpers = :CODPERS");
    	
    	query2 = query2.setParameter("IDEMPR","0049");
    	query2 = query2.setParameter("TIPOPERS",n_tipopersona);
    	query2 = query2.setParameter("CODPERS",int_n_codpersona);
    	    	
    	try
    	{
    		AccReactivaEntity results_accreact = (AccReactivaEntity) query2.getSingleResult();
    		if (results_accreact == null){
    		
    		}
    		return results_accreact;
    	}
    	catch (NoResultException nre){
    		System.out.println("ESTE CLIENTE NO TIENE ACCIONES COMERCIALES");
    		}
		return accreact;
    }
}
