package myPack;

public class MessageLoop implements Runnable{

	String[] messagesArray = {"first", "second", "third"};
	Thread messageloop = new Thread(this);
	
	public void run() {
		int count = 0;
		
		for (String string : messagesArray) {
			count++;	
			System.out.println(messageloop.getName() + " - Message: " + string);
			try{
				Thread.sleep(4000);
			}
			catch(InterruptedException ex){
				System.out.println(messageloop.getName() + ": " + InterruptedException.class.getSimpleName() + ex.getMessage());
				
				break;
			}
		}
		
		if(count==3){
			System.out.println(messageloop.getName() + ": task completed successfully!");
		} else{			
			System.out.println(messageloop.getName() + ": task not completed successfully!");
		}
			
		
	}

}

