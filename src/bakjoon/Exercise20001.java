package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20001 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problem = 0;

        while (true) {
            String input = br.readLine();
            if (input.equals("고무오리 디버깅 끝")) {
                break;
            }
            switch (input) {
                case "문제" -> problem += 1;
                case "고무오리" -> problem = (problem > 0) ? problem - 1 : problem + 2;
            }
        }
        System.out.println(problem == 0 ? "고무오리야 사랑해" : "힝구");
    }
}
