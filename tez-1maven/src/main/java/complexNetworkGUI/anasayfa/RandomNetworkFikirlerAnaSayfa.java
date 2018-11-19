package complexNetworkGUI.anasayfa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import complexNetworkBLO.RandomNetworkFikirDagitIslemleri;
import complexNetworkGUI.RandomNetworkFikirDagilimiPanel;

public class RandomNetworkFikirlerAnaSayfa {

	private JFrame frame;
	private JTextField txt_esigi;
	private JTextField txt_node_say;

	/**
	 * PARAMETRELER
	 */

	Double RANDOM_NETWORK_ESIGI_DEGERI = 0.1;
	Integer NODE_SAYISI = 0;
	Double FIKIR_ESIK_DEGERI = 0.1; // a sayısı
	Double FIKIR_ESIK_YAKINLASMA = 0.1; // e sayısı
	Double[][] randomNetwork;
	Double[] fikirler;
	int zamanSayaci=0;


	/**
	 * 
	 */
	Double[] id = new Double[0];

	private JTextField txt_random_esik;
	private JTextField txt_fikiryaklasimi;
	private JTextField txtTxtsayac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomNetworkFikirlerAnaSayfa window = new RandomNetworkFikirlerAnaSayfa();
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
	public RandomNetworkFikirlerAnaSayfa() {
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
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 765, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 782, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Parametreler", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblfikiresikdegeriParam = new JLabel("Fikir Eşiği");

		txt_esigi = new JTextField();
		txt_esigi.setText("0.5");
		txt_esigi.setColumns(10);

		JLabel lblNodeSays = new JLabel("Node Sayısı");

		txt_node_say = new JTextField();
		txt_node_say.setText("100");
		txt_node_say.setColumns(10);

		JLabel lblDistrubutionSays = new JLabel("random eşik değeri");

		txt_random_esik = new JTextField();
		txt_random_esik.setText("0.5");
		txt_random_esik.setColumns(10);
		
		JLabel lblFikirYaklam = new JLabel("fikir yaklaşımı");
		
		txt_fikiryaklasimi = new JTextField();
		txt_fikiryaklasimi.setText("0.4");
		txt_fikiryaklasimi.setColumns(10);
		
		final JButton btnFikirAta = new JButton("Fikir Ata");
		btnFikirAta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomNetworkFikirDagitIslemleri rn=new RandomNetworkFikirDagitIslemleri();
				FIKIR_ESIK_DEGERI=new Double(txt_esigi.getText());
				FIKIR_ESIK_YAKINLASMA=new Double(txt_fikiryaklasimi.getText());
				RANDOM_NETWORK_ESIGI_DEGERI=new Double(txt_random_esik.getText());
				NODE_SAYISI=new Integer(txt_node_say.getText());
				
				if(zamanSayaci==0)
				{
					panel.removeAll();
					btnFikirAta.setText("Fikir Güncelle");
					randomNetwork= rn.randomNetwork(RANDOM_NETWORK_ESIGI_DEGERI, NODE_SAYISI);
					 fikirler=rn.fikirDagit(NODE_SAYISI);
					 RandomNetworkFikirDagilimiPanel panelRandom=new RandomNetworkFikirDagilimiPanel(fikirler);
					 panel.add(panelRandom);
				}
				else if(zamanSayaci>0)
				{
					panel.removeAll();
					btnFikirAta.setText("Fikir Güncelle");
				    fikirler=rn.guncelleFikir(RANDOM_NETWORK_ESIGI_DEGERI,
				    		NODE_SAYISI, FIKIR_ESIK_DEGERI, FIKIR_ESIK_YAKINLASMA, randomNetwork, fikirler);
				    RandomNetworkFikirDagilimiPanel panelRandom=new RandomNetworkFikirDagilimiPanel(fikirler);
					 panel.add(panelRandom);
					
				}
				panel.revalidate();
				panel.repaint();
				zamanSayaci++;
				txtTxtsayac.setText(zamanSayaci+"");
			}
		});
		
		JLabel lblZamanSayac = new JLabel("Zaman Sayacı");
		
		txtTxtsayac = new JTextField();
		txtTxtsayac.setText("0");
		txtTxtsayac.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNodeSays, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblfikiresikdegeriParam))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txt_esigi, 0, 0, Short.MAX_VALUE)
						.addComponent(txt_node_say, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addGap(49)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDistrubutionSays, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblFikirYaklam))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txt_fikiryaklasimi, 0, 0, Short.MAX_VALUE)
						.addComponent(txt_random_esik, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblZamanSayac)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTxtsayac, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(61))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnFikirAta)
							.addContainerGap(133, Short.MAX_VALUE))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblfikiresikdegeriParam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(txt_esigi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDistrubutionSays))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNodeSays)
								.addComponent(lblFikirYaklam)
								.addComponent(txt_node_say, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(txt_random_esik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_fikiryaklasimi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFikirAta))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblZamanSayac, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)))
					.addContainerGap(21, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(54)
					.addComponent(txtTxtsayac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(8)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 748, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}
