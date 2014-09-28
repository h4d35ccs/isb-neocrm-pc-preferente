package test.com.isb.neocrm.pc.preferente.testhelper.setup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionPropertiesHelper {

   
    @Value("${jdbc.user}")
    private String username;
    @Value("${jdbc.url}")
    private String connectionUrl;
    @Value("${jdbc.pass}")
    private String pass;
    
    
    
    public String getConnectionUrl() {
		return connectionUrl;
	}
	public String getPass() {
		return pass;
	}
	
    public String getUsername() {
        return username;
    }
}
