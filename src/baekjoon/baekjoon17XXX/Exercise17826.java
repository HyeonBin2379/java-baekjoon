package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise17826 {

    private enum Grade {
        FIRST("A+", 1, 5),
        SECOND("A0", 6, 15),
        THIRD("B+", 16, 30),
        FOURTH("B0", 31, 35),
        FIFTH("C+", 36, 45),
        SIXTH("C0", 46, 48),
        LAST("F", 49, 50);

        private final String grade;
        private final int start, end;

        Grade(String grade, int start, int end) {
            this.grade = grade;
            this.start = start;
            this.end = end;
        }

        public static String get(int rank) {
            return Arrays.stream(Grade.values())
                    .filter(g -> g.start <= rank && rank <= g.end)
                    .findFirst()
                    .orElse(LAST)
                    .grade;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> score = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int hong = Integer.parseInt(br.readLine());
        score.add(hong);
        score.sort(Comparator.reverseOrder());
        System.out.println(Grade.get(score.indexOf(hong)+1));
    }
}
