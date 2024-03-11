package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise17496 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int total = 0;
        while (n > t) {
            total += p*c;
            n -= t;
        }
        System.out.println(total);
    }
}
