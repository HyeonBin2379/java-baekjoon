package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24938 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        long avg = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            avg += arr[i];
        }
        avg /= n;

        long answer = 0;
        for (int i = 0; i < n-1; i++) {
            long diff = Math.abs(arr[i]-avg);
            arr[i+1] = (arr[i] > avg) ? arr[i+1]+diff : arr[i+1]-diff;
            answer += diff;
        }
        System.out.println(answer);
    }
}
