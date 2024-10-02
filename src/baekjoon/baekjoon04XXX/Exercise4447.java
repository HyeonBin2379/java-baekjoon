package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            int g = 0, b = 0;
            for (int j = 0; j < name.length(); j++) {
                if (name.toLowerCase().charAt(j) == 'g') {
                    g++;
                } else if (name.toLowerCase().charAt(j) == 'b') {
                    b++;
                }
            }
            if (g > b) {
                sb.append(String.format("%s is GOOD\n", name));
            } else if (g < b) {
                sb.append(String.format("%s is A BADDY\n", name));
            } else {
                sb.append(String.format("%s is NEUTRAL\n", name));
            }
        }
        System.out.print(sb);
    }
}
