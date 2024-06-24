package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < testCase; i++) {
            String skillChain = br.readLine();
            if (!skillChain.contains("CD")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
