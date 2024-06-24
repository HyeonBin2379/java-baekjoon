package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise28960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double h = Double.parseDouble(st.nextToken());
        double l = Double.parseDouble(st.nextToken());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        if ((h >= a/2 && l >= b) || (h >= b/2 && l >= a)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
