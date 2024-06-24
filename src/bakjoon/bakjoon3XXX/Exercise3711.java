package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise3711 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int g = Integer.parseInt(br.readLine());
            Integer[] stuNum = new Integer[g];
            for (int j = 0; j < g; j++) {
                stuNum[j] = Integer.parseInt(br.readLine());
            }

            int answer = 1;
            if (g == 1) {
                System.out.println(answer);
                continue;
            }
            while (true) {
                List<Integer> remainder = new ArrayList<>();
                for (int j = 0; j < g; j++) {
                    int r = stuNum[j] % answer;
                    if (remainder.contains(r)) {
                        break;
                    }
                    remainder.add(stuNum[j] % answer);
                }
                if (remainder.size() == g) {
                    break;
                }
                answer++;
            }
            System.out.println(answer);
        }
    }
}
