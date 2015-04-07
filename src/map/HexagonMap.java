package map;

public class HexagonMap {

	public Point[][] points;
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

}
