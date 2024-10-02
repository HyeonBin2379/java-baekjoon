package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String answer = br.readLine();

        if (a.contains(answer) || b.contains(answer)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
