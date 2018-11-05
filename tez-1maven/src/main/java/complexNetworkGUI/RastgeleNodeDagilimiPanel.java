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

public class RastgeleNodeDagilimiPanel extends JPanel {
	private static final long serialVersionUID = 6294689542092367723L;

	public RastgeleNodeDagilimiPanel(Double[] ideas) {

		// Create dataset
		XYDataset dataset = createDataset(ideas);

		// Create chart
		JFreeChart chart = ChartFactory.createScatterPlot(" Fikirlerin Dağılımı (Homojen Dağılım) ", "X(Node'lar) ", "Y (Fikirler)", dataset);

		// Changes background color
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(new Color(255, 228, 196));

		// Create Panel
		ChartPanel panel = new ChartPanel(chart);
		add(panel);
	}

	private XYDataset createDataset(Double[] ideas) {
		XYSeriesCollection dataset = new XYSeriesCollection();

		//
		XYSeries series1 = new XYSeries("NODE");
		for (int i = 0; i < ideas.length; i++) {

			series1.add(i, ideas[i]);
		}

		dataset.addSeries(series1);

		return dataset;
	}

}
