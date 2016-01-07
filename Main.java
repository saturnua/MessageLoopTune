package myPack;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args){
		int waitTime = 1000;
		
		System.out.println("Please enter time waiting secod thread in millisec (1000 = 1s):");
		
		boolean correctInput = false;
        Scanner sc = new Scanner(System.in);
        while (!correctInput) {
             if (sc.hasNextInt()){
                correctInput = true;
                waitTime = sc.nextInt();
             } else {
                System.out.println("Try again!");
                sc.next();
             }
        }
		
		Runnable thread = new MessageLoop();
		Thread messageloop = new Thread(thread);
		
		System.out.println(messageloop.getName() + " - main: Start MessageLoop thread");
		messageloop.start();
		
		
		System.out.println(messageloop.getName() + " - main: Waiting until MessageLoop will be finished");
		

			do{
				try{
					messageloop.join(waitTime);	//wait when second thread ends job
					if(messageloop.isAlive()){
						System.out.println("         " + messageloop.getName() + " - main: I cannot wait more than " +waitTime + " milliseconds!");
						messageloop.interrupt();		
					}
				}catch(InterruptedException e){}
			}
			while(messageloop.isAlive());
		System.out.println("END");
	}
}
