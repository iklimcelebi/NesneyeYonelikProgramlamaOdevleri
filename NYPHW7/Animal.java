public abstract class Animal {
    protected String hayvan;
    protected int number;
    protected int pozisyon;

    public Animal(String hayvan, int number){
        this.hayvan = hayvan;
        this.number = number;
        this.pozisyon = 1;

    }
    public abstract void move ();

    public int getPozisyon(){
        return pozisyon;
    }

    public int getNumber() {
        return number;
    }

    public java.lang.String getHayvan() {
        return hayvan;
    }
}
