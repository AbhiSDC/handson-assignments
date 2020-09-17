public class Account { 
    private long accountNumber;
    private double balance;

    /* withdraw must return the balance 
       and apply some conditions before deducting
    */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        //System.out.println("Account(long, double) initialized");
    }
    public Account() {
        balance = 0.0;
        System.out.println("Account() intialized");
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() { 
        return balance; 
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void withdraw(double amount) {
        System.out.println("withdraws amount from account");
        setBalance(getBalance() - amount);
    }

    /* deposit must return the balance
    */
    public double deposit(double amount) {
        System.out.println("Deposits Rs."+ amount +" amount to account");
        setBalance(getBalance() + amount);
        return getBalance();
    }
    public void accountInformation() {
        System.out.println("---- Account Information ----");
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
    }
}