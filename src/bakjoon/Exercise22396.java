package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise22396 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            int r0 = Integer.parseInt(st.nextToken());
            int w0 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int answer = 0;
            while (true) {
                double y = (double)(r0+answer*r)/c-w0;
                if (Double.compare(y, 0.0) >= 0) {
                    break;
                }
                answer++;
            }
            System.out.println(answer);
        }
    }
}
