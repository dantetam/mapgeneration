package map;

import java.util.ArrayList;

public class Polygon {

	public ArrayList<Point> points;
	
	public Polygon(Point... p) {
		points = new ArrayList<Point>();
		for (int i = 0; i < p.length; i++)
			points.add(p[i]);
	}
	
	public Polygon[] split(Segment l)
	{
		return new Polygon[2];
	}

}
