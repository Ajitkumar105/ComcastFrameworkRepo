package practice;

import java.util.Date;

public class CaptureTimeStamp {
	
	public static void main(String[] args) {
		String time=new Date().toString().replace(" ", "_").replace(":", " ");
		
		System.out.print(time);
	}

	

	

}
