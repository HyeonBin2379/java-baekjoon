package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise4998 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            double n = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double m = Double.parseDouble(st.nextToken());

            int year = 0;
            while (n <= m) {
                n *= (100+b)/100;
                year++;
            }
            sb.append(year).append("\n");
        }
        System.out.print(sb);
    }
}
