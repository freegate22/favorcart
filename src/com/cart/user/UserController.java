package com.cart.user;

import com.cart.HibernateUtil;
import com.cart.bookmark.Bookmark;
import com.cart.folder.Folder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hansik on 2015. 9. 26..
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public ModelAndView user() {

        Session hbSession = null;
        Transaction tx = null;

        Bookmark bookmark = new Bookmark();
        bookmark.setName("aa");
        bookmark.setCategoryId(1);
        bookmark.setUrl("aa");

        Folder folder = new Folder();
        folder.setName("test3");

        User user = new User();
        user.setId("aa");
        user.setPassword("bb");



        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            tx = hbSession.beginTransaction();
            System.out.println("suc");
            User aa = (User) hbSession.get(User.class, "aa");
            System.out.println(aa);
//            hbSession.save(folder);
//            hbSession.save(user);
            // Hibernate 세션을 이용한 CRUD 처리 코드

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
