package lib;

import processing.core.PApplet;

abstract public class Graphics extends Entity {
	public Graphics(PApplet pApplet) {
		super(pApplet);
	}

	@Override
	public void draw() {
		super.draw();
		shape();
		pApplet.popMatrix();
	}

	abstract protected void shape();

	@Override
	protected void setStyle() {
		if (useStroke) {
			pApplet.strokeWeight(strokeWeight);
			pApplet.stroke(strokeColor);
		} else {
			pApplet.noStroke();
		}

		if (useFill) {
			pApplet.fill(fillColor);
		} else {
			pApplet.noFill();
		}
	}

	protected void updateTransform() {
		pApplet.pushMatrix();
		pApplet.translate(position.x, position.y);
		pApplet.translate(pivot.x, pivot.y);
		pApplet.rotate(rotation);
		pApplet.translate(-pivot.x, -pivot.y);
		pApplet.scale(scale.x, scale.y);
		pApplet.translate(offset.x, offset.y);
	}
}
