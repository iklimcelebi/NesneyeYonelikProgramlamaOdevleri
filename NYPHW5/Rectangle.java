/*
a. Bir	dikdörtgen(Rectangle)	sınıfı	oluşturun.
Sınıf	değişkenleri	private	olmalıdır	ve
negatif	değer	almayı
engelleyen	set	metodları	olmalıdır.
Iki	parametre	alan	bir	kurucusu(Constructor)	olsun.
Kısa	kenar	uzun kenar	 kontrollerini	 yapalım.
 Çevre	 ve	 alanını	 hesaplayan	 metodları	 olsun.
 Ayrıca	 bilgilerini	 ekrana
yazdıran	bir	metodu	olsun.
 */
public class Rectangle {
    private double kısaKenar;
    private double uzunKenar;

    //constructor:
    public Rectangle(double kısaKenar, double uzunKenar){
        if (kısaKenar > uzunKenar){
            throw new IllegalArgumentException("Kısa kenar, uzun kenardan buyuk olamaz.");
        }
        if (kısaKenar == uzunKenar){
            System.out.println("kare!");

        }
        if (kısaKenar <= 0 || uzunKenar <= 0){
            throw new IllegalArgumentException("kenar uzunluklari 0'dan kucuktur.");
        }
        this.kısaKenar = kısaKenar;
        this.uzunKenar= uzunKenar;
    }
    public double getKısaKenar(){
        return kısaKenar;
    }
    public void setKısaKenar(double kısaKenar) { // set methodlarında geri donus degeri olmadığı için void kullanılır.
        if (kısaKenar > 0){
            this.kısaKenar = kısaKenar;
        }
    }

    public double getUzunKenar(){
        return uzunKenar;
    }
    public void setUzunKenar(double uzunKenar){
        if (uzunKenar > 0){
            this.uzunKenar = uzunKenar;
        }
    }

    public double AlanHesapla(){
        return kısaKenar * uzunKenar;
    }

    @Override
    public String toString() {
        return "Kısa kenar: " + kısaKenar + " Uzun kenar: " + uzunKenar + " Alan: " + AlanHesapla();
    }
}

