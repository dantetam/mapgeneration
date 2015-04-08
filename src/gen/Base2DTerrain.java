package gen;

import java.util.Random;

public abstract class Base2DTerrain {

	public double[] terrain;
	public Random random;
	
	public void seed(long seed)
	{
		random = null;
		random = new Random(seed); 
	}
	
	public abstract double[] generate();
	public abstract double[] generate(double[] arguments);

}
