import java.util.Date;

public class FaturasizHat extends Hat {
    private double bakiye;
    public FaturasizHat(String numara, double bakiye) {
        super(numara);
        this.bakiye = bakiye;
    }


    @Override
    public void aramaYap(String arananNumara, int aramaSuresi) {
        double ucret = aramaSuresi * 0.05;

        if (bakiye >= ucret) {
            yapilanAramalar.add(new Konusma(getTelefonNumarasi(), arananNumara, aramaSuresi, new Date()));
            bakiye -= ucret;

        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
    @Override
    public void gelenArama(String arayanNumara, int aramaSuresi) {
        gelenAramalar.add(new Konusma(arayanNumara, getTelefonNumarasi(), aramaSuresi, new Date()));
    }


    @Override
    public String toString() {
        return "Numara: " + getTelefonNumarasi() +
                " | Bakiye: " + bakiye;
    }


}