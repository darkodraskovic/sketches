package roguelike;

import java.util.ArrayList;

import lib.Entity;
import processing.core.PVector;

public class Cell {
	private Map map;
	private Entity entity;
	protected ArrayList<Entity> entities;
	private PVector mapPosition = new PVector();

	public Cell(Map map, Entity entity, int x, int y) {
		this.map = map;
		this.entity = entity;
		setPosition(x, y);
	}

	protected void setPosition(int x, int y) {
		entity.position.x = x * this.map.cellWidth;
		entity.position.y = y * this.map.cellHeight;
		mapPosition.x = x;
		mapPosition.y = y;
	}
	
	protected void draw() {
		entity.draw();
	}
}
