package com.cart.bookmark;

import com.cart.HibernateUtil;
import com.cart.folder.Folder;
import com.cart.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hansik on 2015. 9. 26..
 */

@Controller
public class BookmarkController {

    @RequestMapping("/hello")
    public ModelAndView hello() {

        Session hbSession = null;
        Transaction tx = null;

        Bookmark bookmark = new Bookmark();
        bookmark.setName("aabb");
        bookmark.setCategoryId(1);
        bookmark.setUrl("aabb" );

        Folder folder = new Folder();
        folder.setName("test3");

        User user = new User();
        user.setId("aa");
        user.setPassword("ccc");



        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            tx = hbSession.beginTransaction();

//            User user2 = (User) hbSession.get(User.class, "aa");
//            user2.setPassword("update");
//            hbSession.save(bookmark);
            hbSession.save(folder);

            System.out.println("succ");
            tx.commit();
        } catch(Exception ex) {
            if (tx != null) tx.rollback();
        } finally {
            hbSession.close();
        }

        String message = "Hello, Spring 3.0!";
        System.out.println(message);
        return new ModelAndView("home");
    }
}