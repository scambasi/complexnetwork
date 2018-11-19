package complexNetworkBLO;

import java.util.ArrayList;

public class RandomNetworkFikirDagitIslemleri {

	/**
	 * Random Network işlem tanımlama fonsiyonu berlirnene bir esik degerinin gecen
	 * rastgele sayılar varsa iki ikisi komsu olur. 
	 * @param nodeSayisi
	 * @param nNode
	 * @return
	 */
	public  Double[][] randomNetwork(double esikDegeri, int nodeSayisi) {
		/**
		 * iki degişkenli dizi tanımladık son bölüm dizi sayısını tutucak. Tüm
		 * değerlerini Sıfırlardık
		 */
		Double[][] randomNetwork = new Double[nodeSayisi][nodeSayisi + 1];
		for (int i = 0; i < randomNetwork.length; i++) {
			for (int j = 0; j < randomNetwork[i].length; j++) {
				randomNetwork[i][j] = new Double(0);
			}

		}
		/**
		 * Tüm dizi elemalarını dolaşarak komşulukları oluşturacağız
		 */
		for (int i = 0; i < randomNetwork.length; i++) {
			System.out.println(i + " Komşulukları: ->");
			for (int j = 0; j < randomNetwork.length; j++) {

				if (i != j) {
					double rastgele = (double) Math.random();
					/**
					 * i,j nodu için rastgele sayıdan büyükse komşu oluyorlar.
					 */
					if (rastgele > esikDegeri) {
						randomNetwork[i][j] = (double) 1;
						randomNetwork[i][randomNetwork.length] = randomNetwork[i][randomNetwork.length] + 1;
						System.out.print(j + " , ");
						System.out.println("KOMŞU , ");

					} else {
						randomNetwork[i][j] = (double) 0;
						System.out.print(j + " , ");
						System.out.println("KOMŞU OLMAYAN , ");

					}
				}
			}
			System.out.println(" Komşu Sayısı: ->" + randomNetwork[i][randomNetwork.length]);
		}

		return randomNetwork;
	}
	/**
	 * Rastgele fikir dagit
	 */
	public  Double[] fikirDagit(int nodeSayisi) {
		// fikirleri sıfırladık.
		Double[] randomNetwork = new Double[nodeSayisi];
		for (int i = 0; i < randomNetwork.length; i++) {

			randomNetwork[i] = new Double(0);
		}
		// 0-1 arasında herkese rastgele fikir dağıt.
		for (int i = 0; i < randomNetwork.length; i++) {
			double rastgele = (double) Math.random();
			randomNetwork[i] = rastgele;
		}
		return randomNetwork;
		
	}
	/**
	 * 
	 */
	
	public  Double[]  guncelleFikir(double esikDegeri, int nodeSayisi,double fikirEsigi,double fikirYaklasimi,
			Double[][] randomNetWork,Double[] fikirler)
	{
		Double[] yeniFikir=new Double[nodeSayisi];
		for(int i=0;i<yeniFikir.length;i++)
		{
			yeniFikir[i]=new Double(0);
			
		}
		
		for (int i = 0; i < randomNetWork.length; i++) {
			Double[] komsular=randomNetWork[i];
			ArrayList<Integer> listKomsular=new ArrayList<Integer>();
			for (int j = 0; j < komsular.length-1; j++) {
				//i'nin komşuları listesi
				
				 if(komsular[j]==1)
				 {
					 listKomsular.add(j);			 
				 }
			}
			//komşusu varsa 
			if(listKomsular.size()>0) {
				//rastgele komşu seç 
				 int rastgeleKomsu = (int) (Math.random() * listKomsular.size());
				 //rastgele komşunun fikri
			     double komsununFikri=fikirler[listKomsular.get(rastgeleKomsu)];
				 double benimFikrim=fikirler[i];
				 // komsular fikir paylasım için karar verdimi 
				 if(Math.abs( benimFikrim-komsununFikri)<fikirEsigi)
				 {
					 yeniFikir[i]=(1-fikirYaklasimi)*benimFikrim+fikirYaklasimi*komsununFikri;
					 yeniFikir[listKomsular.get(rastgeleKomsu)]=(1-fikirYaklasimi)*komsununFikri+fikirYaklasimi*benimFikrim;
				 }
			}
		}
		//yeni fikirleir yazdır
		for(int i=0;i<yeniFikir.length;i++)
		{
			System.out.println(" yeni fikir "+yeniFikir[i]+" eski fikir "+fikirler[i]);
		}
		return yeniFikir;
	}
	
}
