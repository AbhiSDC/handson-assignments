abstract class Employee extends Person {
	private int id;
	private double salary;

	Employee(int id, String name, String dob, String gender, long phone, double salary){
		super(name,dob,gender,phone);
		this.id = id;
		this.salary = salary;
	}

	public void testUpdate(Person p){
		if(p instanceof Manager || p instanceof Admin || p instanceof Programmer){
			setSalary(getSalary() * 1.1);
			System.out.println("\nAfter Updating details: ");
			testDisplay();
		}
	}

	public void setId(int id){
		this.id = id;		
	}

	public int getId(){
		return this.id;		
	}

	public double getSalary(){
		return this.salary;
	}

	public void setSalary(double salary){
		this.salary = salary;
	}
}