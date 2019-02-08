package asciiWorld;

import java.applet.Applet;

import asciiPanel.AsciiPanel;

@SuppressWarnings("deprecation")
public class AppletMain extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private AsciiPanel terminal;
	
	public AppletMain() {
		super();
		terminal = new AsciiPanel();
		terminal.write("Test as well",1,1);
		add(terminal);
	}
	
	public void init() {
		super.init();
		this.setSize(terminal.getWidth() + 20, terminal.getHeight() + 20);
	}
	
	public void repaint() {
		super.repaint();
		terminal.repaint();
	}
	
	
}
