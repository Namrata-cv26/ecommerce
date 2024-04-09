package ECommerce.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ECommerce.model.Category;

@Repository
@SuppressWarnings("deprecation")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Category> listCategories() {
		Session session = sessionFactory.openSession();
		org.hibernate.query.Query query = session.createQuery("from Category");
		List<Category> listCategories = query.list();
		session.close();
		return listCategories;
	}

	@Override
	public Category getCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class,categoryId);
		return null;
	}

}
