package main.java.com.cart.folder;

import main.java.com.cart.HibernateUtil;
import main.java.com.cart.common.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by hansik on 2015. 9. 26..
 */
@Repository
public class FolderDao {

    public Cart update(Cart cart){

        String id = cart.getId();
        long regDate = Long.parseLong(cart.getRegDate());
        Cart.Action action = Cart.Action.valueOf(cart.getAction());

        Folder newFolder = new Folder();
        newFolder.setId(Integer.parseInt(id));
        newFolder.setFolderId(Integer.parseInt(cart.getFolderId()));
        newFolder.setName(cart.getName());
        newFolder.setRegDate(new Date(regDate));


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Folder folder = (Folder) session.get(id , Folder.class);
        boolean isReturn = false;
        switch(action){
            case ADD :
                if( folder != null){
                    session.save(newFolder);
                    isReturn = true;
                }
                break;

            case EDIT :
                if( folder == null || folder.getRegDate().getTime() < regDate ){
                    session.saveOrUpdate(newFolder);
                    isReturn = true;
                }
                break;
            case REMOVE :
                if( folder != null){
                    session.delete(newFolder);
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
}
