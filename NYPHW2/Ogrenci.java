import java.util.ArrayList;
public class Ogrenci {
    int no;
    /*double vizeNotu;
    double finalNotu;
    double ortalama;*/// bunları ders sınıfına tasıdım
    String isim;
    ArrayList<Ders> dersler = new ArrayList<>(); // dersler için olusturduğum arraylist

    public Ogrenci(int no, String isim){
        this.no = no;
        this.isim = isim;
    }
    public void dersEkle(Ders ders){
        dersler.add(ders);

    }
    public double genelOrtalama(){
        if (dersler.isEmpty()) return 0;// dersler bos mu kontrolu
        double toplam = 0;
        for (Ders ders : dersler){
            toplam += ders.getOrtalama();
        }
        return toplam / dersler.size();
    }

    @Override
    public String toString() {
        String dersBilgileri = "";
        for (Ders ders : dersler){
            dersBilgileri += "\n  "+ ders.toString();
        }
        return "Numara: " + no + ", İsim: " + isim + ",Genel Ortalama: " + genelOrtalama() + dersBilgileri;
    }
}