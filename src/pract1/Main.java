package pract1;
public class Main {

	public static void main(String[] args) {
		
		Charts.createAnalogChart("Signal", 0); // создает первый график
		Charts.createAnalogChart("Signal", 1); // создает первый график
		Charts.createAnalogChart("Signal", 2); // создает первый график
		Charts.createAnalogChart("Signal", 3); // создает первый график
		Charts.createAnalogChart("Signal", 4); // создает первый график
		Charts.createAnalogChart("Signal", 5); // создает первый график
		Charts.createAnalogChart("Signal", 6); // создает первый график
		Charts.createAnalogChart("Signal", 7); // создает первый график
		Charts.createAnalogChart("Signal", 8); // создает первый график
		Charts.addSeries("ss", 0, 0); // создает первый синал в первом графике
		Charts.addSeries("A1", 1, 0); // создает второй синал в первом графике
		Charts.addSeries("A2", 2, 0); // создает второй синал в первом графике
		Charts.addSeries("A3", 3, 0); // создает второй синал в первом графике
		Charts.addSeries("A4", 4, 0); // создает второй синал в первом графике
		Charts.addSeries("A5", 5, 0); // создает второй синал в первом графике
		Charts.addSeries("A6", 6, 0); // создает второй синал в первом графике
		Charts.addSeries("A7", 7, 0); // создает второй синал в первом графике
		Charts.addSeries("A8", 8, 0); // создает второй синал в первом графике
		
		ChartsD.createAnalogChart("Signal", 0); // создает первый график
		ChartsD.createAnalogChart("Signal", 1); // создает первый график
		ChartsD.createAnalogChart("Signal", 2); // создает первый график
		ChartsD.createAnalogChart("Signal", 3); // создает первый график
		ChartsD.createAnalogChart("Signal", 4); // создает первый график
		ChartsD.createAnalogChart("Signal", 5); // создает первый график
		ChartsD.createAnalogChart("Signal", 6); // создает первый график
		ChartsD.createAnalogChart("Signal", 7); // создает первый график
		ChartsD.createAnalogChart("Signal", 8); // создает первый график
		ChartsD.addSeries("ss", 0, 0); // создает первый синал в первом графике
		ChartsD.addSeries("D1", 1, 0); // создает второй синал в первом графике
		ChartsD.addSeries("D2", 2, 0); // создает второй синал в первом графике
		ChartsD.addSeries("D3", 3, 0); // создает второй синал в первом графике
		ChartsD.addSeries("D4", 4, 0); // создает второй синал в первом графике
		ChartsD.addSeries("D5", 5, 0); // создает второй синал в первом графике
		ChartsD.addSeries("D6", 6, 0); // создает второй синал в первом графике
		ChartsD.addSeries("D7", 7, 0); // создает второй синал в первом графике
		ChartsD.addSeries("D8", 8, 0); // создает второй синал в первом графике
		
		
//		Charts.createDiscreteChart("Сигнал 1", 0); // создает первый дискретиный сигнал
//		Charts.createDiscreteChart("Сигнал 2", 1); // создает второй дискретный сигнал

		
//		for(int i=0; i<3000; i++){
//			Charts.addAnalogData(0, 0, Math.sin(2*Math.PI*i/80)); // строит данные в I системе координат на первом графике
//			Charts.addAnalogData(0, 1, Math.sin(2*Math.PI*i/80+2*Math.PI/3)); // строит данные в I системе координат на втором графике
//			Charts.addAnalogData(0, 2, Math.sin(2*Math.PI*i/80-2*Math.PI/3)); // строит данные в I системе координат на третьем графике
//			
//			Charts.addAnalogData(1, 0, 0.2*Math.sin(2*Math.PI*i/80)); // строит данные во II системе координат на первом графике
//			Charts.addAnalogData(1, 1, 0.3*Math.sin(2*Math.PI*i/80+2*Math.PI/3)); // строит данные во II системе координат на втором графике
//			Charts.addAnalogData(1, 2, 0.4*Math.sin(2*Math.PI*i/80-2*Math.PI/3)); // строит данные во II системе координат на третьем графике
//			
//			if(i>200 && i<1000) Charts.addDiscreteData(0, true); else Charts.addDiscreteData(0, false); // строит данные в III системе координат на первом графике
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
