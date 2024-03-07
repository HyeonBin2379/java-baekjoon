package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] cmd = Arrays.stream(br.readLine().split(" ", c)).mapToInt(Integer::parseInt).toArray();
        int[] spot = new int[n];
        int pos = 0;

        spot[0] = 1;
        for (int i = 0; i < c; i++) {
            pos = (cmd[i] == 1) ? pos+1 : pos-1;
            if (pos < 0 || pos >= n) {
                pos = (pos + n) % n;
            }
            spot[pos]++;
        }
        System.out.println(spot[s-1]);
    }
}
