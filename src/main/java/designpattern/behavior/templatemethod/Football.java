package designpattern.behavior.templatemethod;

public class Football extends Game {

	@Override
	void initialize() {
		System.out.println("Football game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Football game Started! Enjoy the game.");
	}

	@Override
	void endPlay() {
		System.out.println("Football game Finished!");
	}
	
}
