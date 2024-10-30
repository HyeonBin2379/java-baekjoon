package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise10981 {

    private static class Team implements Comparable<Team> {
        String name;
        int solved;
        int penalty;

        public Team(String name, int solved, int penalty) {
            this.name = name;
            this.solved = solved;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Team o) {
            return this.solved != o.solved
                    ? Integer.compare(o.solved, this.solved)
                    : Integer.compare(this.penalty, o.penalty);
        }

        @Override
        public String toString() {
            return "Team{" +
                    "name='" + name + '\'' +
                    ", solved=" + solved +
                    ", penalty=" + penalty +
                    '}';
        }
    }

    private static final Map<String, PriorityQueue<Team>> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String university = st.nextToken();
            String teamName = st.nextToken();
            int solved = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());
            result.putIfAbsent(university, new PriorityQueue<>());
            result.get(university).add(new Team(teamName, solved, penalty));
        }
        List<Team> worldFinal = new ArrayList<>();
        for (String university : result.keySet()) {
            worldFinal.add(result.get(university).peek());
        }
        worldFinal.stream()
                .sorted()
                .limit(k)
                .map(team -> team.name)
                .forEach(System.out::println);
    }
}
