package seminar_1;

import java.util.Random;
import java.util.Scanner;

public class program_1_1 {
    public static int getnumb(int x) {
        if (x == 1 ) {
            return 1;
        }
        return x + getnumb(x - 1);
    }
    public static void main(String[] args) {
        //int a = new Random().nextInt(0, 100);
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите номер треугольного числа");
        int a = Integer.parseInt(iScanner.nextLine());
        System.out.printf("Треугольное число номер %d равно %d.", a, getnumb(a));

        iScanner.close();
    }
}
