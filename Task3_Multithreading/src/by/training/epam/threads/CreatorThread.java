package by.training.epam.threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.training.epam.entity.Train;
import by.training.epam.resourses.WaitingPool;

public class CreatorThread extends Thread {

	private static Logger log = Logger.getLogger(CreatorThread.class);
	private final Lock lock = new ReentrantLock();
	private WaitingPool pool;
	
	public CreatorThread(WaitingPool pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(i < 100){
			
			try {
				Thread.sleep(new Random().nextInt(12_000));
			} catch (InterruptedException e) {
				log.error(e);
			}
			
			Train train = new Train(new Random().nextBoolean());
			
			try {
				lock.lock();
					pool.addTrain(train);
				
			}  finally {
				lock.unlock();
			}
			
			i++;
			
		}
		
	}
	
}
