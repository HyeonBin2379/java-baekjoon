package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise22389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] leapCond = new int[n];
            for (int i = 0; i < n; i++) {
                leapCond[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;
            for (int i = l; i <= r; i++) {
                boolean checked = true;
                for (int j = 0; j < n; j++) {
                    if (i % leapCond[j] == 0) {
                        count += (j % 2 == 0) ? 1 : 0;
                        checked = false;
                        break;
                    }
                }
                if (checked) {
                    count += (n % 2 == 1) ? 0 : 1;
                }
            }
            System.out.println(count);
        }
    }
}
