package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11367 {
    private enum GPA {
        APLUS("A+", 97, 100),
        AZERO("A", 90, 96),
        BPLUS("B+", 87, 89),
        BZERO("B", 80, 86),
        CPLUS("C+", 77, 79),
        CZERO("C", 70, 76),
        DPLUS("D+", 67, 69),
        DZERO("D", 60, 66),
        F("F", 0, 59);

        private final String grade;
        private final int min, max;

        GPA(String grade, int min, int max) {
            this.grade = grade;
            this.min = min;
            this.max = max;
        }

        public static String get(int score) {
            return Arrays.stream(GPA.values())
                    .filter(gpa -> gpa.min <= score && score <= gpa.max)
                    .findFirst()
                    .orElse(F)
                    .grade;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            sb.append(String.format("%s %s\n", name, GPA.get(score)));
        }
        System.out.print(sb);
    }
}
