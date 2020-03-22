package roguelike;

import java.util.ArrayList;

import org.joml.Vector2i;

import lib.Entity;

public class Thing extends MapEntity {
	protected Cell cell;
	private Thing owner;
	private ArrayList<Thing> things = new ArrayList<Thing>();

	public Thing(Map map, Entity entity) {
		super(map, entity);
	}

	public Thing(Map map, Entity entity, int x, int y) {
		super(map, entity);
		setPosition(x, y);
	}

	// POSITION
	@Override
	public void setPosition(int x, int y) {
		Cell cell = map.getCell(x, y);
		super.setPosition(cell.position.x, cell.position.y);
		cell.setThing(this);
	}

	public Vector2i getPosition() {
		return getCell().getPosition();
	}

	// CELL
	protected Cell getCell() {
		if (owner != null) {
			return owner.getCell();
		}
		return cell;
	}

	// OWNER
	protected void setOwner(Thing newOwner) {
		// remove owner
		if (newOwner == null) {
			owner.things.remove(this);
			owner = null;
			return;
		}

		// add owner
		if (cell != null) {
			cell.things.remove(this);
		}
		if (owner != null) {
			owner.things.remove(this);
		}
		newOwner.things.add(this);
		owner = newOwner;
	}
}
