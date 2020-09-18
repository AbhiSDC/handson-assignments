class Address {
	String state;
	String city;
	int pin;

	Address(String state, String city, int pin){
		this.state = state;
		this.city = city;
		this.pin = pin;
	}

	String getState(){
		return this.state;
	}

	String getCity(){
		return this.city;
	}

	int getPin(){
		return this.pin;
	}
}