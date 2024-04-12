package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27646 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            br.readLine();
            int n = Integer.parseInt(br.readLine());
            System.out.println(n-1);
            for (int j = 1; j < n; j++) {
                System.out.println(0 + " " + j);
            }
        }
    }
}
