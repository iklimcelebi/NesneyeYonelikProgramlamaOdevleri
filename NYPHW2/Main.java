import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
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
         System.out.println("1. Ogrenci Ekle ve ders ekle");
         System.out.println("2. Ogrenci Listele");
         System.out.println("3. Her Ders İcin Ortalamanin Ustundeki Ogrenciler");
         System.out.println("4. Her Ders İcin 60'tan Kucuk Sinav Sonuclari");
         System.out.println("5. Her Ders İcin 60'tan Kucuk Sinav Sonucu Sayisi");
         System.out.println("6. Tum Dersler İcin En Yuksek Sinav Sonucu");
         System.out.println("7. Tum Dersler İcin En Dusuk Sinav Sonucu");
         System.out.println("8. Ogrenci Sirala");
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
         Ogrenci ogrenci = new Ogrenci(no, isim);

         while(true) { // ders girisi için while
             System.out.println("Yeni ders adini giriniz: " + "Cikis yapmak icin 'cikis' ");
             String dersAdi = scanner.nextLine();
             if (dersAdi.equals("cikis")) {
                 break;
             }
             System.out.println("Vize Notu: ");
             double vizenot = scanner.nextDouble();
             System.out.println("Final Notu: ");
             double finalnot = scanner.nextDouble();
             scanner.nextLine();

             Ders ders = new Ders(dersAdi, vizenot, finalnot);
             ogrenci.dersEkle(ders);
         }
         ogrenciler.add(ogrenci);
         System.out.println("Ogrenci basariyla eklendi.");
     }
     public static void ogrencileriListele(){
        if (ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
            return;
        }
        for(Ogrenci ogrenci : ogrenciler){
            System.out.println(ogrenci);
        }

     }
    public static void ortalamaninUstu() {
        if (ogrenciler.isEmpty()) {
            System.out.println("Öğrenci bulunmamakta.");
            return;
        }
        for (String dersAdi : getTumDersAdlari()) {
            System.out.println("\n" + dersAdi + " dersi için ortalamanın üstündeki öğrenciler:");
            boolean bulundu = false;
            for (Ogrenci ogr : ogrenciler) {
                for (Ders ders : ogr.dersler) {
                    if (ders.dersAdi.equals(dersAdi) && ders.getOrtalama() > 60) {
                        System.out.println("- " + ogr.isim + " (No: " + ogr.no + ", Not: " + ders.getOrtalama() + ")");
                        bulundu = true;
                    }
                }
            }
            if (!bulundu) {
                System.out.println("Bu derste ortalamanın üstünde öğrenci bulunmamaktadır.");
            }
        }

    }

    public static void sinavSonucuKucuk60() {
        if (ogrenciler.isEmpty()) {
            System.out.println("Öğrenci bulunmamakta.");
            return;
        }

        for (String dersAdi : getTumDersAdlari()) {
            System.out.println("\n" + dersAdi + " dersi için sınav notu 60'tan küçük olan öğrenciler:");
            boolean bulundu = false;
            for (Ogrenci ogr : ogrenciler) {
                for (Ders ders : ogr.dersler) {
                    if (ders.dersAdi.equals(dersAdi) && ders.getOrtalama() < 60) {
                        System.out.println("- " + ogr.isim + " (No: " + ogr.no + ", Not: " + ders.getOrtalama() + ")");
                        bulundu = true;
                    }
                }
            }
            if (!bulundu) {
                System.out.println("Bu derste 60'tan küçük sınav sonucu olan öğrenci bulunmamaktadır.");
            }
        }
    }
    public static void sinavSonucuKucuk60Sayi(){
        int i = 0; // sayac
        for (Ogrenci ogrenci : ogrenciler){
            for (Ders ders : ogrenci.dersler) {
                if (ogrenci.genelOrtalama() < 60) {
                    i++;
                }
            }
        }
        System.out.println("Tum dersler icin 60tan kucuk not sayisi " + i +"dir");
    }
    public static void enYuksekNot(){
        if (ogrenciler.isEmpty()) {
            System.out.println("Öğrenci bulunmamakta.");
            return;
        }
        for (String dersAdi : getTumDersAdlari()) {
            double enYuksek = -1;
            Ogrenci enYuksekOgrenci = null;

            for (Ogrenci ogr : ogrenciler) {
                for (Ders ders : ogr.dersler) {
                    if (ders.dersAdi.equals(dersAdi) && ders.getOrtalama() > enYuksek) {
                        enYuksek = ders.getOrtalama();
                        enYuksekOgrenci = ogr;
                    }
                }
            }

            if (enYuksekOgrenci != null) {
                System.out.println(dersAdi + " dersi için en yüksek sınav sonucu: " + enYuksek +
                        " (Öğrenci No: " + enYuksekOgrenci.no + ", İsim: " + enYuksekOgrenci.isim + ")");
            } else {
                System.out.println(dersAdi + " dersi için kayıtlı sınav sonucu bulunmamaktadır.");
            }
        }
    }




    public static void enDusukNot(){
        if(ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
            return;
        }
        for (String dersAdi : getTumDersAdlari()) {
            double enDusuk = Double.MAX_VALUE;
            Ogrenci enDusukOgrenci = null;

            for (Ogrenci ogr : ogrenciler) {
                for (Ders ders : ogr.dersler) {
                    if (ders.dersAdi.equals(dersAdi) && ders.getOrtalama() < enDusuk) {
                        enDusuk = ders.getOrtalama();
                        enDusukOgrenci = ogr;
                    }
                }
            }

            if (enDusukOgrenci != null) {
                System.out.println(dersAdi + " dersi için en düşük sınav sonucu: " + enDusuk +
                        " (Öğrenci No: " + enDusukOgrenci.no + ", İsim: " + enDusukOgrenci.isim + ")");
            } else {
                System.out.println(dersAdi + " dersi için kayıtlı sınav sonucu bulunmamaktadır.");
            }
        }
    }

    public static void sinavSonucSirala(){
        if(ogrenciler.isEmpty()){
            System.out.println("Ogrenci bulunmamakta.");
            return;
        }
        int n = ogrenciler.size();
        for (int j = 0; j < n - 1; j++){
            for (int k = 0; k <n - j -1;k++){
                if (ogrenciler.get(k).genelOrtalama() > ogrenciler.get(k +1).genelOrtalama()){
                    Ogrenci temp = ogrenciler.get(k);
                    ogrenciler.set(k, ogrenciler.get(k + 1));
                    ogrenciler.set(k + 1, temp);
                }
            }
        }
        ogrencileriListele();

    }
    public static ArrayList<String> getTumDersAdlari() {
        ArrayList<String> dersAdlari = new ArrayList<>();
        for (Ogrenci ogrenci : ogrenciler) {
            for (Ders ders : ogrenci.dersler) {
                if (!dersAdlari.contains(ders.dersAdi)) {
                    dersAdlari.add(ders.dersAdi);
                }
            }
        }
        return dersAdlari;
    }


}

