package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2153 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int sum = 0;

        for (char c : input) {
            if (c >= 'a' && c <= 'z') {
                sum += (c - 'a') + 1;
            } else {
                sum += (c - 'A') + 27;
            }
        }

        for (int i = 2; i*i <= sum; i++) {
            if (sum % i == 0) {
                System.out.println("It is not a prime word.");
                return;
            }
        }
        System.out.println("It is a prime word.");
    }
}
