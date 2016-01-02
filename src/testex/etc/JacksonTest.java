package testex.etc;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import main.java.com.cart.common.Cart;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hshs on 2016. 1. 2..
 */
public class JacksonTest {


//    private String type;
//    private String action;
//    private String folderId;
//    private String destFolderId;
//    private String name;
//    private String url;
//    private String bookmarkId;
//    private long regDate;
    public static void main(String[] args) {
        List<Cart> carts = new ArrayList<Cart>();
        Cart cart1 = new Cart();
        cart1.setType("tt");
        cart1.setAction("aa");
        cart1.setFolderId("Ff");
        cart1.setDestFolderId("dd");
        cart1.setName("nn");
        cart1.setUrl("uu");
        cart1.setBookmarkId("bb");
        cart1.setRegDate(new Date().getTime());
        carts.add(cart1);

        Cart cart2 = new Cart();
        cart2.setType("tt2");
        cart2.setAction("aa2");
        cart2.setFolderId("Ff2");
        cart2.setDestFolderId("dd2");
        cart2.setName("nn2");
        cart2.setUrl("uu2");
        cart2.setBookmarkId("bb2");
        cart2.setRegDate(new Date().getTime());
        carts.add(cart2);

        String json = "[{\"type\":\"tt\",\"action\":\"aa\",\"folderId\":\"Ff\",\"destFolderId\":\"dd\",\"name\":\"nn\",\"url\":\"uu\",\"bookmarkId\":\"bb\",\"regDate\":1451712414982},{\"type\":\"tt2\",\"action\":\"aa2\",\"folderId\":\"Ff2\",\"destFolderId\":\"dd2\",\"name\":\"nn2\",\"url\":\"uu2\",\"bookmarkId\":\"bb2\",\"regDate\":1451712414982}]";
        JsonElement je = new JsonParser().parse(json);
        JsonArray ja = je.getAsJsonArray();
        System.out.println(ja.get(0));
//        Type type = new TypeToken<List<Cart>>(){}.getType();
//        List<Cart> inpList = new Gson().fromJson(json, type);
//        for (int i=0;i<inpList.size();i++) {
//            System.out.println(inpList.get(i));
//            DataObject x = inpList.get(i);
//            System.out.println(x);
//        }

    }
}
