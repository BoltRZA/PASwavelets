package pract1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataComtrade {

	private File comtrCfg;
	private File comtrDat;
	private BufferedReader br;
	private String line;
	private String[] lineData;
	private double k1[] = new double[2];
	private double k2[] = new double[2];
	
	public DataComtrade(String path, String file) {
		comtrCfg = new File(path+file+".cfg");
		comtrDat = new File(path+file+".dat");
	}

	public double[] data = new double[256];
	
	public void run(){
		try { br = new BufferedReader(new FileReader(comtrCfg)); } catch (FileNotFoundException e) { e.printStackTrace(); }		
		try {
			int lineNumber = 0;
			while((line = br.readLine()) != null){
				if(lineNumber==2){
					lineData = line.split(",");
					k1[0] = Double.parseDouble(lineData[5]);
					k2[0] = Double.parseDouble(lineData[6]);
				}
//				if(lineNumber==3){
//					lineData = line.split(",");
//					k1[1] = Double.parseDouble(lineData[5]);
//					k2[1] = Double.parseDouble(lineData[6]);
//				}
				lineNumber++;
			}
		} catch (IOException e) { e.printStackTrace(); }
		
		try { br = new BufferedReader(new FileReader(comtrDat)); } catch (FileNotFoundException e) { e.printStackTrace(); }		
		
		double rms=0;
		int number = 0;
		double meanValue = 0.0;
		try {
			while((line = br.readLine()) != null && number<255){
				lineData = line.split(",");
				meanValue = Double.parseDouble(lineData[2])*k1[0]+k2[0];
//				System.out.println(number+"   "+meanValue);
				Charts.addAnalogData(0, 0, meanValue, 0.000078125);
				ChartsD.addAnalogData(0, 0, meanValue, 0.000078125);
				number++;
				data[number] = meanValue;
			}
		} catch (IOException e) { e.printStackTrace(); }
		
	}

}

