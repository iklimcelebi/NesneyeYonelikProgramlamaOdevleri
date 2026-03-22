public class Main {
    public static void main(String[] args) {

        Operator op = new Operator();// op tanım.

        FaturaliHat h1 = new FaturaliHat("5551112233", 100, 50);
        FaturasizHat h2 = new FaturasizHat("5554445566", 20);


        op.hatEkle(h1);
        op.hatEkle(h2);

        // Aramalar
        h1.aramaYap("5554445566", 200);
        h2.gelenArama("5551112233", 200);
        h2.aramaYap("5551112233", 50);
        h1.gelenArama("5554445566", 50);

        // Çıktılar
        System.out.println(h1);
        System.out.println(h2);
        System.out.println("Hat1 En Uzun: " + h1.enUzunKonusma());
        System.out.println("Hat2 En Uzun: " + h2.enUzunKonusma());
        System.out.println("Hat1 Sıklık: " + h1.aramaSikliginaGoreSirala());
        System.out.println("Hat2 Sıklık: " + h2.aramaSikliginaGoreSirala());
    }
}