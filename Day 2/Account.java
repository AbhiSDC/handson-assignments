class Account {
    public static void main(String[] args) {
        SavingsAccount s1 = new SavingsAccount(8989000089L,"Anuj Kumar", "Punjab", "Patiala");
        SavingsAccount s2 = new SavingsAccount(7833909012L, "Abhinav Patel", 20000.0, "Maharashtra", "Panvel");
        SavingsAccount s3 = new SavingsAccount(8976002377L, "Radha Kapoor", 45000.0, "Haryana", "Gurugram");
        //SavingsAccount s4 = new SavingsAccount(7433820001L, "Sahil Saini", "Karnataka", "Bengaluru");
        //SavingsAccount s5 = new SavingsAccount(6755201922L, "Shubhi Bose", 60000, "Uttar Pradesh", "Lucknow");
        s1.deposit(40000);
        s1.display();

        s2.withdraw(2000);
        s2.deposit(1000);
        s2.display();

        s3.withdraw(5000);
        s3.deposit(10000);
        s3.display();
    }
}