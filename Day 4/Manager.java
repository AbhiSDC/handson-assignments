class Manager extends Employee {

	Manager(int id, String name, String dob, String gender, long phone, double salary, Address adrr){
		super(id, name, dob, gender, phone, salary);
		setAddress(adrr);
	}

	public void testDisplay(){
		System.out.println("\nManager details are: ");
		System.out.println("ID  : " + getId());
		System.out.println("Name  : " + getName());
		System.out.println("DOB   : " + getDOB());
		System.out.println("Gender: " + getGender());
		System.out.println("Phone: " + getPhone());
		System.out.println("Address: " + getAddress(this.adrr));
		System.out.println("Salary: " + getSalary());
	}
}