package gen;

public class MidpointDisplace extends Base2DTerrain {

	public static void main(String[] args)
	{
		MidpointDisplace temp = new MidpointDisplace();
		temp.seed(870L);
		temp.generate(new double[]{129,0,0.9}); //2^n + 1
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

	//args[0] = rows, args[1] = starting amplitude, args[2] = persistence
	public double[] generate(double[] args) {
		terrain = new double[(int)args[0]];
		terrain[0] = args[1]; terrain[terrain.length - 1] = args[1];
		for (int i = 0; i < 5; i++)
		{
			averageDivide(terrain, 0, terrain.length - 1, 64, args[2]);
		}
		return super.terrain;
	}
	
	public void averageDivide(double[] t, int a, int b, double amp, double persistence)
	{
		if (b - a < 2) return;
		//System.out.println(amp);
		t[(a+b)/2] = (t[a]+t[b])/2 + (random.nextDouble()*2 - 1)*amp;
		averageDivide(t,a,(a+b)/2,amp*persistence,persistence);
		averageDivide(t,(a+b)/2,b,amp*persistence,persistence);
	}
	
	public void correct()
	{
		correct(terrain, 0, terrain.length);
	}
	
	public void correct(double[] t, int a, int b)
	{
		if (b - a < 2) return;
		if ((a+b)/2 - 1 < 0) //Use right
			t[(a+b)/2] = t[(a+b)/2 + 1]*(random.nextDouble()*2); //x + (r*2 - 1)x = r*2(x)
		else if ((a+b)/2 + 1 >= t.length) //Use left
			t[(a+b)/2] = t[(a+b)/2 - 1]*(random.nextDouble()*2);
		else //Average left and right
			t[(a+b)/2] = (t[(a+b)/2 - 1] + t[(a+b)/2 + 1])/2 + random.nextDouble()*t[(a+b)/2]/2;
		correct(t,a,(a+b)/2);
		correct(t,(a+b)/2,b);
	}

}
