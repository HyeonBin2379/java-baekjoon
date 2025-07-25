package algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int combo = 0;
        int count = 0;
        for (int i = 1; i < m-1;) {
            if (!s.startsWith("OI", i)) {
                combo = 0;
                i += 1;
                continue;
            }

            if (++combo == n) {
                if (s.charAt(i-2*combo+1) == 'I') {
                    count++;
                }
                combo--;
            }
            i += 2;
        }
        System.out.println(count);
    }
}
