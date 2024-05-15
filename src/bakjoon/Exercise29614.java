package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Exercise29614 {

    private static final Map<String, Double> grade = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setGrade();

        String[] input = br.readLine().split("");
        List<Double> scores = new ArrayList<>();
        for (int i = 0; i < input.length; ) {
            StringBuilder sb = new StringBuilder(input[i]);
            int inc = 1;
            if (i < input.length-1 && input[i+1].equals("+")) {
                sb.append(input[i+1]);
                inc = 2;
            }
            scores.add(grade.get(sb.toString()));
            i += inc;
        }
        System.out.printf("%.4f\n", scores.stream().reduce(0.0, Double::sum)/scores.size());
    }

    private static void setGrade() {
        grade.put("A+", 4.5);
        grade.put("A", 4.0);
        grade.put("B+", 3.5);
        grade.put("B", 3.0);
        grade.put("C+", 2.5);
        grade.put("C", 2.0);
        grade.put("D+", 1.5);
        grade.put("D", 1.0);
        grade.put("F", 0.0);
    }
}
