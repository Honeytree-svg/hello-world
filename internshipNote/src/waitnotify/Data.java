package waitnotify;

public class Data {
    private String packet;
     
    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;
    private boolean num = false;
  
    public void send(String packet) {
    	
    	while(num);

        //notifyAll();
    }
  
    public String receive() {
    	
    	while(!num);
    	
        while (transfer) {
//            try {
//                wait();
//            } catch (InterruptedException e)  {
//                Thread.currentThread().interrupt(); 
//                //Log.error("Thread interrupted", e); 
//            }
        	System.out.println("reveiver is waiting");
        }
        transfer = true;
        num = false;
 
        //notifyAll();
        return packet;
    }
}

