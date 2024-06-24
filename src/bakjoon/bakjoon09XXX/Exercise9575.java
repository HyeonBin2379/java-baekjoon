package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Exercise9575 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            Set<Integer> result = new TreeSet<>();
            int n = Integer.parseInt(br.readLine());
            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .distinct()
                    .toArray();
            int m = Integer.parseInt(br.readLine());
            int[] b = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .distinct()
                    .toArray();
            int k = Integer.parseInt(br.readLine());
            int[] c = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .distinct()
                    .toArray();

            for (int value : a) {
                for (int i : b) {
                    for (int j : c) {
                        int sum = value + i + j;
                        if (containOnlyFiveAndEight(sum)) {
                            result.add(sum);
                        }
                    }
                }
            }
            System.out.println(result.size());
        }
    }

    private static boolean containOnlyFiveAndEight(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit != 5 && digit != 8) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}