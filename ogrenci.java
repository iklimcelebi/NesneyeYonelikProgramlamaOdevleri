public class ogrenci {
    int no;
    double vizeNotu;
    double finalNotu;
    double ortalama;
    String isim;

    public ogrenci(int no, double vizeNotu, double finalNotu, double ortalama, String isim){
        this.no = no;
        this.vizeNotu = vizeNotu;
        this.finalNotu = finalNotu;
        this.ortalama = OrtalamaHesapla();
        this.isim = isim;
    }
    public double OrtalamaHesapla(){
        this.ortalama = vizeNotu * 0.4 + finalNotu * 0.6;
        return this.ortalama;
    }

    @Override
    public String toString() {
        return "Numara: " + no + ", İsim: " + isim + ", Ortalama: " + OrtalamaHesapla();
    }
}