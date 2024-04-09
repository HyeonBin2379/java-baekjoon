package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise12866 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String input = br.readLine();
        long[] acgt = new long[4];
        for (int i = 0; i < l; i++) {
            switch (input.charAt(i)) {
                case 'A' -> acgt[0]++;
                case 'C' -> acgt[1]++;
                case 'G' -> acgt[2]++;
                case 'T' -> acgt[3]++;
            }
        }

        long answer = 1;
        for (int i = 0; i < 4; i++) {
            answer *= acgt[i];
            answer %= MOD;
        }
        System.out.println(answer);
    }
}
