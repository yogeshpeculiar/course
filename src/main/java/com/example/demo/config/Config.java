package com.example.demo.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Config {
	 @Bean
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	  LocalContainerEntityManagerFactoryBean em = new
	  LocalContainerEntityManagerFactoryBean(); em.setDataSource(dataSource);
	  em.setPackagesToScan(new String[] { "com.example" });
	  
	  JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	  em.setJpaVendorAdapter(vendorAdapter);
	  em.setJpaProperties(hibernateProperties());
	  
	  return em;
	  }
	  
	  @Bean public Properties hibernateProperties() { 
		  Properties properties = new Properties();
	  
	  properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	  properties.put("hibernate.show_sql", "true");
	  properties.put("hibernate.format_sql", "true");
	  properties.put("hibernate.hbm2ddl.auto", "none"); 
	  return properties; 
	  }
	  
	  @Bean 
	  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { 
		  JpaTransactionManager  transactionManager = new JpaTransactionManager();
	  transactionManager.setEntityManagerFactory(emf);
	  
	  return transactionManager;
	  }
	 
	/*
	 * @Autowired private DataSource dataSource; // It will automatically read
	 * database properties from application.properties and create DataSource object
	 * 
	 * @Autowired
	 * 
	 * @Bean(name = "sessionFactory") public LocalSessionFactoryBean
	 * getSessionFactory() { // creating session factory LocalSessionFactoryBean
	 * sessionFactory = new LocalSessionFactoryBean();
	 * sessionFactory.setDataSource(dataSource);
	 * sessionFactory.setPackagesToScan(new String[]{"com.example.demo"});
	 * sessionFactory.setHibernateProperties(hibernateProperties()); return
	 * sessionFactory; } private Properties hibernateProperties() { // configure
	 * hibernate properties Properties properties = new Properties();
	 * properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	 * properties.put("hibernate.show_sql", "true");
	 * properties.put("hibernate.hbm2ddl.auto", "none"); return properties; }
	 * 
	 * @Autowired
	 * 
	 * @Bean(name = "transactionManager") // creating transaction manager factory
	 * public HibernateTransactionManager getTransactionManager( SessionFactory
	 * sessionFactory) { HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager( sessionFactory); return transactionManager; }
	 */
}
