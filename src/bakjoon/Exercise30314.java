package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30314 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        char[] lastWinner = br.readLine().toCharArray();
        char[] me = br.readLine().toCharArray();

        int total = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(lastWinner[i]-me[i]);
            total += Math.min(26-diff, diff);
        }
        System.out.println(total);
    }
}
