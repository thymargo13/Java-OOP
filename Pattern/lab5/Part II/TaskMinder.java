import java.util.Vector;

public class TaskMinder extends Thread{
    private long sleepInterval;
    private long now;
    private Vector _taskEntry;
    
    public TaskMinder(long sleepInterval){
        this.sleepInterval = sleepInterval;
        _taskEntry = new Vector();
    }
    
    public void addTaskEntry(TaskEntry taskEntry){
        _taskEntry.add(taskEntry);
    }
    
    public void removeTaskEntry(TaskEntry taskEntry){
        _taskEntry.remove(taskEntry);
    }
    // public Enumeration getTaskEntries(){
    //     return(_taskEntry.elements());
    // }
    
    public void run() {
		while(true) {
			try {
				sleep(sleepInterval);
				now = System.currentTimeMillis();
				// for(;_taskEntry.hasMoreElements();){
				    
				// }
				for(int i=0; i<_taskEntry.size();i++){
				    if(((TaskEntry)_taskEntry.get(i)).getRepeatInterval() + ((TaskEntry)_taskEntry.get(i)).getTimeLastDone() <= now){
				        ((TaskEntry)_taskEntry.get(i)).getTask().performTask();
				        ((TaskEntry)_taskEntry.get(i)).setTimeLastDone(now);
				    }
				}
			}
			catch (Exception e) {
				System.out.println("Interrupted sleep : " + e);
			}
		}
	}
}