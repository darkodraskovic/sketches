package roguelike;

import java.util.ArrayList;

import lib.Entity;
import lib.Shape;
import processing.core.PApplet;
import processing.core.PShape;

public class Map {
	protected PApplet pApplet;

	private ArrayList<Cell> cells = new ArrayList<Cell>();
	private int width = 32;
	private int height = 24;
	protected int cellWidth = 16;
	protected int cellHeight = 16;

	public int getCellWidth() {
		return cellWidth;
	}

	public int getCellHeight() {
		return cellHeight;
	}

	public Map(PApplet pApplet) {
		this.pApplet = pApplet;

		this.createBaseMap();
	}

	public Map(PApplet pApplet, int width, int height, int cellWidth, int cellHeight) {
		this.pApplet = pApplet;

		this.width = width;
		this.height = height;
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;

		this.createBaseMap();
	}

	private void createBaseMap() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Entity entity = createBaseCellEntity();
				Cell cell = new Cell(this, entity, x, y);
				cells.add(cell);
			}
		}
	}

	private Entity createBaseCellEntity() {
		PShape rect = pApplet.createShape(PApplet.RECT, 0, 0, this.cellWidth, this.cellHeight);
		return new Shape(this.pApplet, rect);
	}

	public Cell getCell(int x, int y) {
		return cells.get(getIndex(x, y));
	}

	public void setCell(Cell cell, int x, int y) {
		cell.setPosition(x, y);
		cells.set(getIndex(x, y), cell);
	}

	public void setCell(Entity entity, int x, int y) {
		Cell cell = new Cell(this, entity, x, y);
		cells.set(getIndex(x, y), cell);
	}

	private int getIndex(int x, int y) {
		return y * this.width + x;
	}

	public void draw() {
		for (Cell cell : cells) {
			cell.draw();
		}
	}
}
