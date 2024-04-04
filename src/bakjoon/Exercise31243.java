package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise31243 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] timeDiff = new int[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            if (start > end) {
                end += 1440;
            }
            timeDiff[i] = end-start;
        }
        int min = Arrays.stream(timeDiff).min().getAsInt();
        int max = Arrays.stream(timeDiff).max().getAsInt();
        System.out.printf("%d:%02d\n", min/60, min%60);
        System.out.printf("%d:%02d\n", max/60, max%60);
    }
}
