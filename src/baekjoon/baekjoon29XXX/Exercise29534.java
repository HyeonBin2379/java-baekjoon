package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise29534 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        if (n < s.length()) {
            System.out.println("Impossible");
            return;
        }
        System.out.println(s.chars().map(ch -> ch-'a'+1).sum());
    }
}
