package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5426 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] input = br.readLine().toCharArray();
            int size = (int)Math.sqrt(input.length);

            char[][] encoding = new char[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    encoding[k][size-1-j] = input[j*size+k];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                sb.append(new String(encoding[j]));
            }
            System.out.println(sb.reverse());
        }
    }
}
