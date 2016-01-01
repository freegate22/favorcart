package main.java.com.cart.bookmark;

import main.java.com.cart.HibernateUtil;
import main.java.com.cart.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

/**
 * Created by hshs on 2015. 9. 26..
 */
@Repository
public class BookmarkDao {

    public void save(Bookmark bookmark){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(bookmark);

        System.out.println("book id" + bookmark.getId());
        session.getTransaction().commit();
        System.out.println("Insert completed");
        session.close();
        sessionFactory.close();
    }

    public void add(Bookmark bookmark){

    }
}
