package week09.lib;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class Shape {
	public String name;
	
	// system
	private PApplet pApplet;
	public PShape shape;

	// transform
	public PVector position = new PVector(0,0);
	public PVector offset = new PVector(0, 0);
	public PVector scale = new PVector(1, 1);
	public float rotation;

	// style
	public boolean useStyle = true;
	public boolean useStroke = true;
	public int strokeColor;
	public float strokeWeight = 1;
	public boolean useFill = true;
	public int fillColor;

	public Shape(PApplet pApplet, PShape shape) {
		this.pApplet = pApplet;
		this.shape = shape;
		this.shape.setStrokeCap(PApplet.SQUARE);
	}
	
	// draw
	public void draw() {
		if (useStyle) {
			setStyle();
		}

		shape();
	}

	private void setStyle() {
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

	private void shape() {
		shape.resetMatrix();
		shape.translate(position.x, position.y);
		shape.translate(offset.x, offset.y);
		shape.rotate(rotation);
		shape.translate(-offset.x, -offset.y);
		shape.scale(scale.x, scale.y);

		pApplet.shape(shape, 0, 0);
//		System.out.println(name);
	}

}
