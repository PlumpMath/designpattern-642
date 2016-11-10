package designpattern.structural.flyweight;

public class Circle implements Shape {
	
	private String color;
	private int x;
	private int y;
	private int radius;
	
	public Circle(String color) {
		this.color = color;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}



	public void draw() {
		System.out.println("Circle::draw() [Color: " + this.color + ", x: " + this.x + ", y: " + this.y);
	}

}
