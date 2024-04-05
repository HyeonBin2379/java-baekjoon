package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise24084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        for (int i = 1; i < len; i++) {
            if (input[i] == 'J') {
                System.out.println(input[i-1]);
            }
        }
    }
}
