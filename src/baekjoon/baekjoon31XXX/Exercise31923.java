package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise31923 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            while (a[i] != b[i]) {
                a[i] += p;
                b[i] += q;
                answer[i]++;
                if (answer[i] > 10000) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
        System.out.println(Arrays.stream(answer).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
