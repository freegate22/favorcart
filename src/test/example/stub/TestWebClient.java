package test.example.stub;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by hansik on 2015. 12. 10..
 */
public class TestWebClient {

    @BeforeClass
    public static void setUp() throws Exception{
        Server server = new Server(8888);

        TestWebClient t = new TestWebClient();

        Context contentOkContext = new Context(server, "/testGetContentOk");
        contentOkContext.setHandler(t.new TestGetContentOkHandler());
        Context contentNotFoundContext = new Context(server, "/testGetContentNotFound");
        contentNotFoundContext.setHandler(t.new TestGetContentNotFoundHandler());

//        server.setStopAtShutdown(true);
        server.start();

    }

    @Test
     public void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        URL url = new URL("http://localhost:8888/testGetContentOk");

        String result = client.getContent(url);
        assertEquals("It works", result);
    }
    @Test
    public void testGetContentNotFound() throws MalformedURLException {
        WebClient client = new WebClient();
        URL url = new URL("http://localhost:8888/testGetContentNotFound");

        String result = client.getContent(url);
        assertNull(result);
    }


    @AfterClass
    public static void tearDown(){
        // not doing
    }

    private class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, int dispatch)
                throws IOException, ServletException {

            OutputStream out = httpServletResponse.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            httpServletResponse.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();

        }
    }

    private class TestGetContentNotFoundHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, int dispatch)
                throws IOException, ServletException {

            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);

        }
    }
}
