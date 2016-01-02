package main.java.com.cart.common;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hshs on 2016. 1. 2..
 */
@Service
public class CartService {

    public List<Cart> update(String cmdList){
        List<Cart> lstCart = new ArrayList<Cart>();
        Gson gson = new Gson();
        JsonElement jsonCmdList = new JsonParser().parse(cmdList);
        JsonArray jsonArray = jsonCmdList.getAsJsonArray();
        Iterator<JsonElement> ir = jsonArray.iterator();
        while(ir.hasNext()){
            JsonElement jsonElement = ir.next();
            Cart cart = gson.fromJson(jsonElement, Cart.class);
            System.out.println(cart.getType());
            lstCart.add(cart);
        }



        // 1. json 뽑기
        // 2. action 순회
        // 3. 같은 폴더 또는 북마크인 경우 마지막명령 수행
        // 4. 달라진 부분 모아 respolse

        return lstCart;
    }

}
