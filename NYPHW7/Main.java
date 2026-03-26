import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal tavsan = new Tavsan(2);
        Animal kaplumbaga = new Kaplumbaga(1);

        System.out.println("Yarıs uzunlugu ne kadar?: ");
        final int finishLine = scanner.nextInt();

        System.out.println("BANG!!");
        System.out.println("Ve yaris basladı!");

        while (kaplumbaga.getPozisyon()< finishLine && tavsan.getPozisyon()< finishLine){
            kaplumbaga.move();
            tavsan.move();

            printTrack(kaplumbaga.getPozisyon(),tavsan.getPozisyon());

/*
            try{
                Tread.sleep(300);

            }catch (InterruptedException e){
                e.printStackTrace();
            } */
        }
        if (kaplumbaga.getPozisyon() >= finishLine && tavsan.pozisyon >= finishLine ){
            System.out.println("Berabere bitti");
        }else if (kaplumbaga.getPozisyon() >= finishLine){
            System.out.println("Kaplumbaga kazandı!!! YAY!");
        }else{
            System.out.println("Tavsan kazandı. YUCH!!!");
        }
    }
    private static void printTrack(int KaplumbagaPos, int TavsanPos){
        for (int i = 1; i <= 100 ; i++){
            if(i == KaplumbagaPos && i == TavsanPos){
                System.out.println("OUCH!!");
                i += 4;
            }else if (i == KaplumbagaPos){
                System.out.println("K");
            }else if(i == TavsanPos){
                System.out.println("T");
            }else{
                System.out.println("_");

            }
            System.out.println();

        }
    }
}