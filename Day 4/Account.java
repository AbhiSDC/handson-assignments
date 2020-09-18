public abstract class Account { 
    private long accountNumber;
    private double balance;
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public double getBalance() { 
        return balance;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void deposit(double amount) {
        System.out.println("Amount deposited: "+amount);
        this.balance = getBalance() + amount;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    // this method has dummy implementation
    public abstract void withdraw(double amount);
    public void accountInformation() {
        System.out.println("Account Number: "+accountNumber+", Balance: "+balance);
        System.out.println("---------------------------");
    }
}