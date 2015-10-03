package com.cart.bookmark;

import com.cart.HibernateUtil;
import com.cart.category.Category;
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

        Category category = new Category();
        category.setId(1);
        category.setName("test1");
        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            tx = hbSession.beginTransaction();
            System.out.println("suc");
            // Hibernate 세션을 이용한 CRUD 처리 코드
            hbSession.save(category);
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