package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise28967 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c = br.readLine();
        String newString = br.readLine();

        int answer = 0;
        int index = 0;
        for (int i = 0; i < newString.length(); i++) {
            if (newString.charAt(i) == c.charAt(index)) {
                index++;
                if (index == c.length()) {
                    answer++;
                    index = 0;
                }
            }
        }
        System.out.println(answer);
    }
}
