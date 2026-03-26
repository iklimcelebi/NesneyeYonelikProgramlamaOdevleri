import java.util.Random;

public class Kaplumbaga extends Animal{
    private Random rand = new Random();
    public Kaplumbaga(int number){
        super("T", number);
    }

    @Override
    public void move(){
        int chance = rand.nextInt(100) + 1;
        if (chance <= 50){
            pozisyon += 3;

        }else if (chance <= 70){
            pozisyon -= 6;

        }else{
            pozisyon += 1;
        }
        if (pozisyon < 1) pozisyon = 1;


    }

}
