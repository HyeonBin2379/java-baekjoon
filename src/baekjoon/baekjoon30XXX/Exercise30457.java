package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise30457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            height[Integer.parseInt(st.nextToken())]++;
        }
        // 왼쪽, 오른쪽 중 한 곳만 바라볼 때, 같은 키의 학생은 최대 2명까지만 참여 가능
        // 같은 키의 학생이 2명을 초과하면 왼쪽/오른쪽 중 한 방향은 반드시 줄에 걸리게 됨
        System.out.println(Arrays.stream(height).map(h -> Math.min(h, 2)).sum());
    }
}
