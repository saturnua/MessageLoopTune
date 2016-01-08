package myPack;

public class MessageLoop implements Runnable{

	String[] messagesArray = {"first", "second", "third"};
	Thread messageloop = new Thread(this);
	
	public void run() {

        messageloop.setName("Loop");
        
        for (int i = 0; i < messagesArray.length; i++) {
               System.out.println(messageloop.getName() + ": " + messagesArray[i]);
               try {
                      Thread.sleep(4000);
               } catch (InterruptedException e) {
                      System.out.println(messageloop.getName() + ": "
                                   + InterruptedException.class.getSimpleName() + " \""
                                   + e.getMessage() + "\"");
                      System.out.println(messageloop.getName()
                                   + ": task was not completed!");
                      return;
               }
        }
        System.out.println(messageloop.getName()
                      + ": task completed successfully!");
  }

}

