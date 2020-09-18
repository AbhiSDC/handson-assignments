class Customer extends Person {
	Customer(String name, String dob, String gender, long phone, Address adrr, Account acc){
		super(name, dob, gender, phone);
		setAddress(adrr);
		setAccount(acc);
	}
	public void testDisplay(){
		System.out.println("\nCustomer details are: ");
		System.out.println("Name  : " + getName());
		System.out.println("DOB   : " + getDOB());
		System.out.println("Gender: " + getGender());
		System.out.println("Phone: " + getPhone());
		System.out.println("Address: " + getAddress(this.adrr));
		System.out.println("Account Details: " + getAccount(this.acc));
	}

}