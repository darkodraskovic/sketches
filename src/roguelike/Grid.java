package roguelike;

import java.util.ArrayList;

public class Grid {

	private ArrayList<Integer> cells = new ArrayList<Integer>();
	private int width;

	public Grid(int width, int height) {
		this.width = width;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				cells.add(0);
			}
		}
	}

	public Integer getCell(int x, int y) {
		return cells.get(getIndex(x, y));
	}

	public void setCell(Integer type, int x, int y) {
		cells.set(getIndex(x, y), type);
	}

	private int getIndex(int x, int y) {
		return y * this.width + x;
	}
	
	public void setRect(Integer type, int x, int y, int width, int height) {
		for (int sy = 0; sy < sy + height; sy++) {
			for (int sx = 0; sx < sx + width; sx++) {
				cells.set(getIndex(x, y), type);
			}
		}
	}
}
