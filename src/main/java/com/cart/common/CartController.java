package main.java.com.cart.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.cart.user.User;
import main.java.com.cart.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hshs on 2016. 1. 1..
 */
@Controller
//@RequestMapping("/1")
@RequestMapping(value={"/1","/"})
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(value = "/sync", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Cart> sync( HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "cmdList", required = false) String cmdList) {

//        System.out.println(cmdList;
        boolean isJsonValid = CommonUtil.isJsonValid(cmdList);
//        if( isJsonValid ) {
//            // 성공 코드 전송
//            response.setStatus( HttpServletResponse.SC_OK );
//            List<Cart> list = cartService.update(cmdList);
//            System.out.println(list);
//            return cartService.update(cmdList);
//
//        } else {
//            response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
//            // 잘못된 json 요청 에러
//            // 실패 코드 전송송
//        }

        List<Cart> list = new ArrayList<Cart>();
        Cart cart = new Cart();
        cart.setType("folder");
        list.add(cart);
        return list;
    }

    @RequestMapping(value="/new")
    public @ResponseBody Cart fortest(
            HttpServletRequest request, HttpServletResponse response) {

        response.setStatus( HttpServletResponse.SC_OK );
        Cart cart = new Cart();
        cart.setName("cc");
        return cart;
    }
}
