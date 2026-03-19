public class Ders {
    String dersAdi;
    double vizeNotu;
    double finalNotu;

    double ortalama;
    public Ders(String dersAdi, double vizeNotu, double finalNotu) { // parametrelerle beraber ders sınıfı

        this.dersAdi = dersAdi;
        this.vizeNotu = vizeNotu;
        this.finalNotu = finalNotu;
        this.ortalama = vizeNotu * 0.4 + finalNotu * 0.6;
    }
    public double getOrtalama(){
        return ortalama;
    }

    @Override
    public String toString(){
        return "Ders: " +dersAdi + "Vize notu: " +vizeNotu + "Final notu: " +finalNotu + "Ortalama: " + ortalama;
    }// geri dondürülecek mesaji veren tostring methodu

}
