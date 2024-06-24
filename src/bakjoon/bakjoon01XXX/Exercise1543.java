package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();
        br.close();

        int count = 0;
        while (document.contains(word)) {
            document = document.replaceFirst(word, " ");
            count++;
        }
        System.out.println(count);
    }
}
