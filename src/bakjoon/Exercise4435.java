package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4435 {
    private static final int[] gandalf = {1, 2, 3, 3, 4, 10};
    private static final int[] sauron = {1, 2, 2, 2, 3, 5, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int battle = Integer.parseInt(br.readLine());

        for (int i = 1; i <= battle; i++) {
            int good = getScore(br.readLine());
            int evil = getScore(br.readLine());
            sb.append(String.format("Battle %d: ", i));
            if (good > evil) {
                sb.append("Good triumphs over Evil\n");
            } else if (good == evil) {
                sb.append("No victor on this battle field\n");
            } else {
                sb.append("Evil eradicates all trace of Good\n");
            }
        }
        System.out.print(sb);
    }

    public static int getScore(String data) {
        int[] army = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < army.length; i++) {
            sum += (army.length == 6) ? army[i]*gandalf[i] : army[i]*sauron[i];
        }
        return sum;
    }
}
