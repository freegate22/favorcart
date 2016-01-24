package main.java.com.cart.bookmark;

import main.java.com.cart.common.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hshs on 2015. 9. 26..
 */
@Service
public class BookmarkService {

    @Autowired BookmarkDao bookmarkDao;

    public List<Cart> update(List<Cart> lstBookmark) {

        List<Cart> lstResult = new ArrayList<Cart>();
        for(Cart cart : lstBookmark){
            Cart returnCart = bookmarkDao.update(cart);
            if( returnCart != null){
                lstResult.add(returnCart);
            }
        }
        return lstResult;
    }


//    public void add(Bookmark bookmark) {
//        bookmarkDao.save(bookmark);
//    }

}
