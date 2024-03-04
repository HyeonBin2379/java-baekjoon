package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            double[] adam = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double[] gosia = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double adamWin = 0d, gosiaWin = 0d;
            for (int j = 0; j < 3; j++) {
                adamWin += adam[j]*gosia[(j+1) % 3];
                gosiaWin += gosia[j]*adam[(j+1) % 3];
            }

            if (adamWin > gosiaWin) {
                sb.append("ADAM\n");
            } else if (adamWin == gosiaWin) {
                sb.append("=\n");
            } else {
                sb.append("GOSIA\n");
            }
        }
        System.out.print(sb);
    }
}