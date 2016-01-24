package main.java.com.cart.folder;

import main.java.com.cart.HibernateUtil;
import main.java.com.cart.common.Cart;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by hansik on 2015. 9. 26..
 */
@Repository
public class FolderDao {

    public Cart update(Cart cart){

        String id = cart.getId();
        long regDate = Long.parseLong(cart.getRegDate());
        Cart.Action action = Cart.Action.getType(cart.getAction());

        Folder newFolder = new Folder();
        newFolder.setId(id);
        newFolder.setFolderId(cart.getFolderId());
        newFolder.setName(cart.getName());
        newFolder.setUpdateTs(new Date(regDate));


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        System.out.println(id);
        String q = "SELECT id, folder_id, folder_name, update_ts FROM folder";
        Query query = session.createQuery(q);
//        query.setParameter("id", "11");
        List<Folder> lstFolder = query.list();

        System.out.println(lstFolder);
        Folder folder = null;
        if( lstFolder.size() > 0 ){
            folder =lstFolder.get(0);
        }

        boolean isReturn = false;
        switch(action){
            case ADD :
                if( folder != null){
                    session.save(newFolder);
                    isReturn = true;
                }
                break;

            case EDIT :
                if( folder == null || folder.getUpdateTs().getTime() < regDate ){
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
