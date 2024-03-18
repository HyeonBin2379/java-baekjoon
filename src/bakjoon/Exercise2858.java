package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2858 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int area = r + b;
        for (int i = 1; i*i <= area; i++) {
            if (area % i == 0) {
                if ((i + area/i)*2-4 == r) {
                    System.out.println(Math.max(i, area/i) + " " + Math.min(i, area/i));
                    return;
                }
            }
        }
    }
}
