// 2.Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.


package seminar_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class program_2_2 {
    
    public static void main(String[] args)  throws IOException {
        Logger logger = Logger.getLogger(program_2_2.class.getName());
        FileHandler fh = new FileHandler("seminar_2/log_program_2_.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(sFormat);

        int[] arr = {1, 4, 9, 4, 8, 5, 5, 7, 3};
        int temp = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    logger.info(Arrays.toString(arr));
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
