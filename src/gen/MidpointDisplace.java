package gen;

public class MidpointDisplace extends Base2DTerrain {

	public static void main(String[] args)
	{
		MidpointDisplace temp = new MidpointDisplace();
		temp.seed(870L);
		temp.generate(new double[]{17,0}); //2^n + 1
		for (int i = 0; i < temp.terrain.length; i++)
			System.out.print((int)temp.terrain[i] + " ");
		System.out.println();
	}
	
	public MidpointDisplace() {
		seed(System.currentTimeMillis());
	}

	public double[] generate() {
		return null;
	}

	//args[0] = rows, args[1] = starting amplitude
	public double[] generate(double[] args) {
		terrain = new double[(int)args[0]];
		terrain[0] = args[1]; terrain[terrain.length - 1] = args[1];
		averageDivide(terrain, 0, terrain.length - 1, 50);
		return super.terrain;
	}
	
	public void averageDivide(double[] t, int a, int b, double amp)
	{
		if (b - a < 2) return;
		t[(a+b)/2] = (t[a]+t[b])/2 + random.nextDouble()*amp;
		averageDivide(t,a,(a+b)/2,amp/2);
		averageDivide(t,(a+b)/2,b,amp/2);
	}

}
