package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise13670 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());

            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int time1 = h1*60+m1;
            int time2 = h2*60+m2;
            if (time1 > time2) {
                time2 += 1440;
            }
            System.out.println(time2-time1);
        }
    }
}
