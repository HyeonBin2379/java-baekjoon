package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < len; i++) {
            if (input[i] != '?') {
                continue;
            }
            input[i] = (input[len-1-i] == '?') ? 'a' : input[len-1-i];
        }
        System.out.println(new String(input));
    }
}