package asciiWorld;

import java.util.List;
import asciiPanel.AsciiPanel;

public class CreatureFactory {

	private World world;
	
	public CreatureFactory(World world) {
		this.world = world;
	}
	
	// world, glyph, color, maxHp, attackValue, defenceValue
	public Creature newPlayer(List<String> messages){
		Creature player = new Creature(world, '@', AsciiPanel.brightYellow, 100, 20, 5);
		world.addAtEmptyLocation(player);
		new PlayerAi(player, messages);
		return player;
	}
	
	public Creature newFungus() {
		Creature fungus = new Creature(world, 'f', AsciiPanel.green, 10, 1, 0);
		world.addAtEmptyLocation(fungus);
		new FungusAi(fungus, this);
		return fungus;
	}
	
}
