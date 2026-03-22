import java.util.Date;
public class Konusma implements Comparable<Konusma> {
    private String arayanNumara;
    private String arananNumara;
    private int aramaSuresi;

    public Konusma(String arayanNumara, String arananNumara, int aramaSuresi, Date tarih) {//constructor
        this.arayanNumara = arayanNumara;
        this.arananNumara = arananNumara;
        this.aramaSuresi = aramaSuresi;

    }
    public String getArayanNumara() {//getters
        return arayanNumara;
    }
    public String getArananNumara() {
        return arananNumara;
    }


    public int getAramaSuresi() {
        return aramaSuresi;

    }


    @Override
    public String toString() {
        return "Arayan: " + arayanNumara +
                ", Aranan: " + arananNumara +
                ", Süre: " + aramaSuresi + " sn";
    }

    @Override//karsılastır
    public int compareTo(Konusma other) {
        return Integer.compare(this.aramaSuresi, other.aramaSuresi);

    }
}



