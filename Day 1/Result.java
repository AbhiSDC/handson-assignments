class Result {
	public static void main(String[] args) {
		int marks = Integer.parseInt(args[0]);
		String grade = "";
		if(marks >= 70 && marks < 100){
			grade = "First Class with Distinction";
		}
		else if(marks < 70 && marks >= 60){
			grade = "First Class";
		}
		else if(marks < 60 && marks >= 50){
			grade = "Second Class";
		}
		else if(marks < 50 && marks >= 35){
			grade = "Pass";
		}
		else{
			grade = "Fail";
		}
		System.out.println("Result is: " + grade);
	}
}