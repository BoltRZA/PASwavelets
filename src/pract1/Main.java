package pract1;
public class Main {

	public static void main(String[] args) {
		
		Charts.createAnalogChart("Signal", 0); // ������� ������ ������
		Charts.createAnalogChart("Signal", 1); // ������� ������ ������
		Charts.createAnalogChart("Signal", 2); // ������� ������ ������
		Charts.createAnalogChart("Signal", 3); // ������� ������ ������
		Charts.createAnalogChart("Signal", 4); // ������� ������ ������
		Charts.createAnalogChart("Signal", 5); // ������� ������ ������
		Charts.createAnalogChart("Signal", 6); // ������� ������ ������
		Charts.createAnalogChart("Signal", 7); // ������� ������ ������
		Charts.createAnalogChart("Signal", 8); // ������� ������ ������
		Charts.addSeries("ss", 0, 0); // ������� ������ ����� � ������ �������
		Charts.addSeries("A1", 1, 0); // ������� ������ ����� � ������ �������
		Charts.addSeries("A2", 2, 0); // ������� ������ ����� � ������ �������
		Charts.addSeries("A3", 3, 0); // ������� ������ ����� � ������ �������
		Charts.addSeries("A4", 4, 0); // ������� ������ ����� � ������ �������
		Charts.addSeries("A5", 5, 0); // ������� ������ ����� � ������ �������
		Charts.addSeries("A6", 6, 0); // ������� ������ ����� � ������ �������
		Charts.addSeries("A7", 7, 0); // ������� ������ ����� � ������ �������
		Charts.addSeries("A8", 8, 0); // ������� ������ ����� � ������ �������
		
		ChartsD.createAnalogChart("Signal", 0); // ������� ������ ������
		ChartsD.createAnalogChart("Signal", 1); // ������� ������ ������
		ChartsD.createAnalogChart("Signal", 2); // ������� ������ ������
		ChartsD.createAnalogChart("Signal", 3); // ������� ������ ������
		ChartsD.createAnalogChart("Signal", 4); // ������� ������ ������
		ChartsD.createAnalogChart("Signal", 5); // ������� ������ ������
		ChartsD.createAnalogChart("Signal", 6); // ������� ������ ������
		ChartsD.createAnalogChart("Signal", 7); // ������� ������ ������
		ChartsD.createAnalogChart("Signal", 8); // ������� ������ ������
		ChartsD.addSeries("ss", 0, 0); // ������� ������ ����� � ������ �������
		ChartsD.addSeries("D1", 1, 0); // ������� ������ ����� � ������ �������
		ChartsD.addSeries("D2", 2, 0); // ������� ������ ����� � ������ �������
		ChartsD.addSeries("D3", 3, 0); // ������� ������ ����� � ������ �������
		ChartsD.addSeries("D4", 4, 0); // ������� ������ ����� � ������ �������
		ChartsD.addSeries("D5", 5, 0); // ������� ������ ����� � ������ �������
		ChartsD.addSeries("D6", 6, 0); // ������� ������ ����� � ������ �������
		ChartsD.addSeries("D7", 7, 0); // ������� ������ ����� � ������ �������
		ChartsD.addSeries("D8", 8, 0); // ������� ������ ����� � ������ �������
		
		
//		Charts.createDiscreteChart("������ 1", 0); // ������� ������ ����������� ������
//		Charts.createDiscreteChart("������ 2", 1); // ������� ������ ���������� ������

		
//		for(int i=0; i<3000; i++){
//			Charts.addAnalogData(0, 0, Math.sin(2*Math.PI*i/80)); // ������ ������ � I ������� ��������� �� ������ �������
//			Charts.addAnalogData(0, 1, Math.sin(2*Math.PI*i/80+2*Math.PI/3)); // ������ ������ � I ������� ��������� �� ������ �������
//			Charts.addAnalogData(0, 2, Math.sin(2*Math.PI*i/80-2*Math.PI/3)); // ������ ������ � I ������� ��������� �� ������� �������
//			
//			Charts.addAnalogData(1, 0, 0.2*Math.sin(2*Math.PI*i/80)); // ������ ������ �� II ������� ��������� �� ������ �������
//			Charts.addAnalogData(1, 1, 0.3*Math.sin(2*Math.PI*i/80+2*Math.PI/3)); // ������ ������ �� II ������� ��������� �� ������ �������
//			Charts.addAnalogData(1, 2, 0.4*Math.sin(2*Math.PI*i/80-2*Math.PI/3)); // ������ ������ �� II ������� ��������� �� ������� �������
//			
//			if(i>200 && i<1000) Charts.addDiscreteData(0, true); else Charts.addDiscreteData(0, false); // ������ ������ � III ������� ��������� �� ������ �������
//			if(i>500 && i<2000) Charts.addDiscreteData(1, true); else Charts.addDiscreteData(1, false);
//		}
		
		
		
		String path = "C:\\Users\\anast\\Desktop\\Wavelet comtrade\\Wavelet comtrade\\";
		String file = "sample6";
//		
		Wavelet w = new Wavelet(256);
		DataComtrade cd = new DataComtrade(path, file);
		cd.run();
		
		
		w.calc(cd.data);
	//	w.filter(new int[]{1, 1, 1, 1, 1, 1, 1, 1});
	}

}
