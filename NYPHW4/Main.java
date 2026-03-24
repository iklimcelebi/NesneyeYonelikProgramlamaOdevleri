import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sayi = scanner.nextInt();
        if (sayi >= 10000 && sayi <= 99999){
            int birincibas = sayi / 10000;
            int ikincibas = (sayi % 10000) / 1000;
            int dorduncubas = (sayi % 100) / 10;
            int besincibas = (sayi % 10);

            if (birincibas == besincibas && ikincibas == dorduncubas){
                System.out.println(sayi +" sayisi polindormdur");
            }else{
                System.out.println(sayi +" sayisi polindrom değildir.");
            }
        }else{
            System.out.println("5 basamaklı sayi girmediniz!!!");
        }
        scanner.close();
    }
}