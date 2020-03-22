package roguelike;

import org.joml.Vector2i;

import lib.Entity;

abstract public class MapEntity {
	private Entity entity;
	protected boolean visible = true;
	
	protected Map map;
	protected Vector2i position = new Vector2i();
	
	// CONSTRUCTOR
	public MapEntity(Map map, Entity entity) {
		this.entity = entity;
		this.map = map;
	}

	// POSITION
	public void setPosition(int x, int y) {
		entity.position.x = x * map.cellWidth;
		entity.position.y = y * map.cellHeight;
		position.x = x;
		position.y = y;
	}

	// DRAW
	protected void draw() {
		entity.draw();
	}
}
