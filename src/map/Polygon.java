package map;

import java.util.ArrayList;

public class Polygon {

	public ArrayList<Point> points;
	
	public Polygon(Point... p) {
		points = new ArrayList<Point>();
		for (int i = 0; i < p.length; i++)
			points.add(p[i]);
		order();
	}
	
	//Given a set of convex points, order them in a reasonable manner
	public void order()
	{
		if (points.size() == 1) return;
		ArrayList<Point> temp = new ArrayList<Point>();
		temp.add(points.get(0)); points.remove(0);
		do
		{
			if (points.size() == 1)
			{
				temp.add(points.get(0));
				break;
			}
			int candidate = 0;
			for (int i = 1; i < points.size(); i++)
				if (temp.get(temp.size() - 1).dist(points.get(i)) < temp.get(temp.size() - 1).dist(points.get(candidate)))
					candidate = i;
			temp.add(points.get(candidate)); points.remove(candidate); 
		} while (true);
		points = temp;
	}
	
	/*public Polygon(Point[] p) {
		for (int i = 0; i < p.length; i++)
			points.add(p[i]);
	}*/
	
	/*public Polygon[] split(Segment l)
	{
		Polygon[] temp = new Polygon[2];
		ArrayList<Segment> sides = new ArrayList<Segment>();
		for (int i = 0; i < points.size() - 1; i++)
		{
			sides.add(new Segment(points.get(i), points.get(i+1)));
		}
		Point intersect1, intersect2 = null;
		int side1, side2;
		for (int i = 0; i < sides.size(); i++)
		{
			Point p = l.intersect(sides.get(i));
			if (p != null)
			{
				if (intersect1 == null) {intersect1 = p; side1 = i;}
				else if (intersect2 == null) {intersect2 = p; side2 = i;}
			}
		}
		if (intersect1 != null && intersect2 != null)
		{
			Point[] newPoints = new Point[];
			for (int i = 0; i <= side1; i++)
				newPoints[i] = points.get(i);
			newPoints[side1 + 1] = intersect1;
			newPoints[side1 + 2] = intersect2;
			for (int i = side1 + 3; i <= side1 + 3 )
				newPoints[i] = 
			temp[0] = new Polygon();
			return temp;
		}
		else
			return new Polygon[]{this}; //Unsuccessful split
	}*/

}
