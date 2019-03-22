package pract1;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
 
public class ChartsD {
	
	private static ChartsD charts;
	private static ArrayList<XYSeriesCollection> datasetsAnalog = new ArrayList<XYSeriesCollection>();
	private static ArrayList<XYSeries> datasetsDiscrete = new ArrayList<XYSeries>();
	private static CombinedDomainXYPlot plot;
	private static JFreeChart chart;
	private static JFrame frame;
	private static XYSeries tempSeries;
	private static double timeStep = 0.00025; // аг дискретизации при 80 т. за период
	private static double currentTime = 0.0;
	private static boolean lastData=false;
	
  public ChartsD(){ 	
    plot = new CombinedDomainXYPlot(new NumberAxis("‚ремЯ, сек"));
    
    chart = new JFreeChart("‘игналы защиты", plot); 
    chart.setBorderPaint(Color.black);
    chart.setBorderVisible(true);
    chart.setBackgroundPaint(Color.white);
    
    frame = new JFrame("‘игналы защиты");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new ChartPanel(chart));
    frame.setSize(1024,768);
    frame.show();   
  }
  
  /**
   * „обавлЯет аналоговый график
   * @param name - €мЯ графика
   * @param number - ЏорЯдковый номер
   */
  public static void createAnalogChart(String name, int number){ 
	  if(charts==null) charts = new ChartsD();
	  
	  XYSeriesCollection dataset = new XYSeriesCollection(); 
	  NumberAxis rangeAxis = new NumberAxis(name); rangeAxis.setAutoRangeIncludesZero(false);
	  XYPlot subplot = new XYPlot(dataset, null, rangeAxis, new StandardXYItemRenderer() ); 
	  subplot.setBackgroundPaint(Color.BLACK);
	  plot.add(subplot); 
	  subplot.setWeight(7);
	  datasetsAnalog.add(dataset);
  }
  
  /**
   * „обавлЯет дискретный график
   * @param name - €мЯ графика
   * @param number - ЏорЯдковый номер
   */
  public static void createDiscreteChart(String name, int number){ 
	  if(charts==null) charts = new ChartsD();
	  
	  XYSeriesCollection dataset = new XYSeriesCollection();
	  NumberAxis rangeAxis = new NumberAxis(name); 
	  rangeAxis.setAutoRangeIncludesZero(false);
	  XYPlot subplot = new XYPlot(dataset, null, rangeAxis, new StandardXYItemRenderer() );
	  plot.add(subplot); 
	  subplot.setWeight(1);
	  XYStepAreaRenderer xysteparearenderer = new XYStepAreaRenderer(2); 
	  subplot.setRenderer(xysteparearenderer);
	  XYSeries series = new XYSeries(name);
	  datasetsDiscrete.add(series);
	  dataset.addSeries(series);
  }
  
  
  /**
   * „обавлЯет в указанный аналоговый график новый сигнал
   * @param name - €мЯ аналогового сигнала
   * @param chartNumber - ЏорЯдковый номер сигнала
   * @param number - ЏорЯдковый номер
   */
  public static void addSeries(String name, int chartNumber, int number){
	  XYSeries series = new XYSeries(name); series.add(0.0, 0.0);
	  datasetsAnalog.get(chartNumber).addSeries(series);
  }
 
  /**
   * ‘троит Ђналоговый сигнал на графике
   * @param chart - ЏорЯдковый номер графика
   * @param series - ЏорЯдковый номер сигнала
   * @param data - „обавлЯемое значение (double)
   */
  public static void addAnalogData(int chart, int series, double data){
	  tempSeries = (XYSeries) datasetsAnalog.get(chart).getSeries().get(series);
	  currentTime = tempSeries.getMaxX()+timeStep;
	  tempSeries.add(currentTime, data);
  }

  /**
   * ‘троит Ђналоговый сигнал на графике
   * @param chart - ЏорЯдковый номер графика
   * @param series - ЏорЯдковый номер сигнала
   * @param data - „обавлЯемое значение (double)
   * @param timeStep - шаг по времени
   */
  public static void addAnalogData(int chart, int series, double data, double timeStep){
	  tempSeries = (XYSeries) datasetsAnalog.get(chart).getSeries().get(series);
	  currentTime = tempSeries.getMaxX()+timeStep;
	  tempSeries.add(currentTime, data);
  }
  
  /**
   * ‘троит „искретный сигнал на графике
   * @param chart - ЏорЯдковый номер дисретного сигнала
   * @param data - „обавлЯемый значение (true/false)
   */
  public static void addDiscreteData(int chart, boolean data){
	  tempSeries = (XYSeries) datasetsDiscrete.get(chart);
	  if(!tempSeries.isEmpty()) lastData = tempSeries.getY(tempSeries.getItemCount()-1).doubleValue()==1;
	  if(!lastData && data) tempSeries.add(currentTime, data?1.0:0.0);
	  if(lastData && !data) tempSeries.add(currentTime, data?1.0:0.0);  
  }
  
}