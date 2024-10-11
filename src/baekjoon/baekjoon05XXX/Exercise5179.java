package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Exercise5179 {

    private static class Player implements Comparable<Player>{
        int id, solvedProblems, penalty;

        public Player(int id) {
            this.id = id;
            this.solvedProblems = 0;
            this.penalty = 0;
        }

        @Override
        public int compareTo(Player o) {
            return this.solvedProblems != o.solvedProblems
                    ? Integer.compare(o.solvedProblems, this.solvedProblems)
                    : Integer.compare(this.penalty, o.penalty);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 수

        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 문제 수
            int N = Integer.parseInt(st.nextToken()); // 제출 수
            int P = Integer.parseInt(st.nextToken()); // 참가자 수

            List<Player> result = new ArrayList<>();
            Map<Integer, Map<String, Integer>> wrongAttempts = new HashMap<>();
            Map<Integer, Map<String, Integer>> solvedTime = new HashMap<>();
            IntStream.rangeClosed(1, P).forEach(num -> {
                result.add(new Player(num));
                wrongAttempts.put(num, new HashMap<>());
                solvedTime.put(num, new HashMap<>());
            });

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int playerId = Integer.parseInt(st.nextToken());
                String problem = st.nextToken();
                int time = Integer.parseInt(st.nextToken());
                int isCorrect = Integer.parseInt(st.nextToken());

                if (isCorrect == 1) {
                    if (!solvedTime.get(playerId).containsKey(problem)) {
                        int wrongCount = wrongAttempts.get(playerId).getOrDefault(problem, 0);
                        result.get(playerId-1).solvedProblems++;
                        result.get(playerId-1).penalty += time + wrongCount * 20;
                    }
                    solvedTime.get(playerId).merge(problem, time, Integer::min);
                } else {
                    wrongAttempts.get(playerId).merge(problem, 1, Integer::sum);
                }
            }
            Collections.sort(result);

            sb.append(String.format("Data Set %d:\n", k));
            result.forEach(player -> sb.append(String.format("%d %d %d\n", player.id, player.solvedProblems, player.penalty)));
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}