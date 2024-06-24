package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int total = input[0] == 'O' ? 1 : 0;
        int bonus = input[0] == 'O' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (input[i] == 'O') {
                total += (i+1 + bonus);
                bonus++;
            } else {
                bonus = 0;
            }
        }
        System.out.println(total);
    }
}
