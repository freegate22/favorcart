package test.java.com.cart.common;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

/**
 * Created by hshs on 2016. 1. 11..
 */
public class TestUtil {

    private static final String CHARACTER = "a";

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );
}