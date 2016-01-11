package testex.stub;

import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Created by hshs on 2016. 1. 6..
 */
public class ACTest {

    public static void main(String[] args) {
        String path = StringUtils.cleanPath(ClassUtils.classPackageAsResourcePath(ACTest.class));
        System.out.println(path);

//        WebApplicationContextUtils.getWebApplicationContext();
    }
}
