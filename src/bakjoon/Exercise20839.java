package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise20839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] standard = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] student = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        String result = "A";
        for (int i = 2; i >= 0; i--) {
            if (standard[i] > student[i]) {
                switch (i) {
                    case 0 -> result = (standard[i] / 2 <= student[i]) ? "B" : "C";
                    case 1 -> result = (standard[i] / 2 <= student[i]) ? "D" : "E";
                    case 2 -> result = "E";
                }
                break;
            }
        }
        System.out.println(result);
    }
}
