package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise2755 {

    private static final Map<String, Double> GPA = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double result = 0.0;
        int totalCredit = 0;
        setGPA();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String lectureName = st.nextToken();
            int credit = Integer.parseInt(st.nextToken());
            double grade = GPA.get(st.nextToken());

            result += grade*credit;
            totalCredit += credit;
        }
        System.out.printf("%.2f\n", result/totalCredit);
    }

    private static void setGPA() {
        GPA.put("A+", 4.3);
        GPA.put("A0", 4.0);
        GPA.put("A-", 3.7);
        GPA.put("B+", 3.3);
        GPA.put("B0", 3.0);
        GPA.put("B-", 2.7);
        GPA.put("C+", 2.3);
        GPA.put("C0", 2.0);
        GPA.put("C-", 1.7);
        GPA.put("D+", 1.3);
        GPA.put("D0", 1.0);
        GPA.put("D-", 0.7);
        GPA.put("F", 0.0);
    }
}
