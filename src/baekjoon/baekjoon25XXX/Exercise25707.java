package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25707 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] beads = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        // 1. 구슬 2개를 연결하는 실의 길이는 구슬에 적인 숫자의 (최대값-최소값) 이상
        // 2. 팔찌를 만들기 위해서는 1바퀴 돌아야 하므로 1.의 반대방향으로 진행하며, 이때의 길이는 (최대-최소)
        // 3. 따라서 2*(최대-최소)가 정답
        System.out.println(2*Math.abs(beads[n-1]-beads[0]));
    }
}
