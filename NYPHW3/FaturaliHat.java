import java.util.Date;
public class FaturaliHat extends Hat {
    private int bedavaDakika;
    private double sabitFatura;
    private int kullanilanSure; // saniyesel
    private double ekUcret;

    public FaturaliHat(String numara, int bedavaDakika, double sabitFatura) {
        super(numara);
        this.bedavaDakika = bedavaDakika;
        this.sabitFatura = sabitFatura;
        this.kullanilanSure = 0;
        this.ekUcret = 0;
    }

    @Override
    public void aramaYap(String arananNumara, int aramaSuresi) {
        Konusma k = new Konusma(getTelefonNumarasi(), arananNumara, aramaSuresi, new Date());
        yapilanAramalar.add(k);

        int toplamBedava = bedavaDakika * 60;

        if (kullanilanSure < toplamBedava) {
            int kalan = toplamBedava - kullanilanSure;

            if (aramaSuresi <= kalan) {
                kullanilanSure += aramaSuresi;
            } else {
                kullanilanSure = toplamBedava;
                int fazla = aramaSuresi - kalan;
                ekUcret += Math.ceil(fazla / 60.0) * 2;
            }
        } else {
            ekUcret += Math.ceil(aramaSuresi / 60.0) * 2;
        }
    }

    @Override
    public void gelenArama(String arayanNumara, int aramaSuresi) {
        gelenAramalar.add(new Konusma(arayanNumara, getTelefonNumarasi(), aramaSuresi, new Date()));
    }

    public double faturaHesapla() {
        return sabitFatura + ekUcret;
    }

    @Override
    public String toString() {
        return "Numara: " + getTelefonNumarasi() +
                " | Fatura: " + faturaHesapla();
    }


}

