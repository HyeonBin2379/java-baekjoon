package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise18964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int even = 0;
        while (st.hasMoreTokens()) {
            even += Integer.parseInt(st.nextToken()) % 2 == 0 ? 1 : 0;
        }

        if (even > len-even) {
            System.out.println("2 0");
        } else {
            System.out.println("2 1");
        }
    }
}
