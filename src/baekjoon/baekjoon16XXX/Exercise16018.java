package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] yesterday = br.readLine().toCharArray();
        char[] today = br.readLine().toCharArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (today[i] == 'C' && yesterday[i] == today[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
