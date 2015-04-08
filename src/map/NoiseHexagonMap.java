package map;

import java.util.ArrayList;

public class NoiseHexagonMap extends HexagonMap {

	public NoiseHexagonMap(String type, int rows, int cols) {
		super("hex", rows, cols);
	}

	public void setupHex()
	{
		super.setupHex("hex");
		for (int r = 0; r < hexs.length; r++)
		{
			for (int c = 0; c < hexs[0].length; c++)
			{
				Polygon pol = hexs[r][c];
				if (pol == null) continue;
				//If it's an even "row", add more vertices to the hexagon
				//otherwise, use the generately verticed to maintain tesellation
				//(i.e. no empty spaces)
				if (c % 2 == 0)
				{
					ArrayList<Point> newPoints = new ArrayList<Point>();
					for (int i = 0; i < pol.points.size() - 1; i++)
					{
						Point p1 = pol.points.get(i), p2 = pol.points.get(i+1);
						newPoints.add(new Point(
								(p1.x + p2.x)/2D + (Math.random()-0.5)*10, 
								(p1.y + p2.y)/2D + (Math.random()-0.5)*10, 
								0)
								);
					}
					//Insert the newly created points in between the others in backwards order
					/*for (int i = newPoints.size() - 1; i >= 0; i--)
					pol.points.add(2*i + 1, newPoints.get(i));*/
					/*0 1 2 3 4
					 --0 1 2 3 

					 --1 3 5 7*/
					for (int i = 0; i < newPoints.size(); i++)
						pol.points.add(2*i + 1, newPoints.get(i));
				}
			}
			//Generate all even "rows" first and then use the data to get the new points for next hexes
			for (int c = 0; c < hexs[0].length; c++)
			{
				Polygon pol = hexs[r][c];
				if (pol == null) continue;
				if (c % 2 == 1)
				{
					
				}
			}
		}
	}

}
