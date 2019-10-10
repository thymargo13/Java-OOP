public class TaskEntry{
    private long repeatInterval;
    private long timeLastDone;
    private Task task;
   
   
    public TaskEntry(Task task, long repeatInterval){
        this.repeatInterval = repeatInterval;
        this.timeLastDone  = System.currentTimeMillis();
        this.task = task;
    }
    
    public long getRepeatInterval(){return repeatInterval;}
    public long getTimeLastDone(){return timeLastDone;}
    public Task getTask(){return task;}
    public void setTimeLastDone(long timeLastDone){this.timeLastDone= timeLastDone;}
}