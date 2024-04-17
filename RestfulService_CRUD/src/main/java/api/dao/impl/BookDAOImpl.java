package api.dao.impl;

import java.util.List;

import org.hibernate.Session;

import api.dao.BookDAO;
import api.entities.Book;
import api.util.HibernateUtil;

public class BookDAOImpl implements BookDAO{

	@Override
	public List<Book> getBooks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Book").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new BookDAOImpl().getBooks().size());
	}
	@Override
	public Book getBookById(String isbn) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Book book = session.get(Book.class, isbn);
			return book;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertBook(Book b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(b);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateBook(Book b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(b);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteBook(String isbn) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(getBookById(isbn));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Book> getBooksByName(String bookName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if(bookName==null || bookName.length()==0)
				bookName = "%";
			else
				bookName = "%"+bookName+"%";
			List list = session.createQuery("from Book where bookName like :bookName")
					.setParameter("bookName", bookName)
					.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
