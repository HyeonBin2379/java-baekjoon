package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9771 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String text;
        int count = 0;
        while ((text = br.readLine()) != null) {
            String[] tokens = text.split(" ");
            for (String token : tokens) {
                if (token.equals(word) || token.contains(word)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
