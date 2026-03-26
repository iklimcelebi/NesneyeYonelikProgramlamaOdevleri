/*
OtoparkTest sınıfı: bu sınıfta ise yazdıg ınız Araç sınıfından bir array(dizi) öluşturacak, Ötöparka
araç kabul etme ve ötöparktan aracı çıkarma metötları test edilmelidir. Ötöparktaki park halindeki
araçların listelenmesi de test edilmelidir. Son olarak da otoparkın töplam kazancı gö sterilmelidir.

*/
import  java.util.Scanner;

public class OtoparkTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kapasite = 5;
        Otopark otopark = new Otopark(kapasite, 50.0);

        for (int i = 0; i < kapasite; i++){
            System.out.println((i  + 1) + "Arac biliglerini giriniz: ");
            System.out.println("Plaka: ");
            String plaka = scanner.nextLine();
            System.out.println("Arac sahibi: ");
            String aracSahibi = scanner.nextLine();

            Arac arac = new Arac(plaka, aracSahibi);
            otopark.aracEkle(arac);

        }
        otopark.listele();

        // ARAÇ ÇIKARMA
        System.out.print("Çıkmak isteyen araç var mı? (evet/hayır): ");
        String istek = scanner.nextLine();

        if (istek.equalsIgnoreCase("evet")){
            System.out.print("Çıkacak aracın plakası: ");
            String plaka = scanner.nextLine();
            otopark.aracCikar(plaka);
        }

        // SON DURUM
        otopark.listele();
        otopark.toplamKazancGoster();

        scanner.close();
    }

}
