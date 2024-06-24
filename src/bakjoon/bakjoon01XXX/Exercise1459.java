package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1459 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long onlyS = (x+y)*w;
        long onlyD = ((x+y) % 2 == 0) ? Math.max(x, y)*s : Math.max(x-1, y-1)*s+w;
        long comb = Math.min(x, y)*s + Math.abs(x-y)*w;
        System.out.println(Math.min(onlyS, Math.min(onlyD, comb)));
    }
}
