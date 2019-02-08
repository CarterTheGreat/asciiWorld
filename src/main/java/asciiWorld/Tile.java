package asciiWorld;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Tile {

	FLOOR((char)250, AsciiPanel.brightBlue),
	WALL((char)178, AsciiPanel.brightBlue),
	BOUNDS('X', AsciiPanel.brightBlack);
	
	private char glyph;
	public char glyph() { return glyph; }
	
	private Color color;
	public Color color() { return color; }
	
	Tile(char glyph, Color color){
		this.glyph = glyph;
		this.color = color;
	}
	
	public boolean isDiggable(){
		return this == Tile.WALL;
	}
	
	public boolean isGround() {
		return this != WALL && this != BOUNDS;
	}
}
