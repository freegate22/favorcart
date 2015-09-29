package com.cart.bookmark;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hansik on 2015. 9. 26..
 */

@Controller
public class BookmarkController {

    @RequestMapping("/hello")
    public ModelAndView hello() {

        String message = "Hello, Spring 3.0!";
        System.out.println(message);
        return new ModelAndView("home");
    }
}