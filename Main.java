import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ogrenci> ogrenciler = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int secim;
        do {
            menu();
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim){
                case 1:
                    ogrenciBilgisiAl();
                    break;
                case 2:
                    ogrencileriListele();
                    break;
                case 3:
                    ortalamaninUstu();
                    break;
                case 4:
                    sinavSonucuKucuk60();
                    break;
                case 5:
                    sinavSonucuKucuk60Sayi();
                    break;
                case 6:
                    enYuksekNot();
                    break;
                case 7:
                    enDusukNot();
                    break;
                case 8:
                    sinavSonucSirala();
                    break;
                case 0:
                    System.out.println("Cikis yapiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz secim yaptınız!!!");
            }

        }while (secim != 0);
    }
     public static void menu(){

         System.out.println("\n*** Ogrenci Sistemi ***");
         System.out.println("1. Ogrenci Ekle");
         System.out.println("2. Ogrenci Listele");
         System.out.println("3. Ortalamanin Ustundeki Ogrenciler");
         System.out.println("4. 60'tan Kucuk Sinav Sonuclari");
         System.out.println("5. 60'tan Kucuk Sinav Sonucu Sayisi");
         System.out.println("6. En Yuksek Sinav Sonucu");
         System.out.println("7. En Dusuk Sinav Sonucu");
         System.out.println("8. Sinav Sonuclarına Gore Sirala");
         System.out.println("0. Cıkıs");
         System.out.print("Secin...: ");

     }
     public static void ogrenciBilgisiAl(){
        // no
        System.out.println("No: ");
        int no = scanner.nextInt();

        scanner.nextLine(); // scanner hatası duzeltmek için kullanılıyormus
        // isim
         System.out.println("Isim: ");
         String isim = scanner.nextLine();
         // vize - final notlari
         System.out.println("Vize Notu: ");
         double vizeNotu = scanner.nextDouble();

         System.out.println("Final Notu: ");
         double finalNotu = scanner.nextDouble();

         // yeni olusturmak icin
         double ortalama = vizeNotu * 0.4 + finalNotu * 0.6;
         ogrenci ogrenci = new ogrenci(no, vizeNotu, finalNotu, ortalama, isim);
         ogrenciler.add(ogrenci);
         System.out.println("Yeni ogrenci eklendi!");
     }
     public static void ogrencileriListele(){
        if (ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
        }
        for(ogrenci ogrenci : ogrenciler){
            System.out.println(ogrenci);
        }

     }
     public static void ortalamaninUstu(){// ortalamanin ustundeki ogrencilr
        if(ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
            return;
        }
        double sinifOrtalama = 0; // sınıf ortalamasını degerini tutar

         for(ogrenci ogrenci : ogrenciler){
             sinifOrtalama += ogrenci.OrtalamaHesapla();
         }
         sinifOrtalama /= ogrenciler.size();

         for (ogrenci ogrenci : ogrenciler){
             if(ogrenci.OrtalamaHesapla() > sinifOrtalama){
                 System.out.println("No: " + ogrenci.no + " Isim: " + ogrenci.isim + " Ortalama: " + ogrenci.OrtalamaHesapla());             }

         }

     }
    public static void sinavSonucuKucuk60(){
        if(ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
            return;
        }
        for (ogrenci ogrenci : ogrenciler){
            if (ogrenci.OrtalamaHesapla() <60){
                System.out.println("No: " + ogrenci.no + " Isim: " + ogrenci.isim + " Ortalama: " + ogrenci.OrtalamaHesapla());
            }

        }

    }
    public static void sinavSonucuKucuk60Sayi(){
        int i = 0; // sayac
        for (ogrenci ogrenci : ogrenciler){
            if (ogrenci.OrtalamaHesapla() < 60){
                i++;
            }

        }
        System.out.println("60tan kucuk not sayisi " + i +"dir");

    }
    public static void enYuksekNot(){
        if(ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
            return;
        }
        ogrenci enYuksek = ogrenciler.get(0);
        for (ogrenci ogrenci: ogrenciler){
            if (ogrenci.OrtalamaHesapla() > enYuksek.OrtalamaHesapla()){
                enYuksek = ogrenci;

            }

        }
        System.out.println("No: " + enYuksek.no + "Isim: "+ enYuksek.isim + " Ortalama: " + enYuksek.OrtalamaHesapla());

    }
    public static void enDusukNot(){
        if(ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
            return;
        }
        ogrenci enDusuk = ogrenciler.get(0);
        for (ogrenci ogrenci: ogrenciler){

            if(ogrenci.OrtalamaHesapla() < enDusuk.OrtalamaHesapla()){
                enDusuk = ogrenci;

            }
        }
        System.out.println("No: " + enDusuk.no + " Isim: " + enDusuk.isim + " Ortalama: " + enDusuk.OrtalamaHesapla());
    }
    public static void sinavSonucSirala(){
        if(ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
            return;
        }
        int n = ogrenciler.size();
        for (int j = 0; j < n - 1; j++){
            for (int k = 0; k <n - j -1;k++){
               if (ogrenciler.get(k).OrtalamaHesapla() > ogrenciler.get(k +1).OrtalamaHesapla()){
                   ogrenci temp = ogrenciler.get(k);
                   ogrenciler.set(k, ogrenciler.get(k + 1));
                   ogrenciler.set(k + 1, temp);

               }

            }

        }
        ogrencileriListele();

    }

}

