package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] level = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            if (level[i] < 250) {
                level[i] = 4;
            } else if (level[i] < 275) {
                level[i] = 3;
            } else if (level[i] < 300) {
                level[i] = 2;
            } else {
                level[i] = 1;
            }
        }
        Arrays.stream(level).forEach(value -> System.out.print(value + " "));
    }
}
