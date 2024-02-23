package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise9772 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();
            double[] pos = Arrays.stream(input.split(" ")).mapToDouble(Double::parseDouble).toArray();
            if (pos[0] * pos[1] == 0) {
                bw.write("AXIS\n");
                if (input.equals("0 0")) {
                    break;
                }
                continue;
            }

            if (pos[0] > 0) {
                bw.write(pos[1] > 0 ? "Q1\n" : "Q4\n");
            } else {
                bw.write(pos[1] > 0 ? "Q2\n" : "Q3\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
