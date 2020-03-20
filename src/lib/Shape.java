package lib;

import processing.core.PApplet;
import processing.core.PShape;

public class Shape extends Entity {
	public Shape(PApplet pApplet, PShape shape) {
		this.pApplet = pApplet;
		this.shape = shape;
		this.shape.setStrokeCap(PApplet.SQUARE);
	}

	@Override
	public void draw() {
		super.draw();
		shape.resetMatrix();
		shape.translate(position.x, position.y);
		shape.translate(offset.x, offset.y);
		shape.rotate(rotation);
		shape.translate(-offset.x, -offset.y);
		shape.scale(scale.x, scale.y);

		pApplet.shape(shape, 0, 0);
	}

	@Override
	protected void setStyle() {
		shape.enableStyle();

		if (useStroke) {
			shape.setStrokeWeight(strokeWeight);
			shape.setStroke(strokeColor);
		} else {
			shape.noStroke();
		}

		if (useFill) {
			shape.setFill(fillColor);
		} else {
			shape.noFill();
		}
	}
}
