public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Trying to withdraw: "+amount);
        if(amount > 50000 || amount > getBalance()) {
            System.out.println("You can't withdraw amount, may be balance is insufficient or limit exceeded");
        } else {
            System.out.println("Amount withdrawn from savings account: "+amount);
            setBalance(getBalance() - amount);
        }
    }
}