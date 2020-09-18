class Student extends Person {
	int rollNo;

	Student(int rollNo, String name, String dob, String gender, long phone, String grade){
		super(name, dob, gender, phone);
		setRollNo(rollNo);
	}

	public void testDisplay(){
		System.out.println("\nStudent details are: ");
		System.out.println("ID  : " + getRollNo());
		System.out.println("Name  : " + getName());
		System.out.println("DOB   : " + getDOB());
		System.out.println("Gender: " + getGender());
		System.out.println("Phone: " + getPhone());
		System.out.println("Grade: " + getGrade());
	}

	public void setRollNo(int rollNo){
		this.rollNo = rollNo;
	}

	public int getRollNo(){
		return this.rollNo;
	}
}