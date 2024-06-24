package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] difficulty = new int[n];
        for (int i = 0; i < n; i++) {
            difficulty[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n-1; i > 0; i--) {
            if (difficulty[i] <= difficulty[i-1]) {
                count += difficulty[i-1] - difficulty[i] + 1;
                difficulty[i-1] = difficulty[i]-1;
            }
        }
        System.out.println(count);
    }
}
