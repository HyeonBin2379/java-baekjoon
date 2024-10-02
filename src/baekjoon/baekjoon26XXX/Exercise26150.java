package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise26150 {

    private static class Puzzle implements Comparable<Puzzle> {
        String title;
        int num, difficulty;

        public Puzzle(String title, int num, int difficulty) {
            this.title = title;
            this.num = num;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Puzzle o) {
            return Integer.compare(this.num, o.num);
        }
        public String getLetter() {
            return String.valueOf(this.title.charAt(difficulty-1)).toUpperCase();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Puzzle> puzzleList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            puzzleList.add(new Puzzle(title, num, difficulty));
        }
        System.out.println(puzzleList.stream()
                .sorted()
                .map(Puzzle::getLetter)
                .collect(Collectors.joining()));
    }
}
