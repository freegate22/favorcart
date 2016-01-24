package main.java.com.cart.folder;

import main.java.com.cart.common.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hshs on 2015. 9. 26..
 */
@Service
public class FolderService {

    @Autowired FolderDao folderDao;

    public List<Cart> update(List<Cart> lstFolder) {

        List<Cart> lstResult = new ArrayList<Cart>();
        for(Cart cart : lstFolder){
            Cart returnCart = folderDao.update(cart);
            if( returnCart != null){
                lstResult.add(returnCart);
            }
        }

        return lstResult;
    }
}
