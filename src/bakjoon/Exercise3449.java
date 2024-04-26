package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3449 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] binary1 = br.readLine().toCharArray();
            char[] binary2 = br.readLine().toCharArray();

            int answer = 0;
            for (int j = 0; j < binary1.length; j++) {
                if (binary1[j] != binary2[j]) {
                    answer++;
                }
            }
            sb.append(String.format("Hamming distance is %d.\n", answer));
        }
        System.out.print(sb);
    }
}
