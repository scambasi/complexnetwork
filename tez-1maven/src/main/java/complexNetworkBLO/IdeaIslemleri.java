package complexNetworkBLO;

import java.util.ArrayList;

public class IdeaIslemleri {
	
	public Double[] fillIdea(int NODE_SAYISI) {
		Double[] IDEA = new Double[NODE_SAYISI];
		for (int i = 0; i < NODE_SAYISI; i++) {
				IDEA[i] = new Double(0);
		}
		// Komşuluklar sırasıyla
		for (int i = 0; i < NODE_SAYISI; i++) {
			double rastgeleNode = Math.random();
			IDEA[i] = rastgeleNode;

		}
		return IDEA;
	}

	public Double[] updateIdea(Double[] idea,int NODE_SAYISI,double e,double a)
	{
	if(idea.length==0)
	{
		return null;
	}
//		double e = 0.5;//kara verme katsayısı
//		double a = 0.1; //yakınlaşma katsayısı
		Double[] ideas=idea;
		for (int i = 0; i < NODE_SAYISI; i++) {
			int j = (int) Math.random() % NODE_SAYISI;
			if ((Math.abs( ideas[i] - ideas[j]) < e)) {
				ideas[i] = (1 - a) * ideas[i] + a * ideas[j];
				ideas[j] = (1 - a) * ideas[j] + a * ideas[i];
			}

		}
		
		return ideas;
		
	}
	public Double[] karistirIdea(Double[] idea,int p,int NODE_SAYISI,double fikir_karar_verme,double fikir_yakinlasmasi) {
	  Double[] id=idea;
	  ArrayList<Double[]> birlesmisFikirler=new ArrayList(); 
	  Double[] birlesmisFikir = new Double[NODE_SAYISI];
	  for (int i = 0; i < NODE_SAYISI; i++) {
		  birlesmisFikir[i] = new Double(0);
	}
	  birlesmisFikirler.add(id);
      for(int i=0;i<p;i++)
      {
    	 
      	 id=updateIdea(id,NODE_SAYISI,fikir_karar_verme,fikir_yakinlasmasi);
      	birlesmisFikirler.add(id);
      }
      for(int i=0;i<birlesmisFikirler.size();i++)
 	  {
 		 Double[] fikir=birlesmisFikirler.get(i);
 		 for(int j=0;j<NODE_SAYISI;j++)
 		 {
 			 birlesmisFikir[j]=(fikir[j]+birlesmisFikir[j]);
 		 }
 	  }
      for(int i=0;i<birlesmisFikir.length;i++)
      {
    	  birlesmisFikir[i]=birlesmisFikir[i]/birlesmisFikirler.size();
      }
      return birlesmisFikir;
	}
	public Double[] fikirDistrubition(Double[] fikirler,int distrubitonParam) {
	//	int distrubitonParam=10;
		Double[] fikirlerLocal=(Double[]) fikirler;
		Double[] distrubitions=new Double[distrubitonParam];
		for(int j=0;j<distrubitonParam;j++) {
			distrubitions[j]=new Double(0);
		}
		for (int i = 0; i < fikirlerLocal.length; i++) {
			for(int j=1;j<=distrubitonParam;j++) {
				Double ilksayi=fikirlerLocal[i]*10;
				int sayi=ilksayi.intValue();
				if(sayi<(j))
				{
					distrubitions[j-1]=++distrubitions[j-1];
					break;
				}
			}
		}
		return distrubitions;
	}
	public Double[][] randomNetwork(int nodeSayisi,Double[] nNode)
	{
		Double[] randomNodes=nNode;
		Double[][] randomNetwork=new Double[nodeSayisi][nodeSayisi];
		for(int i=0;i<randomNetwork.length;i++)
		{
    		for(int j=0;j<randomNetwork[i].length;j++)
			{
				randomNetwork[i][j] = new Double(0);
			}
			
		}
		/**
		 * node sayısını n.n-1/2 defa hesaplıyacağız
		 */
	
		for(int i=0;i<nNode.length;i++)
		{
			double node1=randomNodes[i];
			for(int j=0;j<randomNodes.length;j++)
			{
				double node2=randomNodes[j];
				double rastgele= (double) Math.random();
				/**
				 * iki nodun ortalaması alınıp rastgele sayıdan büyükse komşu oluyorlar.
				 * 
				 */
				/**
				 * k komşu sayısı kaç tane bilmiyoruz hepsini tutuyoruz;
				 */
				
				if((0.5>rastgele))
				{
			    	randomNetwork[i][j]=(double)j;
					
				}else
				{
					randomNetwork[i][j]=(double)-1;
				}
			}
		
			
		}
		
		return randomNetwork;
	}
}
