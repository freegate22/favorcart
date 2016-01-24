package main.java.com.cart.folder;

import main.java.com.cart.common.Cart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hshs on 2015. 9. 26..
 */
@Service
public class FolderService {

    public Cart doAction(Cart cart) {
        return null;
    }

    public List<Cart> update(List<Cart> lstFolder) {

        for(Cart cart : lstFolder){

        }
        // 명령 하나하나가 1트랜젝션
        // hibernate 공부필요

        return new ArrayList<Cart>();
    }
}


//    id(client 생성)	action	folderId	name(유니크)	url	time
//        add	상위폴더	추가될 폴더이름	x