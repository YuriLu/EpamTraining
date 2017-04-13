package by.training.epam.main;

import by.training.epam.entity.Tunnel;
import by.training.epam.resourses.WaitingPool;
import by.training.epam.threads.CreatorThread;
import by.training.epam.threads.DispatcherThread;
import by.training.epam.threads.WaitingPoolMonitorThread;

public class MainClass {
	
	public static void main(String[] args) {
		
		Tunnel tunnelTrue = new Tunnel(true);
		Tunnel tunnelFalse = new Tunnel(false);
		WaitingPool waitingPool = new WaitingPool();
		
		CreatorThread creator = new CreatorThread(waitingPool);
		creator.start();
		
		WaitingPoolMonitorThread poolMonitor = new WaitingPoolMonitorThread(waitingPool);
		poolMonitor.setDaemon(true);
		poolMonitor.start();
		
		DispatcherThread dispatcher = new DispatcherThread(waitingPool, tunnelTrue, tunnelFalse);
		dispatcher.setDaemon(true);
		dispatcher.start();
	
		
	}

}
