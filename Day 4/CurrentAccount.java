public class CurrentAccount extends Account {
    public CurrentAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public void withdraw(double amount) {
        System.out.println("Trying to withdraw: "+amount);
        if(amount < getBalance()) {
            System.out.println("Amount withdrawn from current account: "+amount);
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Sorry Insufficient Balance");
        }
    }
}