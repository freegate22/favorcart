package com.cart.bookmark;

import com.cart.HibernateUtil;
import com.cart.folder.Folder;
import com.cart.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;

/**
 * Created by hansik on 2015. 9. 26..
 */

@Controller
@RequestMapping("/{userId}/**")
public class BookmarkController {

    @RequestMapping(value="/add/bookmark/{bookmarkName}", method= RequestMethod.GET)
    public ModelAndView add(
            HttpServletRequest request,
            @PathVariable("userId") String userId,
            @PathVariable("bookmarkName") String bookmarkName) {

        String folderPath = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);


        Bookmark bookmark = new Bookmark();
        boo
        System.out.println(userId);
        System.out.println(folderPath);
        System.out.println(bookmarkName);

        Session hbSession = null;
        Transaction tx = null;
        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            tx = hbSession.beginTransaction();

//            User user2 = (User) hbSession.get(User.class, "aa");
//            user2.setPassword("update");
//            hbSession.save(bookmark);
//            hbSession.save(folder);

            System.out.println("succ");
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
        } finally {
            hbSession.close();
        }

        String message = "Hello, Spring 3.0!";
        System.out.println(message);
        return new ModelAndView("home");
    }

    @RequestMapping("/{userId}/hello")
    public ModelAndView hello(@PathVariable("userId") String userId) {

        Session hbSession = null;
        Transaction tx = null;

        Bookmark bookmark = new Bookmark();
        bookmark.setName("aabb");
        bookmark.setCategoryId(1);
        bookmark.setUrl("aabb");

        Folder folder = new Folder();
        folder.setName("test3");

        User user = new User();
        user.setId("aa");
        user.setPassword("ccc");

        System.out.println(userId);


        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            tx = hbSession.beginTransaction();

//            User user2 = (User) hbSession.get(User.class, "aa");
//            user2.setPassword("update");
//            hbSession.save(bookmark);
//            hbSession.save(folder);

            System.out.println("succ");
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
        } finally {
            hbSession.close();
        }

        String message = "Hello, Spring 3.0!";
        System.out.println(message);
        return new ModelAndView("home");
    }
}