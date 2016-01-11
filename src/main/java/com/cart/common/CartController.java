package main.java.com.cart.common;

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

    @RequestMapping(value="/sync")
    public @ResponseBody List<Cart> sync(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "cmdList", required = false) String cmdList) {

        System.out.println("!!!!!!!!!!!!");
        System.out.println(cmdList;
        boolean isJsonValid = CommonUtil.isJsonValid(cmdList);
        if( isJsonValid ) {
            System.out.println("AAAAAAAAAAAAA");
            // 성공 코드 전송
            response.setStatus( HttpServletResponse.SC_OK );
            List<Cart> list = cartService.update(cmdList);
            System.out.println(list);
            return cartService.update(cmdList);

        } else {
            System.out.println("BBBBBBBBBBBBB");
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
            // 잘못된 json 요청 에러
            // 실패 코드 전송송
        }

        return new ArrayList<Cart>();
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
