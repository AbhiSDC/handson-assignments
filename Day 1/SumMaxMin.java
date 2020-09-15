class SumMaxMin {
	public static void main(String[] args) {
		int a=0,sum=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(String x:args){
			a = Integer.parseInt(x);
			sum += a;
			if(a > max){
				max = a;
			}
			if(a < min){
				min = a;
			}
		}
		System.out.println("Sum of all No.s is : " + sum);
		System.out.println("Minimum Value is   : " + min);
		System.out.println("Maximum Value is   : " + max);
	}	
}