package myPack;

public class MessageLoop implements Runnable{

	String[] messagesArray = {"first", "second", "third"};
	
	public void run() {
		try {
			for (String string : messagesArray) {
				
				System.out.println(string);
				Thread.sleep(4000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

