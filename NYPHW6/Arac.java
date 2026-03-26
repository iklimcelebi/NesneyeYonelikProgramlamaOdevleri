/*
Araç sınıfında, bu sınıfta aracın plaka numarası ve sahibinin adı ölmalıdır. Ayrıca ilgili
cönstructör’ı da öluşturunuz.
 */


public class Arac {
    private String plaka;
    private String aracSahibi;

    public Arac(String plaka, String aracSahibi){//contructor

        this.plaka = plaka;
        this.aracSahibi = aracSahibi;
    }
    public String getAracSahibi(){
        return aracSahibi;
    }
    public String getPlaka(){
        return plaka;
    }
    @Override
    public String toString() {
        return "Plaka: " + plaka + ", Sahibi: " + aracSahibi;

    }
}
