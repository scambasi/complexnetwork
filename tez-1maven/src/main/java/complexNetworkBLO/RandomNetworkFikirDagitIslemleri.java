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
	public  Float[][] randomNetwork(float esikDegeri, int nodeSayisi) {
		/**
		 * iki degişkenli dizi tanımladık son bölüm dizi sayısını tutucak. Tüm
		 * değerlerini Sıfırlardık
		 */
		Float[][] randomNetwork = new Float[nodeSayisi][nodeSayisi + 1];
		for (int i = 0; i < randomNetwork.length; i++) {
			for (int j = 0; j < randomNetwork[i].length; j++) {
				randomNetwork[i][j] = new Float(0);
			}

		}
		/**
		 * Tüm dizi elemalarını dolaşarak komşulukları oluşturacağız
		 */
		for (int i = 0; i < randomNetwork.length; i++) {
//			System.out.println(i + " Komşulukları: ->");
			for (int j = 0; j < randomNetwork.length; j++) {

				if (i != j) {
					float rastgele = (float) Math.random();
					/**
					 * i,j nodu için rastgele sayıdan büyükse komşu oluyorlar.
					 */
					if (rastgele > esikDegeri) {
						randomNetwork[i][j] = (float) 1;
						randomNetwork[i][randomNetwork.length] = randomNetwork[i][randomNetwork.length] + 1;
//						System.out.print(j + " , ");
//						System.out.println("KOMŞU , ");

					} else {
						randomNetwork[i][j] = (float) 0;
//						System.out.print(j + " , ");
//						System.out.println("KOMŞU OLMAYAN , ");

					}
				}
			}
//			System.out.println(" Komşu Sayısı: ->" + randomNetwork[i][randomNetwork.length]);
		}

		return randomNetwork;
	}
	/**
	 * Rastgele fikir dagit
	 */
	public  Float[] fikirDagit(int nodeSayisi) {
		// fikirleri sıfırladık.
		Float[] randomNetwork = new Float[nodeSayisi];
		for (int i = 0; i < randomNetwork.length; i++) {

			randomNetwork[i] = new Float(0);
		}
		// 0-1 arasında herkese rastgele fikir dağıt.
		for (int i = 0; i < randomNetwork.length; i++) {
			float rastgele = (float) Math.random();
			randomNetwork[i] = rastgele;
		}
		return randomNetwork;
		
	}
	/**
	 * 
	 */
	public Integer[] distributionHesapla(Float[] fikirler,int distParam)
	{
		Float[] fikirLocal = fikirler;
		Integer[] distrubitions=new Integer[distParam];
		for (int i = 0; i < distrubitions.length; i++) {
			distrubitions[i] = new Integer(0);
		}
		for(int i=0;i<fikirLocal.length;i++)
		{
			int sayi=(int) (fikirLocal[i]*10);
			for(int j=1;j<=distParam;j++) {
				if(sayi<(j))
				{
					distrubitions[j-1]=++distrubitions[j-1];
					break;
				}
			}
		}
		
		return distrubitions;
	}
	public float ortalama(Float[] fikirler)
	{
		float ort=0;
		for(int i=0;i<fikirler.length;i++)
		{
			ort+=fikirler[i];
		}
		float toplam=fikirler.length;
		float sonuc=ort/toplam;
		return sonuc;
	}
	public  Float[]  guncelleFikir(float esikDegeri, int nodeSayisi,float fikirEsigi,float fikirYaklasimi,
			Float[][] randomNetWork,Float[] fikirler)
	{
		Float[] yeniFikir=new Float[nodeSayisi];
		for(int i=0;i<yeniFikir.length;i++)
		{
			yeniFikir[i]=new Float(0);
			
		}
		
		for (int i = 0; i < randomNetWork.length; i++) {
			Float[] komsular=randomNetWork[i];
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
				 float komsununFikri=fikirler[listKomsular.get(rastgeleKomsu)];
				 float benimFikrim=fikirler[i];
				 // komsular fikir paylasım için karar verdimi 
				 if(Math.abs( benimFikrim-komsununFikri)<fikirEsigi)
				 {
					 yeniFikir[i]=(1-fikirYaklasimi)*benimFikrim+fikirYaklasimi*komsununFikri;
					 yeniFikir[listKomsular.get(rastgeleKomsu)]=(1-fikirYaklasimi)*komsununFikri+fikirYaklasimi*benimFikrim;
				 }
			}
		}
//		//yeni fikirler yazdır
//		for(int i=0;i<yeniFikir.length;i++)
//		{
//			System.out.println(" yeni fikir "+yeniFikir[i]+" eski fikir "+fikirler[i]);
//		}
		return yeniFikir;
	}
	
}
