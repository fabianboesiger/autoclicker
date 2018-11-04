import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Main {
	
	static Robot robot;
	static Window window;

	public static void main(String[] args) {
		
		window = new Window();
		/*
		final int CLICKS_PER_MINUTE = Integer.parseInt(args[0]);
		final int MINUTES_TO_SLEEP = Integer.parseInt(args[1]);
		
		try{
			robot = new Robot();
		}catch(AWTException e){
			e.printStackTrace();
		}
		
		try{
			Thread.sleep(1000*60*MINUTES_TO_SLEEP);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		while(true){
			click();
			
			try{
				Thread.sleep(1000*60/CLICKS_PER_MINUTE);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		*/
	}
	
	public static void click() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

}
