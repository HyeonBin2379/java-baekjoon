package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] blueray = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();

        int start = Arrays.stream(blueray).reduce(0, Integer::max);
        int end = Arrays.stream(blueray).sum();
        int answer = 0;
        while (start <= end) {
            int mid = (start+end)/2;

            int total = 0;
            int count = 1;
            for (int time : blueray) {
                if (total + time > mid) {
                    count++;
                    total = 0;
                }
                total += time;
            }

            if (count <= m) {
                answer = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
}
