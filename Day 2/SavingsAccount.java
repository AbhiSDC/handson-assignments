class SavingsAccount {
    long accountNo;
    String name;
    double balance;
    String ifsc = "HSBC001";
    String state;
    String city;
    int pin;

    SavingsAccount(long an, String n, String s, String c){
        accountNo = an;
        name = n;
        state = s;
        city = c;
    }

    SavingsAccount(long an, String n, double b, String s, String c){
        accountNo = an;
        name = n;
        state = s;
        city = c;
        balance = b;
    }

    void deposit(double d){
        balance += d;
        System.out.println("\nAmount Deposited by " + name + ": " + d);
        System.out.println(name + "'s updated balance is: " + balance);
    }

    void withdraw(double w){
        if(balance - w < 0.0){
            System.out.println("\nInsufficient Balance, cannot withraw said amount.");
            return;
        }
        balance -= w;
        System.out.println("\nAmount Withdrawn by " + name + ": " + w);
        System.out.println(name + "'s updated balance is: " + balance);
    }

    void display(){
        System.out.println("\nThe account details are: ");
        System.out.println("Name: " + name);
        System.out.println("Account No: " + accountNo);
        System.out.println("IFSC Code: " + ifsc);
        System.out.println("State: " + state);
        System.out.println("City: " + city);
        System.out.println("Current balance: " + balance);
    }
}