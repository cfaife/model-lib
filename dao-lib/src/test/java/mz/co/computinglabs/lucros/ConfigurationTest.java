package mz.co.computinglabs.lucros;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("mz.co.computinglabs.lucros")
public class ConfigurationTest {
	@Bean
	DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
		dataSource.setUrl("jdbc:hsqldb:mem:test;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean
			 = new LocalContainerEntityManagerFactoryBean();
		
		containerEntityManagerFactoryBean.setDataSource(dataSource());
		containerEntityManagerFactoryBean.setPersistenceUnitName("lucrosTestEntityManagerFactory");
		containerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		return containerEntityManagerFactoryBean;
	}
	
	@Bean
	PlatformTransactionManager transactionManager() {
 		return new DataSourceTransactionManager(dataSource());
				
	}
}
