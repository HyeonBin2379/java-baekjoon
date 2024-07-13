package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17201 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < input.length-2; i += 2) {
            if (input[i] != input[i+2]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
