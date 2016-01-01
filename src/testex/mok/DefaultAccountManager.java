package testex.mok;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by hshs on 2015. 12. 19..
 */
public class DefaultAccountManager
        implements AccountManager
{

    private static final Log LOGGER = LogFactory.getLog(DefaultAccountManager.class);

    public Account findAccountForUser( String userId )
    {
        LOGGER.debug( "Getting account for user [" + userId + "]" );
        ResourceBundle bundle = PropertyResourceBundle.getBundle("technical");
        String sql = bundle.getString( "FIND_ACCOUNT_FOR_USER" );

        return null;
    }

    public void updateAccount( Account account )
    {
        // Perform database access here
    }
}