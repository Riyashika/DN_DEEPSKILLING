import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() {
        account = new Account(1000);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        boolean result = account.withdraw(5000);
        assertFalse(result);
        assertEquals(1000, account.getBalance());
    }
}
