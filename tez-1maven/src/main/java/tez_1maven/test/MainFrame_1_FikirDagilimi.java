package tez_1maven.test;

import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;

public class MainFrame_1_FikirDagilimi extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static GraphicsConfiguration gc;
	private static int KARISTIRMA_PARAMETRESI=100;

	public static void main(String[] args){
		JFrame frame= new JFrame(gc);
		IdeaIslemleri ideas=new IdeaIslemleri();
		Double[] id=new Double[0];
		Double[] karistirilmisId=new Double[0];
		
		id=ideas.fillIdea();
		//karistirilmisId=ideas.karistirIdea(id,KARISTIRMA_PARAMETRESI);
		
		
		RastgeleNodeDagilimiPanel dagilimiPanel=new RastgeleNodeDagilimiPanel(id);
		RastgeleNodeDistributionPanel distributionPanel=new RastgeleNodeDistributionPanel(ideas.fikirDistrubition(id));
		
		//NodelarinEtkilesimiDagilimiPanel etkilesimiDagilimiPanel=
		//	new NodelarinEtkilesimiDagilimiPanel(karistirilmisId);
		//NodelarinEtkilesimiDistributionPanel 
		//etkilesimiDistributionPanel=new NodelarinEtkilesimiDistributionPanel(karistirilmisId);
		frame.setLayout(new FlowLayout());
		frame.add(dagilimiPanel);
		frame.add(distributionPanel);
	//	frame.add(etkilesimiDagilimiPanel);
//		frame.add(etkilesimiDistributionPanel);
		
		frame.setTitle("Node'lar Ve Fikir Dağılımları ");
		frame.setSize(1200, 600);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
}