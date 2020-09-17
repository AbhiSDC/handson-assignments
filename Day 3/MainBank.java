public class MainBank {
    public static void main(String[] args) {

        //First Question
        
        /*
        //pass the accountNo and amount to deposit from CLA
        long accNo = Long.parseLong(args[0]);
        double am = Double.parseDouble(args[1]);

        //get the Account using the accountNo by calling getAccount(...)
        MainBank mb = new MainBank();
        // if accountNo is wrong show the error message and must not perform any below
        // operation
        Account updateAcc = mb.getAccount(accNo);

        //show the account information before deposit
        //deposit the amount to that particular Account
        //show the account information after deposit
        if(updateAcc != null){
            updateAcc.accountInformation();
            System.out.println("\nNew Balance is: " + updateAcc.deposit(am) + "\n");
            updateAcc.accountInformation();
        }
        else{
            System.out.println("Account Number provided does not exist in our database. Please check and try again.");
        }*/


        //Second Question

        long sourceAcc = Long.parseLong(args[0]);
        long destAcc = Long.parseLong(args[1]);
        double am = Double.parseDouble(args[2]);

        MainBank mb = new MainBank();
        Account sAcc = mb.getAccount(sourceAcc);
        Account dAcc = mb.getAccount(destAcc);
        if(sAcc != null && dAcc != null){
            System.out.println("Source Account Info:");
            sAcc.accountInformation();
            System.out.println("\nDestination Account Info:");
            dAcc.accountInformation();

            sAcc.withdraw(am);
            System.out.println("\nNew Balance is: " + dAcc.deposit(am));
            

            System.out.println("\nSource Account Updated Info:");
            sAcc.accountInformation();
            System.out.println("\nDestination Account Updated Info:");
            dAcc.accountInformation();

        }
        else{
            if(sAcc == null){
                System.out.println("Source Account Number provided does not exist in our database. Please check and try again.");
            }
            else{
                System.out.println("Destination Account Number provided does not exist in our database. Please check and try again.");
            }
            
        }




    }

    // pass the accountNO and get the Account from Accounts[] 
    public static Account getAccount(long accountNo) {
        AccountsDB adb = new AccountsDB();
        Account[] accounts = adb.getAccounts();
        Account account = null;
        for(Account ac : accounts){
            if(ac.getAccountNumber() == accountNo){
                account = ac;
                break;
            }
        }
        // get the account from accounts using the accountNo
        return account;
    }
}