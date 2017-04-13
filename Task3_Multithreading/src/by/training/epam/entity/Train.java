package by.training.epam.entity;

import org.apache.log4j.Logger;

public class Train {

	private static Logger log = Logger.getLogger(Train.class);
	private boolean direction;
	
	public Train(boolean direction) {
		this.direction = direction;
	}
	
	public boolean getDirection(){
		return direction;
	}
	
	public void busyGo(){
		try {
			Thread.sleep(3_000);
		} catch (InterruptedException e) {
			log.error(e);
		}
	}
	
	public void restGo(){
		try {
			Thread.sleep(7_000);
		} catch (InterruptedException e) {
			log.error(e);
		}
	}

	@Override
	public String toString() {
		return "Train [direction=" + direction + "]";
	}
	
}
