package lib;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public abstract class Entity {
	public String name;
	
	// system
	protected PApplet pApplet;
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
	
	public void draw() {
		if (useStyle) {
			setStyle();
		}
	};
	
	abstract protected void setStyle();
}
