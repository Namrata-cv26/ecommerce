package ECommerce.config;

//package ECommerce.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import com.atomikos.icatch.jta.UserTransactionManager;
//
//import ECommerce.DAO.CategoryDAO;
//import ECommerce.DAO.CategoryDAOImpl;
//import ECommerce.model.Category;
//import jakarta.transaction.TransactionManager;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan({"ECommerce","ECommerce.DAO"})
//public class DBConfig {
//	@Bean
//	public DataSource getH2DataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl(" jdbc:h2:tcp://localhost/~/ECommerce");
//		dataSource.setUsername("ECommerce");
//		dataSource.setPassword("ECommerce");
//		
//		System.out.println("------DataSource Object Created------");
//		return dataSource;
//	}
//	
//	@Bean
//	public SessionFactory getSessionFactory(DataSource dataSource) {
//	    Properties hibernateProp = new Properties();
//	    hibernateProp.put("hibernate.hbm2ddl.auto", "update");
////	    hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//	    hibernateProp.put("hibernate.transaction.jta.platform", "org.hibernate.service.jta.platform.internal.AtomikosJtaPlatform");
//	    LocalSessionFactoryBuilder localFactory = new LocalSessionFactoryBuilder(dataSource); // Use the provided dataSource parameter
//	    localFactory.addProperties(hibernateProp);
//	    localFactory.addAnnotatedClass(Category.class);
//	    System.out.println("------SessionFactory Object is Created------");
//	    return localFactory.buildSessionFactory();
//	}
//
//	
//	@Bean
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//		System.out.println("------Transaction Manager Object Created------");
//		return new HibernateTransactionManager(sessionFactory);
//		
//	}
//	
//	@Bean(name = "categoryDAO")
//	public CategoryDAO categoryDAO() {
//	    return new CategoryDAOImpl();
//	}
//	
//	@Bean
//    public PlatformTransactionManager transactionManager(HibernateTransactionManager userTransactionManager) {
//        JtaTransactionManager transactionManager = new JtaTransactionManager();
//        transactionManager.setUserTransactionName("java:comp/UserTransaction");
//        transactionManager.setTransactionManager((TransactionManager) userTransactionManager);
//        transactionManager.afterPropertiesSet();
//        return transactionManager;
//    }
//
//    @Bean(initMethod = "init", destroyMethod = "close")
//    public UserTransactionManager userTransactionManager() throws Throwable {
//        UserTransactionManager userTransactionManager = new UserTransactionManager();
//        userTransactionManager.init();
//        return userTransactionManager;
//    }
//}


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ECommerce.DAO.CategoryDAO;
import ECommerce.DAO.CategoryDAOImpl;
import ECommerce.model.Category;

@Configuration
@EnableTransactionManagement
@ComponentScan({"ECommerce","ECommerce.DAO"})
public class DBConfig {
    
    @Bean
    public DataSource getH2DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/ECommerce");
        dataSource.setUsername("ECommerce");
        dataSource.setPassword("ECommerce");
        System.out.println("------DataSource Object Created------");
        return dataSource;
    }
    
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.hbm2ddl.auto", "update");
        // Specify the correct Hibernate dialect for H2 database
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        
        LocalSessionFactoryBuilder localFactory = new LocalSessionFactoryBuilder(dataSource);
        localFactory.addProperties(hibernateProp);
        localFactory.addAnnotatedClass(Category.class);
        System.out.println("------SessionFactory Object is Created------");
        return localFactory.buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        System.out.println("------Transaction Manager Object Created------");
        return new HibernateTransactionManager(sessionFactory);
    }
    
    @Bean(name = "categoryDAO")
    public CategoryDAO categoryDAO() {
        return new CategoryDAOImpl();
    }
}

