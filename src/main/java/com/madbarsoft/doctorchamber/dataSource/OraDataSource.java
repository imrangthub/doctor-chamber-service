package com.madbarsoft.doctorchamber.dataSource;
/*package com.mysoft.prescriptionApp.dataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:oracleDataSource.properties")
public class OraDataSource {
		
	@Autowired
	private Environment evn;


	private static HikariConfig config = new HikariConfig( "datasource.properties" );
    private static HikariDataSource ds;
 
    static {
   
    	config.setJdbcUrl( "jdbc_url" );
        config.setUsername( "database_username" );
        config.setPassword( "database_password" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }
 
    private OraDataSource() {
    
    	
    }
 
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
	
	
	  private static HikariDataSource ds;
	
	private  HikariDataSource getDataSource()
	{
			if(ds == null)
			{
				connection = DriverManager.getConnection(,env.getProperty("ora.user"),env.getProperty("ora.password"));

			HikariConfig config = new HikariConfig();
			
	        config.setJdbcUrl(env.getProperty("ora.url"));
	        config.setUsername("root");
	        config.setPassword("password");

	        config.setMaximumPoolSize(10);
	        config.setAutoCommit(false);
	        config.addDataSourceProperty("cachePrepStmts", "true");
	        config.addDataSourceProperty("prepStmtCacheSize", "250");
	        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
	        
	        ds = new HikariDataSource(config);
			}
			return ds;
	}
	
}
*/