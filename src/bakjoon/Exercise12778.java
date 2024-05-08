package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise12778 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            String testType = st.nextToken();
            switch (testType) {
                case "C" -> Arrays.stream(br.readLine().split(" "))
                        .mapToInt(s -> s.charAt(0) - 'A' + 1)
                        .forEach(value -> System.out.print(value + " "));
                case "N" -> Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .map(num -> (char) ('A' + num - 1))
                        .forEach(value -> System.out.print((char) value + " "));
            }
            System.out.println();
        }
    }
}
