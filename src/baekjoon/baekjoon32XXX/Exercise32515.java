package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32515 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] base1 = br.readLine().toCharArray();
        char[] key1 = br.readLine().toCharArray();

        char[] base2 = br.readLine().toCharArray();
        char[] key2 = br.readLine().toCharArray();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (base1[i] == base2[i]) {
                if (key1[i] != key2[i]) {
                    System.out.println("htg!");
                    return;
                }
                answer.append(key1[i]);
            }
        }
        System.out.println(answer);
    }
}
