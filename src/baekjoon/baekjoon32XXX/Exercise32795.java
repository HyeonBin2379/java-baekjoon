package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String fullName = br.readLine();
            String[] abbr = br.readLine().split("");

            String answer = "YES";
            for (String letter : abbr) {
                if (!fullName.contains(letter)) {
                    answer = "NO";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
