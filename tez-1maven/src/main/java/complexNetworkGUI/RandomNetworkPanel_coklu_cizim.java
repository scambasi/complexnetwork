package complexNetworkGUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class RandomNetworkPanel_coklu_cizim extends JPanel {
	private static final long serialVersionUID = 6294689542092367723L;

	public RandomNetworkPanel_coklu_cizim(Double[][] komsuluklar,Double[] ideas) {

//		 XYDataset dataset = createDataset(komsuluklar,ideas);
//	        JFreeChart chart = createChart(dataset);
//	        ChartPanel chartPanel = new ChartPanel(chart);
//	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
//	        chartPanel.setBackground(Color.white);
//		add(chartPanel);
		// Create dataset
		  final XYDataset dataset = createDataset(komsuluklar,ideas);
	        final JFreeChart chart = createChart(dataset);
	        final ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        chartPanel.setBackground(Color.white);
				
				add(chartPanel);
	}
	 /**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     */
    private XYDataset createDataset(Double[][] komsuluklar,Double[] ideas) {
    	 final XYSeriesCollection dataset = new XYSeriesCollection();
        for(int i=0;i<ideas.length;i++)
        {
        	 final XYSeries series = new XYSeries(i+"Komşuluklar");
        	
        	/**
    		 * i nin komşularını bulalım
    		 */
        	Double[] komsular=komsuluklar[i];
        	for(int j=0;j<komsular.length;j++)
        	{
        		 series.add(i,ideas[i]);
        		
        		if(komsular[j]>new Double("0"))
        				{
        				series.add(komsular[j].intValue(),ideas[komsular[j].intValue()]);
        				}
        		
        	}
        	dataset.addSeries(series);
        }
      
                
        return dataset;
        
    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the data for the chart.
     * 
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Line Chart Demo 6",      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
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
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }


//	  private static XYDataset createDataset(Double[][] komsuluklar,Double[] ideas) {
//
//	        XYSeries series = new XYSeries("Random Network Komşulukları",false,false);
//	        
//	        for(int i=0;i<ideas.length;i++)
//	        {
//	        	series.add(i,ideas[i]);
//	        	/**
//        		 * i nin komşularını bulalım
//        		 */
//	        	Double[] komsular=komsuluklar[i];
//	        	for(int j=0;j<komsular.length;j++)
//	        	{
//	        		
//	        		
//	        		if(komsular[j]>new Double("0"))
//	        				{
//	        				series.add(komsular[j].intValue(),ideas[komsular[j].intValue()]);
//	        				}
//	        		
//	        	}
//	        }
//
//	        XYSeriesCollection dataset = new XYSeriesCollection();
//	        dataset.addSeries(series);
//
//	        return dataset;
//	    }
//
//	    private static JFreeChart createChart(XYDataset dataset) {
//
//	        JFreeChart chart = ChartFactory.createXYLineChart(
//	                "RANDOM NETWORK DAĞILIMI ", 
//	                "KOMŞULUKLAR", 
//	                "NODELAR", 
//	                dataset, 
//	                PlotOrientation.VERTICAL,
//	                true, 
//	                true, 
//	                false 
//	        );
//
//	        XYPlot plot = chart.getXYPlot();
//
//	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
//	        renderer.setSeriesPaint(0, Color.RED);
//	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
//
//	        plot.setRenderer(renderer);
//	        plot.setBackgroundPaint(Color.white);
//
//	        plot.setRangeGridlinesVisible(true);
//	        plot.setRangeGridlinePaint(Color.BLACK);
//
//	        plot.setDomainGridlinesVisible(true);
//	        plot.setDomainGridlinePaint(Color.BLACK);
//
//	        chart.getLegend().setFrame(BlockBorder.NONE);
//
//	        chart.setTitle(new TextTitle("RANDOM NETWORK DAĞILIMI",
//	                        new Font("Serif", java.awt.Font.BOLD, 18)
//	                )
//	        );
//
//	        return chart;
//
//	    }
}
