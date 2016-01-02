package main.java.com.cart.common;

import com.google.gson.Gson;

/**
 * Created by hshs on 2016. 1. 2..
 */
public final class CommonUtil {

    public static boolean isJsonValid(String JSON_STRING) {
        try {
            new Gson().fromJson(JSON_STRING, Object.class);
            return true;
        } catch(com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }
}
