package test;

import processing.core.PApplet;

import gen.MidpointDisplace;

public class MidpointDisplaceTest extends PApplet {

	private MidpointDisplace temp = new MidpointDisplace();
	private double[] averages;
	private int rows = 257;
	
	public void setup()
	{
		size(1290,800);
		frameRate(10);
		generateTerrain();
		/*for (int i = 0; i < temp.terrain.length; i++)
			System.out.print((int)temp.terrain[i] + " ");
		System.out.println();*/
	}
	
	public void draw()
	{
		background(255);
		stroke(0);
		int len = (int)((float)width/(float)rows), terrainHeight = 3;
		for (int i = 0; i < temp.terrain.length - 1; i++)
		{
			line(
					len*i, 
					height/2 - (float)temp.terrain[i]*terrainHeight, 
					len*(i+1),
					height/2 - (float)temp.terrain[i+1]*terrainHeight
					);
		}
		stroke(255,0,0);
		for (int i = 0; i < averages.length - 1; i++)
		{
			line(
					len*i, 
					height/2 - (float)averages[i]*terrainHeight, 
					len*(i+1),
					height/2 - (float)averages[i+1]*terrainHeight
					);
		}
		average();
	}
	
	public void mouseClicked()
	{
		generateTerrain();
	}
	
	public void generateTerrain()
	{
		temp = new MidpointDisplace();
		//temp.seed(870L);
		temp.generate(new double[]{rows,0,0.5}); //2^n + 1
		temp.correct();
		temp.correct();
		average();
	}
	
	public void average()
	{
		if (frameCount % 20 <= 10)
			averages = averageCurve(temp.terrain, frameCount % 20);
		else
			averages = averageCurve(temp.terrain, 10 - frameCount % 10);
	}
	
	private double[] averageCurve(double[] terrain, int len)
	{
		double[] t = new double[terrain.length];
		for (int i = 0; i < terrain.length; i++)
		{ 
			//Average of the closest set of numbers of len away from i
			double sum = 0, n = 0;
			for (int j = i - len; j <= i + len; j++)
				if (j >= 0 && j < terrain.length)
				{
					sum += terrain[j]; 
					n++;
				}
			t[i] = sum/n;
		}
		return t;
	}

}
