package tez_1maven.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.lang.reflect.ParameterizedType;

import javax.swing.JFrame;
import javax.swing.JPanel;

import complexNetworkBLO.IdeaIslemleri;
import complexNetworkGUI.RastgeleNodeDagilimiPanel;
import complexNetworkGUI.RastgeleNodeDistributionPanel;

public class MainFrame_1_FikirDagilimi extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int KARISTIRMA_PARAMETRESI=100;

	public static void main(String[] args){
		
		IdeaIslemleri ideas=new IdeaIslemleri();
		Double[] id=new Double[0];
		Double[] karistirilmisId=new Double[0];
		
		id=ideas.fillIdea(100);
	
		/**
		 * Parametreler burdan girilsin
		 */
		JFrame frame= new JFrame();
	
		RastgeleNodeDagilimiPanel dagilimiPanel=new RastgeleNodeDagilimiPanel(id);
		RastgeleNodeDistributionPanel distributionPanel=new RastgeleNodeDistributionPanel(ideas.fikirDistrubition(id,10));
		
		//NodelarinEtkilesimiDagilimiPanel etkilesimiDagilimiPanel=
		//	new NodelarinEtkilesimiDagilimiPanel(karistirilmisId);
		//NodelarinEtkilesimiDistributionPanel 
		//etkilesimiDistributionPanel=new NodelarinEtkilesimiDistributionPanel(karistirilmisId);
		 // create a panel to add buttons and  a specific layout 
        JPanel p = new JPanel(new BorderLayout()); 
  
  //0      // add buttons and textfield to panel 
     //   p.add(pp, BorderLayout.NORTH); 
        p.add(dagilimiPanel, BorderLayout.WEST); 
        p.add(distributionPanel, BorderLayout.EAST); 
   
  
        // add panel to frame 
        frame.add(p); 
		
		frame.setTitle("Node'lar Ve Fikir Dağılımları ");
		frame.setSize(1200, 600);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
}