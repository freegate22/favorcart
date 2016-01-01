package testex.mok;

/**
 * Created by hansik on 2015. 12. 19..
 */
public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
