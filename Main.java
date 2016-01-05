package myPack;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args){
		int waitTime = 1000;
		
		System.out.println("Please enter time waiting secod thread in millisec (1000 = 1s):");
		Scanner sc = new Scanner(System.in);	
		try{
			waitTime = sc.nextInt();
		}catch (InputMismatchException ex){
			System.out.println("Вы ввели неправильное значение в милисекундах, правильное например 1000");
			Scanner sc1 = new Scanner(System.in);
			waitTime = sc1.nextInt();
		}//этот блок всего 1 раз обработает неправильный ввод и можно шире конечно проверить 
		
		
		Runnable thread = new MessageLoop();
		Thread messageloop = new Thread(thread);
		
		System.out.println("Старт MessageLoop thread");
		messageloop.start();
		
		
		System.out.println("Жду пока второй поток закончит выполнение");
		
		do{
			
			System.out.println("Я жду... ");
			try{
				messageloop.join(waitTime);	//ожидание завершения выполнения второго потока
				System.out.println("Больше ждать не буду!!!");
				messageloop.interrupt();
			}catch(InterruptedException e){}
			
		}
		
		while(messageloop.isAlive());
		
		System.out.println("Конец");
	}

}
