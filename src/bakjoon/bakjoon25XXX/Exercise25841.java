package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (w-2*d <= 0 || h-2*d <= 0) {
            System.out.println(0);
        } else {
            System.out.println((w-2*d)*(h-2*d));
        }
    }
}
