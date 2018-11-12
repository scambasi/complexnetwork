package complexNetworkGUI;

import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class RandomNetworkDistrubitionPanel extends JPanel {
	private static final long serialVersionUID = 6294689542092367723L;

	public RandomNetworkDistrubitionPanel(Integer[] ideas) {

		// Create dataset
		XYDataset dataset = createDataset(ideas);

		// Create chart
		JFreeChart chart = ChartFactory.createScatterPlot(" Random Network Distribition", "X() ", "Y()", dataset);

		// Changes background color
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(new Color(255, 228, 196));

		// Create Panel
		ChartPanel panel = new ChartPanel(chart);
		add(panel);
	}

	private XYDataset createDataset(Integer[] ideas) {
		  XYSeries series = new XYSeries(" ");
		  
//		  Map<Integer, Integer> treeMap = new TreeMap<Integer,Integer>(ideas);
//		  for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
//	            System.out.println("Key : " + entry.getKey() 
//					+ " Value : " + entry.getValue());
//	            series.add(entry.getKey(),entry.getValue());
//	        }
		  for(int i=0;i<ideas.length;i++)
		  {
			  series.add(i,ideas[i]);
		  }

	        XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(series);

	        return dataset;
	}

}
