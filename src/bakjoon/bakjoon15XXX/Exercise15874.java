package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        String input = br.readLine();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char newChar = input.charAt(i);
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                newChar = (char) ((newChar+k-'a') % 26 + 'a');
            } else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                newChar = (char) ((newChar+k-'A') % 26 + 'A');
            }
            answer.append(newChar);
        }
        System.out.println(answer);
    }
}
