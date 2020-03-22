package weeks;

import java.util.ArrayList;
import java.util.Iterator;

import org.joml.Vector2i;

import discrete.shape.Stroke;
import lib.Entity;
import lib.Shape;
import processing.core.PApplet;
import processing.core.PShape;
import processing.event.KeyEvent;
import roguelike.Cell;
import roguelike.Map;
import roguelike.Thing;

public class Week10 extends PApplet {

	ArrayList<Entity> entities = new ArrayList<Entity>();

	Map map;

	Thing player;

	public void settings() {
		size(600, 600);
	}

	@Override
	public void setup() {
		map = new Map(this);
		ArrayList<Vector2i> line = Stroke.bresenhamLine(1, 1, 10, 3);
		for (Vector2i point : line) {
			createWallCell(point);
		}

		PShape ellipseShape = createShape(PApplet.ELLIPSE, 0, 0, map.getCellWidth(), map.getCellHeight());
		Entity entity = new Shape(this, ellipseShape);
		entity.fillColor = color(0, 0, 255);
		entity.offset.add(map.getCellWidth() / 2, map.getCellHeight() / 2);
		player = new Thing(map, entity, 8, 9);
	}

	private void createWallCell(Vector2i position) {
		PShape rectShape = createShape(PApplet.RECT, 0, 0, map.getCellWidth(), map.getCellHeight());
		Entity entity = new Shape(this, rectShape);
		entity.fillColor = color(255, 0, 0);
		new Cell(map, entity, position.x, position.y);
	}

	@Override
	public void keyPressed() {
		super.keyPressed();
	}

	@Override
	public void draw() {
		background(128);
		for (Iterator<Entity> iterator = entities.iterator(); iterator.hasNext();) {
			Entity entity = iterator.next();
			entity.draw();
		}
		map.draw();
	}

	@Override
	public void keyPressed(KeyEvent event) {
		super.keyPressed(event);
		Vector2i position = player.getPosition();
		switch (key) {
		case 'a':
			player.setPosition(position.x - 1, position.y);
			break;
		case 'd':
			player.setPosition(position.x + 1, position.y);
			break;
		case 'w':
			player.setPosition(position.x, position.y - 1);
			break;
		case 's':
			player.setPosition(position.x, position.y + 1);
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Sketch" };
		Week10 main = new Week10();
		PApplet.runSketch(processingArgs, main);
	}
}
