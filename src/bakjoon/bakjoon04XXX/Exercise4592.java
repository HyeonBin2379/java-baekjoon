package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise4592 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int[] guess = new int[n];
            for (int i = 0; i < n; i++) {
                guess[i] = Integer.parseInt(st.nextToken());
            }

            System.out.print(guess[0] + " ");
            for (int i = 1; i < n; i++) {
                if (guess[i-1] != guess[i]) {
                    System.out.print(guess[i] + " ");
                }
            }
            System.out.println("$");
        }
    }
}
