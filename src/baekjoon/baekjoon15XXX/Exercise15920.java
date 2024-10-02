package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15920 {

    private static final int[] rail = {5, 1, 6};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int wait = 0, state = 0;
        for (int i = 0; i < n; i++) {
            switch (input[i]) {
                case 'P' -> {
                    state ^= 1;
                    if (wait == 1) {
                        state = 2;
                    }
                }
                case 'W' -> {
                    if (++wait == 2) {
                        System.out.println(rail[state]);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
