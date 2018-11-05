package complexNetworkGUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class RastgeleNodeDistributionPanel extends JPanel {
	private static final long serialVersionUID = 6294689542092367723L;

	public RastgeleNodeDistributionPanel(Double[] ideas) {

		// Create dataset
		CategoryDataset dataset = createDataset(ideas);

		  JFreeChart chart = createChart(dataset);
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        chartPanel.setBackground(Color.white);
	        add(chartPanel);
	}
	 private JFreeChart createChart(CategoryDataset dataset) {

	        JFreeChart barChart = ChartFactory.createBarChart(
	                "Fikirlerin Dağılımı (Homojen Dağılım) Distributions",
	                "X(Dağılım aralıkları)",
	                "Y(Dağılım Sayısı)",
	                dataset,
	                PlotOrientation.VERTICAL,
	                false, true, false);

	        return barChart;
	    }
	private CategoryDataset createDataset(Double[] ideas) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       
		
		for (int i = 0; i < ideas.length; i++) {
			int indis=i+1;
			String indis1="0."+i;
			String indis2="0."+indis;
		
			 dataset.setValue(ideas[i], "Fikirlerin Dağılımı (Homojen Dağılım) Distributions",indis2);
		}

		return dataset;
	}

}
