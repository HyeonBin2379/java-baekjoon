package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int odd = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 1) {
                odd++;
            }
        }
        if (odd == (int)Math.ceil((double) len/2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
