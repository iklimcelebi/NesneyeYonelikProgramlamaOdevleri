import java.util.ArrayList;

public class Operator {
    private ArrayList<Hat> hatlar;
    public Operator() {
        hatlar = new ArrayList<>();
    }
    public void hatEkle(Hat h) {
        hatlar.add(h);
    }
    public Hat hatBul(String numara) { //iptal
        for (Hat h : hatlar)
            if (h.getTelefonNumarasi().equals(numara))
                return h;
        return null;
    }
}