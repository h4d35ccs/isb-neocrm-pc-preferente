/**
 * 
 */
package com.isb.neocrm.pc.preferente.util;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ottoabreu
 * 
 */
@Component
public class ConstantsProvider {

	@Value("${app.constants.idempr}")
	private String idempr;
	@Value("${app.constants.dev1}")
	private String dev1;
	@Value("${app.constants.trx2}")
	private String trx2;
	@Value("${app.constants.b8ipspec}")
	private String b8ipspec;
	@Value("${app.constants.b8ip}")
	private String b8ip;
	@Value("${app.constants.beansb8ip}")
	private String beansb8ip;
	@Value("${app.clientid.cp}")
	private String codePersonRegex;
	@Value("${app.clientid.tp}")
	private String typePersonRegex;
	@Value("${app.constants.indicator.preferente}")
	private String indicatorPreferente;
	@Value("${app.constants.indicator.reactiva}")
	private String indicatorReactiva;
	@Value("${app.constants.indicator.clientexist}")
	private String indicatorClientExist;
	@Value("${app.constants.indicator.clientnoexist}")
	private String indicatorClientNOExist;

	@Value("${app.testenv}")
	private String testenv;

	public boolean isTestEnv() {
		if (testenv == null || testenv.equals("")
				|| testenv.equalsIgnoreCase("true")) {
			return false;
		} else {
			return true;
		}
	}

	public String getIndicatorPreferente() {
		return indicatorPreferente;
	}

	public String getIndicatorReactiva() {
		return indicatorReactiva;
	}

	public String getIndicatorClientExist() {
		return indicatorClientExist;
	}

	public String getIndicatorClientNOExist() {
		return indicatorClientNOExist;
	}

	public String getCodePersonRegex() {
		return codePersonRegex;
	}

	public String getTypePersonRegex() {
		return typePersonRegex;
	}

	public String getIdempr() {
		return idempr;
	}

	public String getDev1() {
		return dev1;
	}

	public String getTrx2() {
		return trx2;
	}

	public String getB8ipspec() {
		return b8ipspec;
	}

	public String getB8ip() {
		return b8ip;
	}

	public String getBeansb8ip() {
		return beansb8ip;
	}

	@PostConstruct
	public void seePropertiesLoaded() {
		Logger log = LoggerFactory.getLogger(ConstantsProvider.class);
		log.debug("Properties loaded: " + this.toString());
	}

	@Override
	public String toString() {
		return "[idempr=" + idempr + ", dev1=" + dev1 + ", trx2=" + trx2
				+ ", b8ipspec=" + b8ipspec + ", b8ip=" + b8ip + ", beansb8ip="
				+ beansb8ip + ", codePersonRegex=" + codePersonRegex
				+ ", typePersonRegex=" + typePersonRegex
				+ ", indicatorPreferente=" + indicatorPreferente
				+ ", indicatorReactiva=" + indicatorReactiva
				+ ", indicatorClientExist=" + indicatorClientExist
				+ ", indicatorClientNOExist=" + indicatorClientNOExist
				+ ", testenv=" + testenv + "]";
	}

}
