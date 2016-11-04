package designpattern.structural.bridge;

public class RedCircle implements DrawAPI {

	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Red Circle: [" + radius + " " + x + " " + y + "]");
	}

}
