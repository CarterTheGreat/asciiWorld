package asciiWorld;

import java.awt.Color;

public class Creature {

	private World world;
	
	// Display values
	public int x;
	public int y;
	
	private char glyph;
	public char glyph() { return glyph; }
	
	private Color color;
	public Color color() { return color; } 
	
	// Traits
	private CreatureAi ai;
	public void setCreatureAi(CreatureAi ai ) { this.ai = ai;}

	private int maxHp;
	public int maxHp() { return maxHp; }
	
	private int hp;
	public int hp() { return hp; }
	
	private int attackValue;
	public int attackValue() { return attackValue; }

	private int defenceValue;
	public int defenceValue() { return defenceValue; }
	
	
	
	public Creature(World world, char glyph, Color color, int maxHp, int attackValue, int defenceValue) {
		this.world = world;
		this.glyph = glyph;
		this.color = color; 
		this.maxHp = maxHp;
		this.attackValue = attackValue;
		this.defenceValue = defenceValue;
	}
	
	
	
	public void moveBy(int mx, int my) {
		Creature other = world.creature(x+mx,y+my);
		
		if(other == null) {
			ai.onEnter(x+mx, y + my, world.tile(x+mx, y+my));
		}else attack(other);	
	}
	
	public boolean canEnter(int wx, int wy) {
		return world.tile(wx, wy).isGround() && world.creature(wx, wy) == null;
	}
	
	public void dig(int wx, int wy) {
		world.dig(wx,wy);
	}
	
	public void attack(Creature other) {
		int amount = Math.max(0, attackValue() - other.defenceValue());
		amount = (int)(Math.random() * amount) + 1;
		other.modifyHp(-amount);
		notify("You attack the '%s' for %d damage.", other.glyph, amount);
		other.notify("The '%s' attacks you for %d damage.", glyph, amount);
	}
	
	public void doAction(String message, Object ... params){
       int r = 9;
       for(int ox = -r; )
	}

	public void notify(String message, Object... params) {
		ai.onNotify(String.format(message, params));
	}
	
	public void update() {
		ai.onUpdate();
	}
	

}
