package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise14456 {

    private static final int[][] mapping = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] round = new int[n][2];
        for (int i = 0; i < n; i++) {
            round[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(IntStream.rangeClosed(0, 5)
                .map(idx -> countWin(round, mapping[idx]))
                .reduce(0, Integer::max));
    }

    private static int countWin(int[][] round, int[] mapping) {
        int count = 0;
        for (int[] ints : round) {
            int cow1 = mapping[ints[0] - 1];
            int cow2 = mapping[ints[1] - 1];

            if ((cow1 == 1 && cow2 == 3) || // Hoof beats Scissors
                    (cow1 == 2 && cow2 == 1) || // Paper beats Hoof
                    (cow1 == 3 && cow2 == 2)) { // Scissors beats Paper
                count++;
            }
        }
        return count;
    }
}
