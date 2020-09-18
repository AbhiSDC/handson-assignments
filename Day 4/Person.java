abstract class Person extends PersonMain {
	private String name;
	private String dob;
	private String gender;
	private long phone;
	private String grade;
	private int id;
	private double salary;
	Address adrr;
	Account acc;

	Person(String name, String dob, String gender, long phone){
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
	}

	public abstract void testDisplay();

	public String getName(){
		return this.name;
	}

	public String getDOB(){
		return this.dob;
	}

	public String getGender(){
		return this.gender;
	}

	public long getPhone(){
		return this.phone;
	}

	public void setGrade(String grade){
		this.grade = grade;
	}

	public String getGrade(){
		return this.grade;
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

	public void setAddress(Address adrr){
		this.adrr = adrr;
	}

	public String getAddress(Address adrr){
		return "State: " + adrr.getState() + ", City: " + adrr.getCity() + ", PIN: " + adrr.getPin();
	}

	public void setAccount(Account acc){
		this.acc = acc;
	}

	public String getAccount(Account acc){
		return "Account Number: " + acc.getAccountNumber() + ", Balance: " + acc.getBalance(); 
	}
}
