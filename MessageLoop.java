package myPack;

public class MessageLoop implements Runnable{

	String[] messagesArray = {"first", "second", "third"};
	Thread messageloop = new Thread(this);
	
	public void run() {
		for (String string : messagesArray) {
			
			//System.out.println(messageloop.getName() + ": " + string);
			try{
				Thread.sleep(4000);
			}
			catch(InterruptedException ex){
				System.out.println(messageloop.getName() + ": Выполнение задачи не завершено");
			}
		}
		
	}

}

