package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16462 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int score = 0;
        for (int i = 0; i < n; i++) {
             score += Math.min(Integer.parseInt(br.readLine().replaceAll("[069]", "9")), 100);
        }
        System.out.println(Math.round((double) score / n));
    }
}
