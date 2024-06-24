package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            char[] input = br.readLine().toCharArray();
            if (input[0] == '#') {
                break;
            }
            int answer = 0;
            for (int i = 1; i <= input.length; i++) {
                if (input[i-1] == ' ') {
                    answer += 0;
                } else {
                    answer += i*(input[i-1]-'A'+1);
                }
            }
            System.out.println(answer);
        }
    }
}
