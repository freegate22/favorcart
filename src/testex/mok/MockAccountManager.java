package testex.mok;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hansik on 2015. 12. 19..
 */
public class MockAccountManager implements AccountManager{

    private Map<String, Account> accounts = new HashMap<String, Account>();

    public void addAccount(String userId, Account account){
        this.accounts.put(userId, account);
    }

    @Override
    public Account findAccountForUser(String userId) {
        return accounts.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
        // not doing
    }
}
