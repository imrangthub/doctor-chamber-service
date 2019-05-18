package com.madbarsoft.doctorchamber.config;
/*package com.mysoft.prescriptionApp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistencePrescription.properties" })
@ComponentScan({"com.mysoft.prescriptionApp" })
@EnableJpaRepositories(basePackages = {"com.mysoft.prescriptionApp" })
public class PrescriptionPersistenceJPAConfig {

    @Autowired
    private Environment env;

    public PrescriptionPersistenceJPAConfig() {
        super();
    }

    //



    @Bean(name = "prescriptionDataSource", destroyMethod = "close")
    public DataSource dataSource() {
    	HikariConfig hikariConfig = new HikariConfig();
    	
    	hikariConfig.setDriverClassName(env.getProperty("jdbcPrescription.driverClassName"));
    	hikariConfig.setJdbcUrl(env.getProperty("jdbcPrescription.url"));
    	hikariConfig.setUsername(env.getProperty("jdbcPrescription.user"));
    	hikariConfig.setPassword(env.getProperty("jdbcPrescription.pass"));
    	
		hikariConfig.setMaximumPoolSize(5);
		hikariConfig.setConnectionTestQuery("SELECT 1");
		hikariConfig.setPoolName("springHikariCP");

		hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
    	
    	
    	
        return dataSource;
    }
    
    @Bean(name = "prescriptionEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.mysoft.prescriptionApp" });
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }
    
    @Bean(name="prescriptionTransactionManager")
    public JpaTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean(name = "prescriptionexceptionTranslation")
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    protected Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        return hibernateProperties;
    }

}*/