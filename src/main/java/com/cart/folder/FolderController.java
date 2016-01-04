package main.java.com.cart.folder;

import main.java.com.cart.HibernateUtil;
import main.java.com.cart.bookmark.Bookmark;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hansik on 2015. 9. 26..
 */

@Controller
@RequestMapping("/")
public class FolderController {

    @RequestMapping(value="/home")
    public ModelAndView home(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
    public static void main(String[] args) {



        Session hbSession = null;
        Transaction tx = null;

        try {
            hbSession = HibernateUtil.getSessionFactory().openSession();
            tx = hbSession.beginTransaction();
            System.out.println("suc");
            // Hibernate 세션을 이용한 CRUD 처리 코드

            tx.commit();
        } catch(Exception ex) {
            if (tx != null) tx.rollback();
        } finally {
            hbSession.close();
        }
    }
}
