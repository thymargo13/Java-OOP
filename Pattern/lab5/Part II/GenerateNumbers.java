public class GenerateNumbers extends Thread {
	private long sleepInterval;
	private long repeatInterval1, repeatInterval2;
	private long timeLastDone1, timeLastDone2;
	private int nextNumber, nextPrimeNumber;
	private long now;

	public GenerateNumbers(long sleepInterval, long repeatInterval1, long repeatInterval2) {
		this.sleepInterval = sleepInterval;
		this.repeatInterval1 = repeatInterval1;
		this.repeatInterval2 = repeatInterval2;
		timeLastDone1 = timeLastDone2 = System.currentTimeMillis();
		nextNumber = 1; 
		nextPrimeNumber = 2;
	}

	public void run() {
		while(true) {
			try {
				//sleep for a while and detect now the time.
				sleep(sleepInterval);
				now = System.currentTimeMillis();
				//job 1 printout number with sequence
				if (repeatInterval1 + timeLastDone1 <= now) {
					System.out.println("Next number is : " + nextNumber);
					nextNumber++;
					timeLastDone1 = now;
				}
				//job 2 printout prime number with sequence
				if (repeatInterval2 + timeLastDone2 <= now) {
					while (true) {
						boolean isPrime = true;
						for (int i = 2; i <= nextPrimeNumber/2; i++) {
							if (nextPrimeNumber % i == 0)
								isPrime = false;
						}

						if (isPrime) {
							System.out.println("Next prime number is : " + nextPrimeNumber);
							nextPrimeNumber++;
							timeLastDone2 = now;
							break;
						}
						nextPrimeNumber++;
					}
				}
			}
			catch (Exception e) {
				System.out.println("Interrupted sleep : " + e);
			}
		}
	}

	public static void main(String [] args) {
		GenerateNumbers gm = new GenerateNumbers(500, 3000, 7000);
		gm.start();
	}
}

