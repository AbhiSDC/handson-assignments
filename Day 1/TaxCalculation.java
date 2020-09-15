class TaxCalculation {
	public static void main(String[] args) {
		int price = Integer.parseInt(args[0]);
		String state = args[1];
		double KN_tax = 0.10;
		double TN_tax = 0.090;
		double TL_tax = 0.095;
		double MH_tax = 0.105;
		double PB_tax = 0.12;
		switch(state){
			case "Karnataka":
				System.out.println("Price(incl. Tax) in Karnataka is: " + (1 + KN_tax)*price);
				break;
			case "TamilNadu":
				System.out.println("Price(incl. Tax) in Tamil Nadu is: " + (1 + TN_tax)*price);
				break;
			case "Telangana":
				System.out.println("Price(incl. Tax) in Telangana is: " + (1 + TL_tax)*price);
				break;
			case "Maharashtra":
				System.out.println("Price(incl. Tax) in Maharashtra is: " + (1 + MH_tax)*price);
				break;
			case "Punjab":
				System.out.println("Price(incl. Tax) in Punjab is: " + (1 + PB_tax)*price);
				break;
			default:
				System.out.println("Data for State is not present.");

		}
		
		
		
		
		
	}
}