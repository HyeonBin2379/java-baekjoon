package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise12606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            String[] words = br.readLine().split(" ");
            for (int j = 0; j < words.length/2; j++) {
                String temp = words[j];
                words[j] = words[words.length-1-j];
                words[words.length-1-j] = temp;
            }
            sb.append(String.format("Case #%d: %s\n", i, String.join(" ", words)));
        }
        System.out.print(sb);
    }
}
