class Employee {
	String name;
	int id;
	double salary;
	Address adrr;

	Employee(){}

	Employee(String name, int id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	Employee(String name, int id, double salary, Address adrr){
		this(name, id, salary);
		this.adrr = adrr;
	}

	void display(Employee[] em){
		System.out.println("Employees with salary > 50000 are: ");
		for(Employee e : em){
			if(e.salary > 50000){
				System.out.println("Name: " + e.name);
			}
		}

		System.out.println("\nEmployees with addresses are: ");
		for(Employee e : em){
			if(e.adrr != null){
				System.out.println("State: " + e.adrr.state + ", City: " + e.adrr.city + ", PIN: " + e.adrr.pin);
			}
		}
	}

	public static void main(String[] args) {
		Employee ep = new Employee();
		Address ad1 = new Address("Punjab", "Patiala", 147001);
		Address ad2 = new Address("Maharashtra", "Panvel", 210045);
		Address ad3 = new Address("Karnataka", "Bengaluru", 453301);

		Employee em[] = new Employee[5];
		em[0] = new Employee("Abhishek Kumar", 1001, 55000.0, ad1);
		em[1] = new Employee("Abhinav Sehgal", 1002, 45000.0);
		em[2] = new Employee("Sahil Mishra", 1003, 65000.0, ad2);
		em[3] = new Employee("Ishita Kapoor", 1004, 50000.0);
		em[4] = new Employee("Vijay Malhotra", 1005, 55000.0, ad3);
		
		ep.display(em);
	}
}

class Address{
	String state, city;
	int pin;

	Address(String state, String city, int pin){
		this.state = state;
		this.city = city;
		this.pin = pin;
	}
}