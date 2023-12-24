package bakjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Exercise2576 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int[] number = new int[7];
        for (int i = 0; i < number.length; i++) {
            number[i] = sc.nextInt();
            if (number[i] % 2 == 1) {
                sum += number[i];
            }
        }

        OptionalInt result = Arrays.stream(number).filter(value -> value % 2 == 1).min();
        Arrays.sort(number);
        if (result.isPresent()) {
            System.out.println(sum);
        }
        System.out.println((result.isPresent()) ? result.getAsInt() : -1);
    }
}
