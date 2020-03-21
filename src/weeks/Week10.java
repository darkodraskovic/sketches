package weeks;

import java.util.ArrayList;
import java.util.Iterator;

import lib.Entity;
import lib.Graphics;
import processing.core.PApplet;

public class Week10 extends PApplet {

	ArrayList<Entity> entities = new ArrayList<Entity>();

	public void settings() {
		size(600, 600);
	}

	@Override
	public void setup() {
		Graphics gfx = new RectSequence(this);
		entities.add(gfx);
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
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Sketch" };
		Week10 main = new Week10();
		PApplet.runSketch(processingArgs, main);
	}
	
	public class RectSequence extends Graphics {
		public RectSequence(PApplet pApplet) {
			super(pApplet);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void shape() {
			for (int i = 0; i < 10; i++) {
				pApplet.rect(i*32, 32, 32, 32);
			}

		}
	}
}


