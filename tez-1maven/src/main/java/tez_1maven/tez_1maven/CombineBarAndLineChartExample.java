package tez_1maven.tez_1maven;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CombineBarAndLineChartExample extends JFrame {

   private static final long serialVersionUID = 1L;

   public CombineBarAndLineChartExample(String title) {
      super(title);

      // Create Category plot
      CategoryPlot plot = new CategoryPlot();

      // Add the first dataset and render as bar
      CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
      plot.setDataset(0, createDataset());
      plot.setRenderer(0, lineRenderer);

      // Add the second dataset and render as lines
      CategoryItemRenderer baRenderer = new BarRenderer();
      plot.setDataset(1, createDataset());
      plot.setRenderer(1, baRenderer);
      
      // Add the second dataset and render as lines
      CategoryItemRenderer xyRenderer = new ScatterRenderer();
      plot.setDataset(1, (CategoryDataset) createDatasetXY());
      plot.setRenderer(1, xyRenderer);

      // Set Axis
      plot.setDomainAxis(new CategoryAxis("Time"));
      plot.setRangeAxis(new NumberAxis("Value"));

      JFreeChart chart = new JFreeChart(plot);
      chart.setTitle("Combined Bar And Line Chart | BORAJI.COM");

      ChartPanel panel = new ChartPanel(chart);
      setContentPane(panel);
   }

   private DefaultCategoryDataset createDataset() {

      // First Series
      String series1 = "Vistor";
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      dataset.addValue(200, series1, "2016-12-19");
      dataset.addValue(150, series1, "2016-12-20");
      dataset.addValue(100, series1, "2016-12-21");
      dataset.addValue(210, series1, "2016-12-22");
      dataset.addValue(240, series1, "2016-12-23");
      dataset.addValue(195, series1, "2016-12-24");
      dataset.addValue(245, series1, "2016-12-25");

      // Second Series
      String series2 = "Unique Visitor";
      dataset.addValue(150, series2, "2016-12-19");
      dataset.addValue(130, series2, "2016-12-20");
      dataset.addValue(95, series2, "2016-12-21");
      dataset.addValue(195, series2, "2016-12-22");
      dataset.addValue(200, series2, "2016-12-23");
      dataset.addValue(180, series2, "2016-12-24");
      dataset.addValue(230, series2, "2016-12-25");

      return dataset;
   }
   private XYDataset createDatasetXY() {

	   XYSeries series1 = new XYSeries("2014");
       series1.add(18, 530);
       series1.add(20, 580);
       series1.add(25, 740);
       series1.add(30, 901);
       series1.add(40, 1300);
       series1.add(50, 2219);
       
       XYSeries series2 = new XYSeries("2016");
       series2.add(18, 567);
       series2.add(20, 612);
       series2.add(25, 800);
       series2.add(30, 980);
       series2.add(40, 1210);
       series2.add(50, 2350);        

       XYSeriesCollection dataset = new XYSeriesCollection();
       dataset.addSeries(series1);
       dataset.addSeries(series2);

	      return dataset;
	   }
   
   public static void main(String[] args) {

       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
        	   CombineBarAndLineChartExample example = new CombineBarAndLineChartExample(
                       "Line Chart and Bar chart Example");
                 example.setSize(800, 400);
                 example.setLocationRelativeTo(null);
                 example.setVisible(true);

           }
       });

   }
   
}