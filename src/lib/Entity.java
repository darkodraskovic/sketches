package lib;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Entity {
	public String name;

	// system
	protected PApplet pApplet;

	// transform
	public PVector position = new PVector(0, 0);
	public PVector offset = new PVector(0, 0);
	public PVector scale = new PVector(1, 1);
	public float rotation;
	public boolean dynamic = true;
	
	// style
	public boolean useStyle = true;
	public boolean useStroke = true;
	public int strokeColor = 0xFF000000;
	public float strokeWeight = 1;
	public boolean useFill = true;
	public int fillColor = 0xFFFFFFFF;

	public Entity(PApplet pApplet) {
		this.pApplet = pApplet;

		pApplet.strokeCap(PApplet.SQUARE);
	}
	
	public void draw() {
		if (useStyle) {
			setStyle();
		}
		if (dynamic) {
			updateTransform();
		}
	};

	abstract protected void setStyle();
	abstract protected void updateTransform();
}
