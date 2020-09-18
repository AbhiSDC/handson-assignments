class PersonMain {
	public static void main(String[] args) {
		Address ad1 = new Address("Punjab", "Patiala", 147001);
		Address ad2 = new Address("Maharashtra", "Panvel", 210045);

		Person[] allObj = {
			new Manager(1001, "Abhishek", "01/06/1970", "Male", 8988434401L, 80000, ad1),
			new Programmer(2002, "Priya", "21/02/1980", "Female", 9568812321L, 65000),
			new Admin(3003, "Abhinav", "31/06/1982", "Male", 9088891189L, 70000),
			new Student(201401, "Sahil", "15/11/1975", "Male", 6477483911L, "First Class"),
			new Customer("Ishita",  "20/02/1985", "Female", 9677003911L, ad2, new SavingsAccount(1133L, 70000))
		};

		for(Person p : allObj){
			p.testDisplay();
		}

		for(Person p : allObj){
			p.testUpdate(p);
		}
	}

	public static void testUpdate(Person p){
		if(p instanceof Manager || p instanceof Admin || p instanceof Programmer){
			p.setSalary(p.getSalary() * 1.1);
			System.out.println("\nAfter Updating details: ");
			p.testDisplay();
		}

		if(p instanceof Student){
			p.setGrade("Second Class");
			System.out.println("\nAfter Updating details: ");
			p.testDisplay();
		}

		if(p.acc != null){
			p.acc.setBalance(50000);
			System.out.println("\nAfter Updating details: ");
			p.testDisplay();
		}
	}
}