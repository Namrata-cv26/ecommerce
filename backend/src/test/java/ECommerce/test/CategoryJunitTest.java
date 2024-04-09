package ECommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ECommerce.DAO.CategoryDAO;
import ECommerce.model.Category;

public class CategoryJunitTest {

	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("ECommerce");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("Mobile");
		category.setCategoryDesc("All Brands of Mobiles");
		
		assertTrue("Problem in adding category",categoryDAO.addCategory(category));
	}

}
