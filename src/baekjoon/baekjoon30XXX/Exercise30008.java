package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise30008 {
    private enum Grade {
        NINE(9, 96, 100),
        EIGHT(8, 89, 96),
        SEVEN(7, 77, 89),
        SIX(6, 60, 77),
        FIVE(5, 40, 60),
        FOUR(4, 23, 40),
        THREE(3, 11, 23),
        TWO(2, 4, 11),
        ONE(1, 0, 0);
        private final int rank, min, max;

        Grade(int rank, int min, int max) {
            this.rank = rank;
            this.min = min;
            this.max = max;
        }

        public static int findGrade(int percent) {
            Grade result = Arrays.stream(Grade.values())
                    .filter(grade -> grade.min < percent && grade.max >= percent)
                    .findFirst()
                    .orElse(ONE);
            return result.rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] rank = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        Arrays.stream(rank).forEach(value -> System.out.print(Grade.findGrade(value*100/n) + " "));
    }
}
