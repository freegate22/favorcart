package main.java.com.cart.bookmark;

import main.java.com.cart.HibernateUtil;
import main.java.com.cart.common.Cart;
import main.java.com.cart.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.Date;

/**
 * Created by hshs on 2015. 9. 26..
 */
@Repository
public class BookmarkDao {

    public Cart update(Cart cart){

        String id = cart.getId();
        long regDate = Long.parseLong(cart.getRegDate());
        Cart.Action action = Cart.Action.valueOf(cart.getAction());

        Bookmark newBookmark = new Bookmark();
        newBookmark.setId(Integer.parseInt(id));
        newBookmark.setFolderId(Integer.parseInt(cart.getFolderId()));
        newBookmark.setName(cart.getName());
        newBookmark.setUrl(cart.getUrl());
        newBookmark.setRegDate(new Date(regDate));


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Bookmark bookmark = (Bookmark) session.get(id , Bookmark.class);
        boolean isReturn = false;
        switch(action){
            case ADD :
                if( bookmark != null){
                    session.save(newBookmark);
                    isReturn = true;
                }
                break;

            case EDIT :
                if( bookmark == null || bookmark.getRegDate().getTime() < regDate ){
                    session.saveOrUpdate(newBookmark);
                    isReturn = true;
                }
                break;
            case REMOVE :
                if( bookmark != null){
                    session.delete(newBookmark);
                    isReturn = true;
                }
                break;
            default:
                break;
        }



        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        if(isReturn){
            return cart;
        } else {
            return null;
        }
    }

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
