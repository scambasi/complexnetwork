package tez_1maven.test;

public class IdeaIslemleri {
	private  int NODE_SAYISI = 150;
	

	public Double[] fillIdea() {
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

	public Double[] updateIdea(Double[] idea)
	{
	if(idea.length==0)
	{
		return null;
	}
		double e = 0.4;
		double a = 0.3;
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
	public Double[] karistirIdea(Double[] idea,int p) {
	  Double[] id=idea;
      for(int i=0;i<p;i++)
      {
      	 id=updateIdea(id);
      }
      return id;
	}
	public Double[] fikirDistrubition(Double[] fikirler) {
		int distrubitonParam=10;
		Double[] fikirlerLocal=(Double[]) fikirler;
		Double[] distrubitions=new Double[distrubitonParam];
		for(int j=0;j<distrubitonParam;j++) {
			distrubitions[j]=new Double(0);
		}
		for (int i = 0; i < fikirlerLocal.length; i++) {
			for(int j=1;j<=distrubitonParam;j++) {
			if(fikirlerLocal[i]<(j*0.1))
			{
				distrubitions[j-1]=++distrubitions[j-1];
				break;
			}
			
			}
			

		}
		return distrubitions;
	}
}
