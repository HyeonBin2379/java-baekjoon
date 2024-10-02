package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("? " + names[i]);
            int answer = Integer.parseInt(br.readLine());
            if (answer == 1) {
                System.out.println("! " + names[i]);
                break;
            }

            System.out.println("? " + names[i]);
            answer = Integer.parseInt(br.readLine());
            if (answer == 1) {
                System.out.println("! " + names[i]);
                break;
            }
        }
    }
}
