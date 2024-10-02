package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise29835 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < n/2; i++) {
            if (input[i] == input[n-1-i]) {
                continue;
            }

            if (input[i] > input[n-1-i]) {
                input[i] = input[n-1-i];
            } else {
                input[n-1-i] = input[i];
            }
            count++;
        }
        System.out.println(count);
        System.out.println(new String(input));
    }
}
