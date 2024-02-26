package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean[] val = Arrays.stream(br.readLine().split(" "))
                .map(s -> !s.equals("0"))
                .toArray(Boolean[]::new);
        System.out.println(combination(val) ? 1 : 0);
    }

    public static boolean combination(Boolean[] val) {
        boolean result = false;
        for (int i = 0; i < 10; i++) {
            for (int j = i+1; j < 10; j++) {
                result ^= val[i] || val[j];
                for (int k = j+1; k < 10; k++) {
                    result ^= (val[i] || val[j] || val[k]);
                }
            }
        }
        return result;
    }
}
