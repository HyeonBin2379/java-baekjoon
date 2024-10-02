package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21167 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int r = Integer.parseInt(st.nextToken());
            double s = Double.parseDouble(st.nextToken());
            long v = Math.round(Math.sqrt(r*(s+0.16)/0.067));
            System.out.println(v);
        }
    }
}
