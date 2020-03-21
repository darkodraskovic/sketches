package lib;

import processing.core.PApplet;
import processing.core.PShape;

public class Shape extends Entity {
	public PShape shape;

	public Shape(PApplet pApplet, PShape shape) {
		super(pApplet);
		this.shape = shape;
	}

	@Override
	public void draw() {
		super.draw();
		
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

	protected void updateTransform() {
		shape.resetMatrix();
		shape.translate(position.x, position.y);
		shape.translate(offset.x, offset.y);
		shape.rotate(rotation);
		shape.translate(-offset.x, -offset.y);
		shape.scale(scale.x, scale.y);
	}
}
