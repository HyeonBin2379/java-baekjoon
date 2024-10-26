package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise30619 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] personByRoom = new int[n];    // 집 번호별 사람 번호에 임의 접근하기 위해 사용
        int[] roomByPerson = new int[n];    // 각 사람별 집 번호에 임의 접근하기 위해 사용
        for (int i = 0; i < n; i++) {
            personByRoom[i] = Integer.parseInt(st.nextToken())-1; // 사람들을 집에 배정
            roomByPerson[personByRoom[i]] = i;               // 사람마다 입주한 집 번호 저장
        }

        int m = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        while (m-- > 0) {
            queue.clear();
            // 사람 번호의 범위 설정
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;
            // 지정한 범위 이내의 사람 번호를 역순으로 저장
            for (int i = right; i >= left; i--) {
                queue.offer(i);
            }

            // 감면되는 세금의 총합이 최대가 되도록 사람들을 재배치
            int[] relocated = roomByPerson.clone();
            int[] sortResult = personByRoom.clone();    // 각 집마다 사람들을 재배치한 결과 저장

            // 범위 내에 속한 사람 번호의 최대값이 그에 대응되는 집 번호 중 최대값과 매칭되는 식으로 스왑해야 함
            for (int i = n-1; i >= 0; i--) {
                if ((!queue.isEmpty() && queue.peek() > sortResult[i]) && (sortResult[i] >= left && sortResult[i] <= right)) {
                    // 사람 번호 스왑
                    int change = sortResult[i];
                    sortResult[i] = queue.poll();
                    sortResult[relocated[sortResult[i]]] = change;

                    // 집 번호 스왑
                    relocated[change] = relocated[sortResult[i]];
                    relocated[sortResult[i]] = i;
                } else if (!queue.isEmpty() && queue.peek() == sortResult[i]) {
                    queue.poll();
                }
            }
            String result = Arrays.stream(sortResult)
                    .mapToObj(value -> Integer.toString(value+1))
                    .collect(Collectors.joining(" "));
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
