package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] mbti = br.readLine().split(" ");

            if (n >= 33) {
                System.out.println(0);
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        int count = 0;
                        for (int m = 0; m < 4; m++) {
                            count += mbti[j].charAt(m) != mbti[k].charAt(m) ? 1 : 0;
                            count += mbti[k].charAt(m) != mbti[l].charAt(m) ? 1 : 0;
                            count += mbti[l].charAt(m) != mbti[j].charAt(m) ? 1 : 0;
                        }
                        min = Math.min(count, min);
                        if (min == 0) {
                            break;
                        }
                    }
                }
            }
            System.out.println(min);
        }
    }
}
