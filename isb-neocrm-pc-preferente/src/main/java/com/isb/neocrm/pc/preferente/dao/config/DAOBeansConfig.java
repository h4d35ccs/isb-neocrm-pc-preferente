package com.isb.neocrm.pc.preferente.dao.config;

import com.isb.neocrm.pc.preferente.dao.AccPreferenteDAO;
//import com.isb.neocrm.pc.preferente.dao.CampaniaDAO;
//import com.isb.neocrm.pc.preferente.dao.PersonaDAO;
import com.isb.neocrm.pc.preferente.dao.jpa.impl.AccPreferenteDAOimpl;
//import com.isb.neocrm.pc.preferente.dao.jpa.impl.CampaniaDAOimpl;
//import com.isb.neocrm.pc.preferente.dao.jpa.impl.PersonaDAOimpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Definición de los Beans utilizados
 * Author: schamorro
 * Date: 16/09/14.
 */
@Configuration
public class DAOBeansConfig {
    @Bean
    public AccPreferenteDAO accprefDAO() {
        return new AccPreferenteDAOimpl();
    }
}
