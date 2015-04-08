package test;

import processing.core.PApplet;

import map.*;

public class HexagonMapTest extends PApplet {

	public HexagonMap map;
	
	public void setup()
	{
		size(800,800);
		strokeWeight(2);
		//map = new NoiseHexagonMap("hex",25,25);
		map = new HexagonMap("square",25,25);
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
		for (int r = 0; r < map.hexs.length; r++)
		{
			for (int c = 0; c < map.hexs[0].length; c++)
			{
				if (map.hexs[r][c] == null) continue;
				//try {
				fill(r*10F, 0, c*10F);
				beginShape();
				for (int i = 0; i < map.hexs[r][c].points.size(); i++)
				{
					Point p = map.hexs[r][c].points.get(i);
					vertex((float)p.x, (float)p.y);
				}
				endShape();
				//} catch (Exception e) {}
			}
		}
	}

}
