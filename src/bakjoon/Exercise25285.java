package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25285 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double height = Integer.parseInt(st.nextToken()) * 0.01;
            int weight = Integer.parseInt(st.nextToken());
            double bmi = weight/Math.pow(height, 2);

            if (height < 1.401) {
                System.out.println(6);
            } else if (height < 1.46) {
                System.out.println(5);
            } else if (height < 1.59) {
                System.out.println(4);
            } else if (height < 1.61) {
                System.out.println((bmi < 16.0 || bmi >= 35.0) ? 4 : 3);
            } else {
                if (bmi < 16.0 || bmi >= 35.0) {
                    System.out.println(4);
                } else if (bmi < 18.5 || bmi >= 30.0) {
                    System.out.println(3);
                } else if (bmi < 20.0 || bmi >= 25.0) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
            }
        }
    }
}
