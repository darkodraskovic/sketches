package week09.sketch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import processing.core.PApplet;
import processing.core.PShape;
import week09.lib.Shape;

public class Sketch09 extends PApplet {

	ArrayList<Shape> shapes = new ArrayList<Shape>();
	HashMap<String, Integer> colors = new HashMap<String, Integer>();

	public void settings() {
		size(600, 600);
	}

	float sclIncr = 0.2f;
	float lineScl = 2f;
	float gapScl = 2f;
	float weightScl = 2f;
	int verDist;
	int distScl = 30;

	@Override
	public void setup() {
		colors.put("green", 0xFF99B898);
		colors.put("red", 0xFFE84A5F);

		createShapes();
	}

	private void createShapes() {
		shapes.clear();

		verDist = height / distScl;
		int numLineRows = height / verDist;

		float noiseArg = 0.1f;
		float lineLen = width / 8;
		float gapLen = width / 16;

		for (int i = 0; i <= numLineRows; i++) {
			int lineStart = 0;
			while (lineStart < width) {
				float noise = noise(noiseArg);
				float ll = lineLen * noise * lineScl;
				float gl = gapLen * noise * gapScl;

				PShape line = createShape(LINE, gl * random(1) - gl / 2, 0, ll, 0);
				Shape shape = new Shape(this, line);
				shape.position.y = i * verDist + verDist / 2;
				shape.position.x = lineStart;
				shape.strokeColor = colors.get("red");
				shape.strokeWeight = 1 + weightScl * noise;
				shapes.add(shape);

				lineStart += ll + gl;
				noiseArg += 0.1;
			}
		}
	}

	@Override
	public void keyPressed() {
		super.keyPressed();

		switch (key) {
		case 'q':
			lineScl += sclIncr;
			break;
		case 'a':
			lineScl -= sclIncr;
			break;
		case 'w':
			gapScl += sclIncr;
			break;
		case 's':
			gapScl -= sclIncr;
			break;
		case 'e':
			weightScl += sclIncr;
			break;
		case 'd':
			weightScl -= sclIncr;
			break;
		case 'r':
			distScl--;
			break;
		case 'f':
			distScl++;
			break;
		default:
			break;
		}

		createShapes();
	}

	@Override
	public void draw() {
		background(colors.get("green"));

		for (Iterator<Shape> iterator = shapes.iterator(); iterator.hasNext();) {
			Shape shape = (Shape) iterator.next();
			shape.draw();
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Sketch" };
		Sketch09 main = new Sketch09();
		PApplet.runSketch(processingArgs, main);
	}
}
