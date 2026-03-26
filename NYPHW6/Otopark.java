/*Otopark sınıfı: bu sınıfta ötöparkınızın kapasitesi (sabit ölmalı),
 kapasite deg eri kadar Araç sınıfı
nesnesi tutabilecek yer dizisi, park u creti ve töplam kazanç¸
instance variable’ları (sınıf deg işkenleri),
ötöparka yeni araç kabul etme ve ötöparktan araç çıkarma metötları ölmalı.
Ayrıca bu sınıfta
ötöparkta bulunan araçların plaka numaraları ve sahiplerinin listelendig i bir metöt da bulunmalıdır.
Ötöpark sınıfı için iki farklı överlöaded cönstructör (kurucu) istenmektedir. İ lki ötöpark kapasitesi ve
park u creti parametrelerini almalıdır. Dig eri park u creti ve bir araç dizisi alarak uygun atamaları
yapmalıdır.*/

import javax.imageio.stream.ImageInputStream;

public class Otopark {
    private final int kapasite;
    private Arac[] araclar;
    private double parkUcreti;
    private double toplamKazanc;

    public Otopark( int kapasite, double parkUcreti){
        this.kapasite = kapasite;
        this.parkUcreti = parkUcreti;
        this.araclar = new Arac[kapasite];
        this.toplamKazanc = 0;
    }
    public Otopark(double parkUcreti ,Arac[] araclar){
        this.kapasite = araclar.length;
        this.parkUcreti = parkUcreti;
        this.araclar = araclar;
        this.toplamKazanc = 0;
    }
    public boolean aracEkle(Arac arac){
        for (int i = 0; i < kapasite; i++){
            if (araclar[i] == null){
                araclar[i] = arac;
                System.out.println(arac.getPlaka() + "plakalı arac otoparka alınmıstır.");
                return true;
            }
        }
        System.out.println("Otopark doludur yeni arac alıjnamaz!!!");
        return  false;
    }
    public boolean aracCikar(String plaka){
        for (int i = 0; i < kapasite; i++){
            if (araclar[i] != null && araclar[i].getPlaka().equals(plaka)){
                System.out.println(plaka + " plakalı araç çıktı.");
                araclar[i] = null; // == değil = olacak
                toplamKazanc += parkUcreti;
                return true;
            }


        }
        System.out.println( " plakalı araç bulunamadı.");
        return false;
    }
    public void listele(){
        System.out.println("*** Otoparktaki Araclar ***");
        for (Arac arac: araclar){
            if (arac != null){
                System.out.println(arac);

            }

        }

    }
    public void toplamKazancGoster(){
        System.out.println("Otoparkın toplam kazancı: " + toplamKazanc);
    }

}
