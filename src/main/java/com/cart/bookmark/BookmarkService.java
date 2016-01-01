package main.java.com.cart.bookmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hshs on 2015. 9. 26..
 */
@Service
public class BookmarkService {

    @Autowired BookmarkDao bookmarkDao;

    public void add(Bookmark bookmark) {
        bookmarkDao.save(bookmark);
    }
}
