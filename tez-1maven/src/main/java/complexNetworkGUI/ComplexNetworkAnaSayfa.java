package complexNetworkGUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.ldap.Rdn;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import complexNetworkBLO.IdeaIslemleri;
import complexNetworkGUI.RastgeleNodeDagilimiPanel;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;

public class ComplexNetworkAnaSayfa {

	private JFrame frame;
	private JTextField txt_karistirma;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txt_karar_ver;
	private JTextField txt_node_say;
	private JTextField txt_fikir_yaklas;
	
	/**
	 * PARAMETRELER
	 */

	 Integer KARISTIRMA_PARAMETRESI=0;
	 Integer NODE_SAYISI=0;
	 Double FIKIR_YAKINLASMASI_KATSAYISI=0.1; //a sayısı
	 Double FIKIR_KARAR_VERME_KATSAYISI=0.1;//e sayısı
	 Integer DISTRIBUTION_KATSAYISI=0;

	 
	 /**
	  * 
	  */
	 Double[] id = new Double[0];
	 
	 private JTextField txt_dist_param;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplexNetworkAnaSayfa window = new ComplexNetworkAnaSayfa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComplexNetworkAnaSayfa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 806, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Grafikler", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Parametreler", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), "Se\u00E7enekler ve Parametreler", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 782, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
		);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Se\u00E7enekler", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		final JRadioButton rd_btn_dist = new JRadioButton("Distrubition");
		buttonGroup.add(rd_btn_dist);

		final JRadioButton rd_btn_dagilim = new JRadioButton("Dağılım");
		rd_btn_dagilim.setSelected(true);
		buttonGroup.add(rd_btn_dagilim);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(rd_btn_dagilim)
					.addGap(54)
					.addComponent(rd_btn_dist)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(rd_btn_dist)
						.addComponent(rd_btn_dagilim, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Network Se\u00E7imi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		final JRadioButton rd_btn_rst_tum = new JRadioButton("Rastgele Dağılım");
		buttonGroup_1.add(rd_btn_rst_tum);
		rd_btn_rst_tum.setSelected(true);
		
		final JRadioButton rd_btn_rst_tum_yaklasim = new JRadioButton("Rastgele D Yaklaşım");
		buttonGroup_1.add(rd_btn_rst_tum_yaklasim);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addComponent(rd_btn_rst_tum)
					.addGap(18)
					.addComponent(rd_btn_rst_tum_yaklasim)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(rd_btn_rst_tum)
						.addComponent(rd_btn_rst_tum_yaklasim))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Parametreler", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
				JLabel lblParam = new JLabel("Karıstırma Param");
				
						txt_karistirma = new JTextField();
						txt_karistirma.setText("100");
						txt_karistirma.setColumns(10);
						
						JLabel lblNodeSays = new JLabel("Node Sayısı");
						
						txt_node_say = new JTextField();
						txt_node_say.setText("100");
						txt_node_say.setColumns(10);
						
						JLabel lblKaraVerme = new JLabel("Karar Verme ");
						
						txt_karar_ver = new JTextField();
						txt_karar_ver.setText("0.5");
						txt_karar_ver.setColumns(10);
						
						JLabel lblYaknlama = new JLabel("Fikir Yaklaşım");
						
						txt_fikir_yaklas = new JTextField();
						txt_fikir_yaklas.setText("0.2");
						txt_fikir_yaklas.setColumns(10);
						
						JLabel lblDistrubutionSays = new JLabel("Distrubition Sayısı");
						
						txt_dist_param = new JTextField();
						txt_dist_param.setText("10");
						txt_dist_param.setColumns(10);
						GroupLayout gl_panel_4 = new GroupLayout(panel_4);
						gl_panel_4.setHorizontalGroup(
							gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_4.createSequentialGroup()
											.addGap(6)
											.addComponent(lblKaraVerme, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txt_karar_ver, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_4.createSequentialGroup()
											.addComponent(lblParam)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txt_karistirma, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
										.addComponent(lblYaknlama, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNodeSays, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_4.createSequentialGroup()
											.addComponent(txt_node_say, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblDistrubutionSays, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
											.addGap(12)
											.addComponent(txt_dist_param, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
										.addComponent(txt_fikir_yaklas, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(70, Short.MAX_VALUE))
						);
						gl_panel_4.setVerticalGroup(
							gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblParam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addComponent(txt_karistirma, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_4.createSequentialGroup()
											.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNodeSays)
												.addComponent(txt_node_say, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDistrubutionSays, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_dist_param, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(4)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_4.createSequentialGroup()
											.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblYaknlama, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_karar_ver, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_fikir_yaklas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(9))
										.addComponent(lblKaraVerme, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(25, Short.MAX_VALUE))
						);
						panel_4.setLayout(gl_panel_4);
		
				JButton btnSorgula = new JButton("sorgula");
				btnSorgula.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IdeaIslemleri ideas = new IdeaIslemleri();
						
						Double[] karistirilmisId=new Double[0];
					  /**
					   * PARAMETERELERİN ALINMASI
					   */
					   if(!txt_karistirma.getText().isEmpty()) {
						   KARISTIRMA_PARAMETRESI=new Integer(txt_karistirma.getText().toString());
					   }
					   if(!txt_fikir_yaklas.getText().isEmpty()) {
						   FIKIR_YAKINLASMASI_KATSAYISI=new Double(txt_fikir_yaklas.getText().toString());
					   }
					   if(!txt_karar_ver.getText().isEmpty()) {
						   FIKIR_KARAR_VERME_KATSAYISI=new Double(txt_karar_ver.getText().toString());
					   }
					   if(!txt_node_say.getText().isEmpty()) {
						   NODE_SAYISI=new Integer(txt_node_say.getText().toString());
					   }
					   if(!txt_dist_param.getText().isEmpty()) {
						   DISTRIBUTION_KATSAYISI=new Integer(txt_dist_param.getText().toString());
					   }
					  
						
						if(rd_btn_rst_tum.isSelected()) {
							
							if (rd_btn_dagilim.isSelected()) {
								panel.removeAll();
								id = ideas.fillIdea(NODE_SAYISI);
								RastgeleNodeDagilimiPanel dagilimiPanel = new RastgeleNodeDagilimiPanel(id);
	
								panel.add(dagilimiPanel);
	
							}
							if (rd_btn_dist.isSelected()) {
								panel.removeAll();
								
								RastgeleNodeDistributionPanel distributionPanel = new RastgeleNodeDistributionPanel(
										ideas.fikirDistrubition(id,DISTRIBUTION_KATSAYISI));
								panel.add(distributionPanel);
							}
						}
						else if(rd_btn_rst_tum_yaklasim.isSelected())
						{
						
							if (rd_btn_dagilim.isSelected()) {
								panel.removeAll();
								karistirilmisId=ideas.karistirIdea(id,KARISTIRMA_PARAMETRESI,NODE_SAYISI,FIKIR_KARAR_VERME_KATSAYISI,FIKIR_YAKINLASMASI_KATSAYISI);
								NodelarinEtkilesimiDagilimiPanel etkilesimiDagilimiPanel=
										new NodelarinEtkilesimiDagilimiPanel(karistirilmisId);
								panel.add(etkilesimiDagilimiPanel);
	
							}
							else if (rd_btn_dist.isSelected()) {
								panel.removeAll();
								karistirilmisId=ideas.karistirIdea(id,KARISTIRMA_PARAMETRESI,NODE_SAYISI,FIKIR_KARAR_VERME_KATSAYISI,FIKIR_YAKINLASMASI_KATSAYISI);
								NodelarinEtkilesimiDistributionPanel 
								etkilesimiDistributionPanel=new NodelarinEtkilesimiDistributionPanel(ideas.fikirDistrubition(karistirilmisId,DISTRIBUTION_KATSAYISI));
								panel.add(etkilesimiDistributionPanel);
							}
						}
						panel.revalidate();
						panel.repaint();

					}
				});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 744, Short.MAX_VALUE)
						.addComponent(btnSorgula))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSorgula)
					.addGap(41))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}
