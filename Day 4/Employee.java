abstract class Employee extends Person {

	Employee(int id, String name, String dob, String gender, long phone, double salary){
		super(name,dob,gender,phone);
		setId(id);
		setSalary(salary);
	}
}