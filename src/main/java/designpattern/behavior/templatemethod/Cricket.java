package designpattern.behavior.templatemethod;

public class Cricket extends Game {

	@Override
	void initialize() {
		System.out.println("Cricket game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Cricket game Started! Enjoy the game.");
	}

	@Override
	void endPlay() {
		System.out.println("Cricket game Finished!");
	}
	
}
