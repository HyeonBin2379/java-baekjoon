package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Exercise14209 {

    private static final Map<Character, Integer> score = Map.of('A', 4, 'K', 3, 'Q', 2, 'J', 1, 'X', 0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = br.readLine().chars().map(ch -> score.get((char)ch)).sum();
            answer += sum;
        }
        System.out.println(answer);
    }
}
