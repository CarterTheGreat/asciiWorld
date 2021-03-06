package asciiWorld;

public class FungusAi extends CreatureAi {

	private CreatureFactory factory;
	private int spreadCount;
	
	public FungusAi(Creature creature, CreatureFactory factory) {
		super(creature);
		this.factory = factory;
	}
	
	public void onUpdate() {
		if(spreadCount < 5 && Math.random() < .025) {
			spread();
		}
	}
	
	public void spread() {
		
		//Spread out growth
		//int x = creature.x + (int)(Math.random()*11) - 5; 
		//int y = creature.y + (int)(Math.random()*11) - 5;
		
		//Globular growth
		int x = creature.x + (int)((Math.random() - .5) * 4);
		int y = creature.y + (int)((Math.random() - .5) * 4);
		
		if(!creature.canEnter(x,y))
			return;
		
		Creature child = factory.newFungus();
		child.x = x;
		child.y = y;
		spreadCount++;
	}
}
