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

    public void add(Bookmark bookmark) {
        bookmarkDao.save(bookmark);
    }

    public List<Cart> update(List<Cart> lstBookmark) {

        List<Cart> lstResult = new ArrayList<Cart>();
        for(Cart cart : lstBookmark){
            bookmarkDao.update(cart);
        }
        return lstResult;
    }


    // db에서 타입에 해당하는 id 추출 select
    // 시간 비교
    // db에 없을 경우 > insert
    // db가 더 이를 경우 > db update
    // db가 더 느릴 경우 > select > return list 에 담기
    // broadcating - 1. push, 2. websocket, 3. request-response scheduller
    // 일단 하나만..


    // 1. json 뽑기
    // 2. action 순회
    // 3. 같은 폴더 또는 북마크인 경우 최신시간 정보를 이용해서 마지막명령 수행
    // 4. 달라진 부분 모아 respolse


}
