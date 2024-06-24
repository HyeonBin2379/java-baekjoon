package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2703 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            char[] input = br.readLine().toCharArray();
            char[] code = br.readLine().toCharArray();

            StringBuilder result = new StringBuilder();
            for (char c : input) {
                if (c != ' ') {
                    result.append(code[c - 'A']);
                } else {
                    result.append(c);
                }
            }
            System.out.println(result);
        }
    }
}
