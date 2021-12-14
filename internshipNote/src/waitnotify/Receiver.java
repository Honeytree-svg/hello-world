package waitnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Data load;
  
    // standard constructors
  
    public Receiver(Data data) {
		// TODO Auto-generated constructor stub
    	this.load = data;
	}

	public void run() {
        for(String receivedMessage = load.receive();  !"End".equals(receivedMessage); receivedMessage = load.receive()) {
             
            System.out.println(receivedMessage);
 
            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                //Log.error("Thread interrupted", e); 
            }
        }
    }
}