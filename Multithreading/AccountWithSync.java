import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AccountWithSync {
	private static Account userAccount = new Account();
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 100; i++) {
			executor.execute(new AddAPenny());
		}
		executor.shutdown();
		while(!executor.isShutdown()) {
		}
		System.out.println("What is balance? " + userAccount.getBalance());
	}
	private static class AddAPenny implements Runnable{
		public void run() {
			synchronized(userAccount) { //by synchronizing it you cut down how many threads can access it at the same time
				userAccount.deposit(1);
			}
		}
	}
	
	private static class Account{
		private static Lock lock = new ReentrantLock(true);
		//private static Lock = the lock class. This creates a concrete lock(ReentraintLock)
		//ReentrantLock(true) allows for fairness meaning the thread that has been waiting longest gets access next
		private int balance = 0;
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			lock.lock(); //This is how you acquire the lock
			try {
				int newBalance = balance + amount;
				balance = newBalance;
			}
			finally {
				lock.unlock(); //this is how you release the lock for other threads
			}
			
		}
		
	}
}
