package test;

import processing.core.PApplet;

import gen.MidpointDisplace;

public class MidpointDisplaceTest extends PApplet {

	private MidpointDisplace temp = new MidpointDisplace();
	private int rows = 257;
	
	public void setup()
	{
		size(1290,800);
		temp = new MidpointDisplace();
		//temp.seed(870L);
		temp.generate(new double[]{rows,0,0.5}); //2^n + 1
		temp.correct();
		temp.correct();
		for (int i = 0; i < temp.terrain.length; i++)
			System.out.print((int)temp.terrain[i] + " ");
		System.out.println();
	}
	
	public void draw()
	{
		background(255);
		stroke(0);
		int len = (int)((float)width/(float)rows), terrainHeight = 5;
		for (int i = 0; i < temp.terrain.length - 1; i++)
		{
			line(
					len*i, 
					height/2 - (float)temp.terrain[i]*terrainHeight, 
					len*(i+1),
					height/2 - (float)temp.terrain[i+1]*terrainHeight
					);
		}
	}

}
