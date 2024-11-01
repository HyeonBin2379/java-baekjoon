package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise20438 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 출석 못한 학생 추려내기
        boolean[] isAttended = new boolean[n+3];
        List<Integer> sleep = Arrays.stream(br.readLine().split(" ", k)).map(Integer::parseInt).collect(Collectors.toList());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (sleep.contains(now) || isAttended[now]) {
                continue;
            }
            IntStream.range(now, n+3)
                    .filter(index -> index % now == 0 && !sleep.contains(index))
                    .forEach(index -> isAttended[index] = true);
        }

        // 누적합을 활용하여 주어진 구간에서 출석 못한 학생 수 구하기
        int[] attendedCount = new int[n+3];
        IntStream.range(3, n+3)
                .forEach(index -> attendedCount[index] = attendedCount[index-1] + (!isAttended[index] ? 1 : 0));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(attendedCount[end]-attendedCount[start-1]);
        }
    }
}
