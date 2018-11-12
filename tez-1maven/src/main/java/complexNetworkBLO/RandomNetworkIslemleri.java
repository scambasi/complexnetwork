package complexNetworkBLO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RandomNetworkIslemleri {

	public static void main(String[] args) {

//		Double[][] param = randomNetwork(0.4, 5);
//		distrubitionHesabi(param);
		karistir(5, 0.4, 5);
	}

	public static Integer[] karistir(int karistirmaParam, double esikDegeri, int nodeSayisi) {
		ArrayList<Integer[]> distributionList=new ArrayList<Integer[]>();
		Integer[] distributionGenel=new  Integer[nodeSayisi];
		for(int m=0;m<distributionGenel.length;m++)
		{
			distributionGenel[m]=new Integer(0);
		}
		/**
		 * tüm distrubitionları bir arrayda topladık
		 */
		for (int i = 0; i < karistirmaParam; i++) {
			Double[][] param = randomNetwork(esikDegeri, nodeSayisi);
			Integer[] localArray=distrubitionHesabi(param);
			distributionList.add(localArray);
		}
		/**
		 * array içinde gezererk tüm distlerin toplamını  alıyoruz.
		 */
		for (int i = 0; i < distributionList.size(); i++) {
			Integer[] local=distributionList.get(i);
			for(int k=0;k<local.length;k++)
			{
				distributionGenel[k]=local[k]+distributionGenel[k];
			}	
		}
		/**
		 * Tüm toplanan distrubitionları ortalamasını aldık
		 */
		for(int i=0;i<distributionGenel.length;i++)
		{
			distributionGenel[i]=distributionGenel[i]/karistirmaParam;
			System.out.println(i+"="+distributionGenel[i]);
		}
		
		return distributionGenel;
	}

	public static Integer[] distrubitionHesabi(Double[][] param) {

		Integer[] distrubitions = new Integer[param.length];
		for (int j = 0; j < distrubitions.length; j++) {
			distrubitions[j] = new Integer(0);
		}
		Integer[] komsuSayisiList = new Integer[param.length];
		for (int i = 0; i < param.length; i++) {
			for (int j = 0; j < param[i].length; j++) {
				Double komsuSayisi = param[i][param.length];
				komsuSayisiList[i] = komsuSayisi.intValue();
			}
		}
		/**
		 * array sıralama
		 */
		Arrays.sort(komsuSayisiList);
		/**
		 * 1 tane komşusu olan kaç kişi var sorusunu cevabı
		 */
		Map<Integer, Integer> komsuVeSayisi = new HashMap();

		for (Integer komsuSayisi : komsuSayisiList) {
			Integer count = komsuVeSayisi.get(komsuSayisi);
			if (count == null) {
				komsuVeSayisi.put(komsuSayisi, 1);
			} else {
				komsuVeSayisi.put(komsuSayisi, ++count);
			}

		}
		

		 Collection<Integer> key = komsuVeSayisi.keySet();
		 Collection<Integer> set = komsuVeSayisi.values();
		 Integer[] keyArray = key.toArray(new Integer[key.size()]);
		 Integer[] setArray = set.toArray(new Integer[set.size()]);
		 for(int i=0;i<keyArray.length;i++)
		 {
		 System.out.print("k= "+keyArray[i]+"=>"+setArray[i]);
		 System.out.println(" ");
		 distrubitions[keyArray[i]]=setArray[i];
		 }
		 System.out.println(" DistArray");
		for(int i=0;i<distrubitions.length;i++)
		{
			 
		 System.out.print(i+" => "+distrubitions[i]);//sayısı
		 System.out.println(" ");
		}
		return distrubitions;
	}

	/**
	 * Random Network işlem tanımlama fonsiyonu berlirnene bir esik degerinin gecen
	 * rastgele sayılarvarsa iki ikisi komsu olur * @param nodeSayisi
	 * 
	 * @param nNode
	 * @return
	 */
	public static Double[][] randomNetwork(double esikDegeri, int nodeSayisi) {
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
}
