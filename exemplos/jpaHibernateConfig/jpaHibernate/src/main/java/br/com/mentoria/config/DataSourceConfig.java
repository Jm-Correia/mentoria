package br.com.mentoria.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	
	@Value("${ds.url}")
	private String url;
	
	@Value("${ds.driverClassName}")
	private String driverClassName;
	
	@Value("${ds.user.name}")
	private String userName;
	
	@Value("${ds.user.password}")
	private String userPassword;
	
	@Bean(name = "ds")
	public DataSource ds() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl(url);
		config.setUsername(userName);
		config.setPassword(userPassword);
		
		config.setMaximumPoolSize(5);
		config.setPoolName("JpaTestPool");
		
		return new HikariDataSource(config);
	}
}
