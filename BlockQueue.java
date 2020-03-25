import java.util.ArrayList;

class BlockQueue {
    
    ArrayList<String> bQueue = new ArrayList<String>();
    
    public synchronized void addQueue() {
        while (bQueue.size() == 10) {
            try {
                wait(); 
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        bQueue.add("Item");
        notifyAll();    
    }
    
    public synchronized void removeQueue() throws InterruptedException {
        if (bQueue.size() == 0) {
            wait(); 
        } 
        bQueue.remove(0);
        notifyAll();     
    }   
    
    public int getSize() {
        return bQueue.size();
    }
    
}