import java.awt.AWTException;
import java.awt.Robot;

public class Clicker extends Thread {
		
	private Robot robot;
	
	private final int clicks;
	private final int delay;
	private final int button;
	
	private boolean shutdown;

	public Clicker(int clicks, int delay, int button) {
		this.clicks = clicks;
		this.delay = delay;
		this.button = button;
		
		shutdown = false;
	}	
		
	public void run() {	
		try{
			robot = new Robot();
		}catch(AWTException e){
			e.printStackTrace();
		}
		
		try{
			Thread.sleep(1000*delay);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		while(!shutdown){
			click();
			
			try{
				Thread.sleep(1000/clicks);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void click() {
		robot.mousePress(button);
		robot.mouseRelease(button);
	}
	
	public void shutdown() {
		shutdown = true;
	}
	
}
