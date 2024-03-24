package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise25630 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int count = 0;

        for (int i = 0; i < len/2; i++) {
            if (input[i] != input[len-1-i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
