package test.com.isb.neocrm.pc.preferente.testhelper.setup;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.tools.ij;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class DerbyDBSetup {

	private static final Logger logger = LoggerFactory
			.getLogger(DerbyDBSetup.class);

	@Autowired
	private ConnectionPropertiesHelper propertiesHelper;
	
	private String username;
	
	private String pass;
	
	private String url;

	public void setUpDerby() throws ClassNotFoundException, SQLException,
			UnsupportedEncodingException, DatabaseUnitException {
		this.setupConnectionParams();
		String createUserParam = ";password="+this.pass+";user=" + this.username;

		try (Connection conn = this.createConnection(createUserParam)) {

			this.createTables(conn);
			logger.debug("Tables created in derby");
			this.insertDataIntoTables(conn);
			logger.debug("Data inserted into Tables in derby");
			conn.commit();
			conn.close();
			System.gc();
		}
	}

	private void setupConnectionParams() {
		this.url = propertiesHelper.getConnectionUrl();
		this.pass = propertiesHelper.getPass();
		this.username = propertiesHelper.getUsername();
		

	}

	private Connection createConnection(String extraParam) throws SQLException,
			ClassNotFoundException {

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		String completeUrl = this.url+extraParam;
		logger.debug("creating connection:"+completeUrl);
		return DriverManager.getConnection(completeUrl);
	}

	private void createTables(Connection connection)
			throws UnsupportedEncodingException {
		ij.runScript(connection,
				DerbyDBSetup.class.getResourceAsStream("/TestTables.sql"),
				"UTF-8", System.out, "UTF-8");
	}

	private void insertDataIntoTables(Connection connection)
			throws DatabaseUnitException, SQLException {

		IDataSet dataSet = new FlatXmlDataSetBuilder().build(Thread
				.currentThread().getContextClassLoader()
				.getResourceAsStream("Dataset.xml"));
		IDatabaseConnection databaseConnection = new DatabaseConnection(
				connection);
		DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, dataSet);
		
	}

	public void dropDatabase() throws ClassNotFoundException, SQLException {
		String dropParam = ";drop=true";
		this.setupConnectionParams();
		try (Connection conn = this.createConnection(dropParam)) {
			conn.close();
		} catch (Exception e) {
			// after droping throws this exception, is not an error
		}

	}

}
