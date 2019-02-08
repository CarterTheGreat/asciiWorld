package asciiWorld.screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class StartScreen implements Screen{

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("Hi this is my game",1,1);
		terminal.writeCenter(" -- [Enter] -- ", 22);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		System.out.println("Key event");
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}

}
