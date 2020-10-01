package com.hsbc.concepts;

class TicketBooking implements Runnable {

	private static int ticket = 2;
	@Override
	public synchronized void run() {
		Thread t = Thread.currentThread();
		if(ticket > 0) {
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getName() + " got the ticket.");
			ticket--;
		}
		else {
			System.out.println("Sorry, " + t.getName() + " didn't get the ticket.");
		}
		
	}
	
}

public class MultithreadingDemo {
	public static void main(String[] args) {
		TicketBooking tb = new TicketBooking();
		for(int i=1; i<=10; i++) {
			Thread thread = new Thread(tb, "User: " + i);
			thread.start();
		}
		
	}
}
