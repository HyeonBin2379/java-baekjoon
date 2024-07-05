package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercise3213 {

    private static final String[] fraction = {"1/4", "1/2", "3/4"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> pieces = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String fraction = br.readLine();
            pieces.put(fraction, pieces.getOrDefault(fraction, 0)+1);
        }

        int[] pizzaCnt = Arrays.stream(fraction)
                .mapToInt(f -> pieces.getOrDefault(f, 0))
                .toArray();
        int answer = pizzaCnt[2] + (pizzaCnt[1]/2);
        pizzaCnt[0] = Math.max(0, pizzaCnt[0]-pizzaCnt[2]);
        if (pizzaCnt[1] % 2 == 1) {
            answer++;
            pizzaCnt[0] = Math.max(0, pizzaCnt[0]-2);
        }
        answer += (pizzaCnt[0] + 3) / 4;
        System.out.println(answer);
    }
}
