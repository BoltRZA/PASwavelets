package pract1;

import java.util.ArrayList;

public class Wavelet {
	
	private ArrayList<double[]> levelA = new ArrayList<double[]>();
	private ArrayList<double[]> levelB = new ArrayList<double[]>();
	private int size = 0;
	private int level = 0;
	public Wavelet(int size) {
		// TODO Auto-generated constructor stub
		this.size= size;
		if ( size == 256 ) level = 8;
		if ( size == 512 ) level = 9;
		if ( size == 1024 ) level = 10;
		
		double[] a = null; // aproksimiruushiee koeff
		double[] b = null; //detaliziruushie koeff
		
		for (int i =0 ; i<=level; i++) {
			a = new double[(int) (size/Math.pow(2, i))]; levelA.add(a);
			b = new double[(int) (size/Math.pow(2, i))]; levelB.add(b);
		}
		
	}
	
	private double[] aCurrent = null; 
	private double[] bCurrent = null; 
	private double[] aPrev = null; 
	private double[] bPrev= null; 
	private double baseTime = 0.000078125;
	
	public void calc(double[] data) {
		levelA.set(0, data);
		
		for (int j = 0; j<level; j++) {
			aPrev = levelA.get(j);
			bPrev = levelB.get(j);
			aCurrent = levelA.get(j+1);
			bCurrent = levelB.get(j+1);
			
			int k = 0;
			int lim = (int) (((size)/(Math.pow(2, j)))-2);
			
			for (int i = 0 ; i<lim; i+=2) {
				aCurrent[k] = (aPrev[i]+aPrev[i+1])/2;
				bCurrent[k] = (aPrev[i]-aPrev[i+1])/2;
				Charts.addAnalogData(j+1, 0, aCurrent[k], baseTime*Math.pow(2, (j+1)));
				ChartsD.addAnalogData(j+1, 0, bCurrent[k], baseTime*Math.pow(2, (j+1)));
				k++;
			}
		}
	}

	
}
