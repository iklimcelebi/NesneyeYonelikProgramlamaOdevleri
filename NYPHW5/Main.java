import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kısa kenar:");
        double kısaKenar = scanner.nextDouble();

        System.out.println("Uzun kenar:");
        double uzunKenar = scanner.nextDouble();

        try {
            Rectangle rectangle = new Rectangle(kısaKenar, uzunKenar); // obje oluşturuldu rectangle sınıfın içindeji methodlara erişir
            System.out.println(rectangle);
        } catch (IllegalArgumentException e){
            System.out.println("Hata:" + e.getMessage());
        }
        scanner.close();
    }
}