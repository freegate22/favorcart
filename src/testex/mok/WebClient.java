package testex.mok;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hshs on 2015. 12. 19..
 */
public class WebClient
{
    /**
     * A method to retrieve the content from the given URL.
     *
     * @param url
     * @return
     */
    public String getContent( URL url )
    {
        StringBuffer content = new StringBuffer();

        try
        {
            HttpURLConnection connection = createHttpURLConnection( url );
            InputStream is = connection.getInputStream();

            int count;
            while ( -1 != ( count = is.read() ) )
            {
                content.append( new String( Character.toChars( count ) ) );
            }
        }
        catch ( IOException e )
        {
            return null;
        }

        return content.toString();
    }

    /**
     * Creates an HTTP connection.
     *
     * @param url
     * @return
     * @throws IOException
     */
    protected HttpURLConnection createHttpURLConnection( URL url )
            throws IOException
    {
        return (HttpURLConnection) url.openConnection();
    }
}