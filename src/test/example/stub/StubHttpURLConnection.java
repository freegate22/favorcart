package test.example.stub;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by hansik on 2015. 12. 10..
 */
public class StubHttpURLConnection extends HttpURLConnection{

    private boolean isInput = true;
    /**
     * Constructor for the HttpURLConnection.
     *
     * @param u the URL
     */
    protected StubHttpURLConnection(URL u) {
        super(u);
    }

    public InputStream getInputStream() throws IOException {
        if (!isInput) {
            throw new ProtocolException("Cannot read from URLConnection"
            + " if doInput=false (call setDoInput(true))");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(new String("It works").getBytes());
        return bais;
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}
