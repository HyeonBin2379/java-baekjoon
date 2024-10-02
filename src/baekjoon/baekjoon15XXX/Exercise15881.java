package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15881 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (input.startsWith("pPAp", i)) {
                i += 3;
                count++;
            }
        }
        System.out.println(count);
    }
}
