//package ECommerce.config;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import ECommerce.model.Category;
//
//
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan("ECommerce")
//public class DBConfig {
//	@Bean(name="dataSource")
//	public DataSource getH2DataSource()
//	{
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl("jdbc:h2:~/test");
//		dataSource.setUsername("Ecommerce");
//		dataSource.setPassword("Ecommerce");
//		
//		System.out.println("------DataSource Object is Created------");
//		
//		return dataSource;
//	}
//	
//	@Bean(name="sessionFactory")
//	
//	public SessionFactory getSessionFactory() {
//		Properties hibernateProp = new Properties();
//		hibernateProp.put("hibernate.hbm2ddl.auto","update");
//		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
//		
//		LocalSessionFactoryBuilder localFactory = new LocalSessionFactoryBuilder(getH2DataSource());
//		localFactory.addProperties(hibernateProp);
//		localFactory.addAnnotatedClass(Category.class);
//		
//		System.out.println("------SessionFactory Object is Created------");
//		return localFactory.buildSessionFactory();
//		
//	}
//	
//	@Bean(name="txManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
//	{
//		System.out.println("------Transaction Manager Object Created------");
//		
//		return new HibernateTransactionManager(sessionFactory);
//	}
//	
//}


package ECommerce.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("ECommerce")
public class DBConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/test");
        dataSource.setUsername("Ecommerce");
        dataSource.setPassword("Ecommerce");

        System.out.println("DataSource Object is Created");

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ECommerce.model");

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        sessionFactory.setHibernateProperties(hibernateProperties);

        System.out.println("SessionFactory Object is Created");
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory.getObject());
        System.out.println("Transaction Manager Object Created");
        return txManager;
    }
}
