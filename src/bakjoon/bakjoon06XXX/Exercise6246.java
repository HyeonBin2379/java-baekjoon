package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise6246 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        boolean[] slot = new boolean[n+1];
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int gap = Integer.parseInt(st.nextToken());
            for (int i = start; i <= n; i += gap) {
                slot[i] = true;
            }
        }
        System.out.println(IntStream.rangeClosed(1, n).filter(i -> !slot[i]).count());
    }
}
