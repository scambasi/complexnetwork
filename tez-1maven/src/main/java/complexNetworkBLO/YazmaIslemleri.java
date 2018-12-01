package complexNetworkBLO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class YazmaIslemleri 
{
	public ArrayList<Object[]>  txtYazNSample(ArrayList<ArrayList<Object[]>> yazmaListNSample,int distParam)
	{
		//genel toplamlar listesi döndürülecek
	    ArrayList<Object[]> listOrtToplamlar=new ArrayList<Object[]>();
	    Date dt=new Date();
	   String dateName= dt.getYear()+"_"+dt.getMonth()+"_"+dt.getDay()+"_"+dt.getHours()+"_"+dt.getMinutes()+"_"+dt.getSeconds();
		// DOSYA ADI
        String fileName = "randomNetwork_"+dateName +".txt";

        try {
            // FILE OLUSTUR.
            FileWriter fileWriter =
                new FileWriter(fileName);
            // BUFFER OLUSTUR.BASLIK OLUSTUR:
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            
            bufferedWriter.write("it|" );
            for(int i=0;i<distParam;i++)
            {
            	 bufferedWriter.write("dt"+(i+1)+ "|" );
            }
            
            bufferedWriter.write("Or");
            bufferedWriter.newLine();
            bufferedWriter.write("------------------------------------------------------");
            bufferedWriter.newLine();
            ///BASLIK SONU
            /*
             * VERİLERİ OLUSTUR:
             */
            /**
             * Sample lar Toplamı için işlemler
             */
            Integer[] distOrtSample=new Integer[distParam];
            for(int i=0;i<distOrtSample.length;i++)
            {
            	distOrtSample[i]=0;
            }
        
            float ortalamaOrtSample=0;
            for(int x=0;x<yazmaListNSample.size();x++)
            {
            	bufferedWriter.write("-----------------SAMPLE-----------------------");
            	 bufferedWriter.newLine();
            	ArrayList<Object[]> yazmaList=yazmaListNSample.get(x);
                    Object[] obj=new Object[2];
                    Integer[] dist=null;
                    float ortalama=0;
                    Integer[] distOrt=new Integer[distParam];
                    for(int i=0;i<distOrt.length;i++)
                    {
                    	distOrt[i]=0;
                    }
                    float ortalamaOrt=0;
                    
                    for(int i=0;i<yazmaList.size();i++)
                    {
                    	obj=yazmaList.get(i);
                    	dist= (Integer[])obj[0];
                    	ortalama=(Float)obj[1];
                    	 bufferedWriter.write((i+1) +" | ");
                    	 for(int k=0;k<dist.length;k++)
                         {
                         	
                         	 bufferedWriter.write(dist[k]+" | ");
                         	distOrt[k]=dist[k]+distOrt[k];
                         	 
                         }
                    	 ortalamaOrt=ortalama+ortalamaOrt;
                         bufferedWriter.write(ortalama +" ");
                         bufferedWriter.newLine();
                        
                    }
                    /**
                     * GENEL TOPLAM
                     */
                    bufferedWriter.write("-----------------GENEL TOPLAM-----------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write((yazmaList.size()+1) +" | ");
                    for(int l=0;l<distOrt.length;l++)
                    {  
                    	distOrt[l]=(distOrt[l]/yazmaList.size());
                    	 bufferedWriter.write(distOrt[l]+" | ");
                    	 distOrtSample[l]=distOrt[l]+distOrtSample[l];
                    	
                    }
                    ortalamaOrt=ortalamaOrt/yazmaList.size();
                    ortalamaOrtSample=ortalamaOrt+ortalamaOrtSample;
                    bufferedWriter.write(ortalamaOrt +" ");
                    bufferedWriter.newLine();
                    bufferedWriter.write("-----------------SAMPLE SONU-----------------------");
                    bufferedWriter.newLine();
                    /**
                     * Sample sonundaki toplamları listeye atıyoruz.
                     */
                    Object[] objToplam=new Object[2];
                    objToplam[0]=distOrt;
                    objToplam[1]=ortalamaOrt;
                    listOrtToplamlar.add(objToplam);
                    
                    
            }
            /**
             * GENEL TOPLAM SAMPLE 
             */
            bufferedWriter.write("-----------------GENEL TOPLAM SAMPLE-----------------------");
            bufferedWriter.newLine();
            bufferedWriter.write((yazmaListNSample.size()) +" | ");
            for(int l=0;l<distOrtSample.length;l++)
            {   distOrtSample[l]=(distOrtSample[l]/yazmaListNSample.size());
            	 bufferedWriter.write(distOrtSample[l] +" | ");
            	
            	
            }
            ortalamaOrtSample=(ortalamaOrtSample/yazmaListNSample.size());
            bufferedWriter.write( ortalamaOrtSample+" ");
            bufferedWriter.newLine();
            bufferedWriter.write("-----------------GENEL TOPLAM SAMPLE- SONU-----------------------");
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("YAZMA BAŞARILI");
            /**
             * Sample genel toplam listeye atıyoruz.
             */
            Object[] objToplamSample=new Object[2];
            objToplamSample[0]=distOrtSample;
            objToplamSample[1]=ortalamaOrtSample;
            listOrtToplamlar.add(objToplamSample);
        }
        catch(IOException ex) {
            System.out.println(
                "YAZMA HATASI '"
                + fileName + "'");
           
             ex.printStackTrace();
        }
		
		return listOrtToplamlar;
	}
	public void  txtYaz(  ArrayList<Object[]> yazmaList,int distParam)
	{
	    Date dt=new Date();
	   String dateName= dt.getYear()+"_"+dt.getMonth()+"_"+dt.getDay()+"_"+dt.getHours()+"_"+dt.getMinutes()+"_"+dt.getSeconds();
		// DOSYA ADI
        String fileName = "randomNetwork_"+dateName +".txt";

        try {
            // FILE OLUSTUR.
            FileWriter fileWriter =
                new FileWriter(fileName);
            // BUFFER OLUSTUR.BASLIK OLUSTUR:
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            
            bufferedWriter.write("it|" );
            for(int i=0;i<distParam;i++)
            {
            	 bufferedWriter.write("dt"+(i+1)+ "|" );
            }
            
            bufferedWriter.write("Or");
            bufferedWriter.newLine();
            bufferedWriter.write("------------------------------------------------------");
            bufferedWriter.newLine();
            ///BASLIK SONU
            /*
             * VERİLERİ OLUSTUR:
             */
                    Object[] obj=new Object[2];
                    Integer[] dist=null;
                    float ortalama=0;
                    Integer[] distOrt=new Integer[distParam];
                    for(int i=0;i<distOrt.length;i++)
                    {
                    	distOrt[i]=0;
                    }
                    float ortalamaOrt=0;
                    
                    for(int i=0;i<yazmaList.size();i++)
                    {
                    	obj=yazmaList.get(i);
                    	dist= (Integer[])obj[0];
                    	ortalama=(Float)obj[1];
                    	 bufferedWriter.write((i+1) +" | ");
                    	 for(int k=0;k<dist.length;k++)
                         {
                         	
                         	 bufferedWriter.write(dist[k]+" | ");
                         	distOrt[k]=dist[k]+distOrt[k];
                         	 
                         }
                    	 ortalamaOrt+=ortalama;
                         bufferedWriter.write(ortalama +" ");
                       
                        
                    }
                    /**
                     * GENEL TOPLAM
                     */
                    bufferedWriter.newLine();
                    bufferedWriter.write("-----------------GENEL TOPLAM-----------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write((yazmaList.size()+1) +" | ");
                    for(int l=0;l<distOrt.length;l++)
                    {  
                    	 bufferedWriter.write((distOrt[l]/yazmaList.size()) +" | ");
                    	
                    }
                    bufferedWriter.write((ortalamaOrt/yazmaList.size()) +" ");
                  
            bufferedWriter.close();
            System.out.println("YAZMA BAŞARILI");
        }
        catch(IOException ex) {
            System.out.println(
                "YAZMA HATASI '"
                + fileName + "'");
           
             ex.printStackTrace();
        }
		
		
	}

}
