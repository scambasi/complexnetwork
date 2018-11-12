package complexNetworkGUI;

import java.awt.Color;
import java.util.Collection;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class RandomNetworkDistributionPanel_barChart extends JPanel {
	private static final long serialVersionUID = 6294689542092367723L;

	public RandomNetworkDistributionPanel_barChart( Map<Integer, Integer> ideas) {

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
	private CategoryDataset createDataset( Map<Integer, Integer> ideas) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       
		
//		for (int i = 0; i < ideas.size(); i++) {
//			int indis=i+1;
//		
//			String indis2="0."+indis;
//		
//			 dataset.setValue(ideas., "Fikirlerin Dağılımı (Homojen Dağılım) Distributions",indis2);
//		}
		Collection<Integer> komsuSet = ideas.values();
		Collection<Integer> komsuSayisiSet = ideas.keySet();
		 Integer[] KomsuSetArray = komsuSet.toArray(new Integer[komsuSet.size()]);
		 Integer[] komsuSayisiSetArray = komsuSayisiSet.toArray(new Integer[komsuSayisiSet.size()]);
		for(int i=0;i<ideas.size();i++) {
				dataset.setValue(komsuSayisiSetArray[i],"Komuşuk distrubitions" , KomsuSetArray[i]);
		}
		return dataset;
	}

}
