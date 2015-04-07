package test;

import map.HexagonMap;
import map.Point;
import processing.core.PApplet;

public class HexagonMapTest extends PApplet {

	public HexagonMap map;
	
	public void setup()
	{
		size(500,500);
		strokeWeight(2);
		map = new HexagonMap(20,20);
		map.setupHex();
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
				fill(r*25F, 0, c*25F);
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
