package main.java.com.cart.common;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import main.java.com.cart.bookmark.BookmarkService;
import main.java.com.cart.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hshs on 2016. 1. 2..
 */
@Service
public class CartService {

    @Autowired
    FolderService folderService;

    @Autowired
    BookmarkService bookmarkService;

    public List<Cart> update(String cmdList){

        List<Cart> lstFolder = new ArrayList<Cart>();
        List<Cart> lstBookmark = new ArrayList<Cart>();
        List<Cart> lstResultCart = new ArrayList<Cart>();

        System.out.println(cmdList);
        Gson gson = new Gson();
        JsonElement jsonCmdList = new JsonParser().parse(cmdList);
        JsonArray jsonArray = jsonCmdList.getAsJsonArray();
        Iterator<JsonElement> ir = jsonArray.iterator();

        while(ir.hasNext()){
            JsonElement jsonElement = ir.next();
            Cart cart = gson.fromJson(jsonElement, Cart.class);
            Cart.Type type = Cart.Type.valueOf(cart.getType().toUpperCase());
            switch (type){
                case FOLDER:
                    lstFolder.add(cart);
                    break;
                case BOOKMARK:
                    lstBookmark.add(cart);
                    break;
            }
        }

        lstResultCart.addAll( folderService.update(lstFolder) );
        lstResultCart.addAll( bookmarkService.update(lstBookmark) );
        return lstResultCart;

    }

}
