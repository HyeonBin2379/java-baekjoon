package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15734 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int total = l+r+a;
        int diff;
        if (l < r) {
            diff = Math.min(r - l, a);
            l += diff;
        } else {
            diff = Math.min(l - r, a);
            r += diff;
        }
        a -= diff;
        System.out.println(l != r ? total - Math.abs(r-l) : total - (a % 2));
    }
}
