package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10984 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int count = Integer.parseInt(br.readLine());
            int credit = 0;
            double gpa = 0d;
            for (int j = 0; j < count; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                double g = Double.parseDouble(st.nextToken());
                credit += c;
                gpa += c*g;
            }
            System.out.printf("%d %.1f\n", credit, gpa/credit);
        }
    }
}
