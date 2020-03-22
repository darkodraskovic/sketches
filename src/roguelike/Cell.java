package roguelike;

import java.util.ArrayList;

import org.joml.Vector2i;

import lib.Entity;

public class Cell extends MapEntity {

	protected ArrayList<Thing> things = new ArrayList<Thing>();

	// CONSTRUCTOR
	public Cell(Map map, Entity entity) {
		super(map, entity);
	}

	public Cell(Map map, Entity entity, int x, int y) {
		super(map, entity);
		setPosition(x, y);
	}
	
	// POSITION
	public void setPosition(int x, int y) {
		super.setPosition(x, y);
		map.setCell(this, x, y);		
	}
	
	public Vector2i getPosition() {
		return new Vector2i(position);
	}

	// THINGS
	protected void setThing(Thing thing) {
		if (thing.cell != null) {
			thing.cell.things.remove(thing);
		}
		things.add(thing);
		thing.cell = this;
	}

	// DRAW
	@Override
	protected void draw() {
		super.draw();
		for (Thing thing : things) {
			thing.draw();
		}
	}
}
