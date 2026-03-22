import java.util.*;

public abstract class Hat {
    private String telefonNumarasi;
    protected List<Konusma> yapilanAramalar; //Aynı sınıf  erişir, Aynı paket erişir,inheritance erisir
    protected List<Konusma> gelenAramalar;

    public Hat(String telefonNumarasi) {//constr
        if (telefonNumarasi.length() != 10) {
            throw new IllegalArgumentException("Telefon numarası 10 haneli olmalı!");
        }
        this.telefonNumarasi = telefonNumarasi;
        this.yapilanAramalar = new ArrayList<>();
        this.gelenAramalar = new ArrayList<>();
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public abstract void aramaYap(String arananNumara, int aramaSuresi);
    public abstract void gelenArama(String arayanNumara, int aramaSuresi);

    public Konusma enUzunKonusma() {
        return Collections.max(
                new ArrayList<Konusma>() {{
                    addAll(yapilanAramalar);
                    addAll(gelenAramalar);
                }},
                Comparator.comparingInt(Konusma::getAramaSuresi)

        );
    }

    public ArrayList<String> aramaSikliginaGoreSirala() {
        Map<String, Integer> map = new HashMap<>();

        for (Konusma k : yapilanAramalar)//enchanteed
            map.put(k.getArananNumara(), map.getOrDefault(k.getArananNumara(), 0) + 1);
        for (Konusma k : gelenAramalar)
            map.put(k.getArayanNumara(), map.getOrDefault(k.getArayanNumara(), 0) + 1);


        List<Map.Entry<String, Integer>> liste = new ArrayList<>(map.entrySet());
        liste.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        ArrayList<String> sonuc = new ArrayList<>();
        for (Map.Entry<String, Integer> e : liste)
            sonuc.add(e.getKey());


        return sonuc;
    }

}
