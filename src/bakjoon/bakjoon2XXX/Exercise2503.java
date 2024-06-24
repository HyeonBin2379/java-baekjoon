package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise2503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        Set<String> numbers = new HashSet<>();
        for (int i = 123; i < 1000; i++) {
            String str = Integer.toString(i);
            if (str.contains("0") || Arrays.stream(str.split("")).distinct().count() != 3) {
                continue;
            }
            numbers.add(str);
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            if (numbers.isEmpty()) {
                break;
            }

            Set<String> answers = new HashSet<>();
            for (String n : numbers) {
                int[] ballCnt = new int[2];

                for (int j = 0; j < 3; j++) {
                    if (n.contains(String.valueOf(num.charAt(j)))) {
                        if (n.charAt(j) == num.charAt(j)) {
                            ballCnt[0]++;
                        } else {
                            ballCnt[1]++;
                        }
                    }
                }
                if (strike == ballCnt[0] && ball == ballCnt[1]) {
                    answers.add(n);
                }
            }
            numbers = answers;
        }
        System.out.println(numbers.size());
    }
}
