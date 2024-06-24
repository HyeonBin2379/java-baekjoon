package bakjoon.bakjoon6XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise6502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int r = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if (4*r*r >= w*w + l*l) {
                sb.append(String.format("Pizza %d fits on the table.\n", ++count));
            } else {
                sb.append(String.format("Pizza %d does not fit on the table.\n", ++count));
            }
        }
        System.out.print(sb);
    }
}
