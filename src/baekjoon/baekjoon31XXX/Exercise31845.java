package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise31845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 점수에 따라 오름차순 정렬: 최댓값을 더하고 최솟값을 딜러에게
        Deque<Integer> score = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int answer = 0;
        // 모든 카드가 없어지거나 주어진 턴 수를 채우면 종료
        while (!score.isEmpty() && m-- > 0) {
            // 최댓값이 음수 -> 음수만 있으므로 더미카드만 주고받아 이후 턴이 의미없음
            if (score.getLast() <= 0) {
                break;
            }
            // 최댓값이 양수 -> 플레이어 점수에 추가 후 덱에서 제거
            answer += score.removeLast();
            // 최솟값이 존재하는 경우 딜러에게
            if (!score.isEmpty()) {
                score.removeFirst();
            }
        }
        System.out.println(answer);
    }
}
