package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise18228 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] bridge = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int penguin = 0;
        for (int i = 0; i < n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
            if (bridge[i] == -1) {
                penguin = i;
            }
        }

        int leftMin = IntStream.rangeClosed(0, Math.max(0, penguin-1)).map(idx -> bridge[idx]).min().getAsInt();
        int rightMin = IntStream.rangeClosed(Math.min(n-1, penguin+1), n-1).map(idx -> bridge[idx]).min().getAsInt();
        System.out.println(leftMin + rightMin);
    }
}
