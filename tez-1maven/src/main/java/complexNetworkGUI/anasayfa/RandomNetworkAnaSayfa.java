package complexNetworkGUI.anasayfa;

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
import complexNetworkBLO.RandomNetworkIslemleri;
import complexNetworkGUI.RandomNetworkDistributionPanel_barChart;
import complexNetworkGUI.RandomNetworkDistrubitionPanel;
import complexNetworkGUI.RandomNetworkPanel;
import complexNetworkGUI.RastgeleNodeDagilimiPanel;
import complexNetworkGUI.RastgeleNodeDistributionPanel;

import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class RandomNetworkAnaSayfa {

	private JFrame frame;
	private JTextField txt_karistirma;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txt_node_say;

	/**
	 * PARAMETRELER
	 */

	Integer KARISTIRMA_PARAMETRESI = 0;
	Integer NODE_SAYISI = 0;
	Double ESIK_DEGERI = 0.1; // a sayısı


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
					RandomNetworkAnaSayfa window = new RandomNetworkAnaSayfa();
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
	public RandomNetworkAnaSayfa() {
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
		panel_1.setBorder(new TitledBorder(
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Parametreler", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(51, 51, 51)),
				"Se\u00E7enekler ve Parametreler", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(51, 51, 51)));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(panel,
												GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING,
												groupLayout.createSequentialGroup().addContainerGap().addComponent(
														panel_1, GroupLayout.PREFERRED_SIZE, 782, Short.MAX_VALUE)))
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Se\u00E7enekler", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		final JRadioButton rd_btn_dist = new JRadioButton("Distrubition");
		rd_btn_dist.setSelected(true);
		buttonGroup.add(rd_btn_dist);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(rd_btn_dist)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(rd_btn_dist)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Network Se\u00E7imi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));

		final JRadioButton rd_btn_rndnetwork = new JRadioButton("Random Network");
		rd_btn_rndnetwork.setSelected(true);
		buttonGroup_1.add(rd_btn_rndnetwork);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap().addComponent(rd_btn_rndnetwork).addContainerGap(62, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(17)
						.addComponent(rd_btn_rndnetwork, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Parametreler", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblParam = new JLabel("Karıstırma Param");

		txt_karistirma = new JTextField();
		txt_karistirma.setText("10");
		txt_karistirma.setColumns(10);

		JLabel lblNodeSays = new JLabel("Node Sayısı");

		txt_node_say = new JTextField();
		txt_node_say.setText("100");
		txt_node_say.setColumns(10);

		JLabel lblDistrubutionSays = new JLabel("random eşik değeri");

		txt_dist_param = new JTextField();
		txt_dist_param.setText("0.5");
		txt_dist_param.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap().addComponent(lblParam)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txt_karistirma, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNodeSays, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txt_node_say, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblDistrubutionSays, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txt_dist_param, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(86, Short.MAX_VALUE)));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
										.addComponent(txt_node_say, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_dist_param, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblParam, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_karistirma, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNodeSays))
						.addGap(17))
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
						.addComponent(lblDistrubutionSays, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE).addGap(44)));
		panel_4.setLayout(gl_panel_4);
		JButton btnSorgula = new JButton("sorgula");
		btnSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomNetworkIslemleri rn = new RandomNetworkIslemleri();
				/**
				 * PARAMETERELERİN ALINMASI
				 */
				if (!txt_karistirma.getText().isEmpty()) {
					KARISTIRMA_PARAMETRESI = new Integer(txt_karistirma.getText().toString());
				}

				if (!txt_node_say.getText().isEmpty()) {
					NODE_SAYISI = new Integer(txt_node_say.getText().toString());
				}
				if (!txt_dist_param.getText().isEmpty()) {
					ESIK_DEGERI = new Double(txt_dist_param.getText().toString());
				}

				if (rd_btn_dist.isSelected()) {
					panel.removeAll();
				    Integer[] dizi=rn.karistir(KARISTIRMA_PARAMETRESI, ESIK_DEGERI,NODE_SAYISI );
					RandomNetworkDistrubitionPanel distributionPanel = new RandomNetworkDistrubitionPanel(dizi);
					panel.add(distributionPanel);
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
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 748, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSorgula))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSorgula)
					.addGap(55))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}
