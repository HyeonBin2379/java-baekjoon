package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30045 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            if (input.contains("01") || input.contains("OI")) {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
