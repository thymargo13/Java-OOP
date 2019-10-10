public class NextNumberTask implements Task{
    private int	nextNumber = 1;
    
    public void performTask(){
        	System.out.println("Next number is : " + nextNumber);
			nextNumber++;
		//	timeLastDone1 = now;
    }
}