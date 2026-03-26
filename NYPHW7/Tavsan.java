import java.util.Random;

public class Tavsan extends Animal{
    private Random rand = new Random();
    public Tavsan(int number){
        super("H", number);
    }

    @Override
    public void move(){
        int chance = rand.nextInt(100) + 1;
        if (chance <= 20){

        }else if (chance <= 40){
            pozisyon += 9;

        }else if (chance <= 50){
            pozisyon -= 12;

        }else if (chance <= 80){
            pozisyon += 1;

        }else{
            pozisyon -= 2;
        }
        if (pozisyon < 1) pozisyon = 1;


    }

}
