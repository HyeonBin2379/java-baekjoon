package bakjoon.bakjoon6XXX;

import java.util.Arrays;

public class Exercise6679 {

    public static void main(String[] args) {
        for (int i = 1000; i < 10000; i++) {
            int[] result = new int[] {getDigitSum(i, 10), getDigitSum(i, 12), getDigitSum(i, 16)};
            if (isAllSame(result, result[0])) {
                System.out.println(i);
            }
        }
    }

    public static int getDigitSum(int num, int radix) {
        int[] digit = Arrays.stream(Integer.toString(num, radix).split(""))
                .mapToInt(value -> Integer.parseInt(value, radix))
                .toArray();
        return Arrays.stream(digit).sum();
    }

    public static boolean isAllSame(int[] sum, int val) {
        return Arrays.stream(sum).allMatch(value -> value == val);
    }
}
