package roguelike;

import java.util.ArrayList;

import lib.Entity;
import lib.Shape;
import processing.core.PApplet;
import processing.core.PShape;

public class Map {
	protected PApplet pApplet;

	protected ArrayList<Cell> cells;

	protected int width;
	protected int height;
	protected int cellWidth;
	protected int cellHeight;

	// CONSTRUCTOR
	public Map(PApplet pApplet) {
		this.pApplet = pApplet;

		setDimensions(32, 24, 16, 16);
		createBaseMap();
	}

	public Map(PApplet pApplet, int width, int height, int cellWidth, int cellHeight) {
		this.pApplet = pApplet;

		setDimensions(width, height, cellWidth, cellHeight);
		createBaseMap();
	}

	// DIMENSIONS
	private void setDimensions(int width, int height, int cellWidth, int cellHeight) {
		this.width = width;
		this.height = height;
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;

		cells = new ArrayList<Cell>(width * height);
	}

	public int getCellWidth() {
		return cellWidth;
	}

	public int getCellHeight() {
		return cellHeight;
	}
	
	// BASE MAP
	private void createBaseMap() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				new Cell(this, createBaseCellEntity(), x, y);
			}
		}
	}

	private Entity createBaseCellEntity() {
		PShape rect = pApplet.createShape(PApplet.RECT, 0, 0, this.cellWidth, this.cellHeight);
		return new Shape(this.pApplet, rect);
	}

	// CELL
	public Cell getCell(int x, int y) {
		x = Utils.clamp(x, 0, width - 1);
		y = Utils.clamp(y, 0, height - 1);
		return cells.get(y * this.width + x);
	}

	protected void setCell(Cell cell, int x, int y) {
		// if map is created
		if (cells.size() < width * height) {
			cells.add(cell);
			return;
		}
		cells.set(y * this.width + x, cell);
	}

	// DRAW
	public void draw() {
		for (Cell cell : cells) {
			cell.draw();
		}
	}
}
