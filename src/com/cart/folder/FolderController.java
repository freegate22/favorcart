package com.cart.folder;

import com.cart.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by hansik on 2015. 9. 26..
 */


public class FolderController {
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
