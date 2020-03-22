package weeks;

import java.util.ArrayList;
import java.util.Iterator;

import org.joml.Vector2i;

import discrete.shape.Stroke;
import lib.Entity;
import lib.Graphics;
import lib.Shape;
import processing.core.PApplet;
import processing.core.PShape;
import roguelike.Map;

public class Week10 extends PApplet {

	ArrayList<Entity> entities = new ArrayList<Entity>();

	Map map;

	public void settings() {
		size(600, 600);
	}

	@Override
	public void setup() {
		map = new Map(this);
		ArrayList<Vector2i> line = Stroke.bresenhamLine(1, 1, 10, 3);
		for (Vector2i l : line) {
			PShape rectShape = createShape(PApplet.RECT, 0, 0, map.getCellWidth(), map.getCellHeight());
			Entity entity = new Shape(this, rectShape);
			entity.fillColor = color(255, 0, 0);
			map.setCell(entity, l.x, l.y);
		}
	}

	@Override
	public void keyPressed() {
		super.keyPressed();

	}

	@Override
	public void draw() {
		for (Iterator<Entity> iterator = entities.iterator(); iterator.hasNext();) {
			Entity entity = iterator.next();
			entity.draw();
		}
		map.draw();
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Sketch" };
		Week10 main = new Week10();
		PApplet.runSketch(processingArgs, main);
	}
}
