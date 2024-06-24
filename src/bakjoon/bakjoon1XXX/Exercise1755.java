package bakjoon.bakjoon1XXX;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise1755 {

    private static final Map<Integer, String> digit = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        setDigitStr();

        Map<String, Integer> result = new TreeMap<>();
        for (int i = m; i <= n; i++) {
            String[] digitNum = Arrays.stream(Integer.toString(i).split(""))
                    .map(Integer::parseInt)
                    .map(digit::get)
                    .toArray(String[]::new);
            result.put(String.join("", digitNum), i);
        }

        int count = 1;
        for (Integer num : result.values()) {
            System.out.print(num + " ");
            if (count % 10 == 0) {
                System.out.println();
            }
            count++;
        }
    }

    private static void setDigitStr() {
        digit.put(0, "zero");
        digit.put(1, "one");
        digit.put(2, "two");
        digit.put(3, "three");
        digit.put(4, "four");
        digit.put(5, "five");
        digit.put(6, "six");
        digit.put(7, "seven");
        digit.put(8, "eight");
        digit.put(9, "nine");
    }
}
