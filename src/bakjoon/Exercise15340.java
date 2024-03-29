package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15340 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int answer = Math.min(Math.min(c*30+d*40, c*35+d*30), c*40+20*d);
            System.out.println(answer);
        }
    }
}
