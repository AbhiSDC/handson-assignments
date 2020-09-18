class Admin extends Employee {
	Admin(int id, String name, String dob, String gender, long phone, double salary){
		super(id, name, dob, gender, phone, salary);
	}
	public void testDisplay(){
		System.out.println("\nAdmin details are: ");
		System.out.println("ID  : " + getId());
		System.out.println("Name  : " + getName());
		System.out.println("DOB   : " + getDOB());
		System.out.println("Gender: " + getGender());
		System.out.println("Phone: " + getPhone());
		System.out.println("Salary: " + getSalary());
	}
}