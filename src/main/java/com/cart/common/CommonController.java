package main.java.com.cart.common;

import main.java.com.cart.bookmark.Bookmark;
import main.java.com.cart.user.User;
import main.java.com.cart.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hshs on 2016. 1. 1..
 */
@Controller
@RequestMapping("/1")
public class CommonController extends GenericController<User, Integer, UserService>{

    @RequestMapping(value="/update")
    public @ResponseBody Bookmark update( HttpServletRequest request ) {

        return null;
    }
}
