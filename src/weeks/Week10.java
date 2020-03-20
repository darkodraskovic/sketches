package weeks;

import processing.core.PApplet;
import roguelike.Grid;

public class Week10 extends PApplet {

	Grid grid = new Grid(32, 32);
	
	public void settings() {
		size(600, 600);
	}

	@Override
	public void setup() {

	}

	@Override
	public void keyPressed() {
		super.keyPressed();

	}

	@Override
	public void draw() {

	}

	public static void main(String[] args) {
		String[] processingArgs = { "Sketch" };
		Week10 main = new Week10();
		PApplet.runSketch(processingArgs, main);
	}
}
