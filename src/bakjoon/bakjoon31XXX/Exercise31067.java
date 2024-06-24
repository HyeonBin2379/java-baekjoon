package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise31067 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] track = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (track[i] <= track[i-1]) {
                track[i] += k;
                count++;
            }
        }
        System.out.println(isIncreasing(track) ? count : -1);
    }

    private static boolean isIncreasing(int[] track) {
        for (int i = 0; i < track.length-1; i++) {
            if (track[i] >= track[i+1]) {
                return false;
            }
        }
        return true;
    }
}
