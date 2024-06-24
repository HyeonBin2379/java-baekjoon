package bakjoon.bakjoon08XXX;

import java.io.*;

public class Exercise8371 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine().trim());
        char[] original = br.readLine().toCharArray();
        char[] dyslexia = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (original[i] != dyslexia[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
