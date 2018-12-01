package complexNetworkBLO;

import java.util.ArrayList;

public class MainApp {

	public static Float RANDOM_NETWORK_ESIGI_DEGERI = (float) 0.5;
	public static Integer NODE_SAYISI = 1000;
	public static Float FIKIR_ESIK_DEGERI = (float) 0.7; // a sayısı
	public static Float FIKIR_ESIK_YAKINLASMA = (float) 0.6; // e sayısı
	public static int NSAMPLE=100;
	public static int ITERASYON =100; // iterasyon
	public static int DIST_PARAM = 10;
	
	
	
	public static Float[][] randomNetwork;
	public static Float[] fikirler;
	

	int zamanSayaci=0;
	public static void main(String[] args) {
		ArrayList<ArrayList<Object[]>> sample=new ArrayList<ArrayList<Object[]>>();
		YazmaIslemleri yi=new YazmaIslemleri();
		
		for(int k=0;k<NSAMPLE;k++)
		{
			ArrayList<Object[]> yazilacaklar=new ArrayList<Object[]>();
			
			RandomNetworkFikirDagitIslemleri rd=new RandomNetworkFikirDagitIslemleri();
			
			
			randomNetwork= rd.randomNetwork(RANDOM_NETWORK_ESIGI_DEGERI, NODE_SAYISI);
				
				 
			for(int i=0;i<ITERASYON;i++)
			{
				Object[] yazdir=new Object[2];
				if(i==0)
				{
					fikirler=rd.fikirDagit(NODE_SAYISI);
					
				}
				else
				{
					fikirler=rd.guncelleFikir(RANDOM_NETWORK_ESIGI_DEGERI,
			    		NODE_SAYISI, FIKIR_ESIK_DEGERI, FIKIR_ESIK_YAKINLASMA, randomNetwork, fikirler);
				}
				
			    Integer[] dist=  rd.distributionHesapla(fikirler, DIST_PARAM);
			    float ort=rd.ortalama(fikirler);
			    yazdir[0]=dist;
			    yazdir[1]=ort;
			    yazilacaklar.add(yazdir);
			    
			   

			}
			 sample.add(yazilacaklar);
		}

		
	    ArrayList<Object[]> list= yi.txtYazNSample(sample, DIST_PARAM);
	}

}
