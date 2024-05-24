package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;

public class Exercise12813 {

    private static Integer[] bin1, bin2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bin1 = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toArray(Integer[]::new);
        bin2 = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(makeResult((b1, b2) -> b1 == 1 && b2 == 1));
        System.out.println(makeResult((b1, b2) -> b1 == 1 || b2 == 1));
        System.out.println(makeResult((b1, b2) -> !b1.equals(b2)));
        System.out.println(makeResult((b1, b2) -> b1 == 0));
        System.out.println(makeResult((b1, b2) -> b2 == 0));
    }

    private static String makeResult(BiFunction<Integer, Integer, Boolean> func) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bin1.length; i++) {
            result.append(func.apply(bin1[i], bin2[i]) ? 1 : 0);
        }
        return result.toString();
    }
}
