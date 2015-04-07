package test;

import map.HexagonMap;
import processing.core.PApplet;

public class HexagonMapTest extends PApplet {

	public HexagonMap map;
	
	public void setup()
	{
		size(500,500);
		strokeWeight(5);
		map = new HexagonMap(20,20);
	}
	
	public void draw()
	{
		background(255);
		fill(0); stroke(0);
		for (int r = 0; r < map.points.length; r++)
		{
			for (int c = 0; c < map.points[0].length; c++)
			{
				point((float)map.points[r][c].x, (float)map.points[r][c].y);
			}
		}
	}

}
