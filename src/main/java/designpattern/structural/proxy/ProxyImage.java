package designpattern.structural.proxy;

public class ProxyImage implements Image {
	
	private RealImage realImage;
	private String fileName;
	
	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	public void display() {
		if(realImage == null) {
			realImage = new RealImage(this.fileName);
		}
		realImage.display();
	}
	
	public Image getRealImage() {
		return this.realImage;
	}

}
