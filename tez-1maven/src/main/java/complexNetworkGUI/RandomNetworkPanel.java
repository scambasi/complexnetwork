package complexNetworkGUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class RandomNetworkPanel extends JPanel {
	private static final long serialVersionUID = 6294689542092367723L;

	public RandomNetworkPanel(Double[][] komsuluklar, Double[] ideas) {

		XYDataset dataset = createDataset(komsuluklar, ideas);
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		add(chartPanel);

	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return a sample dataset.
	 */

	private static XYDataset createDataset(Double[][] komsuluklar, Double[] ideas) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		for (int i = 0; i < ideas.length; i++) {
			XYSeries series = new XYSeries("Random Newtwork"+i,false,true);
			/**
			 * i nin komşularını bulalım
			 */
			Double[] komsular = komsuluklar[i];
			for (int j = 0; j < komsular.length; j++) {
				series.add(i, ideas[i]);

				if (!komsular[j].equals(new Double("-1"))) {
					
					series.add(komsular[j].intValue(), ideas[komsular[j].intValue()]);
					
				}

			}
			dataset.addSeries(series);
		}
		return dataset;
	}

	private static JFreeChart createChart(XYDataset dataset) {
		// create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
        	"RANDOM NETWORK DAĞILIMI ", 
        	"Node'lar", 
        	"Komşuluklar", 
            dataset,                  // data
            PlotOrientation.VERTICAL,
            false,                     // include legend
            false,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;

//		JFreeChart chart = ChartFactory.createXYLineChart("RANDOM NETWORK DAĞILIMI ", "KOMŞULUKLAR", "NODELAR", dataset,
//				PlotOrientation.VERTICAL, true, false, false);
//
//		XYPlot plot = chart.getXYPlot();
//
//		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
//		renderer.setSeriesPaint(0, Color.RED);
//		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
//		 renderer.setSeriesLinesVisible(0, false);
//	        renderer.setSeriesShapesVisible(1, false);
//		plot.setRenderer(renderer);
//		plot.setBackgroundPaint(Color.white);
//
//		
//		plot.setRangeGridlinePaint(Color.BLACK);
//
//	
//		plot.setDomainGridlinePaint(Color.BLACK);
//
//		chart.getLegend().setFrame(BlockBorder.NONE);
//
//		chart.setTitle(new TextTitle("RANDOM NETWORK DAĞILIMI", new Font("Serif", java.awt.Font.BOLD, 18)));
//
//		return chart;

	}
}
