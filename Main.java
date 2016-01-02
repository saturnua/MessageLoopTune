package myPack;

public class Main {
	public static void main(String[] args){
		Runnable thread = new MessageLoop();
		Thread messageloop = new Thread(thread);
		
		System.out.println("����� MessageLoop thread");
		messageloop.start();
		
		messageloop.setName("Thread - 0:");
		System.out.println("��� ���� ������ ����� �������� ����������");
		
		do{
			System.out.println("� ���...");
			try{
				messageloop.join(1000);	
			}catch(InterruptedException e){}
		}
		while(messageloop.isAlive());
		
		System.out.println("�����");
	}

}
