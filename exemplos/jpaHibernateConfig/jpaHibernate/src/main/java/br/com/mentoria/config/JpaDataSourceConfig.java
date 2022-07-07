package br.com.mentoria.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"br.com.mentoria"})
@EnableTransactionManagement
public class JpaDataSourceConfig {

	
	@Value("${jpa.format.sql}")
	private String formatSQL;
	
	@Value("${jpa.show.sql}")
	private String showSQL;
	
	@Value("${jpa.dialect}")
	private String dialect;
	
	@Value("${jpa.ddl.auto}")
	private String ddlAuto;
	
	@Autowired
	private DataSource ds;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("br.com.mentoria.repository");
		factoryBean.setDataSource(ds);
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties p = new Properties();
		p.put("hibernate.dialect", dialect);
		p.put("hibernate.hb2ddl.auto", ddlAuto);
		p.put("hibernate.format_sql", formatSQL);
		p.put("hibernate.show_sql", showSQL);
		return p;
	}


	
}
