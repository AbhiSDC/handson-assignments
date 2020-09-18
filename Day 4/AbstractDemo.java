public class AbstractDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(5555L, 75000);
        CurrentAccount current = new CurrentAccount(9999L, 150000);
        // Account account = new Account(1111L, 9000);
        test(savings);
        test(current);
    }

    public static void test(Account account) {
        account.accountInformation();
        // deposit
        account.deposit(25000);
        // display information
        account.accountInformation();
        // withdraw
        account.withdraw(60000);
        // display information
        account.accountInformation();
    }
}