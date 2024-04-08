package ECommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ECommerce.DAO.CategoryDAO;
import ECommerce.config.DBConfig;
import ECommerce.model.Category;

public class CategoryJunitTest {
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst() {
	    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	    categoryDAO = context.getBean(CategoryDAO.class);
	}

	
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("Mobile");
		category.setCategoryDesc("All Brands Of Mobiles");
		
		assertTrue("Problem in adding Category ", categoryDAO.addCategory(category));
		
		
	}
}
