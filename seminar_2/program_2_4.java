// 4*. Реализуйте простой калькулятор, с консольным интерфейсом.
// К калькулятору добавить логирование.


package seminar_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

import javax.naming.spi.DirStateFactory.Result;

public class program_2_4 {
    private static String messages (int x) {
        System.out.println("Выбирете желаемое действие:\n 1 - Сумма двух чисел\n 2 - Разность двух чисел\n 3 - Произведение двух чисел\n 4 - Производное двух чисел");
        Scanner iScanner = new Scanner(System.in);
        int action = Integer.parseInt(iScanner.nextLine());
        if (action > 4 || action <= 0) {
            return messages(0);
        }
        return doit(action);
    }
    private static String doit (int x) {
        String result = "";
        if (x == 1) result += sum(0);
        else if (x == 2) result += substr(0);
        else if (x == 3) result += multi(0);
        else if ( x == 4) result += divis(0);
        return result;
    }


    private static double sum (int x) {
        System.out.println("Введите первое число");
        Scanner iScanner = new Scanner(System.in);
        double first = Double.parseDouble(iScanner.nextLine());
        System.out.print("+");
        double second = Double.parseDouble(iScanner.nextLine());
        iScanner.close();
        return first + second;
    }
    
    private static double substr (int x) {
        System.out.println("Введите первое число");
        Scanner iScanner = new Scanner(System.in);
        double first = Double.parseDouble(iScanner.nextLine());
        System.out.print("-");
        double second = Double.parseDouble(iScanner.nextLine());
        iScanner.close();
        return first - second;
    }

    private static double multi (int x) {
        System.out.println("Введите первое число");
        Scanner iScanner = new Scanner(System.in);
        double first = Double.parseDouble(iScanner.nextLine());
        System.out.print("*");
        double second = Double.parseDouble(iScanner.nextLine());
        iScanner.close();
        return first * second;
    }

    private static double divis (int x) {
        System.out.println("Введите первое число");
        Scanner iScanner = new Scanner(System.in);
        double first = Double.parseDouble(iScanner.nextLine());
        System.out.print("/");
        double second = Double.parseDouble(iScanner.nextLine());
        iScanner.close();
        return first / second;
    }
        
    public static void main(String[] args)  throws IOException {
        Logger logger = Logger.getLogger(program_2_4.class.getName());
        FileHandler fh = new FileHandler("seminar_2/log_program_4_.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(sFormat);
        // System.out.println(messages(0));
        logger.info(messages(0));


    }
}
