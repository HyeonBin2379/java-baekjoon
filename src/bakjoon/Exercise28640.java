package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28640 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] domino1 = Arrays.stream(br.readLine().split("[|]", 2))
                .mapToInt(value -> value.isEmpty() ? 0 : value.length())
                .sorted()
                .toArray();
        int[] domino2 = Arrays.stream(br.readLine().split("[|]", 2))
                .mapToInt(value -> value.isEmpty() ? 0 : value.length())
                .sorted()
                .toArray();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (domino1[i] == domino2[j]) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}
