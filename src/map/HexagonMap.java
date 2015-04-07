package map;

public class HexagonMap {

	public Point[][] points;
	public Polygon[][] hexs;
	public int row, col;
	public float len = 20;

	public HexagonMap(int rows, int cols) {
		row = rows; col = cols;
		points = new Point[row][col];
		for (int r = 0; r < row; r++)
		{
			for (int c = 0; c < col; c++)
			{
				double x = r*len, y = c*len*1.5F;
				//if (r % 2 == 1) y -= c*len/2;
				if (c % 2 == 0) y += len/2;	

				if (c % 2 == 0)
				{
					if (r % 2 == 0) 
						y -= len/2;
				}
				else
				{
					if (r % 2 == 0)
						y += len/2;
				}
				points[r][c] = new Point(x,y,0);
			}
		}
	}

	public void setupHex()
	{
		hexs = new Polygon[row][col]; //some extra spaces just in case
		for (int r = 0; r < row - 2; r += 2)
		{
			for (int c = 0; c < col - 2; c += 1)
			{
				if (r+2 >= points.length || c+2 >= points[0].length) continue;
				if (c % 2 == 0) 
				{
					r++;
					try {hexs[r][c] = new Polygon(points[r][c],points[r+1][c],points[r+2][c],points[r+2][c+1],points[r+1][c+1],points[r][c+1]);} catch (Exception e) {}
					r--;
				}
				else
					try {hexs[r][c] = new Polygon(points[r][c],points[r+1][c],points[r+2][c],points[r+2][c+1],points[r+1][c+1],points[r][c+1]);} catch (Exception e) {}
			}
		}
		/*for (int r = 1; r < row - 2; r += 2)
		{
			for (int c = 0; c < col - 2; c += 2)
			{
				hexs[r][c] = new Polygon(points[r][c],points[r+1][c],points[r+2][c],points[r+2][c+1],points[r+1][c+1],points[r][c+1]);
			}
		}*/
	}

}
